package hotel.app.android.hotel0.ui.aty;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.OrderedUserDetailsBean;
import hotel.app.android.hotel0.ui.adapter.OrderedFlatSmallDetailsUserAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;

/**
 * 功能：已订短租房详细信息，提供入住人信息，入住详情；
 */
public class OrderedFlatSmallDetailsAty extends BaseActivity {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack, click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_userList)
    RecyclerView rvUserList;
    private OrderedFlatSmallDetailsUserAdapter mOrderedUserDetailsAdapter;
    private List<OrderedUserDetailsBean> mUserDetailsList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_ordered_flat_small_details_aty);
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
        tvTitle.setFocusable(true);
        tvTitle.setFocusableInTouchMode(true);
        tvTitle.requestFocus();
        tvTitle.setText("入住详情");
        ivToBack.setVisibility(View.VISIBLE);
        rvUserList.setLayoutManager(new LinearLayoutManager(this){
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
        finish();
    }
}
