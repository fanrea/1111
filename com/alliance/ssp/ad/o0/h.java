package com.alliance.ssp.ad.o0;

import android.content.Context;

/* compiled from: DensityUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h {
    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        String str = com.alliance.ssp.ad.d0.f.t;
        if (str != null && str.length() > 0) {
            return (int) ((Float.parseFloat(com.alliance.ssp.ad.d0.f.t) * f) + 0.5f);
        }
        if (context != null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int a(int i) {
        String str = com.alliance.ssp.ad.d0.f.t;
        if (str == null || str.length() <= 0) {
            return i;
        }
        return (int) ((i / Float.parseFloat(com.alliance.ssp.ad.d0.f.t)) + 0.5f);
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getResources().getConfiguration().orientation == 2;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
