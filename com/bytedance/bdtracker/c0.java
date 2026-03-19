package com.bytedance.bdtracker;

import com.bytedance.applog.log.IAppLogLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c0 {
    public int a;
    public volatile boolean b;
    public long c;
    public volatile boolean d;
    public final e0 e;
    public final d f;

    public c0(e0 e0Var) {
        this.e = e0Var;
        this.f = e0Var.d;
    }

    public final long a() {
        String str = com.alipay.sdk.m.u.h.i;
        long jB = b();
        if (jB > System.currentTimeMillis()) {
            return jB;
        }
        this.e.d.D.debug("The worker:{} start to work...", d());
        try {
            boolean zC = c();
            this.c = System.currentTimeMillis();
            if (zC) {
                this.a = 0;
            } else {
                this.a++;
            }
            IAppLogLogger iAppLogLogger = this.e.d.D;
            Object[] objArr = new Object[2];
            objArr[0] = d();
            if (zC) {
                str = "success";
            }
            objArr[1] = str;
            iAppLogLogger.debug("The worker:{} worked:{}.", objArr);
        } catch (Throwable th) {
            try {
                this.e.d.D.error("Work do failed.", th, new Object[0]);
                this.c = System.currentTimeMillis();
                this.a++;
                this.e.d.D.debug("The worker:{} worked:{}.", d(), com.alipay.sdk.m.u.h.i);
            } catch (Throwable th2) {
                this.c = System.currentTimeMillis();
                this.a++;
                this.e.d.D.debug("The worker:{} worked:{}.", d(), com.alipay.sdk.m.u.h.i);
                throw th2;
            }
        }
        return b();
    }

    public final long b() {
        long jG;
        long jCurrentTimeMillis;
        if (!f() || s4.b(this.e.b(), this.e.n.c()).a()) {
            jG = 0;
            if (this.b) {
                this.c = 0L;
                this.b = false;
            } else {
                int i = this.a;
                if (i > 0) {
                    long[] jArrE = e();
                    jG = jArrE[(i - 1) % jArrE.length];
                } else {
                    jG = g();
                }
            }
            jCurrentTimeMillis = this.c;
        } else {
            this.e.d.D.debug("Check work time is not net available.", new Object[0]);
            jCurrentTimeMillis = System.currentTimeMillis();
            jG = 5000;
        }
        return jCurrentTimeMillis + jG;
    }

    public abstract boolean c();

    public abstract String d();

    public abstract long[] e();

    public abstract boolean f();

    public abstract long g();

    public c0(e0 e0Var, long j) {
        this.e = e0Var;
        this.f = e0Var.d;
        this.c = j;
    }
}
