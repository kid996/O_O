package O_O.view;

import O_O.model.timeline.PostComment;
import O_O.model.timeline.PostContent;
import O_O.model.user.User;
import O_O.service.timeline.TimeLineService;
import O_O.service.user.UserService;
import O_O.view.timeline.BrowseCommentByIdPage;
import O_O.view.timeline.BrowseContentsPage;
import O_O.view.timeline.PushCommentPage;
import O_O.view.timeline.PushContentPage;
import O_O.view.user.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;

public class Client {
    private HashMap<Integer, Page> mPages;
    public void initPages() {
        if (mPages == null) {
            mPages = new HashMap<>();
        }
        mPages.put(ACTION.MAIN_PAGE,
                new MainPage("入口页面", ACTION.MAIN_PAGE));
        mPages.put(ACTION.USER_INFO,
                new UserInfoPage("个人信息页面", ACTION.USER_INFO));
        mPages.put(ACTION.USER_LOGIN,
                new UserLoginPage("登陆页面", ACTION.USER_LOGIN));
        mPages.put(ACTION.USER_REGISTE,
                new UserRegistePage("注册页面", ACTION.USER_REGISTE));
        mPages.put(ACTION.USER_UPDATE_NAME,
                new UserUpdateNamePage("修改用户昵称", ACTION.USER_UPDATE_NAME));
        mPages.put(ACTION.USER_HOME,
                new UserHomePage("展示用户主页", ACTION.USER_HOME));
        mPages.put(ACTION.PUSH_CONTENT,
                new PushContentPage("发帖子", ACTION.PUSH_CONTENT));
        mPages.put(ACTION.BROWSE_CONTENTS,
                new BrowseContentsPage("查看所有帖子", ACTION.BROWSE_CONTENTS));
        mPages.put(ACTION.USER_LOGOUT,
                new UserLogoutPage("退出当前用户", ACTION.USER_LOGOUT));
        mPages.put(ACTION.USER_UPDATE_PWD,
                new UserUpdatePwdPage("修改密码", ACTION.USER_UPDATE_PWD));
        mPages.put(ACTION.BROWSE_COMMENTS,
                new BrowseCommentByIdPage("查询某条帖子的评论", ACTION.BROWSE_COMMENTS));
        mPages.put(ACTION.PUSH_COMMENT,
                new PushCommentPage("对帖子发表评论", ACTION.PUSH_COMMENT));

    }

    public void start() throws Exception {
        Scanner scan = new Scanner(System.in);
        while (true) {
            //启动主页面,这里不优雅
            HashMap<String, Object> emptyContext = new HashMap<>();
            Page mainPage = mPages.get(ACTION.MAIN_PAGE);
            mainPage.show(emptyContext);

            int commend = scan.nextInt();
            //接收一个回车
            scan.nextLine();
            switch (commend) {
                case ACTION.USER_INFO:
                    caseUserInfo(scan);
                    break;
                case ACTION.USER_LOGIN:
                    caseUserLogin(scan);
                    break;
                case ACTION.USER_REGISTE:
                    caseUserRegiste(scan);
                    break;
                case ACTION.USER_UPDATE_NAME:
                    caseUserUpdateName(scan);
                    break;
                case ACTION.USER_HOME:
                    caseUserHome();
                    break;
                case ACTION.PUSH_CONTENT:
                    casePushContent(scan);
                    break;
                case ACTION.BROWSE_CONTENTS:
                    caseBrowseContents();
                    break;
                case ACTION.USER_LOGOUT:
                    caseUserLogout();
                    break;
                case ACTION.USER_UPDATE_PWD:
                    caseUserUpdatePwd(scan);
                    break;
                case ACTION.BROWSE_COMMENTS:
                    caseBrowseComments(scan);
                    break;
                case ACTION.PUSH_COMMENT:
                    casePushComment(scan);
                    break;
                default:
                    break;
            }
        }
    }

    private void casePushComment(Scanner scan)
            throws Exception {
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还没登陆~");
        }
        System.out.println("请输入要评论的帖子id：");
        String contentId = scan.nextLine();
        System.out.println("请输入要评论的内容：");
        String comment = scan.nextLine();
        // 2.处理输入
        Page page = mPages.get(ACTION.PUSH_COMMENT);
        HashMap<String, Object> params = new HashMap<>();
        PostComment postComment = new PostComment();
        String time = nowTime();
        postComment.setAuthorId(UserContents.getInstance().get("userId"));
        postComment.setComment(comment);
        postComment.setContentId(contentId);
        postComment.setCreateTime(time);
        params.put("token", UserContents.getInstance().get("token"));
        params.put("postComment", postComment);
        boolean isSuccess = TimeLineService.pushComment(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("isSuccess", isSuccess);
        // 3.展示
        page.show(context);
    }

