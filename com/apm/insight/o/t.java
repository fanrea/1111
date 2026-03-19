package com.apm.insight.o;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class t {
    private static final CharSequence a = "sony";
    private static final CharSequence b = "amigo";
    private static final CharSequence c = "funtouch";

    public static String a() {
        if (d.c()) {
            return j();
        }
        if (d.d()) {
            return l();
        }
        if (m()) {
            return n();
        }
        String strK = k();
        if (!TextUtils.isEmpty(strK)) {
            return strK;
        }
        if (e()) {
            return d();
        }
        if (f()) {
            return g();
        }
        if (c()) {
            return b();
        }
        String strH = h();
        return !TextUtils.isEmpty(strH) ? strH : Build.DISPLAY;
    }

    private static String a(String str) {
        Process processExec;
        BufferedReader bufferedReader;
        String line = "";
        BufferedReader bufferedReader2 = null;
        try {
            processExec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            l.a(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            l.a(bufferedReader2);
            return line;
        }
    }

    public static String b() {
        return a("ro.build.uiversion") + Config.replace + Build.DISPLAY;
    }

    public static boolean c() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String d() {
        return a("ro.vivo.os.build.display.id") + Config.replace + a("ro.vivo.product.version");
    }

    public static boolean e() {
        String strA = a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strA) && strA.toLowerCase(Locale.getDefault()).contains(c);
    }

    public static boolean f() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(b);
    }

    public static String g() {
        return Build.DISPLAY + Config.replace + a("ro.gn.sv.version");
    }

    public static String h() {
        return i() ? "eui_" + a("ro.letv.release.version") + Config.replace + Build.DISPLAY : "";
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.letv.release.version"));
    }

    public static String j() {
        return d.c() ? "miui_" + a("ro.miui.ui.version.name") + Config.replace + Build.VERSION.INCREMENTAL : "";
    }

    public static String k() {
        String strA = d.a();
        return (strA == null || !strA.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strA + Config.replace + Build.DISPLAY;
    }

    public static String l() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean m() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String n() {
        return m() ? "coloros_" + a("ro.build.version.opporom") + Config.replace + Build.DISPLAY : "";
    }
}
