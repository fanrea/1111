package com.qq.e.comm.plugin;

import androidx.core.location.LocationRequestCompat;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e20 {
    private final h4 a;
    private volatile boolean b;
    private xl c;
    private q5 d;
    private long e;

    public e20(h4 h4Var) {
        this.a = h4Var;
    }

    public void b() {
        a(this.e);
    }

    public void a() {
        q5 q5Var = this.d;
        if (q5Var != null) {
            q5Var.a();
        }
    }

    public void a(xl xlVar) {
        a(xlVar, false);
    }

    public void a(xl xlVar, boolean z) {
        this.c = xlVar;
        if (z) {
            this.d = new q5(this.a, this);
        }
    }

    public void a(long j) {
        this.c.a(j);
        this.e = j;
        long jC = this.c.c();
        if (jC == LocationRequestCompat.PASSIVE_INTERVAL || this.b || j < jC) {
            return;
        }
        this.b = true;
        this.c.b(j);
    }
}
