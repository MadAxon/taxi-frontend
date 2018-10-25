package taxi.flashka.me.activity;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.util.List;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.adapter.CityAdapter;
import taxi.flashka.me.databinding.ActivityCityBinding;
import taxi.flashka.me.repository.model.CityModel;
import taxi.flashka.me.view.ItemDecoration;
import taxi.flashka.me.view.model.CityViewModel;

public class CityActivity extends BaseActivity<CityViewModel, ActivityCityBinding> {

    public static final String CITY = "CITY";
    public static final int REQUEST_CITY = 0;

    private CityAdapter adapter;

    @Override
    public CityViewModel onCreateViewModel() {
        return ViewModelProviders.of(this).get(CityViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_city;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupToolbar();
        adapter = new CityAdapter();
        dataBinding.recyclerView.setAdapter(adapter);
        dataBinding.recyclerView.addItemDecoration(new ItemDecoration(this));
        viewModel.getItems().observe(this, new Observer<List<CityModel>>() {
            @Override
            public void onChanged(@Nullable List<CityModel> items) {
                if (items != null) {
                    adapter.updateAdapter(items);
                }
            }
        });
        adapter.getClickEvent().observe(this, new Observer<CityModel>() {
            @Override
            public void onChanged(@Nullable CityModel cityModel) {
                if (cityModel != null) {
                    Intent intent = new Intent();
                    try {
                        intent.putExtra(CITY, LoganSquare.serialize(cityModel));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
