package O_O.view.user;

import O_O.model.user.User;
import O_O.view.Page;

import java.util.HashMap;

public class UserInfoPage extends Page {
    public UserInfoPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        StringBuilder sb = new StringBuilder();
        if(context.get("user") == null) {
            sb.append("抱歉，没有查询到此用户");
        }else {
            User user = (User)context.get("user");
            sb.append("++++++++++++++个人信息页面++++++++++++++");
            sb.append("\r\n");
            sb.append("||   昵称：" + user.getName() + "\r\n");
            sb.append("||   性别：" + user.getSex() + "\r\n");
            sb.append("||   年龄：" + user.getAge() + "\r\n");
            sb.append("||   手机：" + user.getPhone() + "\r\n");
            sb.append("++++++++++++++++++++++++++++++++++++++++");
            sb.append("\r\n");
        }

        System.out.println(sb.toString());

    }
}
