package com.baidu.mobads.container.nativecpu;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class az extends com.component.a.g.b {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ t c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    az(t tVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, a aVar, String str) {
        super(kVar, jVar);
        this.c = tVar;
        this.a = aVar;
        this.b = str;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        this.a.handleClick(view, z);
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar) {
        if (com.baidu.mobads.container.n.a.b.equals(this.b)) {
            if (this.c.h != null) {
                this.c.h.a();
            }
        } else {
            this.c.e.removeAllViews();
        }
        if (com.baidu.mobads.container.n.a.a.equals(this.b)) {
            this.c.b();
        }
    }
}
