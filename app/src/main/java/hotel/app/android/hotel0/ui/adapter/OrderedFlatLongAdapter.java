package hotel.app.android.hotel0.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotel.app.android.hotel0.R;

/**
 * 功能：已预订长租公寓列表的适配器
 * Created by Administrator on 2016-12-25.
 */
public class OrderedFlatLongAdapter extends RecyclerView.Adapter<OrderedFlatLongAdapter.OrderedViewHolder> implements View.OnClickListener{
    private Context mContext;
    private String[] mType = {"合同生成中","退订金中","合同生成完毕","住房中"};
    private OnFlatLongButtonListener mOnFlatLongButtonListener;

    public OrderedFlatLongAdapter(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 设置每个  button 的点击事件监听；
     * @param mOnFlatLongButtonListener
     */
    public void setOnFlatLongButtonListener( OnFlatLongButtonListener mOnFlatLongButtonListener){
        this.mOnFlatLongButtonListener = mOnFlatLongButtonListener;
    }
    @Override
    public OrderedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.item_ordered_flat_long_layout,parent,false);
        OrderedViewHolder holder = new OrderedViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(OrderedViewHolder holder, int position) {
        holder.tvType.setText(mType[position]);

        holder.setPositionTag(position);

        holder.tvPayMoney.setOnClickListener(this);
        holder.tvFlatServicing.setOnClickListener(this);
        holder.tvFlatAgreement.setOnClickListener(this);
        holder.tvFlatQuit.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mType.length;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_payMoney:
                mOnFlatLongButtonListener.onItemClickPayMoney((Integer) v.getTag());
                break;
            case R.id.tv_flatAgreement:
                mOnFlatLongButtonListener.onItemClickAgreement((Integer) v.getTag());
                break;
            case R.id.tv_flatQuit:
                mOnFlatLongButtonListener.onItemClickQuitFlat((Integer) v.getTag());
                break;
            case R.id.tv_flatServicing:
                mOnFlatLongButtonListener.onItemClickServicing((Integer) v.getTag());
                break;
        }
    }

    class OrderedViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        TextView tvType,tvFlatServicing,tvFlatAgreement,tvFlatQuit,tvPayMoney;
        public OrderedViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvFlatAgreement = (TextView) itemView.findViewById(R.id.tv_flatAgreement);
            this.tvFlatQuit = (TextView) itemView.findViewById(R.id.tv_flatQuit);
            this.tvFlatServicing = (TextView) itemView.findViewById(R.id.tv_flatServicing);
            this.tvPayMoney = (TextView) itemView.findViewById(R.id.tv_payMoney);
            this.tvType = (TextView) itemView.findViewById(R.id.tv_type);
        }
        public void setPositionTag(int positionTag){
            tvFlatServicing.setTag(positionTag);
            tvFlatAgreement.setTag(positionTag);
            tvFlatQuit.setTag(positionTag);
            tvPayMoney.setTag(positionTag);
        }
    }
    public interface OnFlatLongButtonListener{
        /**
         * 点击申请服务
         * @param position 点击项
         */
        void onItemClickServicing(int position);

        /**
         * 功能：续约付款
         * @param position
         */
        void onItemClickPayMoney(int position);

        /**
         * 功能：点击合同确认
         * @param position
         */
        void onItemClickAgreement(int position);

        /**
         * 功能：点击申请退租;
         * @param position
         */
        void onItemClickQuitFlat(int position);
    }
}
