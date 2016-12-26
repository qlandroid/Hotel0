package hotel.app.android.hotel0.config;

import java.util.List;

import hotel.app.android.hotel0.bean.HotelBean;

/**
 * 功能：酒店详情 所有所要控制View
 * Created by Administrator on 2016-12-26.
 */
public interface IHotelDetailsView {
    void setBannerList(List<Object> list);
    void setHotelInTimeView(int year,int month,int day);
    void setHotelOutTimeView(int year,int month,int day);
    void setHotelAmountDayView(int amountDay);
    void setHotelHomeDetailsView(List<HotelBean> list);
    void setHotelNameView(String name);
    void setHotelTitleView(String title);

}
