package com.android.gdt.qone.ak;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c {
    public static final ConcurrentHashMap g = new ConcurrentHashMap();
    public final String a;
    public volatile b b;
    public boolean f = false;
    public String c = "";
    public int d = 0;
    public final boolean e = false;

    public c(String str) {
        this.a = str;
        this.b = new b("", "", str);
    }

    public static synchronized c a(String str) {
        c cVar;
        ConcurrentHashMap concurrentHashMap = g;
        cVar = (c) concurrentHashMap.get(str);
        if (cVar == null) {
            cVar = new c(str);
            cVar.a();
            concurrentHashMap.put(str, cVar);
        }
        return cVar;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            a(com.android.gdt.qone.ap.f.b(this.a));
            com.android.gdt.qone.am.a aVarA = com.android.gdt.qone.am.a.a(this.a);
            if (aVarA.a()) {
                b bVar = this.b;
                aVarA.e = new b(bVar.a(), bVar.b(), aVarA.a);
                this.b = new b("", "", this.a);
                String str = this.a;
                com.android.gdt.qone.w.a.a(str, "lccNoCN", new com.android.gdt.qone.ap.c(str));
                com.android.gdt.qone.ad.h hVarA = com.android.gdt.qone.ad.h.a(this.a);
                if (hVarA.a() != null) {
                    com.android.gdt.qone.w.a.a(hVarA.b, hVarA.d, new com.android.gdt.qone.ad.f(hVarA));
                }
            } else {
                b bVar2 = this.b;
                b bVar3 = new b("", "", "");
                if (bVar2 == null || bVar2.c()) {
                    bVar2 = bVar3;
                }
                a(bVar2);
                com.android.gdt.qone.af.c.b("QM", "(appKey: %s) Qm load successfully from cache, detail: %s", this.a, this.b.toString());
            }
        }
        this.f = true;
    }

    public final synchronized void a(b bVar) {
        if (bVar != null) {
            if (!bVar.c()) {
                this.b = bVar;
            }
        }
    }
}
