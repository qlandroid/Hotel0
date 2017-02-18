package cn.yizhupingtai.android.hotel.ui.aty;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

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
public class PayRecordAty extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    View ivToBack;
    @BindView(id = R.id.lv_payRecordList)
    ListView lvPayRecordList;

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
        lvPayRecordList.setOnItemClickListener(this);
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

    /******************************************************************************/
    /******************************** item点击事件 ********************************/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    /******************************** item点击事件结束 ****************************/
    /******************************************************************************/
}
