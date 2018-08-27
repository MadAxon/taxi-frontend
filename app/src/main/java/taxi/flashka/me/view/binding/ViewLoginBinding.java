package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.view.View;

public class ViewLoginBinding {

    @BindingAdapter({"visibility"})
    public static void setVisibility(View view, boolean show) {
        if (show) {
            view.animate().alpha(1.0f).setDuration(1000);
        } else {
            view.animate().alpha(0.0f).setDuration(1000);
        }
        view.setFocusable(show);
        view.setClickable(show);
    }

}
