package com.bytedance.sdk.djx.core.business.view.rv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXHorizontalRecyclerView extends RecyclerView {
    public static final String TAG = "DJXHorizontalRecyclerView";
    private int startX;
    private int startY;

    public DJXHorizontalRecyclerView(Context context) {
        super(context);
    }

    public DJXHorizontalRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJXHorizontalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startX = (int) motionEvent.getX();
            this.startY = (int) motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (Math.abs((int) (motionEvent.getX() - this.startX)) < Math.abs((int) (motionEvent.getY() - this.startY))) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            LG.e(TAG, "dispatchTouchEvent error ", e);
            return false;
        }
    }
}
