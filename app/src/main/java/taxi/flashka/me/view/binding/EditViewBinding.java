package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.text.Editable;
import android.text.TextWatcher;

import taxi.flashka.me.view.EditView;

@InverseBindingMethods({
        @InverseBindingMethod(type = EditView.class
                , attribute = "text")
})
public class EditViewBinding {

    @BindingAdapter(value = "textAttrChanged")
    public static void setListener(EditView editView, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null)
            editView.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    inverseBindingListener.onChange();
                }
            });
    }

    @BindingAdapter("text")
    public static void setText(EditView editView, String text) {
        if (text != null && !text.equals(editView.getText())) editView.setText(text);
    }

    @InverseBindingAdapter(attribute = "text")
    public static String getText(EditView editView) {
        return editView.getText();
    }

}
