package hotel.app.android.mylibrary.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotel.app.android.mylibrary.R;
import hotel.app.android.mylibrary.inter.OnItemClickListener;
import hotel.app.android.mylibrary.presenter.DataSelectPresenter;
import hotel.app.android.mylibrary.utils.DateUtils;
import hotel.app.android.mylibrary.view.CalendarView;

/**
 * 功能：月份 当中的显示
 * Created by Administrator on 2016-12-26.
 */
public class CalendarMonthDayAdapter extends RecyclerView.Adapter<CalendarMonthDayAdapter.MonthDayViewHolder> implements View.OnClickListener {
    private Context mContext;
    private int year;
    private int month;
    private int monthFirstDayOfWeek;
    private int monthAmount;
    private OnItemClickListener mListener;
    private DataSelectPresenter mDataSelectPresenter;
    private CalendarView.OnRefreshAdapter mOnRefreshAdapter;

    public CalendarMonthDayAdapter(Context mContext) {
        this.mContext = mContext;
        mDataSelectPresenter = DataSelectPresenter.getInstance();

    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }
    public void setOnRefreshAdapter(CalendarView.OnRefreshAdapter mOnRefreshAdapter){
        this.mOnRefreshAdapter = mOnRefreshAdapter;
    }

    public void setDate(int year, int month) {
        this.year = year;
        this.month = month;
        init(year, month);
        this.notifyDataSetChanged();
    }

    private void init(int year, int month) {
        monthFirstDayOfWeek = DateUtils.getFirstMonthDayOfWeek(year, month) - 1;
        monthAmount = DateUtils.getMonthOfTotalDays(year, month);
    }

    @Override
    public MonthDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_month_day_layout, parent, false);
        MonthDayViewHolder holder = new MonthDayViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MonthDayViewHolder holder, int position) {
        int nowDay = -1;
        /*
        星期天 1 ，星期一 2 星期二 3
         */
        if (position < monthFirstDayOfWeek && monthFirstDayOfWeek != 0) {
            holder.itemView.setBackgroundColor(Color.GRAY);
            holder.tvMonthDay.setText("");
            /*
            当前是空的，这个是这个月开始的第几天；
             */
        } else {
            nowDay = position - (monthFirstDayOfWeek - 1);
            holder.itemView.setTag(nowDay);
            if (mDataSelectPresenter.scanClick(year, month, nowDay)) {
                holder.itemView.setOnClickListener(this);
            }else {
                holder.itemView.setBackgroundColor(Color.parseColor("#ececec"));
                holder.itemView.setOnClickListener(null);
            }
            holder.tvMonthDay.setText(String.valueOf(nowDay));
        }
        if (mDataSelectPresenter.isHotelIn(year, month, nowDay)) {
            /*
            当前是入住状态；
             */
            holder.itemView.setBackgroundColor(Color.RED);
            holder.tvMonthDay.setTextColor(Color.WHITE);
            holder.tvContent.setText("入住");
            holder.tvContent.setVisibility(View.VISIBLE);
        } else if (mDataSelectPresenter.isHotelOut(year, month, nowDay)) {
            /*
            当前是离店状态；
             */
            holder.itemView.setBackgroundColor(Color.RED);
            holder.tvMonthDay.setTextColor(Color.WHITE);
            holder.tvContent.setText("离店");
            holder.tvContent.setVisibility(View.VISIBLE);
        } else {
            holder.tvMonthDay.setTextColor(Color.BLACK);
            holder.tvContent.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return monthFirstDayOfWeek + monthAmount;
    }

    @Override
    public void onClick(View v) {
        if (mListener == null) return;
        int nowDay = (int) v.getTag();
        mDataSelectPresenter.clickPresenter(year, month, nowDay);
        if (mDataSelectPresenter.isSuccess()) {
            mListener.onSuccess(mDataSelectPresenter.getInBean(), mDataSelectPresenter.getOutBean(), mDataSelectPresenter.getAmountDay());
        }
        if (mOnRefreshAdapter !=null)
        mOnRefreshAdapter.onRefresh();
    }

    public static class MonthDayViewHolder extends RecyclerView.ViewHolder {
        TextView tvMonthDay, tvContent;
        View itemView;

        public MonthDayViewHolder(View itemVew) {
            super(itemVew);
            this.itemView = itemVew;
            tvMonthDay = (TextView) itemView.findViewById(R.id.tv_monthDay);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
