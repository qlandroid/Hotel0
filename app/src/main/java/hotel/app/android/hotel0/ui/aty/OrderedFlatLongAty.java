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

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.adapter.OrderedFlatLongAdapter;
import hotel.app.android.hotel0.ui.adapter.OrderedFlatLongAdapter.OnFlatLongButtonListener;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;

/**
 * 功能：已经预订的长租公寓
 */
public class OrderedFlatLongAty extends BaseActivity implements OnFlatLongButtonListener{
    public static final int REQUEST_RENEW_PAY_MONEY = 0X123;

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_orderedFlatLongList)
    RecyclerView rvOrderedFlatLongList;
    private OrderedFlatLongAdapter mOrderedAdapter;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_ordered_flat_long_aty);
    }

    @Override
    public void initWidget() {
        tvTitle.setText("已订长租公寓");
        ivToBack.setVisibility(View.VISIBLE);
        rvOrderedFlatLongList.setLayoutManager(new LinearLayoutManager(this));
        mOrderedAdapter = new OrderedFlatLongAdapter(this);
        mOrderedAdapter.setOnFlatLongButtonListener(this);
        rvOrderedFlatLongList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rvOrderedFlatLongList.setAdapter(mOrderedAdapter);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }
    }

    /**
     * 功能：点击返回
     */
    private void onClickToBack() {
        finish();
    }

    @Override
    public void onClickKeyToBack() {
        super.onClickKeyToBack();
        onClickToBack();
    }

    /*****************************************************************************************/
    /*****************************************************************************************/
    /******************************* 每条item上的button的点击事件 ****************************/
    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this,OrderedFlatLongDetailsAty.class));
    }

    @Override
    public void onItemClickServicing(int position) {
        ViewInject.toast(String.valueOf(position));
        startActivity(new Intent(this,FlatServicingAty.class));
    }

    @Override
    public void onItemClickPayMoney(int position) {
        ViewInject.toast("点击续约付款");
        Intent intent = new Intent(this,FlatLongRenewPayMoneyAty.class);
        startActivityForResult(intent,REQUEST_RENEW_PAY_MONEY);
    }

    @Override
    public void onItemClickAgreement(int position) {
        ViewInject.toast("点击合同确认");
    }

    @Override
    public void onItemClickQuitFlat(int position) {
        startActivity(new Intent(this,FlatLongApplyOutAty.class));
        ViewInject.toast("点击申请退租");
    }
    /**************************** item中的点击事件结束 ***************************************/
    /*****************************************************************************************/
}
