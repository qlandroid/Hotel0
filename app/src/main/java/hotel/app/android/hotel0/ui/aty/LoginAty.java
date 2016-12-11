package hotel.app.android.hotel0.ui.aty;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.ui.view.KeyboardLinearLayout;

public class LoginAty extends BaseActivity {

    @BindView(id = R.id.kll_layout)
    KeyboardLinearLayout kllLayout;
    @BindView(id = R.id.v_showKey)
    View vShowKey;
    @BindView(id = R.id.sv_scrollLayout)
    ScrollView svScrollLayout;
    @BindView(id = R.id.tv_login, click = true)
    TextView tvLogin;
    @BindView(id = R.id.v_showContentTop)
    View vShowContentTop;
    @BindView(id = R.id.tv_register, click = true)
    TextView tvRegister;
    @BindView(id = R.id.tv_retrieve, click = true)
    TextView tvRetrieve;

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

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_login_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mUiHeight = getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        ViewGroup.LayoutParams lp = vShowContentTop.getLayoutParams();
        lp.height = (int) (0.25 * mUiHeight);
        kllLayout.setKeyBordStateListener(keyBordStateListener);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.tv_login:
                startHomeActivity();
                break;
            case R.id.tv_register://注册
                startRegister();
                break;
            case R.id.tv_retrieve: //忘记密码
                startRetrieveActivity();
                break;
        }
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
        Intent intent = new Intent(this, HomeAty.class);
        startActivity(intent);
        finish();
    }
}
