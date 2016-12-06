package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HomeGridBean;
import hotel.app.android.hotel0.inter.OnItemClickListener;

/**
 * 用于首页中 导航
 * Created by Administrator on 2016-12-5.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> implements View.OnClickListener{
    private Context mContext;
    private List<HomeGridBean> mDataList;
    private OnItemClickListener mOnItemClickListener;
    public GridAdapter(Context mContext, List<HomeGridBean> mDataList,OnItemClickListener mOnItemClickListener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_btn,parent,false);
        GridViewHolder holder = new GridViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        HomeGridBean bean = mDataList.get(position);
        holder.tvName.setText(bean.getName());
        holder.ivIcon.setImageResource(bean.getIconId());
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public void onClick(View v) {
        int position   = (int) v.getTag();
        mOnItemClickListener.onClick(v,position);
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView tvName;
        ImageView ivIcon;
        public GridViewHolder(View itemView) {
            super(itemView);
            this.itemView =itemView;
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }
}
