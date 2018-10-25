package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.util.List;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityDealBinding;
import taxi.flashka.me.repository.model.OfferModel;
import taxi.flashka.me.repository.model.UserModel;
import taxi.flashka.me.repository.response.StatusResponse;
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
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, dataBinding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dataBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        dataBinding.navView.setNavigationItemSelectedListener(this);

        viewModel.getApplyEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                Intent intent = new Intent(DealActivity.this, PaymentActivity.class);
                intent.putExtra(PaymentActivity.OFFER_ID, viewModel.offers.getValue().get(0).getId());
                startActivity(intent);
            }
        });

        viewModel.userModel.observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if (userModel != null) viewModel.requestOffers(userModel.getCity().getId());
            }
        });

        viewModel.offers.observe(this, new Observer<List<OfferModel>>() {
            @Override
            public void onChanged(@Nullable List<OfferModel> offerModels) {
                viewModel.runTimer();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (dataBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            dataBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        dataBinding.drawerLayout.closeDrawer(GravityCompat.START);

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
                try {
                    intent.putExtra(ProfileActivity.PROFILE, LoganSquare.serialize(viewModel.userModel.getValue()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_payout:

                break;
            case R.id.nav_condition:

                break;
            case R.id.nav_contacts:
                intent = new Intent(this, ContactsActivity.class);
                break;
            case R.id.nav_logout:
                viewModel.toNullToken();
                intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        startActivity(intent);
        return true;
    }

    @Override
    public void onChanged(@Nullable StatusResponse statusResponse) {
        super.onChanged(statusResponse);
        if (statusResponse != null && statusResponse.getStatus() == 200 && !statusResponse.getMessage().isEmpty())
            showSuccessSnackbar(statusResponse.getMessage());
    }
}
