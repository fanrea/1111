package com.alliance.ssp.ad.o0;

import android.content.SharedPreferences;

/* compiled from: SharedHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class q {
    public static q b;
    public SharedPreferences a;

    public static synchronized q a() {
        if (b == null) {
            b = new q();
        }
        return b;
    }
}
