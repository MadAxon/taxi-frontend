package taxi.flashka.me.view.model;

import android.databinding.ObservableField;

import taxi.flashka.me.repository.model.CityModel;

public class CityItemViewModel extends ItemViewModel<CityModel> {

    public ObservableField<CityModel> cityModel = new ObservableField<>();

    @Override
    public void setItem(CityModel item) {
        cityModel.set(item);
    }

}
