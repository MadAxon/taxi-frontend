package taxi.flashka.me.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ActivityContactsBinding;
import taxi.flashka.me.view.model.ContactsViewModel;

public class ContactsActivity extends BaseActivity<ContactsViewModel, ActivityContactsBinding> {

    @Override
    public ContactsViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(ContactsViewModel.class);
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

        viewModel.getEmailEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"info@happy-order.ru"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "This is my text to send.");
                startActivity(intent);
            }
        });
        viewModel.getMessageEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {

            }
        });
        viewModel.getPhoneEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+" + "7 987 654 32 10"));
                startActivity(callIntent);
            }
        });
    }
}
