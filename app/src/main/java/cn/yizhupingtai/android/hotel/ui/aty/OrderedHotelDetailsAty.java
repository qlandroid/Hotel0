package cn.yizhupingtai.android.hotel.ui.aty;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.bean.OrderedUserDetailsBean;
import cn.yizhupingtai.android.hotel.ui.adapter.OrderedFlatSmallDetailsUserAdapter;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;
import cn.yizhupingtai.android.hotel.utils.DividerItemDecoration;

/**
 * 功能：已订酒店的详细信息页面
 */
public class OrderedHotelDetailsAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack, click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_userList)
    RecyclerView rvUserList;
    private OrderedFlatSmallDetailsUserAdapter mOrderedUserDetailsAdapter;
    private ArrayList<OrderedUserDetailsBean> mUserDetailsList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_ordered_hotel_details_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mUserDetailsList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            OrderedUserDetailsBean bean = new OrderedUserDetailsBean();
            bean.setUserName("item-->" + i);
            bean.setUserNumber("123456789098765432");
            mUserDetailsList.add(bean);
        }
    }


    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("已订酒店详情");
        tvTitle.setFocusable(true);
        tvTitle.setFocusableInTouchMode(true);
        tvTitle.requestFocus();

        ivToBack.setVisibility(View.VISIBLE);
        rvUserList.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mOrderedUserDetailsAdapter = new OrderedFlatSmallDetailsUserAdapter(this, mUserDetailsList);
        rvUserList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rvUserList.setAdapter(mOrderedUserDetailsAdapter);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }
    }

    private void onClickToBack() {

    }
}
