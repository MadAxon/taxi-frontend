package taxi.flashka.me.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;

import taxi.flashka.me.databinding.ItemMenuDealBinding;
import taxi.flashka.me.databinding.NavHeaderDealBinding;
import taxi.flashka.me.repository.model.UserModel;

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

    public void setIsUserLoading(boolean isUserLoading) {
        binding.setIsUserLoading(isUserLoading);
        itemBinding.setIsUserLoading(isUserLoading);
    }

    public void setUserModel(UserModel userModel) {
        binding.setUserModel(userModel);
        itemBinding.setUserModel(userModel);
    }

}
