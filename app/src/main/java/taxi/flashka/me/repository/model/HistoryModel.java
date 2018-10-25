package taxi.flashka.me.repository.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import taxi.flashka.me.repository.DateConverter;

@JsonObject
public class HistoryModel extends BaseObservable {

    @JsonField
    private String transactionType;
    @JsonField
    private String transactionStatus;
    @JsonField
    private String amount;
    @JsonField
    private String commission;
    @JsonField(typeConverter = DateConverter.class)
    private Date date;
    @JsonField
    private String number;
    @JsonField
    private String name;

    private String parsedDate;

    @Bindable
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Bindable
    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Bindable
    public String getAmount() {
        return amount + " \u20BD";
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Bindable
    public String getCommission() {
        return commission + " \u20BD";
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    @Bindable
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Bindable
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getParsedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
        return dateFormat.format(date);
    }

    public void setParsedDate(String parsedDate) {
        this.parsedDate = parsedDate;
    }
}
