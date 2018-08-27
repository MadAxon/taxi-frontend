package taxi.flashka.me.view.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import taxi.flashka.me.BR;
import taxi.flashka.me.R;
import taxi.flashka.me.model.DealOfferModel;

public class LinearLayoutDealBinding {

    @BindingAdapter({"views"})
    public static void setViews(ViewGroup viewGroup, List<DealOfferModel> offers) {
        if (offers != null) {
            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            for (int i = 0; i < offers.size(); i++) {
                DealOfferModel offer = offers.get(i);
                ViewDataBinding binding = DataBindingUtil
                        .inflate(inflater, R.layout.item_offer_deal, viewGroup, true);
                binding.setVariable(BR.offer, offer);
            }
        }
    }

}
