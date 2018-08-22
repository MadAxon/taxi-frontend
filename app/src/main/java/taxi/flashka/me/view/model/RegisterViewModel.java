package taxi.flashka.me.view.model;

import android.content.Context;
import android.databinding.ObservableField;
import android.text.InputType;

import taxi.flashka.me.interfaces.IDateSetListener;
import taxi.flashka.me.view.DatePickerDialog;

public class RegisterViewModel extends ViewModel implements IDateSetListener {

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

    public void onClickedOffer(Context context) {

    }

    public void onClickedContinue(Context context) {

    }

    public void onClickedBirthDate(Context context) {
        new DatePickerDialog(context, this);
    }

    @Override
    public void onDateSet(String date) {
        birthDate.set(date);
    }
}
