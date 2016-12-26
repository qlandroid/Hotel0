package hotel.app.android.mylibrary.utils;

import android.util.Log;

import java.util.Calendar;

/**
 * Created by Administrator on 2016-12-14.
 */
public class DateUtils {

    /**
     * 获得当前年份
     * @return
     */
    public static int getNowYear(){
        Calendar calendar = Calendar.getInstance();

        return calendar.get(Calendar.YEAR);
    }
    /**
     * 获得当前月份
     * @return
     */
    public static int getNowMonth(){
        Calendar calendar = Calendar.getInstance();

        return calendar.get(Calendar.MONTH);
    }
    public static int getNowDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得经过 afterDay 后的年份；
     * @param afterDay 经过多少天；
     * @return
     */
    public  static  int getAfterYear(int afterDay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,afterDay);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获得经过 afterDay 后的月份；
     * @param afterDay 经过多少天；
     * @return
     */
    public static int getAfterMonth(int afterDay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,afterDay);
        return calendar.get(Calendar.MONTH);
    }
    /**
     * 获得经过 afterDay 月份中的天数；
     * @param afterDay 经过多少天；
     * @return
     */
    public static int getAfterDayOfMonth(int afterDay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,afterDay);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得经过 afterDay 星期 中 的天数； 星期天，星期一
     * @param afterDay 经过多少天；
     * @return
     */
    public static int getAfterDayOfWeek(int afterDay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,afterDay);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 返回当前 月份的天数；
     * @param year 当前年份
     * @param month 当前月份
     * @return 当前月份的天数；
     */
    public static int getMonthOfTotalDays(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,1);//设置这个月的一号
        Log.i("getMonthOfTotalDays", "getMonthOfTotalDays:设置当前年份 " + calendar.get(Calendar.YEAR));
        Log.i("getMonthOfTotalDays", "getMonthOfTotalDays: 当前月份" + calendar.get(Calendar.MONTH));
        Log.i("getMonthOfTotalDays", "getMonthOfTotalDays: 这个月的第一天" + calendar.get(Calendar.DATE));

        calendar.add(Calendar.MONTH,1); //这是为下个月
        Log.i("getMonthOfTotalDays", "getMonthOfTotalDays: 下一个月份 " + calendar.get(Calendar.MONTH));

        calendar.add(Calendar.DATE,-1);//设置为这个月的最后一天；
        Log.i("getMonthOfTotalDays", "getMonthOfTotalDays: 这个月的最后一天" + calendar.get(Calendar.DATE));
        return calendar.get(Calendar.DAY_OF_MONTH);//获得当前月份的最后一天，所在月份中的天数；
    }

    /**
     * 获得当月第一天 的星期数；从1开始 1 为星期日  --7 星期六
     * @param year  所要查询的年份；
     * @param month 所要查询的月份；
     * @return 返回当前星期数；
     */
    public static int getFirstMonthDayOfWeek(int year,int month){
        Calendar calendar= Calendar.getInstance();
        calendar.set(year,month,1);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static long getTime(int year,int month,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        return calendar.getTimeInMillis();
    }




}
