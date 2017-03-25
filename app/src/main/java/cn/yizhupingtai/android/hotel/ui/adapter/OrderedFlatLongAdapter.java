package cn.yizhupingtai.android.hotel.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.yizhupingtai.android.hotel.R;
import cn.yizhupingtai.android.hotel.inter.OnForbidClickListener;

/**
 * 功能：已预订长租公寓列表的适配器
 * Created by Administrator on 2016-12-25.
 */
public class OrderedFlatLongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int ID_ITEM_VIEW = 0X1234;
    private static final int FOOT_TYPE = 100000;
    private Context mContext;
    private String[] mType = {"合同生成中", "退订金中", "合同生成完毕", "住房中"};
    private OnFlatLongButtonListener mOnFlatLongButtonListener;
    private List list;

    private OnForbidClickListener mClickListener = new OnForbidClickListener() {
        @Override
        public void forbidClick(View v) {
            switch (v.getId()) {
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
                default:
                    mOnFlatLongButtonListener.onItemClick((Integer) v.getTag());

            }
        }
    };

    public OrderedFlatLongAdapter(Context mContext ,List list) {
        this.mContext = mContext;
        this.list = list;
    }


    /**
     * 设置每个  button 的点击事件监听；
     *
     * @param mOnFlatLongButtonListener
     */
    public void setOnFlatLongButtonListener(OnFlatLongButtonListener mOnFlatLongButtonListener) {
        this.mOnFlatLongButtonListener = mOnFlatLongButtonListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.item_ordered_flat_long_layout, parent, false);
        OrderedViewHolder holder = new OrderedViewHolder(itemView);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holderView, int position) {

            OrderedViewHolder holder = (OrderedViewHolder) holderView;
           //holder.tvType.setText(mType[position]);
            holder.setPositionTag(position);
            holder.itemView.setOnClickListener(mClickListener);
            holder.tvPayMoney.setOnClickListener(mClickListener);
            holder.tvFlatServicing.setOnClickListener(mClickListener);
            holder.tvFlatAgreement.setOnClickListener(mClickListener);
            holder.tvFlatQuit.setOnClickListener(mClickListener);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void update(List list) {
        this.list = list;
        notifyDataSetChanged();
    }


    class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

    class OrderedViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tvType, tvFlatServicing, tvFlatAgreement, tvFlatQuit, tvPayMoney;

        public OrderedViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvFlatAgreement = (TextView) itemView.findViewById(R.id.tv_flatAgreement);
            this.tvFlatQuit = (TextView) itemView.findViewById(R.id.tv_flatQuit);
            this.tvFlatServicing = (TextView) itemView.findViewById(R.id.tv_flatServicing);
            this.tvPayMoney = (TextView) itemView.findViewById(R.id.tv_payMoney);
            this.tvType = (TextView) itemView.findViewById(R.id.tv_type);
        }

        public void setPositionTag(int positionTag) {
            itemView.setTag(positionTag);
            tvFlatServicing.setTag(positionTag);
            tvFlatAgreement.setTag(positionTag);
            tvFlatQuit.setTag(positionTag);
            tvPayMoney.setTag(positionTag);
        }
    }

    public interface OnFlatLongButtonListener {

        /**
         * 点击item查看详情
         *
         * @param position
         */
        void onItemClick(int position);

        /**
         * 点击申请服务
         *
         * @param position 点击项
         */
        void onItemClickServicing(int position);

        /**
         * 功能：续约付款
         *
         * @param position
         */
        void onItemClickPayMoney(int position);

        /**
         * 功能：点击合同确认
         *
         * @param position
         */
        void onItemClickAgreement(int position);

        /**
         * 功能：点击申请退租;
         *
         * @param position
         */
        void onItemClickQuitFlat(int position);
    }
}
