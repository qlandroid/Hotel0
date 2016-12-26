package hotel.app.android.mylibrary.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import hotel.app.android.mylibrary.C;
import hotel.app.android.mylibrary.adapter.CalendarMonthDayAdapter;
import hotel.app.android.mylibrary.inter.OnItemClickListener;

/**
 * 功能:每个月中的每天一天
 * Created by Administrator on 2016-12-26.
 */
public class MonthDayView extends RecyclerView {
    private CalendarMonthDayAdapter mMonthDayAdapter;

    public MonthDayView(Context context) {
        super(context);
        init(context);
    }

    public MonthDayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MonthDayView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        GridLayoutManager manager = new GridLayoutManager(context, C.WEEK_MAX_AMOUNT) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        this.setLayoutManager(manager);

    }
    public void setAdapter(int year,int month){
        mMonthDayAdapter = new CalendarMonthDayAdapter(getContext());
        mMonthDayAdapter.setDate(year,month);
        this.setAdapter(mMonthDayAdapter);
    }

    public void setMonthItemClickListener(OnItemClickListener listener){
        mMonthDayAdapter.setOnItemClickListener(listener);
    }
    public void setOnRefreshAdapter(CalendarView.OnRefreshAdapter l){
        mMonthDayAdapter.setOnRefreshAdapter(l);
    }
}
