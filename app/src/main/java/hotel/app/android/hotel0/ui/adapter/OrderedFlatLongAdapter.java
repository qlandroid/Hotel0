package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotel.app.android.hotel0.R;

/**
 * 功能：已预订长租公寓列表的适配器
 * Created by Administrator on 2016-12-25.
 */
public class OrderedFlatLongAdapter extends RecyclerView.Adapter<OrderedFlatLongAdapter.OrderedViewHolder> {
    private Context mContext;
    private String[] mType = {"合同生成中","退订金中","合同生成完毕","住房中"};

    public OrderedFlatLongAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public OrderedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_ordered_flat_long_layout,parent,false);
        OrderedViewHolder holder = new OrderedViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(OrderedViewHolder holder, int position) {
        holder.tvType.setText(mType[position]);
    }

    @Override
    public int getItemCount() {
        return mType.length;
    }

    class OrderedViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView tvType;
        public OrderedViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvType = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }
}
