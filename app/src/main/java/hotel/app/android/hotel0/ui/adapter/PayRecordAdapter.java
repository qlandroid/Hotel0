package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.PayRecordBean;
import hotel.app.android.hotel0.ui.adapter.base.CommonAdapter;

/**
 * 功能：消费记录中的列表
 * Created by Administrator on 2017-1-4.
 */
public class PayRecordAdapter extends CommonAdapter<PayRecordBean> {

    public PayRecordAdapter(Context context, List<PayRecordBean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void setItemContent(ViewHolder holder, PayRecordBean payRecordBean) {
        holder.setText(R.id.tv_payMoney,String.valueOf(payRecordBean.getPayMoney()));
        holder.setText(R.id.tv_year,String.valueOf(payRecordBean.getYear()));
        holder.setText(R.id.tv_monthAndDay,payRecordBean.getMonth());
        holder.setText(R.id.tv_payName,payRecordBean.getName());
    }
}
