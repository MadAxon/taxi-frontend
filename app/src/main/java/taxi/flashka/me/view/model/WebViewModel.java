package taxi.flashka.me.view.model;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

public class WebViewModel extends ViewModel {

    public ObservableField<String> url = new ObservableField<>();

    public WebViewModel(@NonNull Application application) {
        super(application);
    }

    public WebViewModel(@NonNull Application application, String url) {
        super(application);
        this.url.set(url);
    }
}
