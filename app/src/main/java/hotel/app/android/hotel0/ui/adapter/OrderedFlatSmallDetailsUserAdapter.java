package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.OrderedUserDetailsBean;
import hotel.app.android.hotel0.ui.view.NameTextView;

/**
 * 功能：已订短租房中详情列表中 入住人信息的列表；
 * Created by Administrator on 2016-12-29.
 */
public class OrderedFlatSmallDetailsUserAdapter extends RecyclerView.Adapter<OrderedFlatSmallDetailsUserAdapter.UserViewHolder> {
    private Context mContext;
    private List<OrderedUserDetailsBean> mDataList;

    public OrderedFlatSmallDetailsUserAdapter(Context mContext, List<OrderedUserDetailsBean> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    public void update(List<OrderedUserDetailsBean> mDataList){
        this.mDataList = mDataList;
        this.notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.item_ordered_user_details_layout,parent,false);
        UserViewHolder holder = new UserViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        OrderedUserDetailsBean bean = mDataList.get(position);
        holder.ntvUserNumber.setContent(bean.getUserNumber());
        holder.ntvUserName.setContent(bean.getUserName());
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        NameTextView ntvUserName,ntvUserNumber;

        public UserViewHolder(View itemView) {
            super(itemView);
            ntvUserName = (NameTextView) itemView.findViewById(R.id.ntv_userName);
            ntvUserNumber = (NameTextView) itemView.findViewById(R.id.ntv_userNumber);
        }
    }

}
