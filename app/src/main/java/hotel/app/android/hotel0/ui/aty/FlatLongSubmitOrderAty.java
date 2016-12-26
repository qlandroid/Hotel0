package hotel.app.android.hotel0.ui.aty;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.config.IFlatLongSubmitOrderView;
import hotel.app.android.hotel0.ui.base.BaseActivity;

/**
 * 功能：长租房预订：
 */
public class FlatLongSubmitOrderAty extends BaseActivity implements IFlatLongSubmitOrderView{

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.tv_submit,click = true)
    TextView tvSubmit;
    @BindView(id = R.id.tv_inYear)
    TextView tvInYear;
    @BindView(id = R.id.tv_inDay)
    TextView tvInDay;
    @BindView(id = R.id.tv_inMonth)
    TextView tvInMonth;
    @BindView(id = R.id.tv_longTime)
    TextView tvLongTime;
    @BindView(id = R.id.tv_userName)
    TextView tvUserName;
    @BindView(id = R.id.tv_userNumber)
    TextView tvUserNumber;
    @BindView(id = R.id.tv_flatName)
    TextView tvFlatName;
    @BindView(id = R.id.tv_flatAddress)
    TextView tvFlatAddress;
    @BindView(id = R.id.tv_flatArea)
    TextView tvFlatArea;
    @BindView(id = R.id.iv_flatIcon)
    ImageView ivFlatIcon;
    @BindView(id = R.id.tv_payMode)
    TextView tvPayMode;
    @BindView(id = R.id.ll_payMode,click = true)
    View llPayMode;
    @BindView(id = R.id.ll_selectInTime,click = true)
    View llSelectInTime;
    @BindView(id = R.id.ll_selectLongTime,click = true)
    View llSelectLongTime;

    private IFlatLongSubmitOrderView mOperateView;
    private String[] mSelectPayMode = new String[]{"押一付一","押一付二","押一付三","押一付六"};
    private String[] mSelectLongTime = {"1个月","2个月","3个月","4个月","5个月","6个月","7个月","8个月","9个月","10个月","11个月","12个月"};
    private AlertDialog mSelectPayModeDialog;
    private AlertDialog mSelectInLongTimeDialog;
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_long_submit_order_aty);
    }

    @Override
    public void initData() {
        mOperateView = this;
        mSelectInLongTimeDialog = createDialog(mSelectLongTime, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mOperateView.setInFlatLongTimeView(mSelectLongTime[which]);
                dialog.dismiss();
            }
        });
        mSelectPayModeDialog = createDialog(mSelectPayMode, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mOperateView.setInFlatPayModeView(mSelectPayMode[which]);
                dialog.dismiss();
            }
        });
    }

    @Override
    public void initWidget() {
        tvTitle.setText("生成订单");
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
            case R.id.tv_submit:
                onClickSubmit();
                break;
            case R.id.ll_selectInTime:
                onClickSelectInTime();
                break;
            case R.id.ll_selectLongTime:
                onClickSelectLongTime();
                break;
            case R.id.ll_payMode:
                onClickPayMode();
                break;
        }
    }

    /**
     *  功能：点击入住时间
     *         弹出时间选择器,进行时间选择
     */
    private void onClickSelectInTime() {

    }

    /**
     * 功能：点击入住时间
     *       弹出对话框，进行选择入住时间
     */
    private void onClickSelectLongTime() {
        mSelectInLongTimeDialog.show();
    }

    /**
     * 功能：点击支付方式
     *          弹出对话框，进行选择入住方式
     */
    private void onClickPayMode() {
        mSelectPayModeDialog.show();
    }

    /**
     * 功能：当点击提交进行的操作
     */
    private void onClickSubmit() {
        ViewInject.toast("应该跳转支付页面");
    }

    /**
     * 功能：当点击返回时进行的操作
     *          弹出对话框是否确认退出
     */
    private void onClickToBack() {
        ViewInject.toast("退出");
        finish();
    }

    @Override
    public void onClickKeyToBack() {
        super.onClickKeyToBack();
        onClickToBack();
    }

    /**
     * 功能：创建选择的dialog
     * @return
     */
    private AlertDialog createDialog(String[] showContent, AlertDialog.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setItems(showContent,listener );
        return builder.create();
    }

    /*********************************************************************************/
    /********************* 控制当前页面的显示控件 **********************************/
    /*********************************************************************************/
    @Override
    public void setInFlatTimeView(int year, int month, int day) {
        tvInYear.setText(String.valueOf(year));
        tvInMonth.setText(String.valueOf(month));
        tvInDay.setText(String.valueOf(day));
    }

    @Override
    public void setInFlatLongTimeView(String longMonth) {
        tvLongTime.setText(longMonth);
    }

    @Override
    public void setInFlatPayModeView(String payMode) {
        tvPayMode.setText(payMode);
    }

    @Override
    public void setInitFlatDetailsView(String name, String address, String area, Object imgPath) {
        tvFlatArea.setText(area);
        tvFlatAddress.setText(address);
        tvFlatName.setText(name);
        Glide.with(this).load(imgPath).into(ivFlatIcon);
    }

    @Override
    public void setUserNameView(String userName) {
        tvUserName.setText(userName);
    }

    @Override
    public void setUserNumberView(String userNumber) {
        tvUserNumber.setText(userNumber);
    }
    /**************************  控制显示控件结束  ***********************************/
    /*********************************************************************************/
}
