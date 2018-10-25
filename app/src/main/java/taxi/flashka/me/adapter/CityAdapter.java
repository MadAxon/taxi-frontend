package taxi.flashka.me.adapter;

import taxi.flashka.me.R;
import taxi.flashka.me.adapter.viewholder.CityViewHolder;
import taxi.flashka.me.databinding.ItemCityBinding;
import taxi.flashka.me.repository.model.CityModel;
import taxi.flashka.me.view.SingleLiveEvent;

public class CityAdapter extends BaseAdapter<CityModel, CityViewHolder, ItemCityBinding> {

    private SingleLiveEvent<CityModel> clickEvent = new SingleLiveEvent<>();

    @Override
    public int getLayoutId() {
        return R.layout.item_city;
    }

    @Override
    public CityViewHolder onCreateViewHolderBinding(ItemCityBinding viewDataBinding) {
        CityViewHolder cityViewHolder = new CityViewHolder(viewDataBinding);
        cityViewHolder.setClickEvent(clickEvent);
        return cityViewHolder;
    }

    public SingleLiveEvent<CityModel> getClickEvent() {
        return clickEvent;
    }
}
