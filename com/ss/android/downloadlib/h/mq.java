package com.ss.android.downloadlib.h;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class mq {

    private static class d {
        private static mq d = new mq();
    }

    public static mq d() {
        return d.d;
    }

    private mq() {
    }

    public void d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }

    public void hc(String str, String str2, String str3) {
        com.bytedance.sdk.component.utils.mq.c("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }
}
