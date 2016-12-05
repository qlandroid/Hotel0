package hotel.app.android.hotel0.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.utils.GlideImageLoader;

/**
 * Created by Administrator on 2016-12-5.
 */
public class ManFrag extends KJFragment {
    @BindView(id = R.id.banner)
    Banner banner;
    private List<Integer> mBannerIconList ;
    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View fragView = inflater.inflate(R.layout.frag_man_layout,container,false);
        return fragView;
    }

    @Override
    protected void initData() {
        mBannerIconList= new ArrayList<>();
        mBannerIconList.add(R.drawable.banner_icon_1);
        mBannerIconList.add(R.drawable.banner_icon_2);
        mBannerIconList.add(R.drawable.banner_icon_3);
    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
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
