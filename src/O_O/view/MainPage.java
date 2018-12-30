package O_O.view;

import java.util.HashMap;

public class MainPage extends Page{
    public MainPage(String title, int pageId){
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context){
        StringBuilder sb = new StringBuilder();
        sb.append("<<<<<<<<!【O V O】！>>>>>>>>\n");
        if(context.get("name") != null) {
            sb.append(context.get("name"));
        }else{
            sb.append("亲");
        }
        sb.append("，输入数字选择您想要的操作哦：\n");
        sb.append("1.查询用户信息\n");
        sb.append("2.登陆\n");
        sb.append("3.注册\n");
        sb.append("4.修改昵称\n");
        sb.append("5.展示我的主页\n");
        sb.append("6.发帖\n");
        sb.append("7.查看全部帖子\n");
        sb.append("8.退出当前账户\n");
        sb.append("9.修改密码\n");
        sb.append("10.浏览评论\n");
        sb.append("11.发布评论\n");
        sb.append("===============================");
        System.out.println(sb);
    }
}
