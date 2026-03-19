package com.qq.e.comm.util;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private long a;
    private final StringBuilder b = new StringBuilder();
    private long c;

    public void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a;
        this.c += jElapsedRealtime;
        this.b.append(jElapsedRealtime).append(",");
    }

    public void b() {
        a();
        c();
    }

    public void c() {
        this.a = SystemClock.elapsedRealtime();
    }

    public String toString() {
        int length = this.b.length();
        return length <= 0 ? "" : this.b.deleteCharAt(length - 1).append(":").append(this.c).toString();
    }
}
