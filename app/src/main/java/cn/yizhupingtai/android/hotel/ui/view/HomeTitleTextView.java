package cn.yizhupingtai.android.hotel.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-12-11.
 */
public class HomeTitleTextView extends TextView {

    public HomeTitleTextView(Context context) {
        super(context);
    }

    public HomeTitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeTitleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setText(String district , String road,String village){
        this.setText(district +"|" +road+"|"+village);
    }
}
