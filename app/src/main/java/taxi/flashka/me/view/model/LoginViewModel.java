package taxi.flashka.me.view.model;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;

public class LoginViewModel extends ViewModel {

    public ObservableField<String>
            telephone = new ObservableField<>()
            , password = new ObservableField<>();


    public void onSignInClicked(Context context) {
        Log.i("my_logs", telephone.get());
    }

    public void onClickedRegister(Context context) {

    }
}
