package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HomeBean;

/**
 * 公寓的适配器；
 * Created by Administrator on 2016-12-6.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context mContext;
    private List<HomeBean> mDataList;

    public HomeAdapter(Context mContext, List<HomeBean> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_home_layout,parent,false);
        HomeViewHolder holder = new HomeViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        public HomeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
