package cn.yizhupingtai.android.hotel.ui.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yyydjk.library.DropDownMenu;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;

import java.util.ArrayList;
import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.ui.adapter.HomeListViewAdapter;
import cn.yizhupingtai.android.hotel.ui.adapter.HomeTableSelectAdapter;
import cn.yizhupingtai.android.hotel.ui.aty.FlatLongDetailsAty;

/**
 * Created by Administrator on 2016-12-5.
 */
public class FlatLongFrag extends KJFragment {
    @BindView(id = R.id.dropDownMenu)
    DropDownMenu dropDownMenu;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    private List<String> mTableList;
    private List<View> mViewList;
    private PullToRefreshListView mPullToRefreshListView;
    private int mUiWidth;
    private int mUiHeight;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.frag_flat_long_layout, container, false);
    }

    @Override
    protected void initData() {
        super.initData();
        mUiWidth = getResources().getDisplayMetrics().widthPixels;
        mUiHeight = getResources().getDisplayMetrics().heightPixels;
        mTableList = new ArrayList<>();
        mTableList.add("区域");
        mTableList.add("租金");
        mTableList.add("默认排序");
        mTableList.add("更多");
        mViewList = new ArrayList<>();
        addTableSelect();
    }

    private void addTableSelect() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        //酒店地点筛选
        View flatTableDistrictView = inflater.inflate(R.layout.item_flat_table_select_district, null, false);
        initFlatTableDistrictView(flatTableDistrictView);
        mViewList.add(flatTableDistrictView);
        //酒店价格筛选
        View moneyView = inflater.inflate(R.layout.item_flat_table_select_money, null, false);
        ListView moneyListView = (ListView) moneyView.findViewById(R.id.lv);
        moneyListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mUiHeight / 2));
        initFlatTableMoneyView(moneyListView);
        mViewList.add(moneyView);
        /*
        设置 距离排序，更多
         */
        View distanceView = inflater.inflate(R.layout.item_flat_table_select_money, null, false);
        ListView distanceListView = (ListView) distanceView.findViewById(R.id.lv);
        distanceListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mUiHeight / 2));
        View moreView = inflater.inflate(R.layout.item_flat_table_select_money, null, false);
        ListView moreListView = (ListView) moreView.findViewById(R.id.lv);
        ;
        moreListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mUiHeight / 2));
        initFlatTableDistanceView(distanceListView);
        initFlatTableMoreView(moreListView);
        mViewList.add(distanceView);
        mViewList.add(moreView);
    }

    /**
     * 设置更多
     *
     * @param flatTableMoreView
     */
    private void initFlatTableMoreView(ListView flatTableMoreView) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item-->" + i);
        }
        HomeTableSelectAdapter adapter = new HomeTableSelectAdapter(getActivity(), list, R.layout.item_home_select);
        flatTableMoreView.setAdapter(adapter);
    }

    /**
     * 设置距离排序
     *
     * @param flatTableDistanceView
     */
    private void initFlatTableDistanceView(ListView flatTableDistanceView) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item-->" + i);
        }
        HomeTableSelectAdapter adapter = new HomeTableSelectAdapter(getActivity(), list, R.layout.item_home_select);
        flatTableDistanceView.setAdapter(adapter);
    }

    /**
     * 设置价格排序
     *
     * @param flatTableMoneyView
     */
    private void initFlatTableMoneyView(ListView flatTableMoneyView) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item-->" + i);
        }
        HomeTableSelectAdapter adapter = new HomeTableSelectAdapter(getActivity(), list, R.layout.item_home_select);
        flatTableMoneyView.setAdapter(adapter);
    }

    /**
     * 初始化地址选择条件View
     *
     * @param flatTableView
     */
    private void initFlatTableDistrictView(View flatTableView) {

    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);
        tvTitle.setText("FlatLongHome");
        mPullToRefreshListView = new PullToRefreshListView(getActivity());
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshListView.setLayoutParams(new DropDownMenu.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.onRefreshComplete();
            }
        });
        List list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        HomeListViewAdapter adapter = new HomeListViewAdapter(getActivity(), list, R.layout.item_home_layout);
        mPullToRefreshListView.setAdapter(adapter);
        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), FlatLongDetailsAty.class));
            }
        });
        dropDownMenu.setDropDownMenu(mTableList, mViewList, mPullToRefreshListView);
    }
}
