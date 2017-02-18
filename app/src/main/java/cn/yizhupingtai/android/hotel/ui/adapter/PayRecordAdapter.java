package cn.yizhupingtai.android.hotel.ui.adapter;

import android.content.Context;

import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.bean.PayRecordBean;
import cn.yizhupingtai.android.hotel.ui.adapter.base.CommonAdapter;

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
