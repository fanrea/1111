package com.qq.e.comm.plugin;

import android.os.Build;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k40 {
    public static boolean a() throws ClassNotFoundException {
        try {
            Class.forName("com.qq.e.ads.cfg.VideoOption");
            return Build.VERSION.SDK_INT >= 14;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean b() {
        try {
            return Build.VERSION.SDK_INT >= 14;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
