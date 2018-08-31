package taxi.flashka.me.repository.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class HistoryModel extends BaseObservable {

    private int id;

    private String date;

    private String amount;

    public HistoryModel(int id, String date, String amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Bindable
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
