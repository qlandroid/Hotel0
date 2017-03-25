package cn.yizhupingtai.android.mylibrary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotel.app.android.mylibrary.R;


/**
 * 功能：星期title
 * Created by Administrator on 2016-12-26.
 */
public class CalendarWeekAdapter extends RecyclerView.Adapter<CalendarWeekAdapter.WeekViewHolder>{
    private Context mContext;
    private String[] weekNames ={"日","一","二","三","四","五","六"};

    public CalendarWeekAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public WeekViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_week_layout,parent,false);
        WeekViewHolder holder = new WeekViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(WeekViewHolder holder, int position) {
        holder.tvWeekName.setText(weekNames[position]);
    }

    @Override
    public int getItemCount() {
        return weekNames.length;
    }

    public static class WeekViewHolder extends RecyclerView.ViewHolder{
        TextView tvWeekName;
        public WeekViewHolder(View itemView) {
            super(itemView);
            tvWeekName = (TextView) itemView.findViewById(R.id.tv_weekName);
        }
    }
}
