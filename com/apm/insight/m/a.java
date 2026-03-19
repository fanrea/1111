package com.apm.insight.m;

import android.os.Handler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class a implements Runnable {
    private Handler a;
    private final long b;
    private final long c;

    a(Handler handler, long j, long j2) {
        this.a = handler;
        this.b = j;
        this.c = j2;
    }

    void a() {
        if (b() > 0) {
            this.a.postDelayed(this, b());
        } else {
            this.a.post(this);
        }
    }

    void a(long j) {
        if (j > 0) {
            this.a.postDelayed(this, j);
        } else {
            this.a.post(this);
        }
    }

    long b() {
        return this.b;
    }

    long c() {
        return this.c;
    }
}
