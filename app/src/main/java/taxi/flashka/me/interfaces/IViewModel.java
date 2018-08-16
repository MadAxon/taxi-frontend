package taxi.flashka.me.interfaces;

import android.content.Intent;

public interface IViewModel {

    void onCreate();

    void onResume();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onDestroy();
}
