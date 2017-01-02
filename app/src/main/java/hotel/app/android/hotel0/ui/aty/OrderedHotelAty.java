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
import hotel.app.android.hotel0.bean.OrderedHotelBean;
import hotel.app.android.hotel0.ui.adapter.OrderedHotelDetailsAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;

/**
 * 功能：已经预订酒店详情
 */
public class OrderedHotelAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_bookedHotelList)
    RecyclerView rvBookedHotelListView;
    private OrderedHotelDetailsAdapter mBookedHotelAdapter;
    private List<OrderedHotelBean> mBookedList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_ordered_hotel_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mBookedList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mBookedList.add(new OrderedHotelBean());
        }
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("预订酒店列表");
        ivToBack.setVisibility(View.VISIBLE);
        rvBookedHotelListView.setLayoutManager(new LinearLayoutManager(this));
        rvBookedHotelListView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mBookedHotelAdapter = new OrderedHotelDetailsAdapter(this, mBookedList, new OrderedHotelDetailsAdapter.OnHotelBookedCloseClickListener() {
            @Override
            public void onClickClose(int position, OrderedHotelBean bean) {
                ViewInject.toast("关闭菜单" + position);
                startActivity(new Intent(OrderedHotelAty.this,HotelCloseAty.class));
            }

            @Override
            public void onClickItem(View v, int position, OrderedHotelBean bean) {
                ViewInject.toast("点击整个item"+position);
                startActivity(new Intent(OrderedHotelAty.this,OrderedHotelDetailsAty.class));
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
