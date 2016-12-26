package hotel.app.android.hotel0.ui.aty;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.C;
import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HotelBean;
import hotel.app.android.hotel0.config.IHotelDetailsView;
import hotel.app.android.hotel0.inter.OnItemClickListener;
import hotel.app.android.hotel0.ui.adapter.HotelDetailsAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;
import hotel.app.android.mylibrary.bean.ClickBean;

/**
 * 功能：酒店详情
 */
public class HotelDetailsAty extends BaseActivity implements IHotelDetailsView {
    public static final int REQUEST_CALENDAR_SELECT = 0x123;

    @BindView(id = R.id.rv_listDetails)
    RecyclerView rvListDetails;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack, click = true)
    ImageView ivToBack;
    @BindView(id = R.id.showView)
    View showView;
    @BindView(id = R.id.ll_selectInTime, click = true)
    View llSelecetInTime;
    @BindView(id = R.id.tv_hotelName)
    TextView tvHotelName;
    @BindView(id = R.id.tv_hotelInTime)
    TextView tvHotelInTime;
    @BindView(id = R.id.tv_hotelOutTime)
    TextView tvHotelOutTime;
    @BindView(id = R.id.tv_hotelAmountDay)
    TextView tvHotelAmountDay;

    private HotelDetailsAdapter mDetailsAdapter;
    private IHotelDetailsView mIView;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_hotel_details_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mIView = this;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        mIView.setHotelTitleView("酒店详情");
        ivToBack.setVisibility(View.VISIBLE);
        showView.setFocusable(true);
        showView.setFocusableInTouchMode(true);
        showView.requestFocus();
        rvListDetails.setLayoutManager(new LinearLayoutManager(this));
        List list = new ArrayList();
        for (int i = 0; i < 6; i++) {
            list.add("item--->" + i);
        }
        mDetailsAdapter = new HotelDetailsAdapter(this, list, new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                startActivity(new Intent(HotelDetailsAty.this, HotelSubmitOrderAty.class));
            }
        });
        rvListDetails.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvListDetails.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rvListDetails.setAdapter(mDetailsAdapter);

    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.iv_toBack:
                finish();
                break;
            case R.id.ll_selectInTime:
                onClickSelectInTime();
                break;
        }
    }

    /**
     * 功能：点击时间选择控件
     */
    private void onClickSelectInTime() {
        startActivityForResult(new Intent(this, CalendarAty.class), REQUEST_CALENDAR_SELECT);
    }

    /*****************************************************************************************/
    /*****************************************************************************************/
    /***********************************
     * 对有返回值的Activity操作
     *******************************/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CALENDAR_SELECT:
                    requestCalendarSelect(data);
                    break;
            }
        }
    }

    /**
     * 功能：选择时间后的结果进行操作
     * @param data
     */
    private void requestCalendarSelect(Intent data) {
        int hotelAmountDay = data.getIntExtra(C.Aty.HotelAmountDay,0);
        mIView.setHotelAmountDayView(hotelAmountDay);
        ClickBean inBean = data.getParcelableExtra(C.Aty.HotelInTime);
        mIView.setHotelInTimeView(inBean.getYear(),inBean.getMonth(),inBean.getDay());
        ClickBean outBean = data.getParcelableExtra(C.Aty.HotelOutTime);
        mIView.setHotelOutTimeView(outBean.getYear(), outBean.getMonth(),outBean.getDay());
    }

    /************************* 带有返回值的操作结束 ***************************************/
    /**************************************************************************************/
    /******************************
     * view的控制层
     ******************************************/

    @Override
    public void setBannerList(List<Object> list) {

    }

    @Override
    public void setHotelInTimeView(int year, int month, int day) {
        tvHotelInTime.setText((month+1) + "月" + day + "日");
    }

    @Override
    public void setHotelOutTimeView(int year, int month, int day) {
        tvHotelOutTime.setText((month+1) + "月" + day + "日");
    }

    @Override
    public void setHotelAmountDayView(int amountDay) {
        tvHotelAmountDay.setText(String.valueOf(amountDay)+"晚");
    }

    @Override
    public void setHotelHomeDetailsView(List<HotelBean> list) {
        mDetailsAdapter.update(list);
    }

    @Override
    public void setHotelNameView(String name) {
        tvHotelName.setText(name);
    }

    @Override
    public void setHotelTitleView(String title) {
        tvTitle.setText(title);
    }
    /*************************** 控制View层 结束 ******************************************/
    /**************************************************************************************/
}
