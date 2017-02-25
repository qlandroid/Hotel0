package cn.yizhupingtai.android.hotel.utils;

import org.kymjs.kjframe.utils.KJLoger;

/**
 * Created by Administrator on 2017-2-18.
 */
public class LogUtils {
    public static void log(String clazzName , String methodName,String log){
        KJLoger.debug("***********************************************");
        KJLoger.debug("**************"+methodName+"开始*******************");
        KJLoger.debug("类名:"+ clazzName);
        KJLoger.debug("方法名称:"+ methodName);
        KJLoger.debug("具体内容:" + log);
        KJLoger.debug("***************"+methodName+"结束**************************");
        KJLoger.debug("**************************************************************");

    }
}
