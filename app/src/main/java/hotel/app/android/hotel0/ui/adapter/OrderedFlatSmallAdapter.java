package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotel.app.android.hotel0.R;

/**
 * 功能：已订短租房中的列表的适配器；
 * Created by Administrator on 2016-12-28.
 */
public class OrderedFlatSmallAdapter extends RecyclerView.Adapter<OrderedFlatSmallAdapter.FlatSmallViewHolder> implements View.OnClickListener {
    private Context mContext;
    private String[] types;
    private OnOrderedFlatSmallItemClickListener mOnClickListener;

    public OrderedFlatSmallAdapter(Context mContext) {
        this.mContext = mContext;
        types = new String[]{"入住中", "申请退房中", "押金退款中", "验房中", "却款协议确认", "退还资金中", "退房中"};
    }

    public void setOnItemClickListener(OnOrderedFlatSmallItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public FlatSmallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.item_ordered_flat_small_layout, parent, false);
        FlatSmallViewHolder holder = new FlatSmallViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(FlatSmallViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.tvFlatType.setText(types[position]);
        holder.setViewTag(position);
        setOnItemClickListener(holder,this);
    }
    private void setOnItemClickListener(FlatSmallViewHolder holder,View.OnClickListener listener){
        holder.tvOutFlat.setOnClickListener(listener);
        holder.tvRefund.setOnClickListener(listener);
        holder.tvFlatAddUser.setOnClickListener(listener);
        holder.tvPayMoney.setOnClickListener(listener);
        holder.tvUnlocking.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return types.length;
    }

    @Override
    public void onClick(View v) {
        if (mOnClickListener == null)
            return;
        switch (v.getId()) {
            case R.id.tv_refund://酒店协议
                mOnClickListener.onItemClickRefundAgreement((Integer) v.getTag());
                break;
            case R.id.tv_outFlat://退租
                mOnClickListener.onItemClickOutFlat((Integer) v.getTag());
                break;
            case R.id.tv_unlocking://开锁
                mOnClickListener.onItemClickUnlocking((Integer) v.getTag());
                break;
            case R.id.tv_flatAddUser://添加用户
                mOnClickListener.onItemClickFlatAddUser((Integer) v.getTag());
                break;
            case R.id.tv_payMoney://支付金额
                mOnClickListener.onItemClickPayMoney((Integer) v.getTag());
                break;
            default:
                int position = (int) v.getTag();
                mOnClickListener.onItemClick(v, position);
        }
    }

    class FlatSmallViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tvFlatType, tvRefund, tvOutFlat, tvUnlocking, tvFlatAddUser, tvPayMoney;

        public FlatSmallViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvFlatType = (TextView) itemView.findViewById(R.id.tv_flatType);
            tvRefund = (TextView) itemView.findViewById(R.id.tv_refund);
            tvOutFlat = (TextView) itemView.findViewById(R.id.tv_outFlat);
            tvUnlocking = (TextView) itemView.findViewById(R.id.tv_unlocking);
            tvFlatAddUser = (TextView) itemView.findViewById(R.id.tv_flatAddUser);
            tvPayMoney = (TextView) itemView.findViewById(R.id.tv_payMoney);
        }
        public void setViewTag(int position) {
            itemView.setTag(position);
            tvRefund.setTag(position);
            tvOutFlat.setTag(position);
            tvUnlocking.setTag(position);
            tvFlatAddUser.setTag(position);
            tvPayMoney.setTag(position);
        }
    }

    /**
     * 功能：用于监听Item中各个点击事件
     */
    public interface OnOrderedFlatSmallItemClickListener {
        void onItemClick(View v, int position);

        /**
         * 功能：点击退款协议
         */
        void onItemClickRefundAgreement(int position);

        /**
         * 功能：点击退房
         * @param position
         */
        void onItemClickOutFlat(int position);

        /**
         * 功能：点击开锁
         * @param position
         */
        void onItemClickUnlocking(int position);

        /**
         * 功能：添加入住人信息
         * @param position
         */
        void onItemClickFlatAddUser(int position);

        /**
         * 功能：点击支付金额
         * @param position
         */
        void onItemClickPayMoney(int position);
    }
}
