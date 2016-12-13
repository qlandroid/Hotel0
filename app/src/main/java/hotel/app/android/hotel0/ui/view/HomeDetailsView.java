package hotel.app.android.hotel0.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hotel.app.android.hotel0.R;

/**
 * 公寓详情中 各个属性
 * Created by Administrator on 2016-12-11.
 */
public class HomeDetailsView extends LinearLayout {
    private TextView tvTitle;
    private RecyclerView rvItemLayout;
    private HomeDetailsItemAdapter mItemAdapter;
    private List<HomeDetailsItemBean> mItemList;

    private String[] names = {"户型","装修","面积","朝向","楼层","方式"};

    public HomeDetailsView(Context context) {
        super(context);
        init(context);
    }

    public HomeDetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HomeDetailsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        this.setOrientation(LinearLayout.VERTICAL);
        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.setBackgroundColor(Color.WHITE);
        mItemList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            HomeDetailsItemBean bean = new HomeDetailsItemBean();
            bean.setName(names[i]);
            mItemList.add(bean);
        }
        tvTitle = new TextView(context);
        tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
        tvTitle.setTextColor(context.getResources().getColor(R.color.textTitleColor));
        tvTitle.setTextSize(14);
        this.addView(tvTitle);
        View divX = new View(context);
        LayoutParams divLp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics()));
        divLp.setMargins(0,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10, context.getResources().getDisplayMetrics()),0,0);
        divX.setLayoutParams(divLp);
        divX.setBackgroundColor(context.getResources().getColor(R.color.divColor));
        this.addView(divX);
        rvItemLayout = new RecyclerView(context);
        rvItemLayout.setLayoutManager(new GridLayoutManager(context,2));
        rvItemLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mItemAdapter = new HomeDetailsItemAdapter(context,mItemList);
        rvItemLayout.setAdapter(mItemAdapter);
        this.addView(rvItemLayout);
    }

    /**
     * 设置显示内容
     * @param houseType 户型
     * @param decorate 装修
     * @param area 面积
     * @param orientations 朝向
     * @param height 楼层高度
     * @param mode 方式
     */
    public void setItemContent(String houseType,String decorate,String area ,String orientations
    ,String height ,String mode){
        String[] contents = {houseType,decorate,area,orientations,height,mode};
        for (int i = 0; i < contents.length; i++) {
            HomeDetailsItemBean bean = mItemList.get(i);
            String content = contents[i];
            if (content == null){
                continue;
            }
            bean.setContent(content);
        }
        mItemAdapter.notifyDataSetChanged();

    }
    public void setTitle(String title){
        tvTitle.setText(title);
    }

    public static class HomeDetailsItemBean{
        private String name;
        private String content;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
    private static class HomeDetailsItemAdapter extends RecyclerView.Adapter<HomeDetailsItemAdapter.HomeDetailsItemViewHolder>{
        private Context mContext;
        private List<HomeDetailsItemBean> mDataBean ;

        public HomeDetailsItemAdapter(Context mContext, List<HomeDetailsItemBean> mDataBean) {
            this.mContext = mContext;
            this.mDataBean = mDataBean;
        }

        public void update(List<HomeDetailsItemBean> mDataBean ){
            this.mDataBean = mDataBean;
            this.notifyDataSetChanged();
        }
        @Override
        public HomeDetailsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_home_details_type,parent
            ,false);
            HomeDetailsItemViewHolder holder = new HomeDetailsItemViewHolder(itemView);
            return holder;
        }

        @Override
        public void onBindViewHolder(HomeDetailsItemViewHolder holder, int position) {
            HomeDetailsItemBean bean = mDataBean.get(position);
            holder.tvContent.setText(bean.getContent());
            holder.tvName.setText(bean.getName());
        }

        @Override
        public int getItemCount() {
            return mDataBean == null ? 0 : mDataBean.size();
        }

        static class HomeDetailsItemViewHolder extends RecyclerView.ViewHolder{
            TextView tvName;
            TextView tvContent;
            public HomeDetailsItemViewHolder(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
                tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }
    }

}
