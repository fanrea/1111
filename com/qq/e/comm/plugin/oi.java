package com.qq.e.comm.plugin;

import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class oi {
    private AtomicBoolean a;
    private AtomicInteger b;
    private boolean c;
    private int d;
    private int e;

    /* compiled from: A */
    private static class b {
        private static oi a = new oi();
    }

    private oi() {
        this.a = new AtomicBoolean(false);
        this.b = new AtomicInteger(0);
        this.e = 1;
        this.c = yy.a("sphdv", true);
        this.d = yy.a("hdrefver", 0);
    }

    public void e() {
        this.a.set(true);
    }

    public void a(int i) {
        b10.b(1130024, null, Integer.valueOf(i));
        int iIncrementAndGet = this.b.incrementAndGet();
        this.a.get();
        if (iIncrementAndGet == 3) {
            this.c = false;
            if (this.a.get()) {
                b10.b(1130026, null, Integer.valueOf(i));
            } else {
                b10.b(1130025, null, Integer.valueOf(i));
                yy.b("sphdv", false);
            }
        }
    }

    public static oi a() {
        return b.a;
    }

    public boolean a(r1 r1Var) {
        if (Build.VERSION.SDK_INT < 21) {
            this.e = 2;
            return false;
        }
        if (r1Var.f().a("nshd", 1) != 1) {
            this.e = 3;
            return false;
        }
        String str = r1.d().c().j;
        if (TextUtils.isEmpty(str)) {
            this.e = 4;
            return false;
        }
        String strB = r1Var.f().b("nshdbd", "");
        String lowerCase = str.toLowerCase();
        if (!"oppo a37m,oppo a59m,oppo a59s,oppo a59st,oppo r9km,oppo r9m,oppo r9s,oppo r9tm,vivo v3m a,vivo x5pro d,vivo x6d,vivo x6l,vivo x6plus d,vivo y67,vivo y67a,vivo y67l,jmm al10,sea-al10,redmi 6a,m5 note,kuliao k10".contains(lowerCase) && !strB.contains(lowerCase)) {
            int iA = r1Var.f().a("reshdv", 0);
            if (iA > this.d) {
                b(iA);
                return true;
            }
            boolean z = this.c;
            if (!z) {
                this.e = 6;
            }
            return z;
        }
        this.e = 5;
        return false;
    }

    public boolean c() {
        this.b.get();
        return this.b.get() > 0;
    }

    public int b() {
        return this.e;
    }

    public boolean d() {
        return this.e == 1;
    }

    private void b(int i) {
        this.d = i;
        yy.b("hdrefver", i);
        yy.b("sphdv", true);
        this.c = true;
    }
}
