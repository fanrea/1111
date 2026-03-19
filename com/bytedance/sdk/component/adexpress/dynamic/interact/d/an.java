package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements View.OnTouchListener {
    private static int b = 10;
    private boolean c;
    private float d;
    private float hc;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gb u;

    public an(com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar) {
        this.u = gbVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.hc = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.d) >= b || Math.abs(y - this.hc) >= b) {
                    this.c = true;
                }
            } else if (action == 3) {
                this.c = false;
            }
        } else {
            if (this.c) {
                this.c = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.d) >= b || Math.abs(y2 - this.hc) >= b) {
                this.c = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar = this.u;
                if (gbVar != null) {
                    gbVar.d();
                }
            }
        }
        return true;
    }
}
