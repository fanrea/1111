package com.baidu.mobads.container.components.k;

import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.util.cm;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements a {
    final /* synthetic */ k a;
    final /* synthetic */ j b;
    final /* synthetic */ c c;

    d(c cVar, k kVar, j jVar) {
        this.c = cVar;
        this.a = kVar;
        this.b = jVar;
    }

    @Override // com.baidu.mobads.container.components.k.a
    public void a() {
        this.c.a(this.a, this.b, true);
        this.c.C.dispatchEvent(new cm("AdUserClick", this.b.getUniqueId()));
    }

    @Override // com.baidu.mobads.container.components.k.a
    public void a(boolean z) {
    }
}
