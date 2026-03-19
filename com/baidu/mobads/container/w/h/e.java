package com.baidu.mobads.container.w.h;

import android.os.SystemClock;
import android.util.Printer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e implements Printer {
    private static final int c = 2000;
    private a h;
    private final h i;
    private long d = 2000;
    private long e = 0;
    private long f = 0;
    private boolean g = false;
    boolean a = false;
    boolean b = false;

    public interface a {
        void a(long j, long j2, long j3, long j4);
    }

    public e(a aVar, h hVar) {
        this.h = aVar;
        this.i = hVar;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.i.g() != null && this.i.g() != this) {
            this.i.g().println(str);
        }
        if (!this.a) {
            this.b = str.charAt(0) == '>' || str.charAt(0) == '<';
            this.a = true;
        }
        if (this.b) {
            a(str.charAt(0) == '>');
        }
    }

    private void a(boolean z) {
        if (z) {
            this.e = System.currentTimeMillis();
            this.f = SystemClock.currentThreadTimeMillis();
            a();
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (a(jCurrentTimeMillis)) {
                b(jCurrentTimeMillis);
            }
            b();
        }
    }

    private boolean a(long j) {
        return j - this.e > this.d;
    }

    private void b(long j) {
        com.baidu.mobads.container.w.c.a.b().post(new f(this, this.e, j, this.f, SystemClock.currentThreadTimeMillis()));
    }

    private void a() {
        if (this.i != null && this.i.f() != null) {
            this.i.f().a();
        }
    }

    private void b() {
        if (this.i != null && this.i.f() != null) {
            this.i.f().b();
        }
    }
}
