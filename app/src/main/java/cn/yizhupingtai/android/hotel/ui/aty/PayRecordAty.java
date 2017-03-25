package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.bean.PayRecordBean;
import cn.yizhupingtai.android.hotel.ui.adapter.PayRecordAdapter;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

/**
 * 功能：消费记录
 */
public class PayRecordAty extends BaseActivity  {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    View ivToBack;
    @BindView(id = R.id.lv_payRecordList)
    PullToRefreshListView lvPayRecordList;

    private PayRecordAdapter mPayRecordAdapter;
    private List<PayRecordBean> mPayList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_pay_record_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mPayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            PayRecordBean bean = new PayRecordBean();
            int payMoney  = i;
            if (i%6 == 0){
                payMoney = - payMoney;
            }
            bean.setPayMoney(payMoney);
            bean.setMonth("12-"+i);
            bean.setYear(2016);
            bean.setName("item-->"+i);
            mPayList.add(bean);
        }
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("消费记录");
        ivToBack.setVisibility(View.VISIBLE);

       mPayRecordAdapter = new PayRecordAdapter(this,mPayList,R.layout.item_pay_record_layout);
        lvPayRecordList.setAdapter(mPayRecordAdapter);
        lvPayRecordList.setMode(PullToRefreshBase.Mode.BOTH);
        lvPayRecordList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.onRefreshComplete();
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }
    }

    private void onClickToBack() {
        finish();
    }

}
