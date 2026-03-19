package com.android.gdt.qone.at;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a {
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public final com.android.gdt.qone.av.a a;

    public a(String str) {
        this.a = new com.android.gdt.qone.av.a(str);
    }

    public final synchronized void a() {
    }

    public final synchronized void b() {
    }

    public static synchronized a a(String str) {
        a aVar;
        ConcurrentHashMap concurrentHashMap = b;
        aVar = (a) concurrentHashMap.get(str);
        if (aVar == null) {
            aVar = new a(str);
            concurrentHashMap.put(str, aVar);
        }
        return aVar;
    }
}
