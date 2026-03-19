package com.bytedance.d.hc.an;

import android.os.Handler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d implements Runnable {
    private final long b;
    private Handler d;
    private final long hc;

    d(Handler handler, long j, long j2) {
        this.d = handler;
        this.hc = j;
        this.b = j2;
    }

    void d() {
        if (hc() > 0) {
            this.d.postDelayed(this, hc());
        } else {
            this.d.post(this);
        }
    }

    void d(long j) {
        if (j > 0) {
            this.d.postDelayed(this, j);
        } else {
            this.d.post(this);
        }
    }

    long hc() {
        return this.hc;
    }

    long b() {
        return this.b;
    }
}
