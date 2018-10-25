package taxi.flashka.me.repository.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class CityModel extends BaseObservable {
    @JsonField
    private String name;
    @JsonField
    private long id;

    public CityModel() {
    }

    public CityModel(long id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
