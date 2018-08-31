package taxi.flashka.me.repository.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

@JsonObject
public class ItemsResponse<T> extends BaseResponse<T> {

    @JsonField
    private T items;

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

    @Override
    public T getData() {
        return items;
    }
}
