package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityDealBinding;
import taxi.flashka.me.view.model.DealViewModel;

public class DealActivity extends BaseActivity<DealViewModel, ActivityDealBinding>
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public DealViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(DealViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_deal;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewModel.getApplyEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.nav_offers:

                break;
            case R.id.nav_winners:
                intent = new Intent(this, WinnerActivity.class);
                break;
            case R.id.nav_history:
                intent = new Intent(this, HistoryActivity.class);
                break;
            case R.id.nav_profile:
                intent = new Intent(this, ProfileActivity.class);
                break;
            case R.id.nav_payout:

                break;
            case R.id.nav_condition:

                break;
            case R.id.nav_contacts:
                intent = new Intent(this, ContactsActivity.class);
        }
        startActivity(intent);
        return true;
    }
}
