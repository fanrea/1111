package com.bytedance.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.l0;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class y4 {
    public static final CharSequence a = "amigo";
    public static final CharSequence b = "funtouch";
    public static final i4<Boolean> c = new a();

    public static class a extends i4<Boolean> {
        @Override // com.bytedance.bdtracker.i4
        public Boolean a(Object[] objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static String a() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        Process processExec;
        String strA = a5.a(str);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String line = "";
        if (!TextUtils.isEmpty(str)) {
            BufferedReader bufferedReader2 = null;
            try {
                processExec = Runtime.getRuntime().exec("getprop " + str);
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            } catch (Throwable th) {
                th = th;
            }
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                try {
                    LoggerImpl.global().error("getSysPropByExec error", th, new Object[0]);
                    bufferedReader = bufferedReader2;
                    return line;
                } finally {
                    l0.b.a((Closeable) bufferedReader2);
                }
            }
        }
        return line;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean c() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean d() {
        return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("honor")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor"));
    }

    public static boolean e() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
