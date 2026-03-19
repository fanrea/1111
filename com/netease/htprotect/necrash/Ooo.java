package com.netease.htprotect.necrash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.netease.htprotect.necrash.p005O8.O8oO888;
import java.io.File;

/* renamed from: com.netease.htprotect.necrash.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static volatile boolean f184O8oO888 = false;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final String f185Ooo = "necrash";

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized void m624O8oO888(Context context, String str) {
        if (!f184O8oO888) {
            Log.w(f185Ooo, "setuserId error,please init necrash first");
            return;
        }
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (O8oO888.m615O8oO888()) {
            return;
        }
        try {
            context.getSharedPreferences("necrash_info", 0).edit().putString("userid", str).apply();
        } catch (Exception unused) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static synchronized void m625O8oO888(Context context, String str, String str2) {
        if (f184O8oO888) {
            return;
        }
        if (O8oO888.m615O8oO888()) {
            return;
        }
        if (context == null) {
            Log.w(f185Ooo, "context null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(f185Ooo, "htp appid null");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        File externalFilesDir = context.getExternalFilesDir("neCrash");
        if (externalFilesDir == null) {
            Log.w(f185Ooo, "crash dir init null");
            return;
        }
        f184O8oO888 = true;
        String string = externalFilesDir.toString();
        String strM623oO = O8oO888.m623oO(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.netease.htprotect.necrash.p002O8oO888.O8oO888 o8oO888 = new com.netease.htprotect.necrash.p002O8oO888.O8oO888();
        com.netease.htprotect.necrash.p002O8oO888.Ooo ooo = new com.netease.htprotect.necrash.p002O8oO888.Ooo();
        o8oO888.m537O8oO888(context, string, str, str2, jCurrentTimeMillis);
        ooo.m541O8oO888(context, string, strM623oO, str, str2, jCurrentTimeMillis);
    }
}
