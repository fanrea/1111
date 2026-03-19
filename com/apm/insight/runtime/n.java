package com.apm.insight.runtime;

import com.apm.insight.MonitorCrash;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class n {
    private static MonitorCrash a = null;
    private static boolean b = true;
    private static int c = -1;
    private static int d;

    public static MonitorCrash a() {
        if (b && a == null) {
            MonitorCrash.Config.SdkBuilder sdkBuilderSdk = MonitorCrash.Config.sdk("240740");
            sdkBuilderSdk.versionName("1.5.7.oversea").versionCode(1050790L);
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(com.apm.insight.g.f(), sdkBuilderSdk.keyWords("com.apm.insight").token("f81630b5764841ffbc0320ee2361b090").soList("libapminsighta.so", "libapminsightb.so").versionName("1.5.7.oversea").versionCode(1050790L).channel("release").disablePageView().build());
            a = monitorCrashInitSDK;
            if (monitorCrashInitSDK != null) {
                try {
                    monitorCrashInitSDK.config().setDeviceId("1000002");
                } catch (Throwable unused) {
                }
            }
        }
        return a;
    }

    public static void a(Throwable th, String str) {
        if (com.apm.insight.g.f() != null && c() && b) {
            a().reportCustomErr(str, "INNER", th);
        }
    }

    public static void b() {
        b = false;
    }

    private static boolean c() {
        if (c == -1) {
            c = 5;
        }
        int i = d;
        if (i >= c) {
            return false;
        }
        d = i + 1;
        return true;
    }
}
