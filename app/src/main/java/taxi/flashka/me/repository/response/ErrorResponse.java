package taxi.flashka.me.repository.response;

public class ErrorResponse extends BaseResponse {

    public ErrorResponse(String statusText, int status) {
        super(statusText, status);
    }

    @Override
    public Object getData() {
        return null;
    }
}
