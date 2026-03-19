package com.bytedance.d.hc.gb;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo {
    private static final CharSequence d = "sony";
    private static final CharSequence hc = "amigo";
    private static final CharSequence b = "funtouch";

    public static String d() {
        if (b.b()) {
            return tc();
        }
        if (b.c()) {
            return mq();
        }
        if (uo()) {
            return k();
        }
        String strMk = mk();
        if (!TextUtils.isEmpty(strMk)) {
            return strMk;
        }
        if (u()) {
            return c();
        }
        if (an()) {
            return h();
        }
        if (b()) {
            return hc();
        }
        String strGb = gb();
        return !TextUtils.isEmpty(strGb) ? strGb : Build.DISPLAY;
    }

    public static String hc() {
        return d("ro.build.uiversion") + Config.replace + Build.DISPLAY;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String c() {
        return d("ro.vivo.os.build.display.id") + Config.replace + d("ro.vivo.product.version");
    }

    public static boolean u() {
        String strD = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strD) && strD.toLowerCase(Locale.getDefault()).contains(b);
    }

    public static boolean an() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(hc);
    }

    public static String h() {
        return Build.DISPLAY + Config.replace + d("ro.gn.sv.version");
    }

    public static String gb() {
        return tt() ? "eui_" + d("ro.letv.release.version") + Config.replace + Build.DISPLAY : "";
    }

    public static boolean tt() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String tc() {
        return b.b() ? "miui_" + d("ro.miui.ui.version.name") + Config.replace + Build.VERSION.INCREMENTAL : "";
    }

    public static String mk() {
        String strD = b.d();
        return (strD == null || !strD.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strD + Config.replace + Build.DISPLAY;
    }

    public static String mq() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean uo() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String k() {
        return uo() ? "coloros_" + d("ro.build.version.opporom") + Config.replace + Build.DISPLAY : "";
    }

    private static String d(String str) {
        BufferedReader bufferedReader;
        Process processExec;
        String line = "";
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            an.d(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            an.d(bufferedReader);
            return line;
        }
    }
}
