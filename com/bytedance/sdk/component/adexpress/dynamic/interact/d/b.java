package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements View.OnTouchListener {
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gb an;
    private float b;
    private float c;
    private float d;
    private boolean gb;
    private int h;
    private float hc;
    private boolean tt;
    private boolean u;

    public b(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar) {
        this(gbVar, 5);
    }

    public b(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar, int i) {
        this.h = 5;
        this.gb = true;
        this.an = gbVar;
        if (i > 0) {
            this.h = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar3;
        if (this.tt) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.hc = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.c = motionEvent.getX();
                this.b = motionEvent.getY();
                if (Math.abs(this.c - this.d) > 10.0f) {
                    this.u = true;
                }
                if (Math.abs(this.c - this.d) > 8.0f || Math.abs(this.b - this.hc) > 8.0f) {
                    this.gb = false;
                }
                int iHc = com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), Math.abs(this.c - this.d));
                if (this.c > this.d && iHc > this.h && (gbVar3 = this.an) != null) {
                    gbVar3.d();
                    this.tt = true;
                }
            }
        } else {
            if (!this.u && !this.gb) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iHc2 = com.bytedance.sdk.component.adexpress.c.gb.hc(com.bytedance.sdk.component.adexpress.c.getContext(), Math.abs(this.c - this.d));
            if (this.c > this.d && iHc2 > this.h && (gbVar2 = this.an) != null) {
                gbVar2.d();
                this.tt = true;
            }
            float fAbs = Math.abs(x - this.d);
            float fAbs2 = Math.abs(y - this.hc);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (gbVar = this.an) != null) {
                gbVar.hc();
                this.tt = true;
            }
        }
        return true;
    }
}
