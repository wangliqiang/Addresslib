package com.app.addresslib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by 王立强 on 2017/6/22.
 */

public class UninterceptleListView extends ListView {
    public UninterceptleListView(Context context) {
        super(context);
    }

    public UninterceptleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UninterceptleListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(ev);
    }
}
