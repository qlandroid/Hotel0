package hotel.app.android.hotel0.ui.aty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;

/**
 * 功能：已定长租公寓详情页面
 */
public class OrderedFlatLongDetailsAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_ordered_flat_long_details_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("已订长租公寓详情");
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

    /**
     * 功能：点击返回
     */
    private void onClickToBack() {
        finish();
    }
}
