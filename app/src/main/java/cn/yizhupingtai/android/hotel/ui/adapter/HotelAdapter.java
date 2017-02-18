package cn.yizhupingtai.android.hotel.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.bean.HotelBean;
import cn.yizhupingtai.android.hotel.inter.OnItemClickListener;

/**
 * 酒店列表；
 * Created by Administrator on 2016-12-6.
 */
public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> implements OnClickListener{
    private Context mContext;
    private List<HotelBean> mDataList;
    private OnItemClickListener mListener;

    public HotelAdapter(Context mContext, List<HotelBean> mDataList,OnItemClickListener mListener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.mListener = mListener;
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_hotel_layout,parent,false);
        HotelViewHolder hotel = new HotelViewHolder(itemView);
        return hotel;
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        mListener.onClick(v,position);
    }

    class HotelViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        public HotelViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
