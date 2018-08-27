package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.webkit.WebView;

public class WebViewBinding {

    @BindingAdapter({"loadUrl"})
    public void loadUrl(WebView webView, String url) {
        if (url != null && url.length() > 0) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }
    }
}
