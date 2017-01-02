package hotel.app.android.hotel0.bean;

/**
 * 功能：显示入住人信息
 * Created by Administrator on 2016-12-29.
 */
public class OrderedUserDetailsBean {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 身份证号
     */
    private String userNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
