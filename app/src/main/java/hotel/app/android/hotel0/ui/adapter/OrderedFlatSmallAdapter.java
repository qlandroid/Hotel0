package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotel.app.android.hotel0.R;

/**
 * 功能：已订短租房中的列表的适配器；
 * Created by Administrator on 2016-12-28.
 */
public class OrderedFlatSmallAdapter extends RecyclerView.Adapter<OrderedFlatSmallAdapter.FlatSmallViewHolder> implements View.OnClickListener{
    private Context mContext;
    private String[] types ;
    private OnOrderedFlatSmallItemClickListener mOnClickListener;
    public OrderedFlatSmallAdapter(Context mContext) {
        this.mContext = mContext;
        types = new String[]{"入住中","申请退房中","押金退款中","验房中","却款协议确认","退还资金中","退房中"};
    }
    public void setOnItemClickListener(OnOrderedFlatSmallItemClickListener mOnClickListener){
        this.mOnClickListener = mOnClickListener;
    }
    @Override
    public FlatSmallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView =  li.inflate(R.layout.item_ordered_flat_small_layout,parent,false);
        FlatSmallViewHolder holder = new FlatSmallViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(FlatSmallViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.tvFlatType.setText(types[position]);
    }

    @Override
    public int getItemCount() {
        return types.length;
    }

    @Override
    public void onClick(View v) {
        if (mOnClickListener == null)
            return;
        switch (v.getId()){
            default:
                int position = (int) v.getTag();
                mOnClickListener.onItemClick(v,position);
        }
    }

    class FlatSmallViewHolder extends RecyclerView.ViewHolder{
        TextView tvFlatType;
        public FlatSmallViewHolder(View itemView) {
            super(itemView);
            tvFlatType = (TextView) itemView.findViewById(R.id.tv_flatType);
        }
    }

    /**
     * 功能：用于监听Item中各个点击事件
     */
    public interface OnOrderedFlatSmallItemClickListener{
        void onItemClick(View v,int position);
    }
}
