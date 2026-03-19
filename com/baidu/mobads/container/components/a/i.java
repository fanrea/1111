package com.baidu.mobads.container.components.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class i {
    public static final int a = 0;
    public static final int b = 1;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private final long h;
    private final long i;
    private final long j;
    private long k;
    private long l;
    private int g = 0;
    private int m = 0;

    public abstract void a(boolean z);

    public i(long j, long j2, long j3) {
        this.h = j;
        this.i = j2;
        this.j = j3;
        this.l = j;
    }

    public void a(int i) {
        this.m = i;
    }

    public boolean a(long j, boolean z) {
        if (this.g == 3) {
            return true;
        }
        if (this.m == 0 && !z) {
            return false;
        }
        this.k += j;
        if (this.k > this.j + this.h) {
            return true;
        }
        if (this.k >= this.h && this.k >= this.l) {
            a(z);
            this.l += Math.max(this.i, j);
            if (this.l > this.j + this.h) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.g = 3;
    }
}
