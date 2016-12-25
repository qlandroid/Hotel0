package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.bean.HotelDetailsBookedBean;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HotelBookedDetailsAdapter extends RecyclerView.Adapter<HotelBookedDetailsAdapter.HotelBookedDetailsViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<HotelDetailsBookedBean> mDataList;
    private OnHotelBookedCloseClickListener mListener;

    public HotelBookedDetailsAdapter(Context mContext, List<HotelDetailsBookedBean> mDataList, OnHotelBookedCloseClickListener mListener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.mListener = mListener;
    }

    @Override
    public HotelBookedDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_hotel_booked_layout, parent, false);
        HotelBookedDetailsViewHolder holder = new HotelBookedDetailsViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HotelBookedDetailsViewHolder holder, int position) {
        holder.tvCloseHotel.setTag(position);
        holder.tvCloseHotel.setOnClickListener(this);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_closeHotelBooked:
                int position = (int) v.getTag();
                mListener.onClickClose(position, mDataList.get(position));
                break;
            default:
                int viewPosition = (int) v.getTag();
                mListener.onClickItem(v, viewPosition, mDataList.get(viewPosition));
                break;
        }
    }

    public interface OnHotelBookedCloseClickListener {
        void onClickClose(int position, HotelDetailsBookedBean bean);

        void onClickItem(View v, int position, HotelDetailsBookedBean bean);
    }

    class HotelBookedDetailsViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tvCloseHotel;

        public HotelBookedDetailsViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvCloseHotel = (TextView) itemView.findViewById(R.id.tv_closeHotelBooked);
        }
    }
}
