package javalang.net.jcat;


import java.io.InputStream;

public class HttpRequest {

    private InputStream inputStream;

    private String uri;

    private Method method;

    public HttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public void init() {

    }

    public String getUri() {
        return uri;
    }

    public HttpRequest setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public HttpRequest setMethod(Method method) {
        this.method = method;
        return this;
    }
}
