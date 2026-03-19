package com.qq.e.comm.plugin;

import android.os.SystemClock;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d20 {
    private final int a;
    private int b;
    private long c = -1;

    public int a() {
        return this.a;
    }

    public d20(int i) {
        this.a = i;
        this.b = i;
    }

    public boolean b() {
        if (this.c == -1) {
            this.c = SystemClock.elapsedRealtime();
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.c;
        this.c = jElapsedRealtime;
        double d = j;
        int i = this.a;
        double d2 = i;
        Double.isNaN(d2);
        Double.isNaN(d);
        double d3 = d * (d2 / 60000.0d);
        double d4 = this.b;
        Double.isNaN(d4);
        int i2 = (int) (d4 + d3);
        this.b = i2;
        if (i2 > i) {
            this.b = i;
        }
        int i3 = this.b;
        if (i3 < 1) {
            return true;
        }
        this.b = i3 - 1;
        return false;
    }
}
