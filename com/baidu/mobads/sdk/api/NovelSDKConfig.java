package com.baidu.mobads.sdk.api;

import android.app.Application;
import com.baidu.mobads.sdk.internal.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NovelSDKConfig {
    public static boolean isInitNovelSDK() {
        return ao.f();
    }

    public static void attachBaseContext(Application application, String str, String str2) {
        ao.a(application, str, str2);
    }
}
