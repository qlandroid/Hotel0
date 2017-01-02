package hotel.app.android.hotel0.ui.aty;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;

/**
 * 功能：长租公寓 中申请维修服务列表；
 */
public class FlatServiceAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_serviceList)
    RecyclerView rvServiceList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_service_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("申请服务列表");
        ivToBack.setVisibility(ImageView.VISIBLE);

    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }
    }

    /**
     * 功能：点击返回键
     */
    private void onClickToBack() {
        finish();
    }
}
