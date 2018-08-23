package taxi.flashka.me.view.model;

import android.arch.lifecycle.ViewModel;

public abstract class ItemViewModel<M> extends ViewModel {

    public abstract void setItem(M item);

}
