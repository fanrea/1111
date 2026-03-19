package com.bytedance.d.hc.gb;

import android.content.Context;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    public static File d(Context context) {
        return new File(b(context), "CrashLogJava");
    }

    public static File hc(Context context) {
        return new File(b(context), "crash_history");
    }

    public static String d() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String hc() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    private static String b(Context context) {
        String path;
        try {
            if (com.bytedance.sdk.openadsdk.api.plugin.hc.d(context) != null) {
                path = com.bytedance.sdk.openadsdk.api.plugin.hc.d(context).getPath();
            } else {
                File fileD = com.bytedance.sdk.openadsdk.api.plugin.hc.d(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                path = fileD != null ? fileD.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return "/sdcard/";
        }
    }
}
