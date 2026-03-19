package com.bytedance.framwork.core.de.ha;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: RomUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class j {
    public static boolean a = false;
    public static boolean b = false;
    private static final CharSequence c = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence e = "funtouch";
    private static String f;
    private static Method g;

    public static String a() {
        if (b && !TextUtils.isEmpty(f)) {
            return f;
        }
        String strS = s();
        f = strS;
        return strS;
    }

    private static String s() {
        if (r()) {
            return j();
        }
        if (o()) {
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
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        b = true;
        return Build.DISPLAY;
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
        return !TextUtils.isEmpty(strA) && strA.toLowerCase(Locale.getDefault()).contains(e);
    }

    public static boolean f() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(d);
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
        return r() ? "miui_" + a("ro.miui.ui.version.name") + Config.replace + Build.VERSION.INCREMENTAL : "";
    }

    public static String k() {
        String strP = p();
        return (strP == null || !strP.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strP + Config.replace + Build.DISPLAY;
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

    private static String a(String str) {
        Process processExec;
        BufferedReader bufferedReader;
        String strB = b(str);
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
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
            d.a(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            d.a(bufferedReader2);
            return line;
        }
    }

    private static String b(String str) {
        try {
            if (g == null) {
                g = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            }
            return (String) g.invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean o() {
        return Build.DISPLAY.contains("Flyme") || "flyme".equals(Build.USER);
    }

    public static String p() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a(com.alipay.sdk.m.c.a.a);
        }
        return q();
    }

    public static String q() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, com.alipay.sdk.m.c.a.a);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean r() {
        try {
            if (Class.forName("miui.os.Build") != null) {
                a = true;
                return true;
            }
        } catch (Exception unused) {
        }
        return a;
    }
}
