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
            System.out.println((String)context.get("comments"));
        }else {
            System.out.println("请求评论内容失败！");
        }

    }
}
