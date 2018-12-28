package O_O.view.user;

import O_O.view.Page;

import java.util.HashMap;

public class UserRegistePage extends Page {
    public UserRegistePage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if((boolean)context.get("isSuccess")) {
            System.out.println("恭喜 " + context.get("name") + " ，注册成功！");
        }else {
            System.out.println("注册失败，可能是网络原因，也可能是注册信息有误~");
        }

    }
}
