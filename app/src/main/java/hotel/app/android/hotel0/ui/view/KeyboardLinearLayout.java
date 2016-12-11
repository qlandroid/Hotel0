package hotel.app.android.hotel0.ui.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-11-4.
 */
public class KeyboardLinearLayout extends LinearLayout {
    /**
     * ***********************************************************
     * *****************监听键盘的出现****************************
     */
    private boolean openListener = false;
    public static  final int KEYBORAD_HIDE =0;
    public static final int KEYBORAD_SHOW =1;
    private Handler uiHandler = new Handler();
    private static final int SOFIKEYPAD_MIN_HEIGHT= 50;
    private KeyBordStateListener keyBordStateListener;
    public void setKeyBordStateListener(KeyBordStateListener keyBordStateListener){
        if (keyBordStateListener == null){
            openListener = false;
        }else {
            openListener = true;
        }
        this.keyBordStateListener = keyBordStateListener;
    }
    public interface  KeyBordStateListener{
        void stateChange(int state);
    }
    /********************************截至*****************************************/
    public KeyboardLinearLayout(Context context) {
        super(context);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, final int h, int oldw, final int oldh) {
        if (!openListener) return;//如果没有开启监听时间则不进行下面步骤；
        Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                if (oldh - h > SOFIKEYPAD_MIN_HEIGHT){
                    keyBordStateListener.stateChange(KEYBORAD_SHOW);
                }else {
                    if (keyBordStateListener != null){
                        keyBordStateListener.stateChange(KEYBORAD_HIDE);
                    }
                }
            }
        };
        uiHandler.post(mRunnable);
    }
}
