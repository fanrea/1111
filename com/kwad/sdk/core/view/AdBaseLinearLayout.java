package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.utils.aj;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdBaseLinearLayout extends LinearLayout {
    private static final aj.a aDV = new aj.a();
    private View.OnTouchListener bJU;

    public AdBaseLinearLayout(Context context) {
        super(context);
    }

    public AdBaseLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdBaseLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDispatchTouchListener(View.OnTouchListener onTouchListener) {
        this.bJU = onTouchListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.bJU;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            aj.a aVar = aDV;
            aVar.ac(getWidth(), getHeight());
            aVar.p(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aDV.q(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public aj.a getTouchCoords() {
        return aDV;
    }
}
