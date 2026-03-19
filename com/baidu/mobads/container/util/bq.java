package com.baidu.mobads.container.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bq {
    public static final String a = "BaiduXAdSDK";
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private static final int e = 5;
    private static final int f = 6;
    private static final int g = 7;
    private static final int h = -1;
    private static final int i;
    private static volatile bq j;

    static {
        i = com.baidu.mobads.container.h.b ? 2 : 4;
        j = null;
    }

    public static bq a() {
        if (j == null) {
            synchronized (bq.class) {
                if (j == null) {
                    j = new bq();
                }
            }
        }
        return j;
    }

    private bq() {
    }

    public boolean a(String str, int i2) {
        return true;
    }

    public boolean a(int i2) {
        return a(a, i2);
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj).append(' ');
        }
        return sb.toString();
    }

    public void a(Object... objArr) {
        if (!a(3)) {
            return;
        }
        a(e(objArr));
    }

    public void a(String str) {
        a(a, str);
    }

    public void a(String str, String str2) {
        if (!a(3)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.h(str).c(str2);
        } catch (Exception e2) {
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(String str, Throwable th) {
        if (!a(3)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.h(a).b(th, str);
        } catch (Exception e2) {
        }
    }

    public void b(String str) {
        if (!a(5)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.b().e(str);
        } catch (Exception e2) {
        }
    }

    public void b(Object... objArr) {
        if (!a(5)) {
            return;
        }
        b(e(objArr));
    }

    public void b(String str, Throwable th) {
        if (!a(5)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.b().d(th, str);
        } catch (Exception e2) {
        }
    }

    public void b(Throwable th) {
        b("", th);
    }

    public void c(Object... objArr) {
        if (!a(6)) {
            return;
        }
        c(e(objArr));
    }

    public void c(String str) {
        if (!a(6)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.b().f(str);
        } catch (Exception e2) {
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(String str, Throwable th) {
        if (!a(6)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.b().e(th, str);
        } catch (Exception e2) {
        }
    }

    public void d(String str) {
        b(a, str);
    }

    public void b(String str, String str2) {
        if (!a(4)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.b().c(str, str2);
        } catch (Exception e2) {
        }
    }

    public void d(Object... objArr) {
        if (!a(4)) {
            return;
        }
        d(e(objArr));
    }

    public void d(String str, Throwable th) {
        if (!a(4)) {
            return;
        }
        try {
            com.baidu.mobads.container.l.g.b().c(th, str);
        } catch (Exception e2) {
        }
    }
}
