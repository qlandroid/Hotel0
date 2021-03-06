package cn.yizhupingtai.android.hotel.presenter;

import cn.yizhupingtai.android.hotel.contract.LoginContract;
import cn.yizhupingtai.android.hotel.model.LoginModelImpl;


/**
 * Created by Administrator on 2017/02/18
 */

public class LoginPresenterImpl implements LoginContract.Presenter {

    LoginModelImpl mLoginModeImpl;
    LoginContract.View mLoginView;

    public LoginPresenterImpl(LoginContract.View mLoginView) {
        this.mLoginView = mLoginView;
        mLoginModeImpl = new LoginModelImpl();
    }

    @Override
    public void login() {
        String account = mLoginView.getAccount();
        String password = mLoginView.getAccount();
        if (!isNotNull(account, password)) {
            return;
        }
        mLoginView.showLoginDialog();
        mLoginView.toHomeAty();
       /* mLoginModeImpl.login(mLoginView.getAccount(), mLoginView.getPassword(), new LoginContract.OnLoginListener() {
            @Override
            public void loginSuccess(UserBean userBean) {
                mLoginView.toHomeAty();
                mLoginView.cancelDialog();
                mLoginView.closeAty();
            }

            @Override
            public void loginFailed(String errorMsg) {
                mLoginView.display(errorMsg);
                mLoginView.clearPassword();
                mLoginView.cancelDialog();
            }
        });*/
    }

    private boolean isNotNull(String account, String password) {
        if (account == null || account.isEmpty()) {
            mLoginView.display("账号不能为空");
            mLoginView.showToAccount();
            return false;
        }
        if (password == null || password.isEmpty()) {
            mLoginView.display("密码不能为空");
            mLoginView.showToPassword();
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        mLoginView.clearPassword();
    }
}