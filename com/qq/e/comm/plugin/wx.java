package com.qq.e.comm.plugin;

import com.qq.e.comm.constants.CustomPkgConstants;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wx {
    public static String a() {
        String aDActivityName = CustomPkgConstants.getADActivityName();
        return aDActivityName == null ? "com.qq.e.ads.ADActivity" : aDActivityName;
    }

    public static String b() {
        String downLoadServiceName = CustomPkgConstants.getDownLoadServiceName();
        return downLoadServiceName == null ? "com.qq.e.comm.DownloadService" : downLoadServiceName;
    }

    public static String c() {
        String landscapeADActivityName = CustomPkgConstants.getLandscapeADActivityName();
        return landscapeADActivityName == null ? "com.qq.e.ads.LandscapeADActivity" : landscapeADActivityName;
    }

    public static String d() {
        String portraitADActivityName = CustomPkgConstants.getPortraitADActivityName();
        return portraitADActivityName == null ? "com.qq.e.ads.PortraitADActivity" : portraitADActivityName;
    }
}
