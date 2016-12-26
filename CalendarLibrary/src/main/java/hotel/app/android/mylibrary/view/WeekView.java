package hotel.app.android.mylibrary.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import hotel.app.android.mylibrary.C;
import hotel.app.android.mylibrary.adapter.CalendarWeekAdapter;

/**
 * 功能：星期的显示
 * Created by Administrator on 2016-12-26.
 */
public class WeekView extends RecyclerView {

    public WeekView(Context context) {
        super(context);
        init(context);
    }

    public WeekView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WeekView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }
    private void init(Context context){
        GridLayoutManager manager = new GridLayoutManager(context, C.WEEK_MAX_AMOUNT) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        this.setLayoutManager(manager);
        CalendarWeekAdapter adapter = new CalendarWeekAdapter(context);
        this.setAdapter(adapter);
    }
}
