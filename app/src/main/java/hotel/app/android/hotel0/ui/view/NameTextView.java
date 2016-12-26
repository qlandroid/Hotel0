package hotel.app.android.hotel0.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import hotel.app.android.hotel0.R;

/**
 * Created by Administrator on 2016-12-25.
 */
public class NameTextView extends LinearLayout {
    private TextView tvName;
    private TextView tvContent;
    public NameTextView(Context context) {
        super(context);
        init(context, null);
    }

    public NameTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public NameTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        this.setOrientation(LinearLayout.VERTICAL);
        View view = LayoutInflater.from(context).inflate(R.layout.view_name_text_view,this,true);
        this.addView(view);
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        if (attrs!=null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NameTextView);
            String name = a.getString(R.styleable.NameTextView_name);
            String content = a.getString(R.styleable.NameTextView_content);
            if (name != null){
                setName(name);
            }
            if (content!=null){
                setContent(content);
            }
        }
    }
    public void setName(String name){
        tvName.setText(name);
    }
    public void setContent(String content){
        tvContent.setText(content);
    }
}
