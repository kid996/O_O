package O_O.view.user;

import O_O.view.Page;

import java.util.HashMap;

public class UserUpdateNamePage extends Page {
    public UserUpdateNamePage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((boolean)context.get("isSuccess")) {
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }

    }
}
