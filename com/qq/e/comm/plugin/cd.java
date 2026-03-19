package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cd {

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e2.values().length];
            a = iArr;
            try {
                iArr[e2.NATIVEEXPRESSAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e2.NATIVEUNIFIEDAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e2.UNIFIED_BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e2.UNIFIED_INTERSTITIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a(e2 e2Var, String str) {
        String str2;
        int i = a.a[e2Var.ordinal()];
        if (i == 1 || i == 2) {
            str2 = "naexpopct";
        } else if (i == 3) {
            str2 = "bexpopct";
        } else {
            if (i != 4) {
                return 50;
            }
            str2 = "ihexpopct";
        }
        return r1.d().f().a(str2, str, 50);
    }

    public static int a(String str) {
        return r1.d().f().a("nauexpopct", str, 20);
    }
}
