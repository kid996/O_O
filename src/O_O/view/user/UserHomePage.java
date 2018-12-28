package O_O.view.user;

import O_O.view.Page;

import java.util.HashMap;

public class UserHomePage extends Page {
    public UserHomePage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        if(context != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("++++++++++++++个人信息页面++++++++++++++");
            sb.append("\r\n");
            sb.append("||   昵称：" + context.get("name") + "\r\n");
            sb.append("||   性别：" + context.get("age") + "\r\n");
            sb.append("||   年龄：" + context.get("phone") + "\r\n");
            sb.append("||   手机：" + context.get("sex") + "\r\n");
            sb.append("++++++++++++++++++++++++++++++++++++++++");
            sb.append("\r\n");
            System.out.println(sb);
        }else{
            System.out.println("error page");
        }
    }
}
