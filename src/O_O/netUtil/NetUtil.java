package O_O.netUtil;

import net.sf.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class NetUtil {

    public static Response sendRequest(Request request) throws Exception{
        Response response = null;
        Socket socket = new Socket("localhost", 8888);

        //数据发送
        DataOutputStream os = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream())
        );
        os.writeUTF(request.toString());
        os.flush();
        socket.shutdownOutput();

        //数据接收
        DataInputStream is = new DataInputStream(
                new BufferedInputStream(socket.getInputStream())
        );
        String responseStr = is.readUTF();
        System.out.println(responseStr);
        JSONObject responseJson = JSONObject.fromObject(responseStr);
        response = jsonToResponse(responseJson);
        return response;
    }

    private static Response jsonToResponse(JSONObject responseJson){
        Response response = new Response();
        if(responseJson.has("code")) {
            response.setCode((int) responseJson.get("code"));
        }
        if(responseJson.has("message")) {
            response.setMessage((String) responseJson.get("message"));
        }
        if(responseJson.has("data")) {
            response.setData(responseJson.get("data"));
        }
        return response;
    }
}
