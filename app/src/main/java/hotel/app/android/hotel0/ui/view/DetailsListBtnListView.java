package hotel.app.android.hotel0.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hotel.app.android.hotel0.R;
import hotel.app.android.hotel0.inter.OnItemClickListener;

/**
 * Created by Administrator on 2016-12-11.
 */
public class DetailsListBtnListView extends RecyclerView {
    public DetailsListBtnListView(Context context) {
        super(context);
        init(context);
    }

    public DetailsListBtnListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DetailsListBtnListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context mContext){
        this.setLayoutManager(new LinearLayoutManager(mContext));
    }
    public void setOnItemClickListener(Context context,List<BtnBean> list,OnItemClickListener listener){
        DetailsBtnAdapter adapter = new DetailsBtnAdapter(context, list, listener);
        this.setAdapter(adapter);
    }
    public static class BtnBean{
        private String name;
        private int iconId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIconId() {
            return iconId;
        }

        public void setIconId(int iconId) {
            this.iconId = iconId;
        }
    }
    public static class DetailsBtnAdapter extends RecyclerView.Adapter<DetailsBtnAdapter.DetailsBtnViewHolder>implements OnClickListener {
        private Context mContext;
        private List<BtnBean> mDataList;
        private OnItemClickListener mListener;

        public DetailsBtnAdapter(Context mContext, List<BtnBean> mDataList, OnItemClickListener mListener) {
            this.mContext = mContext;
            this.mDataList = mDataList;
            this.mListener = mListener;
        }

        @Override
        public DetailsBtnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_details_btn,parent,false);
            DetailsBtnViewHolder holder = new DetailsBtnViewHolder(itemView);
            return holder;
        }
        @Override
        public void onBindViewHolder(DetailsBtnViewHolder holder, int position) {
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(this);
            BtnBean bean = mDataList.get(position);
            holder.name.setText(bean.getName());
            holder.icon.setImageResource(bean.getIconId());
        }

        @Override
        public int getItemCount() {
            return mDataList == null ? 0 : mDataList.size();
        }

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            if (mListener == null){
                throw new RuntimeException("必须设置监听事件");
            }
            mListener.onClick(v,position);

        }

        class DetailsBtnViewHolder extends RecyclerView.ViewHolder{
            View  itemView;
            TextView name;
            ImageView icon;
            public DetailsBtnViewHolder(View itemView) {
                super(itemView);
                this.itemView  = itemView;
                name = (TextView) itemView.findViewById(R.id.tv_name);
                icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            }
        }
    }
}