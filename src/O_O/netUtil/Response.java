package O_O.netUtil;

public class Response {
    private int code;
    private Object data;
    private String message;

    public static interface Status{
        public final static int SUCCESS = 0;
        public final static int FAILED = 1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{code:");
        sb.append(code);
        sb.append(", data:");
        sb.append(data);
        sb.append(", message:");
        sb.append(message);
        sb.append("}");
        return sb.toString();
    }
}
