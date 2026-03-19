package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class cq {
    static cq a;
    static cq b;
    static cq c;
    private long d;
    private a e;

    static {
        c();
    }

    enum a {
        DWORD(4),
        QWORD(8);

        int c;

        a(int i) {
            this.c = i;
        }
    }

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public a b() {
        return this.e;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    private static void c() {
        a = new cq();
        b = new cq();
        c = new cq();
        b.a(a.DWORD);
        int i = Build.VERSION.SDK_INT;
        if (cr.a()) {
            a.a(a.QWORD);
            c.a(a.QWORD);
            switch (i) {
                case 19:
                    a.a(32L);
                    b.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                case 21:
                    a.a(40L);
                    a.a(a.QWORD);
                    c.a(32L);
                    c.a(a.QWORD);
                    b.a(56L);
                    return;
                case 22:
                    a.a(52L);
                    c.a(44L);
                    b.a(20L);
                    return;
                case 23:
                    a.a(48L);
                    c.a(40L);
                    b.a(12L);
                    return;
                case 24:
                case 25:
                    a.a(48L);
                    c.a(40L);
                    b.a(4L);
                    return;
                case 26:
                case 27:
                    a.a(40L);
                    c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    a.a(32L);
                    c.a(24L);
                    b.a(4L);
                    return;
            }
        }
        a.a(a.DWORD);
        c.a(a.DWORD);
        switch (i) {
            case 19:
                a.a(32L);
                b.a(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            case 21:
                a.a(40L);
                a.a(a.QWORD);
                c.a(32L);
                c.a(a.QWORD);
                b.a(56L);
                return;
            case 22:
                a.a(44L);
                c.a(40L);
                b.a(20L);
                return;
            case 23:
                a.a(36L);
                c.a(32L);
                b.a(12L);
                return;
            case 24:
            case 25:
                a.a(32L);
                c.a(28L);
                b.a(4L);
                return;
            case 26:
            case 27:
                a.a(28L);
                c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                a.a(24L);
                c.a(20L);
                b.a(4L);
                return;
        }
    }
}
