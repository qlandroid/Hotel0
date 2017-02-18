package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

/**
 * 功能：长租房续约付费页面
 */
public class FlatLongRenewPayMoneyAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_long_renew_pay_money_aty);
    }

    @Override
    public void initWidget() {
        tvTitle.setText("续约订单");
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }
    }

    private void onClickToBack() {
        finish();
    }
}
