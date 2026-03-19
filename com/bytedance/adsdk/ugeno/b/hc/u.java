package com.bytedance.adsdk.ugeno.b.hc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.ugeno.b.cb;
import com.bytedance.adsdk.ugeno.b.yo;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private cb gb;
    private cb h;
    private boolean mk;
    private boolean mq;
    private Context tc;
    private String tt;
    private d uo;
    private float d = Float.MIN_VALUE;
    private float hc = Float.MIN_VALUE;
    private int b = 0;
    private int c = Integer.MAX_VALUE;
    private int u = Integer.MAX_VALUE;
    private AtomicBoolean an = new AtomicBoolean(true);

    public u(Context context, cb cbVar, boolean z, boolean z2) {
        this.tc = context;
        this.h = cbVar;
        this.mk = z;
        this.mq = z2;
        b();
    }

    public u(Context context, cb cbVar, cb cbVar2, boolean z, boolean z2) {
        this.tc = context;
        this.h = cbVar;
        this.gb = cbVar2;
        this.mk = z;
        this.mq = z2;
        b();
    }

    private void b() {
        if (this.mq) {
            this.uo = new d();
        }
        cb cbVar = this.h;
        if (cbVar == null) {
            return;
        }
        this.b = cbVar.b().optInt("slideThreshold");
        this.tt = this.h.b().optString("slideDirection");
        this.c = this.h.b().optInt("frequency", Integer.MAX_VALUE);
        this.u = this.h.b().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.an.get();
    }

    public void d() {
        if (this.u == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.b.hc.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.an.set(false);
            }
        }, this.u);
    }

    public void hc() {
        this.d = Float.MIN_VALUE;
        this.hc = Float.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(com.bytedance.adsdk.ugeno.b.yo r7, com.bytedance.adsdk.ugeno.hc.b r8, android.view.MotionEvent r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.b.hc.u.d(com.bytedance.adsdk.ugeno.b.yo, com.bytedance.adsdk.ugeno.hc.b, android.view.MotionEvent, boolean):boolean");
    }

    private void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        d dVar = this.uo;
        if (dVar != null) {
            dVar.d(bVar);
        }
    }

    private void d(yo yoVar, cb cbVar, com.bytedance.adsdk.ugeno.hc.b bVar) {
        if (this.c <= 0) {
            d(bVar);
            return;
        }
        if (!this.an.get()) {
            d(bVar);
            return;
        }
        yoVar.d(cbVar, bVar, bVar);
        int i = this.c;
        if (i != Integer.MAX_VALUE) {
            this.c = i - 1;
        }
    }
}
