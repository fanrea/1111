package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.mobads.container.util.animation.j;
import com.fendasz.moku.planet.constants.MokuConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends hc {
    private AtomicBoolean cb;
    private int e;
    private int k;
    private float mk;
    private float mq;
    private int uo;
    private String w;
    private com.bytedance.adsdk.ugeno.b.hc.d yo;

    public c(Context context) {
        super(context);
        this.uo = 0;
        this.k = Integer.MAX_VALUE;
        this.e = Integer.MAX_VALUE;
        this.cb = new AtomicBoolean(true);
        this.w = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.u.b.hc
    public boolean d(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.u != null) {
            this.w = TextUtils.isEmpty(this.u.get("direction")) ? MokuConstants.TASK_TAG_ALL : this.u.get("direction");
            this.uo = com.bytedance.adsdk.ugeno.an.b.d(this.u.get("distance"), 0);
            if (this.k == Integer.MAX_VALUE) {
                this.k = com.bytedance.adsdk.ugeno.an.b.d(this.u.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.e == Integer.MAX_VALUE) {
                this.e = com.bytedance.adsdk.ugeno.an.b.d(this.u.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            this.cb.get();
        }
        if (this.hc != null && this.hc.fu() && this.yo == null) {
            this.yo = new com.bytedance.adsdk.ugeno.b.hc.d();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        d();
        return d(this.hc, motionEvent);
    }

    private void d() {
        if (this.e == Integer.MAX_VALUE || this.hc == null || System.currentTimeMillis() - this.hc.v() < this.e) {
            return;
        }
        this.cb.set(false);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean d(com.bytedance.adsdk.ugeno.hc.b bVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.b.hc.d dVar = this.yo;
        if (dVar != null) {
            if (dVar.d(motionEvent)) {
                return false;
            }
            this.yo.d(bVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mk = motionEvent.getX();
            this.mq = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.uo == 0 && this.d != null) {
                b(bVar);
                return true;
            }
            int iHc = com.bytedance.adsdk.ugeno.an.gb.hc(this.tc, x - this.mk);
            int iHc2 = com.bytedance.adsdk.ugeno.an.gb.hc(this.tc, y - this.mq);
            String str = this.w;
            char c = 65535;
            switch (str.hashCode()) {
                case 3739:
                    if (str.equals("up")) {
                        c = 0;
                        break;
                    }
                    break;
                case 96673:
                    if (str.equals(MokuConstants.TASK_TAG_ALL)) {
                        c = 4;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals(j.d)) {
                        c = 2;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals(j.e)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                iHc = -iHc2;
            } else if (c == 1) {
                iHc = iHc2;
            } else if (c == 2) {
                iHc = -iHc;
            } else if (c != 3) {
                iHc = (int) Math.abs(Math.sqrt(Math.pow(iHc, 2.0d) + Math.pow(iHc2, 2.0d)));
            }
            if (iHc >= this.uo) {
                if (this.d != null) {
                    this.mk = 0.0f;
                    this.mq = 0.0f;
                    b(bVar);
                    return true;
                }
            } else {
                hc(bVar);
                return false;
            }
        }
        return true;
    }

    private void hc(com.bytedance.adsdk.ugeno.hc.b bVar) {
        com.bytedance.adsdk.ugeno.b.hc.d dVar = this.yo;
        if (dVar != null) {
            dVar.d(bVar);
        }
    }

    private void b(com.bytedance.adsdk.ugeno.hc.b bVar) {
        if (this.k <= 0) {
            hc(bVar);
            return;
        }
        if (!this.cb.get()) {
            hc(bVar);
            return;
        }
        this.d.d(bVar, this.an, this.b.hc());
        int i = this.k;
        if (i != Integer.MAX_VALUE) {
            this.k = i - 1;
        }
    }
}
