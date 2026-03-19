package com.apm.insight.n;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class q {
    private static final HashMap<String, Long> a = new HashMap<>();

    public static boolean a(Object obj) {
        if (obj == null) {
            obj = com.apm.insight.f.a();
        }
        return a(obj, "ensure_all", com.apm.insight.runtime.a.b(obj));
    }

    public static boolean a(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return a(obj, com.apm.insight.o.e.a(str), com.apm.insight.runtime.a.c(obj));
    }

    public static synchronized boolean a(Object obj, String str, long j) {
        if (str == null) {
            return false;
        }
        Long l = a.get(str);
        if (l == null) {
            l = 0L;
        }
        return l.longValue() >= j;
    }
}
