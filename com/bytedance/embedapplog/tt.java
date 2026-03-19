package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;
import com.bytedance.common.utility.DeviceUtils;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    private static final CharSequence d = "sony";
    private static final CharSequence hc = "amigo";
    private static final CharSequence b = "funtouch";
    private static final d<Boolean> c = new d<Boolean>() { // from class: com.bytedance.embedapplog.tt.1
    };

    public static String d() {
        return hc(a.a);
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = d();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || hc() || b();
    }

    public static boolean hc() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei");
        }
        return true;
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean c() throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.c("Honor", e.getMessage());
        }
        return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, a.a));
    }

    public static boolean u() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean an() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean h() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    private static String hc(String str) {
        String strD = zv.d(str);
        return !TextUtils.isEmpty(strD) ? strD : fv.d(str);
    }

    public static boolean gb() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean tt() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean tc() {
        return DeviceUtils.ROM_SAMSUNG.equalsIgnoreCase(Build.BRAND) || DeviceUtils.ROM_SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String k() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean mk() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strHc = hc("ro.build.version.incremental");
        return !TextUtils.isEmpty(strHc) && strHc.contains("VIBEUI_V2");
    }

    public static boolean mq() {
        return k().toUpperCase().contains("NUBIA");
    }

    public static boolean uo() {
        return k().toUpperCase().contains("ASUS");
    }

    public static boolean d(Context context) {
        return k().toUpperCase().contains("HUAWEI");
    }

    static abstract class d<T> {
        d() {
        }
    }
}
