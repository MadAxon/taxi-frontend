package taxi.flashka.me.adapter;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import taxi.flashka.me.view.model.ItemViewModel;

public abstract class BaseAdapter<VM extends ItemViewModel<M>, M> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    private final ArrayList<M> models;

    public abstract @LayoutRes int getLayoutId();

    public abstract @IdRes int getVariable();

    public abstract VM onCreateViewModel();

    public BaseAdapter(ArrayList<M> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, getLayoutId()
                , parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        M item = models.get(position);
        holder.bind(item);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void updateAdapter(List<M> models) {
        if (models != null && models.size() != 0) {
            int positionStart = this.models.size();
            this.models.addAll(models);
            notifyItemRangeInserted(positionStart, models.size());
        }
    }

    public void clearAdapter() {
        models.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding viewDataBinding;

        private final VM viewModel;

        public ViewHolder(ViewDataBinding viewDataBinding) {
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
}
