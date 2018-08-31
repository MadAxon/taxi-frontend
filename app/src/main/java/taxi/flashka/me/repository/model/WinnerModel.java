package taxi.flashka.me.repository.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class WinnerModel extends BaseObservable {

    private String carNumber;

    private int id;

    private String amount;

    public WinnerModel(String carNumber, int id, String amount) {
        this.carNumber = carNumber;
        this.id = id;
        this.amount = amount;
    }

    @Bindable
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
