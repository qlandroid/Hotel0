package hotel.app.android.hotel0.ui.aty;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.ViewInject;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HotelDetailsBookedBean;
import hotel.app.android.hotel0.ui.adapter.HotelBookedDetailsAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;

public class HotelDetailsBookedAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_bookedHotelList)
    RecyclerView rvBookedHotelListView;
    private HotelBookedDetailsAdapter mBookedHotelAdapter;
    private List<HotelDetailsBookedBean> mBookedList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_hotel_details_booked_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mBookedList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mBookedList.add(new HotelDetailsBookedBean());
        }
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("预订酒店列表");
        ivToBack.setVisibility(View.VISIBLE);
        rvBookedHotelListView.setLayoutManager(new LinearLayoutManager(this));
        rvBookedHotelListView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mBookedHotelAdapter = new HotelBookedDetailsAdapter(this, mBookedList, new HotelBookedDetailsAdapter.OnHotelBookedCloseClickListener() {
            @Override
            public void onClickClose(int position, HotelDetailsBookedBean bean) {
                ViewInject.toast("关闭菜单" + position);
                startActivity(new Intent(HotelDetailsBookedAty.this,HotelCloseAty.class));
            }

            @Override
            public void onClickItem(View v, int position, HotelDetailsBookedBean bean) {
                ViewInject.toast("点击整个item"+position);
            }
        });
        rvBookedHotelListView.setAdapter(mBookedHotelAdapter);
    }

    @Override
    public void widgetClick(View v) {
       super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                finish();
                break;
        }
    }
}
