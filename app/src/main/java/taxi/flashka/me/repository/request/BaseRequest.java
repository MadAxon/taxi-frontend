package taxi.flashka.me.repository.request;

public class BaseRequest<T> {

    private String baseUrl, requestUrl;

    private T body;

    public BaseRequest(String baseUrl, String requestUrl, T body) {
        this.baseUrl = baseUrl;
        this.requestUrl = requestUrl;
        this.body = body;
    }

    public String getFullUrl() {
        return baseUrl + requestUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
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
