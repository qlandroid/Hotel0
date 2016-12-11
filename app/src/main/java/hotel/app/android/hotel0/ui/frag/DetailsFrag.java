package hotel.app.android.hotel0.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;
import org.kymjs.kjframe.ui.ViewInject;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.inter.OnItemClickListener;
import hotel.app.android.hotel0.ui.view.DetailsListBtnListView;
import hotel.app.android.hotel0.ui.view.RoundImageView;

/**
 * Created by Administrator on 2016-12-5.
 */
public class DetailsFrag extends KJFragment {
    @BindView(id = R.id.rv_btn)
    DetailsListBtnListView rvBtn;
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.tv_details_left,click = true)
    TextView tvDetailsLeft;
    @BindView(id = R.id.tv_details_right,click = true)
    TextView tvDetailsRight;
    @BindView(id = R.id.riv_userIcon)
    RoundImageView rivUserIcon;
    @BindView(id = R.id.tv_userName)
    TextView tvUserName;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.frag_details_layout,container,false);
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void initWidget(View parentView) {
        super.initWidget(parentView);

        tvTitle.setText("个人详情");
        List<DetailsListBtnListView.BtnBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            DetailsListBtnListView.BtnBean bean = new DetailsListBtnListView.BtnBean();
            bean.setName("item--->"+i);

            bean.setIconId(R.mipmap.drop_down_selected_icon);
            list.add(bean);
        }
        rvBtn.setOnItemClickListener(getActivity(), list, new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                ViewInject.toast("被点击了---->" + position);
            }
        });
    }

}
