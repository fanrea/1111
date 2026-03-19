package com.ss.android.socialbase.appdownloader.an;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static String b;
    private static String c;
    private static String d;
    private static String hc;
    private static Boolean u;

    public static boolean d(Context context) {
        return context != null && b(context) == 0 && u();
    }

    public static boolean hc(Context context) {
        return context != null && c(context) == 0 && an();
    }

    public static String d() {
        if (d == null) {
            d = d("getApiVersion");
        }
        return d;
    }

    public static String hc() {
        if (hc == null) {
            hc = d(IFunc.IVK_VERSION);
        }
        return hc;
    }

    public static String b() {
        if (b == null) {
            b = d("getReleaseType");
        }
        return b;
    }

    public static String c() {
        if (c == null) {
            c = d("getBuildVersion");
        }
        return c;
    }

    public static int b(Context context) {
        if (context == null) {
            return 1;
        }
        if (hc(hc(), d())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int c(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static boolean u() {
        if (u == null) {
            u = Boolean.FALSE;
            try {
                u = Boolean.valueOf("156".equals(d("ro.config.hw_optb", "0")) && "true".equals(d("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return u.booleanValue();
    }

    public static boolean an() {
        return u() && hc(hc(), d()) && d(Process.myUid()) == 0;
    }

    public static String h() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String d(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int d(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            mq.d(th);
            return 1;
        }
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean hc(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }
}
