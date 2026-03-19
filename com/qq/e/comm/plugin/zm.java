package com.qq.e.comm.plugin;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zm {
    private static final ConcurrentHashMap<String, kj> a = new ConcurrentHashMap<>();

    public static <T extends kj> T a(String str, Class<T> cls) {
        return (T) a(str, cls, true);
    }

    public static <T extends kj> void b(String str, Class<T> cls) {
        a.remove(a(cls, str));
    }

    private static <T extends kj> T a(String str, Class<T> cls, boolean z) {
        String strA = a(cls, str);
        ConcurrentHashMap<String, kj> concurrentHashMap = a;
        T t = (T) concurrentHashMap.get(strA);
        if (t != null || !z) {
            return t;
        }
        try {
            T t2 = (T) Class.forName(cls.getName()).newInstance();
            try {
                concurrentHashMap.putIfAbsent(strA, t2);
                return (T) concurrentHashMap.get(strA);
            } catch (Throwable unused) {
                return t2;
            }
        } catch (Throwable unused2) {
            return t;
        }
    }

    public static <T extends kj> void a(Class<T> cls) {
        int i;
        if (k1.class.equals(cls)) {
            i = 1;
        } else if (ud.class.equals(cls)) {
            i = 2;
        } else {
            i = yi.class.equals(cls) ? 3 : 0;
        }
        b10.a(1130037, null, Integer.valueOf(i), Integer.valueOf(c1.b() ? 1 : 0), null);
    }

    private static <T extends kj> String a(Class<T> cls, String str) {
        String str2;
        if (k1.class.equals(cls)) {
            str2 = "ai";
        } else if (ud.class.equals(cls)) {
            str2 = "fs";
        } else {
            str2 = yi.class.equals(cls) ? "hy" : "";
        }
        return str2 + str;
    }
}
