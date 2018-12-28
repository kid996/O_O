package O_O.view.user;

import O_O.view.Page;

import java.util.HashMap;

public class UserLogoutPage extends Page {
    public UserLogoutPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((Boolean)context.get("isSuccess")) {
            System.out.println("退出成功！");
        }else {
            System.out.println("退出失败！");
        }

    }
}
