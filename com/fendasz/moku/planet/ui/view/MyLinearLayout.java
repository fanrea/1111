package com.fendasz.moku.planet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MyLinearLayout extends LinearLayout {
    private static final String TAG = "MyLinearLayout==>";
    private boolean intercepted;
    private long time;
    private int x;
    private int y;

    public MyLinearLayout(Context context) {
        super(context);
        this.x = 0;
        this.y = 0;
        this.time = System.currentTimeMillis();
        this.intercepted = false;
    }

    public MyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = 0;
        this.y = 0;
        this.time = System.currentTimeMillis();
        this.intercepted = false;
    }

    public MyLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 0;
        this.y = 0;
        this.time = System.currentTimeMillis();
        this.intercepted = false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.intercepted = false;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.x = (int) motionEvent.getX();
            this.y = (int) motionEvent.getY();
            this.time = System.currentTimeMillis();
        } else {
            if (action == 2) {
                int iAbs = (int) Math.abs(motionEvent.getX() - this.x);
                int iAbs2 = (int) Math.abs(motionEvent.getY() - this.y);
                Log.d(TAG, "OFFETX=>" + iAbs + ",OFFETY=>" + iAbs2);
                if (iAbs > 50 || iAbs2 > 50) {
                    this.intercepted = true;
                } else {
                    this.intercepted = false;
                }
            }
            this.intercepted = false;
        }
        Log.d(TAG, "intercepted==>" + this.intercepted);
        return this.intercepted;
    }
}
