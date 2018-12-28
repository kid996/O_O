package O_O.view.timeline;

import O_O.view.Page;

import java.util.HashMap;

public class PushCommentPage extends Page {
    public PushCommentPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((Boolean)context.get("isSuccess")) {
            System.out.println("成功发送评论！");
        }else {
            System.out.println("sorry,评论上传失败了~");
        }

    }
}
