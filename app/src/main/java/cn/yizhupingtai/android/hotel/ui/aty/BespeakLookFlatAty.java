package cn.yizhupingtai.android.hotel.ui.aty;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.kymjs.kjframe.ui.BindView;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.base.BaseActivity;

/**
 * 功能：已经预约看房列表
 */
public class BespeakLookFlatAty extends BaseActivity {

    @BindView(id = R.id.pullToListLookFlatList)
    PullToRefreshListView mBespeakLookFlatListView;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_bespeak_look_flat_aty);
    }
}
