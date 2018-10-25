package taxi.flashka.me.repository.request;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import taxi.flashka.me.repository.model.CityModel;

@JsonObject
public class RegisterRequest {

    @JsonField
    private String birthDate;
    @JsonField
    private String carNumber;
    @JsonField
    private String lastName;
    @JsonField
    private String firstName;
    @JsonField
    private String phoneNumber;
    @JsonField
    private String patronymic;
    @JsonField
    private CityModel city;

    public RegisterRequest() {
    }

    public RegisterRequest(String birthDate, String carNumber, String lastName, String firstName, String patronymic, String phoneNumber, CityModel city) {
        this.birthDate = birthDate;
        this.carNumber = carNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city;
    }
}
