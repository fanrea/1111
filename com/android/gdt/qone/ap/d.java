package com.android.gdt.qone.ap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements com.android.gdt.qone.x.a {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ String b;

    public d(String[] strArr, String str) {
        this.a = strArr;
        this.b = str;
    }

    @Override // com.android.gdt.qone.x.a
    public final void a() {
        this.a[0] = com.android.gdt.qone.an.a.a.a(this.b);
        com.android.gdt.qone.af.c.b("SDK_INIT ｜ LOCAL_ENC", "get the storage QM:%s (appKey: %s)", this.a, this.b);
    }
}
