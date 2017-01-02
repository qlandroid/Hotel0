package hotel.app.android.hotel0.ui.aty;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.adapter.OrderedFlatSmallAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;

/**
 * 功能：已经预订的短租房
 */
public class OrderedFlatSmallAty extends BaseActivity implements OrderedFlatSmallAdapter.OnOrderedFlatSmallItemClickListener{

    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack, click = true)
    ImageView ivToBack;
    @BindView(id = R.id.rv_listDetails)
    RecyclerView rvListDetails;
    private OrderedFlatSmallAdapter mOrderedFlatSmallAdapter;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_ordered_flat_small_aty);
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("已订短租房");
        ivToBack.setVisibility(View.VISIBLE);
        rvListDetails.setLayoutManager(new LinearLayoutManager(this));
        mOrderedFlatSmallAdapter = new OrderedFlatSmallAdapter(this);
        mOrderedFlatSmallAdapter.setOnItemClickListener(this);
        rvListDetails.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rvListDetails.setAdapter(mOrderedFlatSmallAdapter);
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.iv_toBack:
                onClickToBack();
                break;
        }


    }

    private void onClickToBack() {
        finish();
    }

    /********************************************************************************/
    /********************************************************************************/
    /***************************** Item中的点击事件 *********************************/

    @Override
    public void onItemClick(View v, int position) {
        startActivity(new Intent(this,OrderedFlatSmallDetailsAty.class));
    }

    /**************************** Item中的点击事件结束 ******************************/
    /********************************************************************************/
}
