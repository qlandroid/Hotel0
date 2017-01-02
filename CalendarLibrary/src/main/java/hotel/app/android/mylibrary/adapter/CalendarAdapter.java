package hotel.app.android.mylibrary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hotel.app.android.mylibrary.bean.CalendarBean;
import hotel.app.android.mylibrary.R;
import hotel.app.android.mylibrary.inter.OnItemClickListener;
import hotel.app.android.mylibrary.view.CalendarView;
import hotel.app.android.mylibrary.view.MonthDayView;

/**
 * 功能：日历的总体适配器
 * Created by Administrator on 2016-12-26.
 */
public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    private Context mContext;
    private List<CalendarBean> mDataList;
    private OnItemClickListener mListener;
    private CalendarView.OnRefreshAdapter mOnRefreshAdapter;

    public CalendarAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void update(List<CalendarBean> mDataList) {
        this.mDataList = mDataList;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public void setOnRefreshAdapter(CalendarView.OnRefreshAdapter l) {
        mOnRefreshAdapter = l;
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater localinflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView =localinflater.inflate(R.layout.item_calendar_layout, parent, false);
        CalendarViewHolder holder = new CalendarViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        CalendarBean bean = mDataList.get(position);
        int year = bean.getYear();
        int month = bean.getMonth();
        holder.tvMonth.setText(String.valueOf(month + 1));
        holder.tvYear.setText(String.valueOf(year));
        holder.mdvMonthDay.setAdapter(year, month);
        if (mListener != null)
            holder.mdvMonthDay.setMonthItemClickListener(mListener);
        if (mOnRefreshAdapter != null)
            holder.mdvMonthDay.setOnRefreshAdapter(mOnRefreshAdapter);

    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }


    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        MonthDayView mdvMonthDay;
        TextView tvYear, tvMonth;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            mdvMonthDay = (MonthDayView) itemView.findViewById(R.id.mdv_monthDay);
            tvYear = (TextView) itemView.findViewById(R.id.tv_year);
            tvMonth = (TextView) itemView.findViewById(R.id.tv_month);
        }
    }
}
