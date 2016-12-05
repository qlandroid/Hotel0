package hotel.app.android.hotel0.ui.aty;

import android.widget.ImageView;
import android.widget.TextView;

import org.kymjs.kjframe.ui.BindView;
import org.kymjs.kjframe.ui.KJFragment;

import java.util.ArrayList;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.ui.base.BaseActivity;
import hotel.app.android.hotel0.ui.frag.DetailsFrag;
import hotel.app.android.hotel0.ui.frag.FlatFrag;
import hotel.app.android.hotel0.ui.frag.HotelFrag;
import hotel.app.android.hotel0.ui.frag.ManFrag;
import hotel.app.android.hotel0.ui.view.NavigationGroupView;

public class HomeAty extends BaseActivity {
    @BindView(id = R.id.tv_title)
    TextView tvTitle;
    @BindView(id = R.id.iv_toBack, click = true)
    ImageView ivToBack;
    @BindView(id = R.id.ngv_radioButton)
    NavigationGroupView ngvRadioButton;

    private String[] mRadioBtnNames = {"首页", "酒店", "公寓", "个人"};
    private int[] mRadioBtnIcons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    private ArrayList<KJFragment> mFragmentList;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_home_aty);
    }

    @Override
    public void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new ManFrag());
        mFragmentList.add(new HotelFrag());
        mFragmentList.add(new FlatFrag());
        mFragmentList.add(new DetailsFrag());
    }

    @Override
    public void initWidget() {
        ngvRadioButton.setOnClickButtonListener(new NavigationGroupView.OnClickButtonListener() {
            @Override
            public void onClickSelectButton(int position) {
                changeFragment(R.id.fl_content, mFragmentList.get(position));
            }
        });
        ngvRadioButton.setResources(mRadioBtnNames, R.color.colorPrimary, R.color.colorAccent, mRadioBtnIcons, mRadioBtnIcons);
        ngvRadioButton.setSelectButton(0);
    }
}
