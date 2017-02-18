package cn.yizhupingtai.android.hotel.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.yizhupingtai.android.hotel.R;

/**
 * Created by Administrator on 2016-12-25.
 */
public class NameTextView extends LinearLayout {
    public final static int TEXT_CONTENT_SIZE = 16;
    public final static int TEXT_NAME_SIZE = 14;
    public final static int TEXT_NAME_COLOR = Color.GRAY;
    public final static int CENTRE_PADDING = 6;
    private TextView tvName;
    private TextView tvContent;

    public NameTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public NameTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public NameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.setOrientation(LinearLayout.HORIZONTAL);
        tvContent = new TextView(context);
        tvName = new TextView(context);

        this.addView(tvName);
        this.addView(tvContent);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );
        tvContent.setLayoutParams(lp);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NameTextView,defStyleAttr,0);
            int count = a.getIndexCount();
            for (int i = 0; i < count; i++) {
                int attr = a.getIndex(i);
                switch (attr){
                    case R.styleable.NameTextView_content:
                        String content =a.getString(attr);
                        setContent(content);
                        break;
                    case R.styleable.NameTextView_name:
                        String name = a.getString(attr);
                        setName(name);
                        break;
                    case R.styleable.NameTextView_nameSize:
                        float nameSize = a.getDimension(attr, TEXT_NAME_SIZE);
                        tvName.setTextSize(TypedValue.COMPLEX_UNIT_PX,nameSize);
                        break;
                    case R.styleable.NameTextView_contentSize:
                        float contentSize = a.getDimension(attr,TEXT_CONTENT_SIZE);
                        tvContent.setTextSize(TypedValue.COMPLEX_UNIT_PX,contentSize);
                        break;
                    case R.styleable.NameTextView_contentColor:
                        int color = a.getColor(attr,TEXT_NAME_COLOR);
                        setContentColor(color);
                        break;
                    case R.styleable.NameTextView_nameColor:
                        int nameColor = a.getColor(attr,TEXT_NAME_COLOR);
                        setNameColor(nameColor);
                        break;
                    case R.styleable.NameTextView_centrePadding:
                        float d = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,CENTRE_PADDING,getResources().getDisplayMetrics());
                        float padding = a.getDimension(attr,d);
                        setCentrePadding((int) padding);
                        break;
                    case R.styleable.NameTextView_contentMaxLine:
                        int maxLine = a.getInteger(attr,1);
                        setContentMaxLine(maxLine);
                        break;
                }
            }
            a.recycle();
        }
    }
    public void setCentrePadding(int padding){
        tvName.setPadding(0,0,padding,0);
    }
    public void setContentColor(int color){
        tvContent.setTextColor(color);
    }
    public void setNameColor(int color){
        tvName.setTextColor(color);
    }

    public void setContentMaxLine(int maxLine){
        tvContent.setMaxLines(maxLine);
    }
    public void setContentSize(int size) {
        tvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setName(String name) {
        tvName.setText(name + ":");
    }

    public void setContent(String content) {
        tvContent.setText(content);
    }
}
