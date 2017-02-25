package cn.yizhupingtai.android.hotel.inter;

import android.view.View;

/**
 * Created by Administrator on 2017-2-25.
 */
public abstract class  OnForbidClickListener implements View.OnClickListener{
    private final static int MIN_CLICK_TIME = 700;
    private long lastTime ;
    @Override
    public void onClick(View v) {
        if (System.currentTimeMillis() - lastTime > MIN_CLICK_TIME){
            forbidClick(v);
            lastTime = System.currentTimeMillis();
        }
    }
    public abstract void forbidClick(View v);
}
