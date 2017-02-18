package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

/**
 * 注册
 */
public class RegisterAty extends BaseActivity {
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_register_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("注册中心");
        ivToBack.setVisibility(View.VISIBLE);
    }
    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                finish();
                break;
        }
    }
}
