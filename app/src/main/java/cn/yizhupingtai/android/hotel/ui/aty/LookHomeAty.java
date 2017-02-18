package cn.yizhupingtai.android.hotel.ui.aty;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;

import java.util.Calendar;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

public class LookHomeAty extends BaseActivity {
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.fl_selectTime,click = true)
    View flSelectTime;
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_look_home_aty);
    }

    @Override
    public void initWidget() {
        tvTitle.setText("预约看房");
        ivToBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                finish();
                break;
            case R.id.fl_selectTime:
                onClickSelectTime();
                break;
        }
    }

    /**
     * 功能：点击选择看房时间
     */
    private void onClickSelectTime() {
        Calendar calendar = Calendar.getInstance();
       new  DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
               ViewInject.toast(year+"year"+monthOfYear +"month"+dayOfMonth+"day");
           }
       },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) ).show();
    }
}
