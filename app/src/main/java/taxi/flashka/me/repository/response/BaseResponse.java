package taxi.flashka.me.repository.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class BaseResponse<M> {

    @JsonField
    private String message;

    @JsonField
    private int status;

    public BaseResponse() {
    }

    public BaseResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public M getResult() {
        return null;
    }
}
