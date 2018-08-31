package taxi.flashka.me.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import taxi.flashka.me.R;

public class ProgressButton extends ConstraintLayout {

    private Button button;

    private TextView textView;

    private ProgressBar progressBar;

    private String buttonText;

    private int measuredWidthButton;

    private ViewPropertyAnimator animator;

    public ProgressButton(Context context) {
        super(context);
        initLayout(context, null);
    }

    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context, attrs);
    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs);
    }

    public void makeVisible() {
        if (measuredWidthButton == 0) measuredWidthButton = button.getMeasuredWidth();
        ValueAnimator anim = ValueAnimator.ofInt(measuredWidthButton, button.getMeasuredHeight());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = val;
                button.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(500);
        anim.start();
        textView.animate().alpha(0).setDuration(250);
        progressBar.setVisibility(VISIBLE);
        animator.alpha(1).setDuration(500);
        button.setEnabled(false);
    }

    public void makeGone() {
        if (measuredWidthButton != 0) {
            ValueAnimator anim = ValueAnimator.ofInt(button.getMeasuredHeight(), measuredWidthButton);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                    layoutParams.width = val;
                    button.setLayoutParams(layoutParams);
                }
            });
            anim.setDuration(500);
            textView.animate().alpha(1).setDuration(500);
            animator.alpha(0).setDuration(250);
            anim.start();
        }
        button.setEnabled(true);
    }

    private void initLayout(Context context, @Nullable AttributeSet attributeSet) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_progress_button, this, true);
        progressBar = view.findViewById(R.id.progressBar);
        animator = progressBar.animate();
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (progressBar.getAlpha() == 0) progressBar.setVisibility(GONE);
            }
        });

        button = view.findViewById(R.id.button);
        textView = view.findViewById(R.id.textView);
        if (attributeSet != null) {
            TypedArray typedArray = context.getTheme()
                    .obtainStyledAttributes(attributeSet, R.styleable.ProgressButton, 0 ,0);
            buttonText = typedArray.getString(R.styleable.ProgressButton_text);
            textView.setText(buttonText);
            typedArray.recycle();
        }
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
