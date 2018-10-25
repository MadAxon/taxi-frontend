package taxi.flashka.me.repository.request;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class PaymentRequest {

    @JsonField
    private long offerId;

    @JsonField
    private String paymentType;

    public PaymentRequest(long offerId, PaymentType paymentType) {
        this.offerId = offerId;
        this.paymentType = paymentType.name();
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public enum PaymentType {
        FREE,
        BALANCE,
        VISA
    }

}
