package cn.yizhupingtai.android.hotel.contract;

import cn.yizhupingtai.android.hotel.bean.UserBean;

/**
 * Created by Administrator on 2017-2-18.
 */
public class LoginContract {

    public interface View {
        String getAccount();
        String getPassword();
        void toHomeAty();
        void clearAccount();
        void clearPassword();
        void display(String s);
        void showLoginDialog();
        void cancelDialog();
        void showToAccount();
        void showToPassword();
        void closeAty();
    }

    public interface Presenter {

        void login();
        void clear();
    }

    public interface Model {
        void login(String name , String password,OnLoginListener listener);
    }

    public interface OnLoginListener{
        void loginSuccess(UserBean userBean);
        void loginFailed(String errorMsg);
    }


}