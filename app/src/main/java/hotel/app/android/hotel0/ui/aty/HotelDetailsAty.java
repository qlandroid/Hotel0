package hotel.app.android.hotel0.ui.aty;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.inter.OnItemClickListener;
import hotel.app.android.hotel0.ui.adapter.HotelDetailsAdapter;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.utils.DividerItemDecoration;

public class HotelDetailsAty extends BaseActivity {
    @BindView(id = R.id.rv_listDetails)
    RecyclerView rvListDetails;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack,click = true)
    ImageView ivToBack;
    @BindView(id = R.id.showView)
    View showView;



    private HotelDetailsAdapter mDetailsAdapter;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_hotel_details_aty);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initWidget() {
        super.initWidget();
        tvTitle.setText("酒店详情");
        ivToBack.setVisibility(View.VISIBLE);
        showView.setFocusable(true);
        showView.setFocusableInTouchMode(true);
        showView.requestFocus();
        rvListDetails.setLayoutManager(new LinearLayoutManager(this));
        List list = new ArrayList();
        for (int i = 0; i < 6; i++) {
            list.add("item--->" + i);
        }
        mDetailsAdapter = new HotelDetailsAdapter(this, list, new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                startActivity(new Intent(HotelDetailsAty.this,HotelSubmitOrderAty.class));
            }
        });
        rvListDetails.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvListDetails.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rvListDetails.setAdapter(mDetailsAdapter);

    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()){
            case R.id.iv_toBack:
                finish();
                break;
        }
    }
}
