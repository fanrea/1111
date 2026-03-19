package com.android.gdt.qone.ao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class h {
    public static final ConcurrentHashMap e = new ConcurrentHashMap();
    public final String a;
    public final String b;
    public final String c;
    public final AtomicBoolean d = new AtomicBoolean(false);

    public h(String str) {
        this.a = str;
        String strE = com.android.gdt.qone.w.a.e();
        this.b = strE;
        this.c = str + strE;
    }

    public static synchronized h a(String str) {
        h hVar;
        ConcurrentHashMap concurrentHashMap = e;
        hVar = (h) concurrentHashMap.get(str);
        if (hVar == null) {
            hVar = new h(str);
            concurrentHashMap.put(str, hVar);
        }
        return hVar;
    }
}
