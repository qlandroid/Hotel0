package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

/**
 * 功能：公寓添加入住人
 */
public class FlatAddUserAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.tv_addUser,click = true)
    TextView tvAddUser;
    @BindView(id = R.id.et_addName)
    EditText etAddName;
    @BindView(id = R.id.et_addUserNumber)
    EditText etAddUserNumber;
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_add_user_aty);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("添加入住人");
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
            case R.id.tv_addUser:
                onClickAddUser();
                break;
        }
    }

    /**
     * 功能：点击添加用户
     */
    private void onClickAddUser() {
        ViewInject.toast("添加入住人");
    }

    /**
     * 功能：返回
     */
    private void onClickToBack() {

    }
}
