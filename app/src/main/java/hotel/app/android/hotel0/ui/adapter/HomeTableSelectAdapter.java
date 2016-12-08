package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;

import java.util.List;

import hotel.app.android.hotel0.R;

/**
 * Created by Administrator on 2016-12-8.
 */
public class HomeTableSelectAdapter extends CommonAdapter<String>{
    public HomeTableSelectAdapter(Context context, List<String> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void setItemContent(ViewHolder holder, String s) {
        holder.setText(R.id.tv_name,s);
    }
}
