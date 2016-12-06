package hotel.app.android.hotel0.ui.frag;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;
import org.kymjs.kjframe.utils.KJLoger;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HomeBean;
import hotel.app.android.hotel0.bean.HomeGridBean;
import hotel.app.android.hotel0.bean.HotelBean;
import hotel.app.android.hotel0.inter.OnItemClickListener;
import hotel.app.android.hotel0.ui.adapter.GridAdapter;
import hotel.app.android.hotel0.ui.adapter.HomeAdapter;
import hotel.app.android.hotel0.ui.adapter.HotelAdapter;
import hotel.app.android.hotel0.utils.DividerItemDecoration;
import hotel.app.android.hotel0.utils.GlideImageLoader;
import hotel.app.android.hotel0.utils.SpaceItemDecoration;

/**
 * Created by Administrator on 2016-12-5.
 */
public class ManFrag extends KJFragment {
    @BindView(id = R.id.banner)
    Banner banner;
    @BindView(id = R.id.rv_gridView)
    RecyclerView rvGridView;
    @BindView(id = R.id.rv_home)
    RecyclerView rvHome;
    @BindView(id = R.id.rv_hotel)
    RecyclerView rvHotel;

    private List<Integer> mBannerIconList;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View fragView = inflater.inflate(R.layout.frag_man_layout, container, false);
        return fragView;
    }

    @Override
    protected void initData() {
        mBannerIconList = new ArrayList<>();
        mBannerIconList.add(R.drawable.banner_icon_1);
        mBannerIconList.add(R.drawable.banner_icon_2);
        mBannerIconList.add(R.drawable.banner_icon_3);
    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
        initBanner();
        setManGridBtn();
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvHome.addItemDecoration(new SpaceItemDecoration(50));
        rvHotel.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        rvHotel.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        List<HomeBean> homeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            homeList.add(new HomeBean());
        }
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(),homeList);
        rvHome.setAdapter(homeAdapter);
        List<HotelBean> hotelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            hotelList.add(new HotelBean());
        }
        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(),hotelList);
        rvHotel.setAdapter(hotelAdapter);

    }

    /**
     * 设置主页面中的导航
     */
    private void setManGridBtn() {
        List<HomeGridBean> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            HomeGridBean bean0 = new HomeGridBean();
            bean0.setName("测试-->"+i);
            bean0.setIconId(R.mipmap.ic_launcher);
            list.add(bean0);
        }

        rvGridView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        GridAdapter gridAdapter = new GridAdapter(getActivity(), list, new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                KJLoger.debug("当前导航被点击了---->"+ position);
            }
       }) ;
        rvGridView.setAdapter(gridAdapter);
    }


    private void initBanner() {
        //设置banner样式
        //+banner.setBannerStyle(BannerConfig.);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(mBannerIconList);
        //设置banner动画效果
        //banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(Arrays.asList(titles));
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2_000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
