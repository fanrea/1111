package com.baidu.enan.e.d;

import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static volatile Method a;

    public static String a(String str, String str2) {
        try {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    }
                }
            }
            return (String) a.invoke(null, str, str2);
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return str2;
        }
    }
}
