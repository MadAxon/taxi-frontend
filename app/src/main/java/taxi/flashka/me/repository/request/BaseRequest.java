package taxi.flashka.me.repository.request;

public class BaseRequest<T> {

    private final String baseUrl = "http://18.224.86.0:8080/taxi/";

    private String requestUrl;

    private T body;

    public BaseRequest(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public BaseRequest(String requestUrl, T body) {
        this.requestUrl = requestUrl;
        this.body = body;
    }

    public String getFullUrl() {
        return baseUrl + requestUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
