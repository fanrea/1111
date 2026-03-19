package com.dhylive.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PreviewRecyclerView extends RecyclerView {
    private boolean isLock;

    public PreviewRecyclerView(Context context) {
        super(context);
    }

    public PreviewRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            this.isLock = false;
        } else if (actionMasked == 5) {
            this.isLock = true;
        }
        if (this.isLock) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            this.isLock = false;
        } else if (actionMasked == 5) {
            this.isLock = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
