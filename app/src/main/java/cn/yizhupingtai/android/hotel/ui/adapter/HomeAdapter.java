package cn.yizhupingtai.android.hotel.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.bean.HomeBean;
import cn.yizhupingtai.android.hotel.inter.OnItemClickListener;

/**
 * 公寓的适配器；
 * Created by Administrator on 2016-12-6.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> implements View.OnClickListener{
    private Context mContext;
    private List<HomeBean> mDataList;
    private OnItemClickListener mListener;

    public HomeAdapter(Context mContext, List<HomeBean> mDataList,OnItemClickListener mListener) {
        this.mContext = mContext;
        this.mListener = mListener;
        this.mDataList = mDataList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_home_layout,parent,false);
        HomeViewHolder holder = new HomeViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
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

    class HomeViewHolder extends RecyclerView.ViewHolder{
        View  itemView;
        public HomeViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
