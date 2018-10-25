package taxi.flashka.me.repository.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class ItemResponse<T> extends BaseResponse<T> {

    @JsonField
    private T result;

    public T getItem() {
        return result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
