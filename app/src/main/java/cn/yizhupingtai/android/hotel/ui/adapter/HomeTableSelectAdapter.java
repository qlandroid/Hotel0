package cn.yizhupingtai.android.hotel.ui.adapter;

import android.content.Context;

import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.adapter.base.CommonAdapter;

/**
 * Created by Administrator on 2016-12-8.
 */
public class HomeTableSelectAdapter extends CommonAdapter<String> {
    public HomeTableSelectAdapter(Context context, List<String> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void setItemContent(ViewHolder holder, String s) {
        holder.setText(R.id.tv_name,s);
    }
}
