package taxi.flashka.me.view.model;

import android.databinding.ObservableField;

public class WebViewModel extends ViewModel {

    public ObservableField<String> url = new ObservableField<>();

    public WebViewModel(String url) {
        this.url.set(url);
    }
}
