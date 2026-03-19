package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements View.OnTouchListener {
    private boolean b;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gb c;
    private float d;
    private float hc;
    private int u;

    public u(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar, int i) {
        this.c = gbVar;
        this.u = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.hc = y;
                if (Math.abs(y - this.d) > 10.0f) {
                    this.b = true;
                }
            }
        } else {
            if (!this.b) {
                return false;
            }
            int iHc = com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), Math.abs(this.hc - this.d));
            if (this.hc - this.d < 0.0f && iHc > this.u && (gbVar = this.c) != null) {
                gbVar.d();
                this.d = 0.0f;
                this.hc = 0.0f;
                this.b = false;
            }
        }
        return true;
    }
}
