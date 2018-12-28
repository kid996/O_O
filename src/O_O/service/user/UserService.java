package O_O.service.user;

import O_O.model.user.User;
import O_O.netUtil.NetUtil;
import O_O.netUtil.Request;
import O_O.netUtil.Response;
import O_O.view.ACTION;
import O_O.view.UserContents;
import net.sf.json.JSONObject;

import java.util.HashMap;

public class UserService {
    public static User queryUserInfo(HashMap<String, Object> params)
            throws Exception {
        //1. 封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("phone", "\"" + params.get("phone") + "\"");
        request.setAction(String.valueOf(ACTION.USER_INFO));
        request.setData(dataReq);
        //2. 发送请求
        Response response = NetUtil.sendRequest(request);
        //3. 取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            JSONObject data = JSONObject.fromObject(response.getData());
            User user = new User();
            user.setName((String)data.get("name"));
            user.setPhone((String)data.get("phone"));
            user.setAge((String)data.get("age"));
            user.setSex((String)data.get("sex"));
            return user;
        }
        return null;
    }

    public static boolean login(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("phone", "\"" + params.get("phone") + "\"");
        dataReq.put("pwd", "\"" + params.get("pwd") + "\"");
        request.setAction(String.valueOf(ACTION.USER_LOGIN));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            JSONObject data = JSONObject.fromObject(response.getData());
            if(data.containsKey("token")) {
                UserContents.getInstance().put("phone", (String)params.get("phone"));
                UserContents.getInstance().put("pwd", (String)params.get("pwd"));
                UserContents.getInstance().put("token", (String)data.get("token"));
                return true;
            }
        }
        return false;
    }

    public static boolean registe(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        User user = (User)params.get("user");
        dataReq.put("pwd" , "\"" + user.getPwd() + "\"");
        dataReq.put("name" , "\"" + user.getName() + "\"");
        dataReq.put("phone", "\"" + user.getPhone() + "\"");
        dataReq.put("age", "\"" + user.getAge() + "\"");
        dataReq.put("sex", "\"" + user.getSex() + "\"");
        request.setAction(String.valueOf(ACTION.USER_REGISTE));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            JSONObject data = JSONObject.fromObject(response.getData());
            if(data.containsKey("token")){
                UserContents.getInstance().put("token", (String)data.get("token"));
                UserContents.getInstance().put("pwd", (String)params.get("name"));
                UserContents.getInstance().put("name", (String)params.get("name"));
                UserContents.getInstance().put("phone", (String)params.get("phone"));
                UserContents.getInstance().put("age", (String)params.get("age"));
                UserContents.getInstance().put("sex", (String)params.get("sex"));
                return true;
            }
        }

        return false;
    }



    public static boolean userUpdateName(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("newName", "\"" + params.get("newName") + "\"");
        dataReq.put("token", "\"" + params.get("token") + "\"");
        request.setAction(String.valueOf(ACTION.USER_UPDATE_NAME));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            UserContents.getInstance().put("name", (String)params.get("newName"));
            return true;
        }
        return false;

    }

    public static User userHome(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("token", "\"" + params.get("token") + "\"");
        request.setAction(String.valueOf(ACTION.USER_HOME));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            JSONObject data = JSONObject.fromObject(response.getData());

            User user = new User();
            if(data.containsKey("age")) {
                user.setAge((String)data.get("age"));
            }
            if(data.containsKey("name")) {
                user.setName((String)data.get("name"));
            }
            if(data.containsKey("phone")) {
                user.setPhone((String)data.get("phone"));
            }
            if(data.containsKey("sex")) {
                user.setSex((String)data.get("sex"));
            }

            return user;
        }
        return null;
    }

    public static boolean userLogout(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("token", "\"" + params.get("token") + "\"");
        request.setAction(String.valueOf(ACTION.USER_LOGOUT));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            UserContents.getInstance().deleteAll();
            return true;
        }
        return false;
    }

    public static boolean userUpdatePwd(HashMap<String, Object> params)
            throws Exception {
        String newPwd = (String)params.get("newPwd");
        String reNewPwd = (String)params.get("reNewPwd");
        if(newPwd.equals(reNewPwd)) {
            //1.封装请求
            Request request = new Request();
            HashMap<String, Object> dataReq = new HashMap<>();
            dataReq.put("token", "\"" + params.get("token") + "\"");
            dataReq.put("newPwd", "\"" + params.get("newPwd") + "\"");
            request.setAction(String.valueOf(ACTION.USER_UPDATE_PWD));
            request.setData(dataReq);
            //2.发送请求
            Response response = NetUtil.sendRequest(request);
            //3.取出参数并返回
            if(response.getCode() == Response.Status.SUCCESS) {
                JSONObject data = JSONObject.fromObject(response.getData());
                if (data.containsKey("token")) {
                    UserContents.getInstance().put("token", (String)data.get("token"));
                    return true;
                }
            }
        }
        return false;
    }
}
