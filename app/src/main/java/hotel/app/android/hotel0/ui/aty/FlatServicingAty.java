package hotel.app.android.hotel0.ui.aty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.ui.view.NameTextView;

/**
 * 功能： 公寓中申请维修页面
 */
public class FlatServicingAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id =R.id.ntv_userName)
    NameTextView ntvUserName;
    @BindView(id = R.id.ntv_flatAddress)
    NameTextView ntvFlatAddress;
    @BindView(id = R.id.ntv_userPhone,click = true)
    NameTextView ntvUserPhone;
    @BindView(id = R.id.tv_submit,click = true)
    TextView tvSubmit;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_servicing_aty);
    }

    @Override
    public void initWidget() {
        tvTitle.setText("报修申请");
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
            case R.id.tv_submit:
                onCLickSubmit();
                break;
            case R.id.ntv_userPhone:
                onClickEditUserPhone();
                break;
        }
    }

    /**
     * 功能：点击手机号码，修改联系客户的电话号码；
     */
    private void onClickEditUserPhone() {
        ViewInject.toast("修改手机号");
    }

    /**
     * 功能：提交报修
     */
    private void onCLickSubmit() {
        ViewInject.toast("提交报修");
    }

    /**
     * 点击返回键
     */
    private void onClickToBack() {
        finish();
    }
}
