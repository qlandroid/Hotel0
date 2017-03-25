package cn.yizhupingtai.android.mylibrary.inter;

import cn.yizhupingtai.android.mylibrary.bean.ClickBean;

/**
 * Created by Administrator on 2016-12-26.
 */
public interface OnItemClickListener {
    void onSuccess(ClickBean inBean,ClickBean outBean,int amountDay);
}
