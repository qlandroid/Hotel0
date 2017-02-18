package cn.yizhupingtai.android.hotel.ui.aty;

import android.os.Bundle;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;

import java.util.ArrayList;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;
import cn.yizhupingtai.android.hotel.ui.frag.DetailsFrag;
import cn.yizhupingtai.android.hotel.ui.frag.FlatLongFrag;
import cn.yizhupingtai.android.hotel.ui.frag.FlatSmallFrag;
import cn.yizhupingtai.android.hotel.ui.frag.HotelFrag;
import cn.yizhupingtai.android.hotel.ui.frag.ManFrag;
import cn.yizhupingtai.android.hotel.ui.view.NavigationGroupView;

/**
 * 功能：用于主页面显示，显示五个Fragment 底部一个buttonGroup导航；
 */
public class HomeAty extends BaseActivity {
    public static final String SELECT_POSITION = "selectPosition";

    @BindView(id = R.id.ngv_radioButton)
    NavigationGroupView ngvRadioButton;

    private String[] mRadioBtnNames = {"首页", "酒店", "短租公寓", "长租公寓", "个人"};
    private int[] mRadioBtnIcons = {R.drawable.home_bottom_man, R.drawable.home_bottom_hotel, R.drawable.home_bottom_small, R.drawable.home_bottom_long,
            R.drawable.home_bottom_user};

    private ArrayList<KJFragment> mFragmentList;
    private int selectPosition = 0;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_home_aty);
    }

    @Override
    public void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new ManFrag());
        mFragmentList.add(new HotelFrag());
        mFragmentList.add(new FlatSmallFrag());
        mFragmentList.add(new FlatLongFrag());
        mFragmentList.add(new DetailsFrag());
    }

    @Override
    public void initWidget() {
        ngvRadioButton.setOnClickButtonListener(new NavigationGroupView.OnClickButtonListener() {
            @Override
            public void onClickSelectButton(int position) {
                selectPosition = position;
                changeFragment(R.id.fl_content, mFragmentList.get(position));
            }
        });
        ngvRadioButton.setResources(mRadioBtnNames, R.color.gray, R.color.red, mRadioBtnIcons, mRadioBtnIcons);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ngvRadioButton.setSelectButton(selectPosition);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        outState.putInt(SELECT_POSITION, selectPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        selectPosition = savedInstanceState.getInt(SELECT_POSITION);
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
