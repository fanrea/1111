package com.android.gdt.qone.am;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a {
    public static final ConcurrentHashMap h = new ConcurrentHashMap();
    public final String a;
    public boolean b = false;
    public boolean c = false;
    public int d = 0;
    public com.android.gdt.qone.ak.b e;
    public boolean f;
    public boolean g;

    public a(String str) {
        this.a = str;
    }

    public static synchronized a a(String str) {
        a aVar;
        ConcurrentHashMap concurrentHashMap = h;
        aVar = (a) concurrentHashMap.get(str);
        if (aVar == null) {
            aVar = new a(str);
            concurrentHashMap.put(str, aVar);
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[Catch: all -> 0x00fe, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0009, B:14:0x0035, B:16:0x003b, B:51:0x00ee, B:53:0x00f4, B:17:0x003f, B:20:0x0049, B:22:0x0084, B:24:0x008a, B:43:0x00c8, B:45:0x00ce, B:46:0x00d1, B:49:0x00e0, B:50:0x00ec, B:30:0x00a0, B:31:0x00a7, B:6:0x000c, B:8:0x0020, B:13:0x0033), top: B:66:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean a() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.am.a.a():boolean");
    }
}
