package cn.yizhupingtai.android.hotel.ui.aty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.contract.LoginContract;
import cn.yizhupingtai.android.hotel.inter.OnForbidClickListener;
import cn.yizhupingtai.android.hotel.presenter.LoginPresenterImpl;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;
import cn.yizhupingtai.android.hotel.ui.view.KeyboardLinearLayout;

public class LoginAty extends BaseActivity implements LoginContract.View {

    @BindView(id = R.id.kll_layout)
    KeyboardLinearLayout kllLayout;
    @BindView(id = R.id.v_showKey)
    View vShowKey;
    @BindView(id = R.id.sv_scrollLayout)
    ScrollView svScrollLayout;
    @BindView(id = R.id.tv_login)
    TextView tvLogin;
    @BindView(id = R.id.v_showContentTop)
    View vShowContentTop;
    @BindView(id = R.id.tv_register)
    TextView tvRegister;
    @BindView(id = R.id.tv_retrieve)
    TextView tvRetrieve;
    @BindView(id = R.id.et_loginAccount)
    EditText etLoginAccount;
    @BindView(id = R.id.et_loginPassword)
    EditText etLoginPassword;

    KeyboardLinearLayout.KeyBordStateListener keyBordStateListener = new KeyboardLinearLayout.KeyBordStateListener() {
        @Override
        public void stateChange(int state) {
            switch (state) {
                case KeyboardLinearLayout.KEYBORAD_HIDE://输入发隐藏
                    vShowKey.setVisibility(View.GONE);
                    break;
                case KeyboardLinearLayout.KEYBORAD_SHOW:
                    svScrollLayout.scrollTo((int) tvLogin.getX(), (int) tvLogin.getY());
                    vShowKey.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    private int mUiHeight;
    private LoginContract.Presenter mLoginPresenter;
    private ProgressDialog mLoginDialog;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_login_aty);
    }

    @Override
    public void initData() {
        super.initData();

        mLoginDialog = new ProgressDialog(this);
        mLoginDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mLoginDialog.setMessage("登录中...");
        mLoginDialog.setCanceledOnTouchOutside(false);

        mUiHeight = getResources().getDisplayMetrics().heightPixels;
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        ViewGroup.LayoutParams lp = vShowContentTop.getLayoutParams();
        lp.height = (int) (0.25 * mUiHeight);
        kllLayout.setKeyBordStateListener(keyBordStateListener);

        tvLogin.setOnClickListener(new OnForbidClickListener() {
            @Override
            public void forbidClick(View v) {
                startHomeActivity();
            }
        });
        tvRegister.setOnClickListener(new OnForbidClickListener() {
            @Override
            public void forbidClick(View v) {
                startRegister();
            }
        });
        tvRetrieve.setOnClickListener(new OnForbidClickListener() {
            @Override
            public void forbidClick(View v) {
                startRetrieveActivity();
            }
        });
    }


    /**
     * 启动忘记密码页面，找回密码；
     */
    private void startRetrieveActivity() {
        Intent intent = new Intent(this, RetrieveAty.class);
        startActivity(intent);
    }

    /**
     * 启动注册页面；
     */
    private void startRegister() {
        Intent intent = new Intent(this, RegisterAty.class);
        startActivity(intent);
    }

    /**
     * 启动主页面
     */
    private void startHomeActivity() {
        mLoginPresenter.login();
    }

    @Override
    public String getAccount() {
        return etLoginAccount.getText().toString();
    }

    @Override
    public String getPassword() {
        return etLoginPassword.getText().toString();
    }

    @Override
    public void toHomeAty() {
        Intent intent = new Intent(this, HomeAty.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void clearAccount() {
        etLoginAccount.setText("");
    }

    @Override
    public void clearPassword() {
        etLoginPassword.setText("");
    }

    @Override
    public void display(String s) {
        ViewInject.toast(s);
    }

    @Override
    public void showLoginDialog() {
        mLoginDialog.show();
    }

    @Override
    public void cancelDialog() {
        mLoginDialog.cancel();
    }
}
