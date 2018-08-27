package taxi.flashka.me.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import taxi.flashka.me.R;

public class EditView extends ConstraintLayout {

    private TextView textView;

    private EditText editText;

    @Nullable
    private String title, hint, text;

    private int inputType, maxLength;

    private boolean isShown;

    public EditView(Context context) {
        super(context);
        initLayout(context);
    }

    public EditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributes(context, attrs);
    }

    public EditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.EditView, 0, 0);
        title = typedArray.getString(R.styleable.EditView_title);
        hint = typedArray.getString(R.styleable.EditView_hint);
        text = typedArray.getString(R.styleable.EditView_text);
        typedArray.recycle();
        initLayout(context);
    }

    private void initLayout(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_edit, this, true);
        textView = view.findViewById(R.id.textView);
        editText = view.findViewById(R.id.editText);

        textView.setText(title);
        if (hint != null) editText.setHint(hint);
        if (text != null) editText.setText(text);
    }

    @Nullable
    public String getText() {
        text = editText.getText().toString();
        return text;
    }

    public void setText(@Nullable String text) {
        this.text = text;
        editText.setText(text);
    }

    public EditText getEditText() {
        return editText;
    }

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
        editText.setInputType(inputType);
    }

    @Override
    public boolean isShown() {
        return isShown;
    }

    public void setIsShown(boolean shown) {
        isShown = shown;
        int selectionEnd = editText.getSelectionEnd();
        if (!isShown) editText.setTransformationMethod(new PasswordTransformationMethod());
        else editText.setTransformationMethod(null);
        editText.setSelection(selectionEnd);
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    public void setEditable(boolean editable) {
        editText.setFocusable(editable);
        editText.setClickable(!editable);
        editText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditView.this.performClick();
            }
        });
    }
}
