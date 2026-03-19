package com.baidu.mobads.container.f;

import com.component.feed.ad;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c extends ad.a {
    final /* synthetic */ ad a;
    final /* synthetic */ boolean b;
    final /* synthetic */ com.baidu.mobads.container.adrequest.j c;
    final /* synthetic */ b d;

    c(b bVar, ad adVar, boolean z, com.baidu.mobads.container.adrequest.j jVar) {
        this.d = bVar;
        this.a = adVar;
        this.b = z;
        this.c = jVar;
    }

    @Override // com.component.feed.ad.a
    public void a() {
        if (this.a.b() && this.b) {
            this.d.a(this.a, this.c);
        }
    }
}
