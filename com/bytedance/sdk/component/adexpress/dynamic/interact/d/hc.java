package com.bytedance.sdk.component.adexpress.dynamic.interact.d;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements View.OnTouchListener {
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gb an;
    private long b;
    private boolean c;
    private float d;
    private float hc;
    private InteractViewContainer u;

    public hc(InteractViewContainer interactViewContainer, com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar) {
        this.u = interactViewContainer;
        this.an = gbVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = System.currentTimeMillis();
            this.d = motionEvent.getX();
            this.hc = motionEvent.getY();
            this.u.u();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.d) >= com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), 10.0f) || Math.abs(y - this.hc) >= com.bytedance.sdk.component.adexpress.c.gb.d(com.bytedance.sdk.component.adexpress.c.getContext(), 10.0f)) {
                    this.c = true;
                    this.u.an();
                }
            }
        } else {
            if (this.c) {
                return false;
            }
            if (System.currentTimeMillis() - this.b >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.interact.gb gbVar = this.an;
                if (gbVar != null) {
                    gbVar.d();
                }
            } else {
                this.u.an();
            }
        }
        return true;
    }
}
