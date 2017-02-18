package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

/**
 * 个人详情设置
 */
public class UserDetailsAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.tv_finish,click = true)
    TextView tvFinish;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_user_details_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("个人设置");
        tvFinish.setVisibility(View.VISIBLE);
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                finish();
                break;
            case R.id.tv_finish://完成
                finish();
                break;
        }
    }
}
