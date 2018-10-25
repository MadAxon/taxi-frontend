package taxi.flashka.me.adapter.viewholder;

import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;

import taxi.flashka.me.view.model.ItemViewModel;

public abstract class BaseViewHolder<VM extends ItemViewModel<M>, M> extends RecyclerView.ViewHolder {

    private final ViewDataBinding viewDataBinding;

    private final VM viewModel;

    public abstract @IdRes int getVariable();

    public abstract VM onCreateViewModel();

    public BaseViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
        viewModel = onCreateViewModel();
    }

    public void bind(M model) {
        viewModel.setItem(model);
        viewDataBinding.setVariable(getVariable(), viewModel);
        viewDataBinding.executePendingBindings();
    }

    public void unbind() {
        if (viewDataBinding != null) viewDataBinding.unbind();
    }

}
