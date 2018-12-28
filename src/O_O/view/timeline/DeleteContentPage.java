package O_O.view.timeline;

import O_O.view.Page;

import java.util.HashMap;

public class DeleteContentPage extends Page {
    public DeleteContentPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((Boolean)context.get("isSuccess")) {
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }

    }
}
