package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.view.MotionEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends hc {
    private com.bytedance.adsdk.ugeno.b.hc.d k;
    private float mk;
    private float mq;
    private boolean uo;

    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.u.b.hc
    public boolean d(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.hc != null && this.hc.fu() && this.k == null) {
            this.k = new com.bytedance.adsdk.ugeno.b.hc.d();
        }
        return d(this.hc, (MotionEvent) objArr[0]);
    }

    public boolean d(com.bytedance.adsdk.ugeno.hc.b bVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.b.hc.d dVar = this.k;
        if (dVar != null) {
            if (dVar.d(motionEvent)) {
                return false;
            }
            this.k.d(bVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mk = motionEvent.getRawX();
            this.mq = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.mk) >= 15.0f || Math.abs(rawY - this.mq) >= 15.0f) {
                    this.uo = true;
                }
            } else if (action == 3) {
                this.uo = false;
            }
        } else {
            if (this.uo) {
                this.uo = false;
                this.mk = 0.0f;
                this.mq = 0.0f;
                com.bytedance.adsdk.ugeno.b.hc.d dVar2 = this.k;
                if (dVar2 != null) {
                    dVar2.d(bVar);
                }
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.mk) >= 15.0f || Math.abs(rawY2 - this.mq) >= 15.0f) {
                this.uo = false;
                com.bytedance.adsdk.ugeno.b.hc.d dVar3 = this.k;
                if (dVar3 != null) {
                    dVar3.d(bVar);
                }
            } else if (this.d != null) {
                this.d.d(bVar, this.an, this.b.hc());
                this.mk = 0.0f;
                this.mq = 0.0f;
                return true;
            }
        }
        return true;
    }
}
