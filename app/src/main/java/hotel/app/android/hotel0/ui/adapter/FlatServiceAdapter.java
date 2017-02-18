package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;

import java.util.List;

import hotel.app.android.hotel0.bean.FlatServiceBean;
import hotel.app.android.hotel0.ui.adapter.base.CommonAdapter;

/**
 * 功能：设置公寓服务的适配器
 * Created by Administrator on 2017-1-13.
 */
public class FlatServiceAdapter extends CommonAdapter<FlatServiceBean> {
    public FlatServiceAdapter(Context context, List<FlatServiceBean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void setItemContent(ViewHolder holder, FlatServiceBean flatServiceBean) {

    }
}
