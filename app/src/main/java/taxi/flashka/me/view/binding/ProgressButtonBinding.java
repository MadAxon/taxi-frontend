package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.view.View;

import taxi.flashka.me.view.ProgressButton;

public class ProgressButtonBinding {

    @BindingAdapter({"visibility"})
    public static void setVisibility(ProgressButton progressButton, boolean isLoading) {
        if (isLoading) progressButton.makeVisible();
        else progressButton.makeGone();
    }

    @BindingAdapter({"onClick"})
    public static void setClickListener(ProgressButton progressButton, View.OnClickListener onClickListener) {
        progressButton.getButton().setOnClickListener(onClickListener);
    }

}
