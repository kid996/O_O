package O_O.view.timeline;

import O_O.view.Page;

import java.util.HashMap;

public class PushContentPage extends Page {
    public PushContentPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((boolean)context.get("isSuccess")) {
            System.out.println("发帖成功！");
        }else {
            System.out.println("发帖失败！");
        }

    }
}
