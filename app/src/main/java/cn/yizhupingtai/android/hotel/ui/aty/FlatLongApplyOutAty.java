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
 * 功能：长租房申请退房
 */
public class FlatLongApplyOutAty extends BaseActivity {
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.tv_submit,click = true)
    TextView tvSubmit;
    @BindView(id = R.id.et_editContent)
    EditText etEditContent;
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_apply_out_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("申请退租");
        ivToBack.setVisibility(ImageView.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
            case R.id.tv_submit:
                onClickSubmit();
                break;
        }
    }

    /**
     * 功能：点击申请提交
     */
    private void onClickSubmit() {
        ViewInject.toast("提交成功");
        finish();
    }

    /**
     * 功能：返回
     */
    private void onClickToBack() {
        finish();
    }
}
