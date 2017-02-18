package hotel.app.android.hotel0.ui.aty;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;

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
