package com.alliance.ssp.ad.l;

import android.content.Context;

/* compiled from: DecoratorUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static int a(Context context, float f) {
        if (context == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }
}
