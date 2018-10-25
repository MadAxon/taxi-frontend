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
public class OfferModel extends BaseObservable {


    @JsonField
    private String winnerStatus;
    @JsonField
    private String participants;
    @JsonField
    private int payment;
    @JsonField
    private String win;
    @JsonField(typeConverter = DateConverter.class)
    private Date endDate;
    @JsonField(typeConverter = DateConverter.class)
    private Date startDate;
    @JsonField
    private long id;

    private String parsedStartDate,
            parsedPayment;

    @Bindable
    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    @Bindable
    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Bindable
    public String getWin() {
        return win + " \u20BD";
    }

    public void setWin(String win) {
        this.win = win;
    }

    @Bindable
    public String getWinnerStatus() {
        return winnerStatus;
    }

    public void setWinnerStatus(String winnerStatus) {
        this.winnerStatus = winnerStatus;
    }

    @Bindable
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Bindable
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getParsedStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault());
        return dateFormat.format(startDate);
    }

    public void setParsedStartDate(String parsedStartDate) {
        this.parsedStartDate = parsedStartDate;
    }

    @Bindable
    public String getParsedPayment() {
        return parsedPayment + " \u20BD";
    }

    public void setParsedPayment(String parsedPayment) {
        this.parsedPayment = parsedPayment;
    }
}
