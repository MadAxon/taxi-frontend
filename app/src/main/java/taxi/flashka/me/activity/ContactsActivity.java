package taxi.flashka.me.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityContactsBinding;
import taxi.flashka.me.view.model.ContactsViewModel;

public class ContactsActivity extends BaseActivity<ContactsViewModel, ActivityContactsBinding> {

    @Override
    public ContactsViewModel onCreateViewModel() {
        return new ContactsViewModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contacts;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
    }
}
