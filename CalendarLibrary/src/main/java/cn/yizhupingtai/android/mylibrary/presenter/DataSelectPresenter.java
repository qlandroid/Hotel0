package cn.yizhupingtai.android.mylibrary.presenter;

import cn.yizhupingtai.android.mylibrary.bean.ClickBean;
import cn.yizhupingtai.android.mylibrary.utils.DateUtils;

/**
 *  功能： 日期选择操作类
 * Created by Administrator on 2016-12-26.
 */
public class DataSelectPresenter {
    public static boolean click = true;
    private static DataSelectPresenter mDataSelectPresenter;

    private DataSelectPresenter(){
        nowYear = DateUtils.getNowYear();
        nowMonth = DateUtils.getNowMonth();
        nowDay = DateUtils.getNowDay();
    }
    private int nowYear,nowMonth,nowDay;
    private  int inYear;
    private  int inMonth;
    private  int inDay;
    private  int outYear;
    private  int outMonth;
    private  int outDay;
    private boolean isSuccess = false;

    public static DataSelectPresenter getInstance() {
        if (mDataSelectPresenter == null){
            synchronized (DataSelectPresenter.class){
                if (mDataSelectPresenter == null){
                    mDataSelectPresenter = new DataSelectPresenter();
                }
            }
        }
        return mDataSelectPresenter;
    }
    public boolean clickPresenter(int year,int month,int day){

        if (click){
            //当前是选择入住状态
            inYear = year;
            inMonth = month;
            inDay = day;
            click = !click;
            isSuccess = false;
            initOut();
            return true;
        }else {
            if (inYear > year) {
                return false;
            }else if (inYear == year){
                if (inMonth > month){
                    return false;
                }else if (inMonth == month){
                    if (inDay>=day){
                        return false;
                    }
                }
            }
            outDay = day;
            outMonth = month;
            outYear = year;
            isSuccess = true;
            click = !click;
            return true;
        }
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    private void initOut(){
        outDay = -1;
        outMonth = -1 ;
        outYear = -1;
    }

    /**
     * 判断当前的 时间是否是入住
     * @param year
     * @param month
     * @param day
     * @return
     */
    public boolean isHotelIn(int year,int month,int day){
        if (year == inYear && month == inMonth && day == inDay){
            return true;
        }
        return false;
    }
    public boolean isHotelOut(int year,int month,int day){
        if (year == outYear && month == outMonth && day == outDay){
            return true;
        }
        return false;
    }
    public ClickBean getInBean(){
        ClickBean bean = new ClickBean();
        bean.setMonth(inMonth);
        bean.setDay(inDay);
        bean.setYear(inYear);
        return bean;
    }
    public ClickBean getOutBean(){
        ClickBean bean = new ClickBean();
        bean.setDay(outDay);
        bean.setYear(outYear);
        bean.setMonth(outMonth);
        return bean;
    }
    public int getAmountDay(){
        long inTime =DateUtils.getTime(inYear,inMonth,inDay);
        long outTime = DateUtils.getTime(outYear,outMonth,outDay);
        long amountDayTime = outTime - inTime;
        int amountDay = (int) (amountDayTime /24/60/60/1000);
        return amountDay;
    }
    public boolean scanClick(int year, int month, int day){
        if (year < nowYear){
            return false;
        }else if (year >nowYear){
            return true;
        }else {
            if (month < nowMonth){
                return false;
            }else if (month>nowMonth){
                return true;
            }else {
                if (day<nowDay){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 功能：重置
     */
    public void resetting(){
        inDay = -1;
        inMonth = -1 ;
        inYear =-1;
        outDay = -1;
        outYear =-1;
        outMonth = -1;
    }
}
