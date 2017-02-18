package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

public class HotelCloseAty extends BaseActivity {
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.tv_closeHotelBooked)
    TextView tvCloseHotelBooked;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_hotel_close_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("取消订单");
        ivToBack.setVisibility(View.VISIBLE);
        tvCloseHotelBooked.setVisibility(View.GONE);
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
