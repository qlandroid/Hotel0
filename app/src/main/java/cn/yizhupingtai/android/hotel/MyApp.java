package cn.yizhupingtai.android.hotel;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2016-12-27.
 */
public class MyApp extends Application {

    public static MyApp getInstance() {
        return Instance.myApp;
    }
    private static class Instance{
        public static  MyApp myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Instance.myApp = this;
        SDKInitializer.initialize(getApplicationContext());
    }

}
