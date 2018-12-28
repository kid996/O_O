package O_O.service.timeline;

import O_O.model.timeline.PostComment;
import O_O.model.timeline.PostContent;
import O_O.netUtil.NetUtil;
import O_O.netUtil.Request;
import O_O.netUtil.Response;
import O_O.view.ACTION;
import net.sf.json.JSONObject;

import java.util.HashMap;

public class TimeLineService {
    public static boolean pushContent(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        PostContent postContent = (PostContent) params.get("postContent");
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("title", "\"" + postContent.getTitle() + "\"");
        dataReq.put("content", "\"" + postContent.getContent() + "\"");
        dataReq.put("createTime", "\"" + postContent.getCreateTime() + "\"");
        dataReq.put("token", "\"" + params.get("token") + "\"");
        request.setAction(String.valueOf(ACTION.PUSH_CONTENT));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            return true;
        }
        return false;
    }

    public static String browseContents(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("token", "\"" + params.get("token") + "\"");
        request.setAction(String.valueOf(ACTION.BROWSE_CONTENTS));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出请求并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            JSONObject data = JSONObject.fromObject(response.getData());
            return (String)data.get("postContents");
        }
        return null;
    }

    public static String browseComments(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        dataReq.put("token", "\"" + params.get("token") + "\"");
        dataReq.put("contentId", "\"" + params.get("contentId") + "\"");
        request.setAction(String.valueOf(ACTION.BROWSE_COMMENTS));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出参数并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            JSONObject data = JSONObject.fromObject(response.getData());
            return (String)data.get("comments");
        }
        return null;
    }

    public static boolean pushComment(HashMap<String, Object> params)
            throws Exception {
        //1.封装请求
        Request request = new Request();
        HashMap<String, Object> dataReq = new HashMap<>();
        PostComment postComment = (PostComment) params.get("postComment");
        dataReq.put("token", "\"" + params.get("token") + "\"");
        dataReq.put("comment", "\"" + postComment.getComment() + "\"");
        dataReq.put("contentId", "\"" + postComment.getCommentId() + "\"");
        dataReq.put("createTime", "\"" + postComment.getCreateTime() + "\"");
        request.setAction(String.valueOf(ACTION.PUSH_COMMENT));
        request.setData(dataReq);
        //2.发送请求
        Response response = NetUtil.sendRequest(request);
        //3.取出请求并返回
        if(response.getCode() == Response.Status.SUCCESS) {
            return true;
        }
        return false;

    }
}
