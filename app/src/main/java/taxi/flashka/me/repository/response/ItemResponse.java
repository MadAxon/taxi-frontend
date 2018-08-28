package taxi.flashka.me.repository.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

@JsonObject
public class ItemResponse<T> {

    @JsonField
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
