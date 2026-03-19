package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q6 {

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.UNIFIED_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.FULL_SCREEN_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.REWARD_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.END_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.REWARD_PAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: A */
    public enum c {
        SPLASH,
        UNIFIED_INTERSTITIAL,
        FULL_SCREEN_INTERSTITIAL,
        REWARD_VIDEO,
        REWARD_PAGE,
        END_CARD
    }

    private static String b(c cVar) {
        int i = a.a[cVar.ordinal()];
        return (i == 3 || i == 4) ? "7,7,7,7" : i != 6 ? "6,6,6,6" : "14,14,14,14";
    }

    public static b a(c cVar, h4 h4Var) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        String strA;
        Context contextA;
        String[] strArrSplit;
        String strA2 = a(cVar);
        int i = 0;
        if (TextUtils.isEmpty(strA2)) {
            iA4 = 0;
            iA2 = 0;
            iA3 = 0;
        } else {
            try {
                String strB = b(cVar);
                vx vxVarF = r1.d().f();
                if (h4Var == null) {
                    strA = vxVarF.b(strA2, strB);
                } else {
                    strA = vxVarF.a(strA2, h4Var.y0(), strB);
                }
                if (strA.contains(",")) {
                    strB = strA;
                } else if (h4Var != null) {
                    strB = com.qq.e.comm.plugin.b.c().a(h4Var.x0(), strA, strB);
                }
                contextA = r1.d().a();
                strArrSplit = strB.split(",");
                iA = yu.a(contextA, Integer.parseInt(strArrSplit[0]));
            } catch (Exception unused) {
                iA = 0;
            }
            try {
                iA2 = yu.a(contextA, Integer.parseInt(strArrSplit[1]));
            } catch (Exception unused2) {
                iA2 = 0;
                iA3 = 0;
                i = iA;
                iA4 = 0;
                return new b(i, iA2, iA3, iA4);
            }
            try {
                iA3 = yu.a(contextA, Integer.parseInt(strArrSplit[2]));
            } catch (Exception unused3) {
                iA3 = 0;
                i = iA;
                iA4 = 0;
                return new b(i, iA2, iA3, iA4);
            }
            try {
                iA4 = yu.a(contextA, Integer.parseInt(strArrSplit[3]));
                i = iA;
            } catch (Exception unused4) {
                i = iA;
                iA4 = 0;
                return new b(i, iA2, iA3, iA4);
            }
        }
        return new b(i, iA2, iA3, iA4);
    }

    private static String a(c cVar) {
        switch (a.a[cVar.ordinal()]) {
            case 1:
                return "ssvsa";
            case 2:
                return "icbsa";
            case 3:
                return "fsicbsa";
            case 4:
                return "rvcbsa";
            case 5:
                return "eccbsa";
            case 6:
                return "rpcbsa";
            default:
                return "";
        }
    }

    /* compiled from: A */
    public static class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public b(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }
}
