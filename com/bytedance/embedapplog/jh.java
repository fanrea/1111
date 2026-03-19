package com.bytedance.embedapplog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class jh {
    private boolean b;
    private volatile boolean c;
    final de d;
    private int hc = 0;

    abstract boolean b();

    abstract String c();

    abstract long d();

    abstract long[] hc();

    jh(de deVar) {
        this.d = deVar;
    }

    void u() {
        this.b = true;
    }

    boolean an() {
        return this.b;
    }

    final long h() {
        boolean zB;
        long jD;
        long jD2 = d();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.c) {
            jD2 = 0;
            this.c = false;
        }
        if (jD2 > 1000 + jCurrentTimeMillis) {
            return jD2 - jCurrentTimeMillis;
        }
        try {
            zB = b();
        } catch (Exception e) {
            um.hc(e);
            zB = false;
        }
        if (zB) {
            this.hc = 0;
            jD = d() - System.currentTimeMillis();
        } else {
            long[] jArrHc = hc();
            int i = this.hc;
            this.hc = i + 1;
            jD = jArrHc[i % jArrHc.length];
        }
        um.c(c() + " worked:" + zB + " " + jD, null);
        return jD;
    }

    void gb() {
        um.d("setImmediately, " + c());
        this.c = true;
    }
}
