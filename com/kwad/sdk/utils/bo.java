package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bo {
    public static boolean apM() {
        return ag.o("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void apN() {
        ag.n("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void apO() {
        ag.n("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean apP() {
        return ag.o("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void apQ() {
        ag.n("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean apR() {
        return ag.o("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void i(final Context context, final String str, final String str2) {
        h.execute(new bh() { // from class: com.kwad.sdk.utils.bo.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                bo.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        if (context != null) {
            com.kwad.sdk.crash.utils.h.m(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
            apN();
        }
    }

    public static String aM(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String strJ = com.kwad.sdk.crash.utils.h.J(file);
            return TextUtils.isEmpty(strJ) ? "" : strJ;
        } catch (Throwable unused) {
            return "";
        }
    }
}
