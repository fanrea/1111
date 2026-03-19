package com.bytedance.sdk.component.adexpress.c;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    public static boolean d(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean hc(String str) {
        return com.bytedance.sdk.component.adexpress.c.d() && d(str);
    }
}
