package O_O.view.user;

import O_O.view.Page;

import java.util.HashMap;

public class UserLoginPage extends Page {
    public UserLoginPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((boolean)context.get("isSuccess")) {
            System.out.println("登陆成功！");
        }else {
            System.out.println("登陆失败！");
        }
    }
}
