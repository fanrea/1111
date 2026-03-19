package com.bytedance.sdk.djx.core.business.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NewsViewPager extends ViewPager {
    private boolean mCanScroller;
    private boolean mCanSideslip;

    public NewsViewPager(Context context) {
        super(context);
        this.mCanSideslip = true;
        this.mCanScroller = true;
    }

    public NewsViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanSideslip = true;
        this.mCanScroller = true;
    }

    public void setCanSideslip(boolean z) {
        this.mCanSideslip = z;
    }

    public void setCanScroller(boolean z) {
        this.mCanScroller = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanScroller) {
            return false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanScroller) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected void onPageScrolled(int i, float f, int i2) {
        super.onPageScrolled(i, f, i2);
        if (i == 0 && f == 0.0f && i2 == 0 && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(!this.mCanSideslip);
        }
    }
}
