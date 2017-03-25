package cn.yizhupingtai.android.mylibrary.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.yizhupingtai.android.mylibrary.adapter.CalendarAdapter;
import cn.yizhupingtai.android.mylibrary.bean.CalendarBean;
import cn.yizhupingtai.android.mylibrary.inter.OnItemClickListener;
import cn.yizhupingtai.android.mylibrary.presenter.DataSelectPresenter;
import cn.yizhupingtai.android.mylibrary.utils.DateUtils;
import cn.yizhupingtai.android.mylibrary.utils.DividerItemDecoration;

/**
 * 功能：日历选择控件
 * Created by Administrator on 2016-12-26.
 */
public class CalendarView extends RecyclerView {
    private CalendarAdapter mCalendarAdapter;

    public CalendarView(Context context) {
        super(context);
        init(context);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.setLayoutManager(new LinearLayoutManager(context));
        mCalendarAdapter = new CalendarAdapter(context);
        this.setAdapter(mCalendarAdapter);
        this.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        addOnRefreshAdapter();
        setNestedScrollingEnabled(false);
    }

    private void update(List<CalendarBean> list) {
        mCalendarAdapter.update(list);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mCalendarAdapter.setOnItemClickListener(listener);
    }

    private void addOnRefreshAdapter(){
        mCalendarAdapter.setOnRefreshAdapter(new OnRefreshAdapter() {
            @Override
            public void onRefresh() {
                notifyDataSetChanged();
            }
        });
    }
    private void notifyDataSetChanged(){
        mCalendarAdapter.notifyDataSetChanged();
    }
    public interface OnRefreshAdapter{
        void onRefresh();
    }

    public void setAfterDay(int afterDay) {
        if (afterDay <= 0) {
            throw new RuntimeException("afterDay必须为大于0的整数");
        }
        int afterYear = DateUtils.getAfterYear(afterDay);
        int afterMonth = DateUtils.getAfterMonth(afterDay);
        int nowYear = DateUtils.getNowYear();
        int nowMonth = DateUtils.getNowMonth();

        //一共有多少个月
        int amountMonth = 0;

        if (afterYear - nowYear == 0) {
            /*
            同一年份
             */
            amountMonth = afterMonth - nowMonth;
        } else {
            /*
            不同年份
             */
            amountMonth = afterMonth + 11 - nowMonth;
        }
        List<CalendarBean> list = new ArrayList<>();
        for (int i = 0; i < amountMonth; i++) {
            int month = nowMonth + i;
            int year = nowYear;
            if (month > 11) {
                /*
                当前是不同年份
                 */
                month = month - 12;
                year++;
            }
            CalendarBean bean = new CalendarBean();
            bean.setMonth(month);
            bean.setYear(year);
            list.add(bean);
        }
        update(list);
    }
    public void onDestroy(){
        DataSelectPresenter.getInstance().resetting();
    }
}
