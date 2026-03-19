package com.baidu.mobads.container.u;

import android.view.View;
import com.baidu.mobads.container.o.j;
import com.bytedance.sdk.djx.core.log.T2WLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c extends com.component.a.g.b {
    final /* synthetic */ b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(b bVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        super(kVar, jVar);
        this.a = bVar;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        if (this.w != null && this.a.j == 1) {
            com.baidu.mobads.container.o.b bVarA = dVar.a();
            bVarA.a(j.a.SPLASH_FOCUS_CARD.c());
            bVarA.b(j.a.SPLASH_FOCUS_CARD.c());
            this.w.splashAdClick(T2WLog.SCENE_CARD, bVarA);
            this.a.a("click");
        }
    }
}
