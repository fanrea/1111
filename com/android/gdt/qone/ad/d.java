package com.android.gdt.qone.ad;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements com.android.gdt.qone.x.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ h c;

    public d(h hVar, String str, String str2) {
        this.c = hVar;
        this.a = str;
        this.b = str2;
    }

    @Override // com.android.gdt.qone.x.a
    public final void a() {
        this.c.a.edit().putString(this.a, this.b).apply();
    }
}
