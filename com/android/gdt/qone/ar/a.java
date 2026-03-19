package com.android.gdt.qone.ar;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements b {
    public final String a;
    public b b;

    public a(String str) {
        this.a = str;
    }

    @Override // com.android.gdt.qone.ar.b
    public final String b() {
        return h() == null ? "" : h().b();
    }

    @Override // com.android.gdt.qone.ar.b
    public final String c() {
        return h() == null ? "" : h().c();
    }

    @Override // com.android.gdt.qone.ar.b
    public final void d() {
        if (h() == null) {
            return;
        }
        h().d();
    }

    @Override // com.android.gdt.qone.ar.b
    public final String e() {
        return h() == null ? "" : h().e();
    }

    @Override // com.android.gdt.qone.ar.b
    public final String f() {
        return h() == null ? "" : h().f();
    }

    @Override // com.android.gdt.qone.ar.b
    public final String g() {
        return h() == null ? "" : h().g();
    }

    public final b h() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar;
        }
        ConcurrentHashMap concurrentHashMap = com.android.gdt.qone.aq.b.a;
        com.android.gdt.qone.aq.b bVar2 = com.android.gdt.qone.aq.a.a;
        String str = "BizInfo" + this.a;
        bVar2.getClass();
        com.android.gdt.qone.as.a aVar = (com.android.gdt.qone.as.a) com.android.gdt.qone.aq.b.a.get(str);
        if (!(aVar instanceof b)) {
            return null;
        }
        b bVar3 = (b) aVar;
        this.b = bVar3;
        return bVar3;
    }
}
