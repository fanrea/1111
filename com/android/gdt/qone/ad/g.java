package com.android.gdt.qone.ad;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements com.android.gdt.qone.x.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ h c;

    public g(h hVar, String str, long j) {
        this.c = hVar;
        this.a = str;
        this.b = j;
    }

    @Override // com.android.gdt.qone.x.a
    public final void a() {
        this.c.a.edit().putLong(this.a, this.b).apply();
    }
}
