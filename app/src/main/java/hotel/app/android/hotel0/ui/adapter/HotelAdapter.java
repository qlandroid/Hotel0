package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HotelBean;

/**
 * 酒店列表；
 * Created by Administrator on 2016-12-6.
 */
public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private Context mContext;
    private List<HotelBean> mDataList;

    public HotelAdapter(Context mContext, List<HotelBean> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_hotel_layout,parent,false);
        HotelViewHolder hotel = new HotelViewHolder(itemView);
        return hotel;
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder{

        public HotelViewHolder(View itemView) {
            super(itemView);
        }
    }
}
