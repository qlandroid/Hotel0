package cn.yizhupingtai.android.hotel.ui.aty;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.view.HomeDetailsView;
import cn.yizhupingtai.android.hotel.utils.GlideImageLoader;

public class FlatSmallDetailsAty extends KJActivity {


    @BindView(id = R.id.hdv_detailsItem)
    HomeDetailsView hdvDetailsItem;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack , click = true)
    ImageView ivToBack;
    @BindView(id = R.id.banner)
    Banner banner;
    @BindView(id = R.id.tv_lookHome,click = true)
    TextView tvLookHome;

    private ArrayList<Integer> mBannerIconList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_small_details_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mBannerIconList = new ArrayList<>();
        mBannerIconList.add(R.drawable.banner_icon_1);
        mBannerIconList.add(R.drawable.banner_icon_1);
        mBannerIconList.add(R.drawable.banner_icon_1);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        ivToBack.setVisibility(View.VISIBLE);
        tvTitle.setText("公寓详情");
        String[] contents = {"三室两厅一卫","精装修","12.0m²","朝西南","5/11层","合租"};
        hdvDetailsItem.setTitle("基本信息");
        hdvDetailsItem.setItemContent(contents[0],contents[1],contents[2],contents[3],contents[4],contents[5]);
        initBanner();
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                finish();
                break;
            case R.id.tv_lookHome:
                onClickLookHome();
                break;
        }
    }

    /**
     * 点击看房
     */
    private void onClickLookHome() {
        startActivity(new Intent(this,LookHomeAty.class));
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
        banner.setDelayTime(3_000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用

    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.start();
    }
}
