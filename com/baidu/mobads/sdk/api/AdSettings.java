package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.cn;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return cn.c() + "";
    }

    public static void setNotificationIcon(int i) {
        CustomNotification.setNotificationIcon(i);
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }
}
