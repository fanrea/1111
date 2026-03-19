package com.bytedance.d.hc.gb;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static boolean d = false;

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = d();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return hc();
        }
        return true;
    }

    public static String d() {
        return hc(a.a);
    }

    private static String hc(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                an.d(bufferedReader);
                return line;
            } catch (Throwable unused) {
                an.d(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean hc() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b() {
        if (!d) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.bytedance.d.hc.h.hc.d = true;
                    d = true;
                    return com.bytedance.d.hc.h.hc.d;
                }
            } catch (Exception unused) {
            }
            d = true;
        }
        return com.bytedance.d.hc.h.hc.d;
    }

    public static boolean c() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
