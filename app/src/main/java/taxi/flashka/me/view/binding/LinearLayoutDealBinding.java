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
import taxi.flashka.me.repository.model.OfferModel;

public class LinearLayoutDealBinding {

    @BindingAdapter({"views"})
    public static void setViews(ViewGroup viewGroup, List<OfferModel> offers) {
        viewGroup.removeAllViews();
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (offers != null && offers.size() > 1) {
            for (int i = 1; i < offers.size(); i++) {
                OfferModel offer = offers.get(i);
                ViewDataBinding binding = DataBindingUtil
                        .inflate(inflater, R.layout.item_offer_deal, viewGroup, true);
                binding.setVariable(BR.offer, offer);
            }
        } else {
            ViewDataBinding binding = DataBindingUtil
                    .inflate(inflater, R.layout.item_offer_deal, viewGroup, true);
        }
    }

}
