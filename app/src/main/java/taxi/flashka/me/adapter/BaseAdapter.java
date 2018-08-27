package taxi.flashka.me.adapter;

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

    private final ArrayList<M> items;

    public abstract @LayoutRes int getLayoutId();

    public abstract @IdRes int getVariable();

    public abstract VM onCreateViewModel();

    public BaseAdapter() {
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, getLayoutId()
                , parent, false);
        return new BaseAdapter.ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {
        M item = items.get(position);
        holder.bind(item);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull BaseAdapter.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateAdapter(List<M> items) {
        if (items != null && items.size() != 0) {
            int positionStart = this.items.size();
            this.items.addAll(items);
            notifyItemRangeInserted(positionStart, items.size());
        }
    }

    public void clearAdapter() {
        items.clear();
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

        private void bind(M model) {
            viewModel.setItem(model);
            viewDataBinding.setVariable(getVariable(), viewModel);
            viewDataBinding.executePendingBindings();
        }

        private void unbind() {
            if (viewDataBinding != null) viewDataBinding.unbind();
        }

    }
}
