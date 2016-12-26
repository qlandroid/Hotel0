package hotel.app.android.mylibrary.inter;

import hotel.app.android.mylibrary.bean.ClickBean;

/**
 * Created by Administrator on 2016-12-26.
 */
public interface OnItemClickListener {
    void onSuccess(ClickBean inBean,ClickBean outBean,int amountDay);
}
