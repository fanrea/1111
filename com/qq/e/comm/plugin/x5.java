package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x5 {
    private static final HashMap<String, nj> a = new HashMap<>();

    private static <T extends nj> String a(String str, Class<T> cls) {
        return str + Config.replace + cls.getCanonicalName();
    }

    public static <T extends nj> void c(String str, Class<T> cls) {
        a.remove(a(str, cls));
    }

    public static <T extends nj> T b(String str, Class<T> cls) {
        String strA = a(str, cls);
        HashMap<String, nj> map = a;
        T t = (T) map.get(strA);
        if (t == null) {
            synchronized (cls) {
                try {
                    nj njVar = (nj) Class.forName(cls.getName() + "Impl").newInstance();
                    try {
                        map.put(strA, njVar);
                    } catch (Throwable unused) {
                    }
                    t = (T) njVar;
                } catch (Throwable unused2) {
                }
            }
        }
        return t;
    }
}
