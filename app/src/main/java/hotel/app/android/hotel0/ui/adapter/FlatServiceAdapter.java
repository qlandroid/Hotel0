package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hotel.app.android.hotel0.R;

/**
 * 功能：公寓服务，清单列表
 * Created by Administrator on 2016-12-29.
 */
public class FlatServiceAdapter extends RecyclerView.Adapter<FlatServiceAdapter.FlatServiceViewHolder> {

    private Context mContext;

    @Override
    public FlatServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.item_flat_service_layout,parent,false);
        FlatServiceViewHolder holder = new FlatServiceViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(FlatServiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class FlatServiceViewHolder extends RecyclerView.ViewHolder{

        public FlatServiceViewHolder(View itemView) {
            super(itemView);
        }
    }

}
