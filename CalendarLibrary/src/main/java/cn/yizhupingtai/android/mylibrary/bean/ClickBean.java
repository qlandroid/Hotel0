package cn.yizhupingtai.android.mylibrary.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016-12-26.
 */
public class ClickBean implements Parcelable {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "ClickBean{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.year);
        dest.writeInt(this.month);
        dest.writeInt(this.day);
    }

    public ClickBean() {
    }

    protected ClickBean(Parcel in) {
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
    }

    public static final Parcelable.Creator<ClickBean> CREATOR = new Parcelable.Creator<ClickBean>() {
        @Override
        public ClickBean createFromParcel(Parcel source) {
            return new ClickBean(source);
        }

        @Override
        public ClickBean[] newArray(int size) {
            return new ClickBean[size];
        }
    };
}
