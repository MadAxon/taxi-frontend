package taxi.flashka.me.view.model;

import android.databinding.ObservableField;
import android.text.InputType;

import taxi.flashka.me.view.SingleLiveEvent;

public class ProfileViewModel extends ViewModel {

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
            , saveEvent = new SingleLiveEvent<>()
            , passwordEvent = new SingleLiveEvent<>();

    public void onClickedPassword() {
        passwordEvent.call();
    }

    public void onClickedSave() {
        saveEvent.call();
    }

    public void onClickedBirthDate() {
        birthDateEvent.call();
    }

    public SingleLiveEvent<Void> getBirthDateEvent() {
        return birthDateEvent;
    }

    public SingleLiveEvent<Void> getSaveEvent() {
        return saveEvent;
    }

    public SingleLiveEvent<Void> getPasswordEvent() {
        return passwordEvent;
    }
}
