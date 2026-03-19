package com.bytedance.sdk.djx.core.business.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXRefreshLayout2 extends DJXRefreshLayout {
    private float mLastY;
    private OnSlideListener mSlideListener;
    private boolean mTouched;

    public interface OnSlideListener {
        void onSlideDown();

        void onSlideUp();
    }

    public DJXRefreshLayout2(Context context) {
        this(context, null);
    }

    public DJXRefreshLayout2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouched = false;
    }

    public void setSlideListener(OnSlideListener onSlideListener) {
        this.mSlideListener = onSlideListener;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnSlideListener onSlideListener;
        OnSlideListener onSlideListener2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mTouched = true;
            this.mLastY = motionEvent.getY();
        } else if (actionMasked == 1 || actionMasked == 3) {
            float y = motionEvent.getY() - this.mLastY;
            if (y > 0.0f) {
                if (this.mTouched && y * getDragRate() > getRefreshMidHeight() && (onSlideListener2 = this.mSlideListener) != null) {
                    onSlideListener2.onSlideDown();
                }
            } else if (y < 0.0f && this.mTouched && (-y) * getDragRate() > getLoadMidHeight() && (onSlideListener = this.mSlideListener) != null) {
                onSlideListener.onSlideUp();
            }
            this.mTouched = false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
