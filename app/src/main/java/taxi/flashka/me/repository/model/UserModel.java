package taxi.flashka.me.repository.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class UserModel extends BaseObservable {

    @Nullable
    @JsonField
    private String birthDate;

    @NonNull
    @JsonField
    private CityModel city = new CityModel();

    @JsonField
    @Nullable
    private String patronymic;

    @JsonField
    @NonNull
    private String lastName = "",
            firstName = "",
            phoneNumber = "",
            carNumber = "",
            balance = "0",
            registerDate = "";

    @JsonField
    private int id;

    private String fullName,
            carNumberParsed,
            carNumberCode,
            carNumberRegion;

    @NonNull
    @Bindable
    public String getBalance() {
        return balance + " \u20BD";
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @NonNull
    @Bindable
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @NonNull
    @Bindable
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(@NonNull String carNumber) {
        this.carNumber = carNumber;
    }

    @Nullable
    @Bindable
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@Nullable String birthDate) {
        this.birthDate = birthDate;
    }

    @NonNull
    @Bindable
    public CityModel getCity() {
        return city;
    }

    public void setCity(@NonNull CityModel city) {
        this.city = city;
    }

    @Nullable
    @Bindable
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(@Nullable String patronymic) {
        this.patronymic = patronymic;
    }

    @NonNull
    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return firstName + " " + (patronymic != null? patronymic + " " : "") + lastName;
    }

    @Bindable
    public String getCarNumberCode() {
        if (carNumber.length() >= 6)
            return carNumber.substring(0, 6);
        return carNumber;
    }

    @Bindable
    public String getCarNumberRegion() {
        if (carNumber.length() >= 6)
            return carNumber.substring(6);
        return carNumber;
    }

    @Bindable
    public String getCarNumberParsed() {
        String[] parsedCarNumber = carNumber.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        if (parsedCarNumber.length == 4)
            return String.format("%s %s %s | %s RUS", parsedCarNumber[0], parsedCarNumber[1]
                    , parsedCarNumber[2], parsedCarNumber[3]);
        else return carNumber;
    }

    public void setCarNumberParsed(String carNumberParsed) {
        this.carNumberParsed = carNumberParsed;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCarNumberCode(String carNumberCode) {
        this.carNumberCode = carNumberCode;
    }

    public void setCarNumberRegion(String carNumberRegion) {
        this.carNumberRegion = carNumberRegion;
    }
}
