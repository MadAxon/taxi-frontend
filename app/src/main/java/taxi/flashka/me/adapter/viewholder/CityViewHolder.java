package taxi.flashka.me.adapter.viewholder;

import taxi.flashka.me.BR;
import taxi.flashka.me.databinding.ItemCityBinding;
import taxi.flashka.me.repository.model.CityModel;
import taxi.flashka.me.view.SingleLiveEvent;
import taxi.flashka.me.view.model.CityItemViewModel;

public class CityViewHolder extends BaseViewHolder<CityItemViewModel, CityModel> {

    private SingleLiveEvent<CityModel> clickEvent;

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public CityItemViewModel onCreateViewModel() {
        return new CityItemViewModel();
    }

    public CityViewHolder(ItemCityBinding viewDataBinding) {
        super(viewDataBinding);
        viewDataBinding.setViewHolder(this);
    }

    public void setClickEvent(SingleLiveEvent<CityModel> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public void onClickedCityItem(CityModel cityModel) {
        clickEvent.setValue(cityModel);
    }

}
