package cn.yizhupingtai.android.hotel;

import android.content.Intent;

import cn.yizhupingtai.android.hotel.ui.aty.LoginAty;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void setRootView() {

    }

    @Override
    public void initData() {
        Intent intent = new Intent(this, LoginAty.class);
        startActivity(intent);
        finish();
    }
}
