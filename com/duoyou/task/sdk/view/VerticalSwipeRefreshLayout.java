package com.duoyou.task.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class VerticalSwipeRefreshLayout extends SwipeRefreshLayout {
    private float preX;
    private int scaleTouchSlop;

    public VerticalSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scaleTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.preX = motionEvent.getX();
        } else if (action == 2 && Math.abs(motionEvent.getX() - this.preX) > this.scaleTouchSlop + 60) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
