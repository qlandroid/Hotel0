package cn.yizhupingtai.android.hotel.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by Administrator on 2016/11/26.
 */
public class NavigationGroupView extends LinearLayout implements View.OnClickListener {


    public NavigationGroupView(Context context) {
        this(context, null, 0);
    }

    public NavigationGroupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private Context mContext;
    private OnClickButtonListener mOnClickButtonListener;
    private int lastPosition = -1;

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        this.setOrientation(LinearLayout.HORIZONTAL);
    }

    public void setOnClickButtonListener(OnClickButtonListener l) {
        this.mOnClickButtonListener = l;
    }

    public void setResources(String[] names,int nameNomalColor, int nameSelectColors, int[] selectIcon,int[] normalIcon) {
        if (names == null) return;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int select = selectIcon[i];
            int normal = normalIcon[i];
            addButton(i, name,nameNomalColor,nameSelectColors,select,normal);
        }
    }

    private void addButton(int i, String name, int normalColor, int selectColor, int selectIcon
            , int normalIcon) {
        ImageButtonView button = new ImageButtonView(mContext);
        button.setLayoutParams(new LayoutParams(0, LayoutParams.MATCH_PARENT
                , 1));
        button.setName(name);
        button.setNameColor(selectColor,normalColor);
        button.setTag(i);
        button.setSelectImageView(selectIcon,normalIcon);
        addClickListener(button);
        addView(button);
    }

    private void addClickListener(View view) {
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (lastPosition == position) return;
        lastPosition = position;
        if (mOnClickButtonListener == null) {
            return;
        }
        int childSize = getChildCount();
        for (int i = 0; i < childSize; i++) {
            ImageButtonView view = (ImageButtonView)getChildAt(i);
            view.setStatus(i == position);
        }
        mOnClickButtonListener.onClickSelectButton(position);
    }

    public void setSelectButton(int position){
        lastPosition = position;
        int childSize = getChildCount();
        for (int i = 0; i < childSize; i++) {
            ImageButtonView view = (ImageButtonView)getChildAt(i);
            view.setStatus(i == position);
        }
        mOnClickButtonListener.onClickSelectButton(position);
    }

    public interface OnClickButtonListener {
        void onClickSelectButton(int position);
    }
}
