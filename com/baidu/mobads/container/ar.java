package com.baidu.mobads.container;

import com.style.widget.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ar implements a.c {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ k b;

    ar(k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        this.b = kVar;
        this.a = jVar;
    }

    @Override // com.style.widget.a.c
    public void a() {
        this.b.dispatchDislikeEvent(this.a, "show", null);
    }

    @Override // com.style.widget.a.b
    public void a(String str) {
        this.b.sendDislikeClickLog(str, this.a);
        this.b.dispatchDislikeEvent(this.a, "click", str);
    }

    @Override // com.style.widget.a.c
    public void b() {
        this.b.dispatchDislikeEvent(this.a, "close", null);
    }
}
