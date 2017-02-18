package hotel.app.android.hotel0.ui.aty;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.FlatServiceBean;
import hotel.app.android.hotel0.ui.adapter.FlatServiceAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;

/**
 * 功能：长租公寓 中用户所申请维修服务列表；
 */
public class FlatServiceAty extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.pullToListService)
    PullToRefreshListView mServiceListView;

    private List<FlatServiceBean> mServiceBeanList;
    private FlatServiceAdapter mFlatServiceAdapter;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_flat_service_aty);
    }

    @Override
    public void initData() {
        super.initData();
        mServiceBeanList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mServiceBeanList.add(new FlatServiceBean());
        }
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("申请服务列表");
        ivToBack.setVisibility(ImageView.VISIBLE);
        mFlatServiceAdapter = new FlatServiceAdapter(this,mServiceBeanList,R.layout.item_flat_service_layout);
        mServiceListView.setMode(PullToRefreshBase.Mode.BOTH);
        mServiceListView.setOnItemClickListener(this);
        mServiceListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.onRefreshComplete();
            }
        });
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }
    }

    /**
     * 功能：点击返回键
     */
    private void onClickToBack() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
