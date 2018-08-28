package taxi.flashka.me.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import taxi.flashka.me.R;
import taxi.flashka.me.databinding.ItemMenuDealBinding;
import taxi.flashka.me.databinding.NavHeaderDealBinding;

public class NavigationView extends android.support.design.widget.NavigationView {

    private NavHeaderDealBinding binding;

    private ItemMenuDealBinding itemBinding;

    public NavigationView(Context context) {
        super(context);
        initLayout(context);
    }

    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public NavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
        binding = NavHeaderDealBinding.inflate(LayoutInflater.from(context));
        addHeaderView(binding.getRoot());
        MenuItem menuItem = getMenu().getItem(4);
        itemBinding = ItemMenuDealBinding.inflate(LayoutInflater.from(context));
        menuItem.setActionView(itemBinding.getRoot());
    }

    public void setIsLoading(boolean isLoading) {
        binding.setIsLoading(isLoading);
        itemBinding.setIsLoading(isLoading);
    }

    public void setName(String name) {
        binding.setName(name);
    }

    public void setCarNumber(String carNumber) {
        binding.setCarNumber(carNumber);
    }

    public void setCity(String city) {
        binding.setCity(city);
    }

    public void setAmount(String amount) {
        itemBinding.setAmount(amount);
    }

}
