package O_O.model.user;

public class User {
    private String mUserId;
    private String mName;
    private String mPhone;
    private String mPwd;
    private String mAge;
    private String mSex;
    private String mToken;

    public String getUserId() {
        return mUserId;
    }
    public void setUserId(String mUserId) {
        this.mUserId = mUserId;
    }
    public String getName() {
        return mName;
    }
    public void setName(String mName) {
        this.mName = mName;
    }
    public String getPhone() {
        return mPhone;
    }
    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }
    public String getPwd() {
        return mPwd;
    }
    public void setPwd(String mPassword) {
        this.mPwd = mPassword;
    }
    public String getAge() {
        return mAge;
    }
    public void setAge(String mAge) {
        this.mAge = mAge;
    }
    public String getSex() {
        return mSex;
    }
    public void setSex(String mSex) {
        this.mSex = mSex;
    }
    public String getToken() {
        return mToken;
    }
    public void setToken(String mToken) {
        this.mToken = mToken;
    }
}
