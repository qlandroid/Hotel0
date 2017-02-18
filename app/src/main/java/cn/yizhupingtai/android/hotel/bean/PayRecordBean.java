package cn.yizhupingtai.android.hotel.bean;

/**
 * 功能：每条消费记录详细信息
 * Created by Administrator on 2017-1-4.
 */
public class PayRecordBean {
    private int year;
    private String month;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private String payTime;
    private double payMoney;
    private String  name;

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
