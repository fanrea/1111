package com.baidu.mobads.container.u;

import android.text.TextUtils;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s extends com.component.a.g.b {
    final /* synthetic */ p a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    s(p pVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        super(kVar, jVar);
        this.a = pVar;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        if (TextUtils.equals("ad_click", str)) {
            this.a.splashAdClick("click", dVar.a());
        }
    }
}
