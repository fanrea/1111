package com.bytedance.adsdk.ugeno.an;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    private static Context b;
    private static String d;
    private static Resources hc;

    private static String d(Context context) {
        if (d == null) {
            d = context.getPackageName();
        }
        return d;
    }

    private static int d(Context context, String str, String str2) {
        if (hc == null) {
            hc = context.getResources();
        }
        return hc.getIdentifier(str, str2, d(context));
    }

    public static int d(Context context, String str) {
        return d(context, str, "raw");
    }

    public static int hc(Context context, String str) {
        return d(context, str, "drawable");
    }

    public static int b(Context context, String str) {
        return d(context, str, "id");
    }
}
