package com.pangrowth.adclog;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class t {
    public static ConcurrentHashMap<a, k> a;

    public enum a {
        MSG,
        JSON,
        BUNDLE,
        INTENT,
        THROWABLE,
        BORDER,
        STACKTRACE,
        THREAD,
        /* JADX INFO: Fake field, exist only in values array */
        STACKTRACE_STR
    }

    static {
        ConcurrentHashMap<a, k> concurrentHashMap = new ConcurrentHashMap<>();
        a = concurrentHashMap;
        concurrentHashMap.put(a.MSG, new m("MM-dd HH:mm:ss"));
        a.put(a.JSON, new n());
        a.put(a.BUNDLE, new o());
        a.put(a.INTENT, new p());
        a.put(a.BORDER, new l());
        a.put(a.STACKTRACE, new C0964r());
        a.put(a.THREAD, new s());
        a.put(a.THROWABLE, new q());
    }

    public static String a(a aVar, String str) {
        k kVar = a.get(aVar);
        return kVar != null ? aVar == a.BORDER ? kVar.a(new String[]{str}) : kVar.a(str) : str;
    }
}
