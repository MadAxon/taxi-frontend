package taxi.flashka.me.view.model;

import android.content.Intent;

import taxi.flashka.me.interfaces.IViewModel;

public abstract class ViewModel extends android.arch.lifecycle.ViewModel implements IViewModel {

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onDestroy() {

    }
}
