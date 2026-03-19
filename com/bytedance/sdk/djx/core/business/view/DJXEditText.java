package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXEditText extends EditText {
    private static final String TAG = "DJXEditText";
    private float mLastY;

    public DJXEditText(Context context) {
        super(context);
    }

    public DJXEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJXEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.d(TAG, "onTouchEvent: action = " + motionEvent.getAction() + ", x = " + motionEvent.getX() + ", y = " + motionEvent.getY());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastY = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (canScroll(((int) (((double) (motionEvent.getY() - this.mLastY)) + 0.5d)) > 0 ? 1 : -1)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.mLastY = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean canScroll(int i) {
        int height = getLayout().getHeight();
        int height2 = (getHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
        Log.d(TAG, "canScroll: contentHeight = " + height + ", layoutHeight = " + height2 + ", scrollY = " + getScrollY());
        return i > 0 ? getScrollY() > 0 : getScrollY() + height2 < height;
    }
}
