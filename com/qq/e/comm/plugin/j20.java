package com.qq.e.comm.plugin;

import android.os.SystemClock;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j20 {
    private long a;
    private final StringBuilder b = new StringBuilder();
    private long c;

    public void d() {
        this.a = SystemClock.elapsedRealtime();
    }

    public void c() {
        a();
        d();
    }

    public void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.a;
        this.c += jElapsedRealtime;
        StringBuilder sb = this.b;
        sb.append(jElapsedRealtime);
        sb.append(",");
    }

    public String toString() {
        int length = this.b.length();
        if (length <= 0) {
            return "";
        }
        StringBuilder sbDeleteCharAt = this.b.deleteCharAt(length - 1);
        sbDeleteCharAt.append(":");
        sbDeleteCharAt.append(this.c);
        return sbDeleteCharAt.toString();
    }

    public long b() {
        return this.c;
    }
}
