package O_O.netUtil;

import net.sf.json.JSONObject;

import java.util.HashMap;

public class Request {
    private String action;
    private HashMap<String, Object> data;
    private String socket;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("action:");
        sb.append(action);
        sb.append(", data:");
        sb.append(data);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args){
        Request req = new Request();
        HashMap<String,Object> data = new HashMap<>();
        data.put("a","1");
        data.put("b","2");
        req.setData(data);
        req.setAction("3");
        System.out.println(req.toString());
        JSONObject json = JSONObject.fromObject(req.toString());
        System.out.println(json);
        JSONObject json2 = JSONObject.fromObject(json.toString());
        System.out.println(json2);
    }
}
