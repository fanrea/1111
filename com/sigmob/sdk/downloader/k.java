package com.sigmob.sdk.downloader;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;

    private static String a(long bytes, boolean si) {
        return com.sigmob.sdk.downloader.core.c.a(bytes, si) + "/s";
    }

    public synchronized void a() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public synchronized void a(long increaseBytes) {
        if (this.a == 0) {
            long jB = b();
            this.a = jB;
            this.d = jB;
        }
        this.b += increaseBytes;
        this.f += increaseBytes;
    }

    long b() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void c() {
        long jB = b();
        long j = this.b;
        long jMax = Math.max(1L, jB - this.a);
        this.b = 0L;
        this.a = jB;
        this.c = (long) ((j / jMax) * 1000.0f);
    }

    public long d() {
        c();
        return this.c;
    }

    public synchronized long e() {
        long jB = b() - this.a;
        if (jB < 1000) {
            long j = this.c;
            if (j != 0) {
                return j;
            }
        }
        if (this.c == 0 && jB < 500) {
            return 0L;
        }
        return d();
    }

    public synchronized long f() {
        long jB;
        jB = this.e;
        if (jB == 0) {
            jB = b();
        }
        return (long) ((this.f / Math.max(1L, jB - this.d)) * 1000.0f);
    }

    public synchronized void g() {
        this.e = b();
    }

    public String h() {
        return m();
    }

    public String i() {
        return a(e(), true);
    }

    public String j() {
        return a(this.c, true);
    }

    public synchronized long k() {
        return b() - this.a;
    }

    public String l() {
        return a(d(), false);
    }

    public String m() {
        return a(d(), true);
    }

    public String n() {
        return o();
    }

    public String o() {
        return a(f(), true);
    }
}
