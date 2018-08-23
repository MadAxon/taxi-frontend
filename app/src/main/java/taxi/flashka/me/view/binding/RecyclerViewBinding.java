package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import taxi.flashka.me.adapter.HistoryAdapter;
import taxi.flashka.me.model.HistoryModel;

public class RecyclerViewBinding<T> {

    @BindingAdapter(value = {"app:adapter", "app:items"}, requireAll = false)
    public void bind(RecyclerView recyclerView, HistoryAdapter adapter, List<HistoryModel> items) {
        if (items == null)
            recyclerView.setAdapter(adapter);
        else
            adapter.updateAdapter(items);
    }

}
