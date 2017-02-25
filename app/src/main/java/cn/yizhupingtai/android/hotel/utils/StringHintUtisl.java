package cn.yizhupingtai.android.hotel.utils;

import cn.yizhupingtai.android.hotel.MyApp;
import cn.yizhupingtai.android.hotel.R;

/**
 * Created by Administrator on 2017-2-25.
 */
public class StringHintUtisl {
    public static String getHttpErrorHint(){
        return MyApp.getInstance().getString(R.string.httpErrorHint);
    }
}
