package com.baidu.ad.magic.flute.a.a;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    public static final int a = -103;
    public static final int b = -104;
    public static final int c = -105;
    public static final int d = -106;
    public static final int e = -107;
    public static final int f = -108;
    public static final int g = -108;
    private static final int h = 6;
    private static final int i = 24;
    private static final int j = a.a(24);
    private static final int n = -100;
    private static final int o = -101;
    private static final int p = -102;
    private l k;
    private f l = new f();
    private Context m;

    public d(Context context) {
        this.m = context;
        this.k = new l(this.m);
    }

    private int a(Object obj, Object obj2) throws q, g {
        try {
            return this.k.a(obj, obj2);
        } catch (q e2) {
            throw e2;
        } catch (Throwable th) {
            throw new g(th);
        }
    }

    private m a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return m.a(-101, null);
        }
        c cVarA = c.a(bArr);
        if (cVarA == null) {
            return m.a(-106, null);
        }
        long[] jArrB = cVarA.b();
        return (jArrB == null || jArrB.length == 0) ? m.a(-107, null) : m.a(com.baidu.ad.magic.flute.d.a.a(jArrB[0]));
    }

    private Object a(String str, int i2) throws g {
        try {
            return p.a(this.k.d, new Object[]{str, this.l.a + i2});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new g("");
        }
    }

    private byte[] a(Object obj, String str) {
        k kVar = new k();
        for (int i2 = 0; i2 < j; i2++) {
            kVar.a(j.b(a(obj, a(str, i2))));
        }
        return kVar.a().b();
    }

    private int b(Object obj, String str) {
        new k();
        return a(obj, b(str));
    }

    private Object b(String str) throws g {
        try {
            return p.a(this.k.d, new Object[]{str, this.l.b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new g("");
        }
    }

    public m a(String str) {
        int i2 = -103;
        try {
            Object objA = this.k.a(this.m);
            if (objA == null) {
                e = new NullPointerException("gpm null error");
            } else {
                try {
                    return b(objA, str) == 1 ? m.a(-108) : a(a(objA, str));
                } catch (g e2) {
                    e = e2;
                    i2 = -100;
                } catch (n e3) {
                    e = e3;
                    i2 = -104;
                } catch (q e4) {
                    e = e4;
                    i2 = -2;
                }
            }
            return m.a(i2, e);
        } catch (q e5) {
            return m.a(-103, e5);
        }
    }
}
