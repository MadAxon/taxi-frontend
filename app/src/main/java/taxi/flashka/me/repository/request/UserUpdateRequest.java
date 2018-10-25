package taxi.flashka.me.repository.request;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import taxi.flashka.me.repository.model.CityModel;

@JsonObject
public class UserUpdateRequest {

    @JsonField
    private String birthDate;
    @JsonField
    private CityModel city;
    @JsonField
    private String patronymic;
    @JsonField
    private String lastName;
    @JsonField
    private String firstName;

    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String birthDate, CityModel city, String patronymic, String lastName, String firstName) {
        this.birthDate = birthDate;
        this.city = city;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
}
