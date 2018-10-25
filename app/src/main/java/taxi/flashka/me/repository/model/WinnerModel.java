package taxi.flashka.me.repository.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class WinnerModel extends BaseObservable {

    @JsonField
    private OfferModel offer;

    @JsonField
    private UserModel winner;

    @Bindable
    public OfferModel getOffer() {
        return offer;
    }

    public void setOffer(OfferModel offer) {
        this.offer = offer;
    }

    @Bindable
    public UserModel getWinner() {
        return winner;
    }

    public void setWinner(UserModel winner) {
        this.winner = winner;
    }
}