    private String nowTime() {
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone.setDefault(tz);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());

    }

    private void caseBrowseComments(Scanner scan)
            throws Exception {
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还没有登陆~");
            return;
        }
        System.out.println("您要查看哪条帖子的评论？");
        String contentId = scan.nextLine();
        // 2.处理用户输入
        Page page = mPages.get(ACTION.BROWSE_COMMENTS);
        HashMap<String, Object> params = new HashMap<>();
        params.put("contentId", contentId);
        params.put("token", UserContents.getInstance().get("token"));
        String comments = TimeLineService.browseComments(params);
        HashMap<String, Object> context = new HashMap<>();
        if (comments != null) {
            context.put("comments", comments);
        }
        // 3.展示
        page.show(context);
    }

    private void caseUserUpdatePwd(Scanner scan)
            throws Exception {
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还没登陆~");
            return;
        }
        System.out.println("请输入新密码：");
        String newPwd = scan.nextLine();
        System.out.println("请再次输入：");
        String reNewPwd = scan.nextLine();
        // 2.处理用户输入
        HashMap<String, Object> params = new HashMap<>();
        Page page = mPages.get(ACTION.USER_UPDATE_PWD);
        params.put("token", UserContents.getInstance().get("token"));
        params.put("newPwd", newPwd);
        params.put("reNewPwd", reNewPwd);
        boolean isSuccess = UserService.userUpdatePwd(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("isSuccess", isSuccess);
        // 3.展示
        page.show(context);
    }

    private void caseUserLogout() throws Exception {
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还未登录~");
            return;
        }
        // 2.处理用户输入
        HashMap<String, Object> params = new HashMap<>();
        Page page = mPages.get(ACTION.USER_LOGOUT);
        params.put("token", UserContents.getInstance().get("token"));
        boolean isSuccess = UserService.userLogout(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("isSuccess", isSuccess);
        // 3.展示
        page.show(context);
    }

    private void caseBrowseContents() throws Exception {
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还未登陆~");
            return;
        }
        // 2.处理用户输入
        Page page = mPages.get(ACTION.BROWSE_CONTENTS);
        HashMap<String, Object> params = new HashMap<>();
        params.put("token", UserContents.getInstance().get("token"));
        String postContents = TimeLineService.browseContents(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("contents", postContents);
        // 3.展示
        page.show(context);
    }

    private void casePushContent(Scanner scan) throws Exception {
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("请先登录哦~");
        }
        System.out.println("请输入要帖子题目：");
        String title = scan.nextLine();
        System.out.println("请输入要发送的帖子内容：");
        String content = scan.nextLine();
        // 2. 处理用户输入
        Page page = mPages.get(ACTION.PUSH_CONTENT);
        HashMap<String, Object> params = new HashMap<>();
        PostContent postContent = new PostContent();
        String time = nowTime();
        postContent.setmAuthorId(UserContents.getInstance().get("userId"));
        postContent.setTitle(title);
        postContent.setContent(content);
        postContent.setmCreateTime(time);
        params.put("postContent", postContent);
        params.put("token", UserContents.getInstance().get("token"));
        boolean isSuccess = TimeLineService.pushContent(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("isSuccess", isSuccess);
        // 3.展示
        page.show(context);
    }

    private void caseUserHome() throws Exception{
        // 1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还未登录！");
            return;
        }
        // 2.处理用户输入
        HashMap<String, Object> params = new HashMap<>();
        params.put("token", UserContents.getInstance().get("token"));
        Page page = mPages.get(ACTION.USER_HOME);
        User user = UserService.userHome(params);
        HashMap<String, Object> context = new HashMap<>();
        if(user != null) {
            context.put("name", user.getName());
            context.put("age", user.getAge());
            context.put("phone", user.getPhone());
            context.put("sex", user.getSex());
        }else{
            context = null;
        }

        // 3.展示
        page.show(context);
    }

    private void caseUserUpdateName(Scanner scan) throws Exception {
        //1.用户输入
        if (!UserContents.getInstance().isLogin()) {
            System.out.println("您还未登录！");
            return;
        }
        System.out.println("请输入用户新昵称：");
        String newName = scan.nextLine();

        //2.处理用户输入
        HashMap<String, Object> params = new HashMap<>();
        Page page = mPages.get(ACTION.USER_UPDATE_NAME);
        params.put("token", UserContents.getInstance().get("token"));
        params.put("newName", newName);
        boolean isSuccess = UserService.userUpdateName(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("isSuccess", isSuccess);

        //3.显示
        page.show(context);
    }

    private void caseUserRegiste(Scanner scan)
            throws Exception {
        //1.用户输入
        if (UserContents.getInstance().isLogin()) {
            System.out.println("您已经登陆过了，请先退出~");
            return;
        }
        System.out.println("请输入用户昵称：（小于10字符）");
        String name = scan.nextLine();
        System.out.println("请输入密码：");
        String pwd = scan.nextLine();
        System.out.println("请再次输入密码：");
        String rePwd = scan.nextLine();
        System.out.println("请输入手机号：");
        String phone = scan.nextLine();
        System.out.println("请输入您的年龄：(200以内的数字)");
        String age = scan.nextLine();
        System.out.println("请输入您的性别：");
        String sex = scan.nextLine();

        //2.处理用户输入
        Page page = mPages.get(ACTION.USER_REGISTE);
        HashMap<String, Object> params = new HashMap<>();

        User newUser = new User();
        newUser.setAge(age);
        newUser.setName(name);
        newUser.setPhone(phone);
        newUser.setPwd(pwd);
        newUser.setSex(sex);
        params.put("user", newUser);
        params.put("rePwd", rePwd);
        boolean flag = checkAction(params);
        HashMap<String, Object> context = new HashMap<>();
        if(flag) {
            boolean isSuccess = UserService.registe(params);
            context.put("isSuccess", isSuccess);
            context.put("name", name);
        }else{
            context.put("isSuccess", false);
        }
        //3.显示
        page.show(context);
    }

    private static boolean checkAction(HashMap<String, Object> context) {
        User user = (User)context.get("user");
        String name = user.getName();
        String pwd = user.getPwd();
        String rePwd = (String)context.get("rePwd");
        String phone = user.getPhone();
        String age = user.getAge();

        if(name.length() > 10) {
            System.out.println("名字太长");
            return false;
        }
        if(!pwd.equals(rePwd)) {
            System.out.println("两次密码不一致");
            return false;
        }
        if(phone.length() != 11) {
            System.out.println("手机号长度不对");
            return false;
        }else {
            for(int i = 0 ; i < 11 ; i ++) {
                char c = phone.charAt(i);
                if(!Character.isDigit(c)) {
                    System.out.println("手机号输入有误");
                    return false;
                }
            }
        }
        for(int i = 0 ; i < age.length() ; i ++) {
            char c = age.charAt(i);
            if(!Character.isDigit(c)) {
                System.out.println("年龄不是数字");
                return false;
            }
        }
        if(Integer.parseInt(age) >200) {
            System.out.println("年龄不符合实际");
            return false;
        }
        return true;
    }

    private void caseUserLogin(Scanner scan) throws Exception {
        //1.用户输入
        if (UserContents.getInstance().isLogin()) {
            System.out.println("您已经登陆过了~");
            return;
        }
        System.out.println("手机号：");
        String phone = scan.nextLine();
        System.out.println("密码：");
        String pwd = scan.nextLine();

        //2.处理用户输入
        Page page = mPages.get(ACTION.USER_LOGIN);
        HashMap<String, Object> params = new HashMap<>();
        params.put("pwd", pwd);
        params.put("phone", phone);
        boolean isSuccess = UserService.login(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("isSuccess", isSuccess);


        //3.显示
        page.show(context);
    }

    private void caseUserInfo(Scanner scan)
            throws Exception {
        //1.用户输入
        System.out.println("请输入要查询用户的手机号");
        String phone = scan.nextLine();

        //2.处理用户输入
        Page page = mPages.get(ACTION.USER_INFO);
        HashMap<String, Object> params = new HashMap<>();
        params.put("phone", phone);
        User user = UserService.queryUserInfo(params);
        HashMap<String, Object> context = new HashMap<>();
        context.put("user", user);

        //3.显示
        page.show(context);
    }
}
