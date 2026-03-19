package com.alliance.ssp.ad.n0;

import com.alliance.ssp.ad.bean.YTTheme;

/* compiled from: SAThemeColor.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public static final f e;
    public static final f f;
    public static f g;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    /* compiled from: SAThemeColor.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[YTTheme.values().length];
            a = iArr;
            try {
                iArr[YTTheme.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[YTTheme.NIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[YTTheme.FOLLOW_SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        f fVar = new f("#FFFFFFFF", "#FFF1F5F9", "#FF000000", "#FFC7C7C7");
        e = fVar;
        f = new f("#FF5F5F5F", "#FF5F5F5F", "#FFFFFFFF", "#FFFFFFFF");
        g = fVar;
    }

    public f(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }
}
