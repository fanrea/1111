package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Build;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y2 {
    public static final String a = Build.BRAND;
    public static final String b = Build.DEVICE;
    public static final String c = Build.FINGERPRINT;
    public static final String d = Build.HARDWARE;
    public static final String e = Build.PRODUCT;

    public static boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
