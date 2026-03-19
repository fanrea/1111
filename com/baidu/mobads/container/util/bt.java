package com.baidu.mobads.container.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bt {
    private static final int[] a = new int[0];
    private static final int[] b = {bu.g, bu.h, bu.i, 9, 11};
    private static final int[] c = new int[0];

    public enum a {
        UNDEFINED("undefined", -1),
        NORMAL("normal", 0),
        SECRET("secret", 1),
        DANGER("danger", 2);

        private String e;
        private int f;

        a(String str, int i) {
            this.e = str;
            this.f = i;
        }

        public String b() {
            return this.e;
        }

        public int c() {
            return this.f;
        }
    }

    public static int a(int i) {
        if (a(a, i)) {
            return a.UNDEFINED.c();
        }
        if (a(b, i)) {
            return a.SECRET.c();
        }
        if (a(c, i)) {
            return a.DANGER.c();
        }
        return a.NORMAL.c();
    }

    public static boolean a(int i, boolean z) {
        if (com.baidu.mobads.container.h.b) {
            return true;
        }
        int iA = a(i);
        if (iA == a.UNDEFINED.c()) {
            return false;
        }
        if (iA == a.NORMAL.c()) {
            return true;
        }
        if (iA == a.SECRET.c()) {
            return !a();
        }
        return z;
    }

    public static boolean a() {
        com.baidu.mobads.container.util.e.c cVarA = com.baidu.mobads.container.util.e.c.a(com.baidu.mobads.container.f.b());
        if (cVarA == null) {
            return false;
        }
        return cVarA.c() || cVarA.a() || cVarA.b();
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(String str) {
        try {
            return u.a(str);
        } catch (Exception e) {
            return "";
        }
    }
}
