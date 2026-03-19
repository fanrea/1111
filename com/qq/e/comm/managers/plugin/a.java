package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static Method a = null;
    private static boolean b = false;

    private static void a(Throwable th) throws Throwable {
        if (b) {
            return;
        }
        if (a == null) {
            Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
            a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        a.invoke(null, th);
    }

    public static void a(Throwable th, String str) {
        try {
            a(new Exception("插件错误：" + str, th));
        } catch (Throwable unused) {
            b = true;
        }
    }
}
