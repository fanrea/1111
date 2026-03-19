package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements View.OnTouchListener {
    private float an;
    private float b;
    private float c;
    private float d;
    private boolean gb;
    private float h;
    private float hc;
    private boolean mk;
    private int tc;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gb tt;
    private boolean u = true;

    public c(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar, int i, boolean z) {
        this.tt = gbVar;
        this.tc = i;
        this.mk = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.hc = motionEvent.getY();
            this.an = motionEvent.getY();
            this.u = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.h = y;
                if (Math.abs(y - this.an) > 10.0f) {
                    this.gb = true;
                }
                this.c = motionEvent.getX();
                this.b = motionEvent.getY();
                if (Math.abs(this.c - this.d) > 8.0f || Math.abs(this.b - this.hc) > 8.0f) {
                    this.u = false;
                }
            }
        } else {
            if (!this.gb && !this.u) {
                return false;
            }
            if (!this.mk && (gbVar3 = this.tt) != null) {
                gbVar3.d();
            } else {
                int iHc = com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), Math.abs(this.h - this.an));
                if (this.h - this.an < 0.0f && iHc > this.tc && (gbVar2 = this.tt) != null) {
                    gbVar2.d();
                } else if (this.u && (gbVar = this.tt) != null) {
                    gbVar.d();
                }
            }
        }
        return true;
    }
}
