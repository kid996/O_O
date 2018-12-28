package O_O.view;

import java.util.HashMap;

public class MainPage extends Page{
    public MainPage(String title, int pageId){
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context){
        System.out.println("<<<<<<<<!【O V O】！>>>>>>>>");
        System.out.println("亲，输入数字选择您想要的操作哦：");
        System.out.println("1.查询用户信息");
        System.out.println("2.登陆");
        System.out.println("3.注册");
        System.out.println("4.修改昵称");
        System.out.println("5.展示我的主页");
        System.out.println("6.发帖");
        System.out.println("7.查看全部帖子");
        System.out.println("8.退出当前账户");
        System.out.println("9.修改密码");
        System.out.println("10.浏览评论");
        System.out.println("11.发布评论");
        System.out.println("===============================");
    }
}
