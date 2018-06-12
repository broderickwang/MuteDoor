package com.example.hannahxian.mutedoor.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.hannahxian.mutedoor.R;

/**
 * Created by Administrator on 2018/6/12.
 */

public class CleanEdit extends RelativeLayout{

    private Context mContext;

    private Drawable mDrawable;

    public CleanEdit(Context context) {
        this(context,null);
    }

    public CleanEdit(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CleanEdit(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CleanEdit);
        mDrawable = array.getDrawable(R.styleable.CleanEdit_clean_img);
        array.recycle();
        addView();
    }

    private void addView() {
        EditText editText = new EditText(mContext);
        ViewGroup.LayoutParams eParams = new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT
                ,ViewGroup.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(eParams);
        addView(editText);
        ImageView imageView = new ImageView(mContext);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                ,ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(ALIGN_PARENT_RIGHT);
        params.addRule(CENTER_VERTICAL);
        imageView.setLayoutParams(params);
        if(mDrawable!=null)
            imageView.setImageDrawable(mDrawable);
        addView(imageView);
    }

}
