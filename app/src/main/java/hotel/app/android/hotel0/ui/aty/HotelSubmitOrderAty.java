package hotel.app.android.hotel0.ui.aty;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;

public class HotelSubmitOrderAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack , click = true)
    ImageView ivToBack;
    private AlertDialog.Builder mShowBack;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_hotel_submit_order_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mShowBack = new AlertDialog.Builder(this)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setMessage("您的订单还未完成，是否确认要离开当前页面？");
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("提交订单");
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
         if (keyCode == 4){
             toBackShowDialog();
             return true;
         }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                toBackShowDialog();
                break;
        }
    }
    private void toBackShowDialog(){
        mShowBack.show();
    }
}
