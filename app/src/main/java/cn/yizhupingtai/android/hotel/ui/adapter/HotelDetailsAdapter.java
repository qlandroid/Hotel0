package cn.yizhupingtai.android.hotel.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.inter.OnItemClickListener;

/**
 * 功能：酒店详情 中 酒店房间 列表的适配器；
 * Created by Administrator on 2016-12-12.
 */
public class HotelDetailsAdapter extends RecyclerView.Adapter<HotelDetailsAdapter.HomeDetailsViewHolder> implements OnClickListener{
    private Context mContext;
    private List mDataList;
    private OnItemClickListener mListener;

    public HotelDetailsAdapter(Context mContext, List mDataList, OnItemClickListener mListener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.mListener = mListener;
    }

    public void update(List mDataList){
        this.mDataList = mDataList;
        this.notifyDataSetChanged();
    }
    @Override
    public HomeDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_home_details_layout,parent,false);
        HomeDetailsViewHolder  holder = new HomeDetailsViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeDetailsViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mDataList == null?0 : mDataList.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        mListener.onClick(v,position);

    }

    class HomeDetailsViewHolder extends RecyclerView.ViewHolder{
        View itemView ;
        public HomeDetailsViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
