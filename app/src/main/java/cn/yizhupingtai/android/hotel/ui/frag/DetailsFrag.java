package cn.yizhupingtai.android.hotel.ui.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;

import java.util.ArrayList;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.aty.FlatServiceAty;
import cn.yizhupingtai.android.hotel.ui.aty.OrderedFlatLongAty;
import cn.yizhupingtai.android.hotel.ui.aty.OrderedFlatSmallAty;
import cn.yizhupingtai.android.hotel.ui.aty.OrderedHotelAty;
import cn.yizhupingtai.android.hotel.ui.aty.PayRecordAty;
import cn.yizhupingtai.android.hotel.ui.aty.UserDetailsAty;
import cn.yizhupingtai.android.hotel.ui.view.DetailsListBtnListView;
import cn.yizhupingtai.android.hotel.ui.view.RoundImageView;
import cn.yizhupingtai.android.hotel.utils.DividerItemDecoration;

/**
 * 个人中心
 * Created by Administrator on 2016-12-5.
 */
public class DetailsFrag extends KJFragment implements DetailsListBtnListView.OnItemClickListener{
    public final static int CLICK_TYPE_VIP_MANAGER = 0X001;
    public final static int CLICK_TYPE_OVER_HOTEL = 0X002;
    public final static int CLICK_TYPE_OVER_LONG_FLAT = 0X003;
    public final static int CLICK_TYPE_OVER_SMALL_FLAT = 0X004;
    public final static int CLICK_TYPE_FLAT_SERVICE = 0X005;
    public final static int CLICK_TYPE_PAY_NOTE = 0X006;
    public final static int CLICK_TYPE_FLAT_LOOK = 0X007;

    @BindView(id = R.id.rv_btn)
    DetailsListBtnListView rvBtn;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.tv_details_left,click = true)
    TextView tvDetailsLeft;
    @BindView(id = R.id.tv_details_right,click = true)
    TextView tvDetailsRight;
    @BindView(id = R.id.riv_userIcon,click = true)
    RoundImageView rivUserIcon;
    @BindView(id = R.id.tv_userName)
    TextView tvUserName;
    private ArrayList<DetailsListBtnListView.BtnBean> mBtnlist;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.frag_details_layout,container,false);
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);

        tvTitle.setText("个人详情");
        mBtnlist = new ArrayList<>();
        addBottomBtn("会员管理",R.drawable.icon_vip_edit, CLICK_TYPE_VIP_MANAGER);
        addBottomBtn("已预约看房",R.drawable.icon_ordered,CLICK_TYPE_FLAT_LOOK);
        addBottomBtn("已订酒店",R.drawable.icon_ordered,CLICK_TYPE_OVER_HOTEL);
        addBottomBtn("已订短租房",R.drawable.icon_ordered,CLICK_TYPE_OVER_SMALL_FLAT);
        addBottomBtn("已定长租房",R.drawable.icon_ordered,CLICK_TYPE_OVER_LONG_FLAT);
        addBottomBtn("公寓服务",R.drawable.icon_flat_service,CLICK_TYPE_FLAT_SERVICE);
        addBottomBtn("消费记录",R.drawable.icon_pay_note,CLICK_TYPE_PAY_NOTE);
        rvBtn.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        rvBtn.setOnItemClickListener(getActivity(), mBtnlist,this);
    }

    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.riv_userIcon:
                startActivity(new Intent(getActivity(), UserDetailsAty.class));
                break;
        }
    }

    /**
     * 添加底部的button;
     * @param name
     * @param iconId
     */
    private void addBottomBtn(String name,int iconId,int clickType){
        DetailsListBtnListView.BtnBean bean0=  new DetailsListBtnListView.BtnBean();
        bean0.setIconId(iconId);
        bean0.setClickType(clickType);
        bean0.setName(name);
        mBtnlist.add(bean0);
    }


    /***********************************************************************************/
    /**************************  底部Button点击事件  ***********************************/
    @Override
    public void onClickItem(View v, int clickType) {
        switch (clickType){
            case CLICK_TYPE_FLAT_SERVICE:
                onClickItemService();
                break;
            case CLICK_TYPE_OVER_HOTEL:
                onClickItemOverHotel();
                break;
            case CLICK_TYPE_OVER_LONG_FLAT:
                onClickItemOverLongFlat();
                break;
            case CLICK_TYPE_OVER_SMALL_FLAT:
                onClickItemOverSmallFlat();
                break;
            case CLICK_TYPE_VIP_MANAGER:
                onClickItemVipManager();
                break;
            case CLICK_TYPE_PAY_NOTE:
                onClickItemPayNote();
                break;
            case CLICK_TYPE_FLAT_LOOK:
                onCLickItemFlatLook();
                break;
        }
    }

    /**
     * 功能：点击底部Item 跳转预约看房；
     */
    private void onCLickItemFlatLook() {

    }

    /**
     * 功能：点击底部Item 跳转会员管理
     */
    private void onClickItemVipManager() {

    }

    /**
     * 功能：点击底部Item 跳转消费记录
     */
    private void onClickItemPayNote() {
        startActivity(new Intent(getActivity(), PayRecordAty.class));
    }

    /**
     * 功能：点击底部Item 跳转已定短租
     */
    private void onClickItemOverSmallFlat() {
        startActivity(new Intent(getActivity(), OrderedFlatSmallAty.class));
    }

    /**
     * 功能：点击底部Item 跳转已定长租房
     */
    private void onClickItemOverLongFlat() {
        startActivity(new Intent(getActivity(), OrderedFlatLongAty.class));
    }

    /**
     * 功能：点击底部Item 跳转已定酒店
     */
    private void onClickItemOverHotel() {
        startActivity(new Intent(getActivity(), OrderedHotelAty.class));
    }

    /**
     * 功能：点击底部Item 跳转底部公寓服务
     */
    private void onClickItemService() {
        startActivity(new Intent(getActivity(), FlatServiceAty.class));
    }
    /*************************** 底部Button点击事件结束 *********************************/
    /***********************************************************************************/
}
