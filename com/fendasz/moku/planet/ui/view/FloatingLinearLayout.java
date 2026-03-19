package com.fendasz.moku.planet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FloatingLinearLayout extends LinearLayout {
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public FloatingLinearLayout(Context context) {
        super(context);
    }

    public FloatingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatingLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
