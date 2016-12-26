package hotel.app.android.hotel0.ui.aty;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.C;
import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.mylibrary.bean.ClickBean;
import hotel.app.android.mylibrary.inter.OnItemClickListener;
import hotel.app.android.mylibrary.view.CalendarView;

/**
 * 功能：时间选择器
 */
public class CalendarAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.cv_calendar)
    CalendarView cvCalendar;
    @Override
    public void setRootView() {
        setContentView(R.layout.activity_calendar_aty);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initWidget() {
        tvTitle.setText("时间选择");
        ivToBack.setVisibility(View.VISIBLE);
        cvCalendar.setAfterDay(100);
        cvCalendar.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onSuccess(ClickBean inBean, ClickBean outBean, int amountDay) {
                Intent intent = new Intent();
                intent.putExtra(C.Aty.HotelInTime,inBean);
                intent.putExtra(C.Aty.HotelOutTime,outBean);
                intent.putExtra(C.Aty.HotelAmountDay,amountDay);

                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        cvCalendar.onDestroy();
        super.onDestroy();
    }
}
