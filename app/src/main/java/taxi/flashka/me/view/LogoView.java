package taxi.flashka.me.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import taxi.flashka.me.R;

public class LogoView extends ConstraintLayout {
    public LogoView(Context context) {
        super(context);
        initLayout(context);
    }

    public LogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public LogoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_logo, this, true);

        Typeface lightRoboto = null;
        Typeface boldRoboto = null;
        try {
            lightRoboto = ResourcesCompat.getFont(context, R.font.roboto_light);
            boldRoboto = ResourcesCompat.getFont(context, R.font.roboto_bold);
        } catch (Resources.NotFoundException rnfe) {

        }

        SpannableString startString = new SpannableString(context.getString(R.string.app_name_start));
        startString.setSpan(new ForegroundColorSpan(context.getResources()
                .getColor(R.color.colorAccent)), 0, startString.length(), 0);
        if (lightRoboto != null) startString.setSpan(new StyleSpan(lightRoboto.getStyle())
                , 0, startString.length(), 0);

        SpannableString endString = new SpannableString(context.getString(R.string.app_name_end));
        endString.setSpan(new ForegroundColorSpan(context.getResources()
                .getColor(android.R.color.white)), 0, endString.length(), 0);
        if (boldRoboto != null) endString.setSpan(new StyleSpan(boldRoboto.getStyle())
                , 0, endString.length(), 0);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(startString);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(endString);

        TextView textView = view.findViewById(R.id.logo);
        textView.setText(spannableStringBuilder);
    }
}
