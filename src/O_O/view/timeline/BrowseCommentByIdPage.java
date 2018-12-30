package O_O.view.timeline;

import O_O.view.Page;

import java.util.HashMap;

public class BrowseCommentByIdPage extends Page {
    public BrowseCommentByIdPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if(context.containsKey("comments")) {
            String comments = (String)context.get("comments");
            System.out.println(comments.replace("\t", "\n"));
        }else {
            System.out.println("请求评论内容失败！");
        }

    }
}
