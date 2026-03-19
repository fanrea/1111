package com.baidu.mobads.container.s;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r extends com.component.a.g.b {
    final /* synthetic */ p a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r(p pVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        super(kVar, jVar);
        this.a = pVar;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        if (this.a.k != null) {
            this.a.k.a(view, dVar);
        } else {
            super.a(view, z, str, dVar);
        }
    }
}
