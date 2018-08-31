package taxi.flashka.me.repository.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public abstract class BaseResponse<T> {

    @JsonField
    private String statusText;

    @JsonField
    private int status;

    public abstract T getData();

    public BaseResponse() {
    }

    public BaseResponse(String statusText, int status) {
        this.statusText = statusText;
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
