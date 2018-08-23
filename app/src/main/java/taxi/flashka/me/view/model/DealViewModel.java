package taxi.flashka.me.view.model;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.util.Log;
import android.view.MenuItem;

import taxi.flashka.me.R;
import taxi.flashka.me.activity.ContactsActivity;
import taxi.flashka.me.activity.ProfileActivity;
import taxi.flashka.me.model.DealOfferModel;

public class DealViewModel extends ViewModel {

    public ObservableArrayList<DealOfferModel> offers
            = new ObservableArrayList<>();

    public boolean onNavigationItemSelected(Context context, int itemId) {
        Intent intent = null;
        switch (itemId) {
            case R.id.nav_offers:

                break;
            case R.id.nav_winners:

                break;
            case R.id.nav_history:

                break;
            case R.id.nav_profile:
                intent = new Intent(context, ProfileActivity.class);
                break;
            case R.id.nav_payout:

                break;
            case R.id.nav_condition:

                break;
            case R.id.nav_contacts:
                intent = new Intent(context, ContactsActivity.class);
        }
        context.startActivity(intent);
        return true;
    }

    public void onClickedApply() {
        Log.i("my_logs", "click");
        offers.add(new DealOfferModel("23.07.2018 13:00", 1));
        offers.add(new DealOfferModel("24.07.2018 13:30", 2));
    }

}
