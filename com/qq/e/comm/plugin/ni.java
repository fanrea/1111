package com.qq.e.comm.plugin;

import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ni {
    private static String a;
    private static Boolean b;

    public static int b() {
        if (c()) {
            return Settings.Secure.getInt(r1.d().a().getContentResolver(), "pure_mode_state", -1);
        }
        return -1;
    }

    public static boolean c() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            method.setAccessible(true);
            b = Boolean.valueOf("harmony".equals(method.invoke(cls, new Object[0])));
        } catch (Exception unused) {
            b = Boolean.FALSE;
        }
        return b.booleanValue();
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            th.getMessage();
            return str2;
        }
    }

    public static String a() {
        String str = a;
        if (str != null) {
            return str;
        }
        if (!c()) {
            a = "";
            return "";
        }
        String strA = a(com.alipay.sdk.m.c.a.b, com.kuaishou.weapon.p0.bq.e);
        a = strA;
        return strA;
    }
}
