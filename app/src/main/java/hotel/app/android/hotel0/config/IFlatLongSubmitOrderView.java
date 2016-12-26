package hotel.app.android.hotel0.config;

/**
 * 功能：控制长住公寓生成订单页 ，View 控制
 * Created by Administrator on 2016-12-25.
 */
public interface IFlatLongSubmitOrderView {
    /**
     * 设置入住时间
     * @param year 入住年份
     * @param month 入住月份
     * @param day 入住月份中的天数
     */
    void setInFlatTimeView(int year,int month,int day);

    /**
     *  设置入住时长
     * @param longMonth  入住时长
     */
    void setInFlatLongTimeView(String longMonth);

    /**
     * 设置支付方式
     * @param payMode 所要显示的内容
     */
    void setInFlatPayModeView(String payMode);

    /**
     * 设置初始化的控件
     * @param name 当前公寓的名称
     * @param address 当前公寓的地址
     * @param area 当前公寓的面积；
     * @param imgPath 当前图片的地址；
     */
    void setInitFlatDetailsView(String name,String address,String area,Object imgPath);

    /**
     * 设置入住人的详情信息
     * @param userName 设置名字
     */
    void setUserNameView(String userName);

    /**
     * 设置入住人的身份证号
     * @param userNumber 身份证号
     */
    void setUserNumberView(String userNumber);
}
