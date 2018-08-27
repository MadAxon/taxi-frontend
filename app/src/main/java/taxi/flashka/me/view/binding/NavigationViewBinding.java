package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;

import taxi.flashka.me.databinding.NavHeaderDealBinding;
import taxi.flashka.me.model.HistoryModel;

public class NavigationViewBinding {
    @BindingAdapter({"bind"})
    public static void bind(NavigationView view, boolean model) {
        NavHeaderDealBinding binding = NavHeaderDealBinding.inflate(LayoutInflater.from(view.getContext()));
        binding.setIsLoading(model);
        binding.executePendingBindings();
        view.addHeaderView(binding.getRoot());
    }
}
