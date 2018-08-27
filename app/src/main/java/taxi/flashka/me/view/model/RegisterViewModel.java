package taxi.flashka.me.view.model;

import android.databinding.ObservableField;
import android.text.InputType;

import taxi.flashka.me.view.SingleLiveEvent;

public class RegisterViewModel extends ViewModel {

    public ObservableField<String>
            tel = new ObservableField<>("")
            , lastName = new ObservableField<>("")
            , firstName = new ObservableField<>("")
            , patronymic = new ObservableField<>("")
            , birthDate = new ObservableField<>("")
            , city = new ObservableField<>("")
            , carNumber = new ObservableField<>("")
            , regionCode = new ObservableField<>("");

    public ObservableField<Integer>
            carNumberLength = new ObservableField<>(6)
            , regionCodeLength = new ObservableField<>(3)
            , inputType = new ObservableField<>(InputType.TYPE_CLASS_NUMBER
            | InputType.TYPE_NUMBER_FLAG_SIGNED);

    public ObservableField<Boolean> editable = new ObservableField<>(false);

    private SingleLiveEvent<Void> birthDateEvent = new SingleLiveEvent<>()
            , continueEvent = new SingleLiveEvent<>()
            , offerEvent = new SingleLiveEvent<>();

    public void onClickedOffer() {
        offerEvent.call();
    }

    public void onClickedContinue() {
        continueEvent.call();
    }

    public void onClickedBirthDate() {
        birthDateEvent.call();
    }

    public SingleLiveEvent<Void> getBirthDateEvent() {
        return birthDateEvent;
    }

    public SingleLiveEvent<Void> getContinueEvent() {
        return continueEvent;
    }

    public SingleLiveEvent<Void> getOfferEvent() {
        return offerEvent;
    }
}
