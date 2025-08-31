package RestAssured.ReqRes;

import java.util.HashMap;
import java.util.Map;

public class POJO_PostRequest {

    String name;
    String path;
    String method;
    int status_code;
    private Map<String, Object> response_data = new HashMap<>();
    private Map<String, Object> headers = new HashMap<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public Object getResponse_data() {
        return response_data;
    }

    public Object getHeaders() {
        return headers;
    }

}
