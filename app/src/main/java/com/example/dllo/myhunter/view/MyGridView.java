package com.example.dllo.myhunter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.view.MotionEvent;

/**
 * 自定义展开Gridview
 */
public class MyGridView extends GridView {

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    // 重新测量 -规定他的高度是展开的
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
