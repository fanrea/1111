package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb implements View.OnTouchListener {
    private float an;
    private final int b = 10;
    private float c;
    private final com.bytedance.sdk.component.adexpress.dynamic.interact.gb d;
    private float h;
    private final boolean hc;
    private float u;

    public gb(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar, boolean z) {
        this.d = gbVar;
        this.hc = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
            this.u = motionEvent.getY();
            Object[] objArr = new Object[3];
            Float.valueOf(this.c);
            String str = ", mStartY: " + this.u;
        } else if (action == 1) {
            this.an = motionEvent.getX();
            this.h = motionEvent.getY();
            Object[] objArr2 = new Object[3];
            Float.valueOf(this.an);
            String str2 = ", mEndY: " + this.h;
            if (!this.hc && (gbVar2 = this.d) != null) {
                gbVar2.d();
            } else {
                float f = this.an - this.c;
                float f2 = this.h - this.u;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                Object[] objArr3 = new Object[2];
                Float.valueOf(fSqrt);
                float fHc = com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), Math.abs(fSqrt));
                Object[] objArr4 = new Object[5];
                Float.valueOf(fHc);
                Integer.valueOf(10);
                if (fHc > 10.0f && (gbVar = this.d) != null) {
                    gbVar.d();
                }
            }
        }
        return true;
    }
}
