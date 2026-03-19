package com.baidu.mobads.container.e;

import android.view.View;
import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p extends com.component.a.g.b {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p(l lVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.adrequest.j jVar2) {
        super(kVar, jVar);
        this.b = lVar;
        this.a = jVar2;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        this.b.mClickTracker.a(dVar.a().a());
        this.b.mClickTracker.a(view);
        this.b.a(z);
        this.b.a(this.b.mAdInstanceInfo, dVar);
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar) {
        try {
            if (this.b.V) {
                com.style.widget.a.a(this.v, this.b.W).a(new q(this));
            } else {
                Toast.makeText(this.v, "您已成功提交反馈，请勿重复提交哦！", 0).show();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar, String str) {
        if ("close".equals(str)) {
            this.b.a(dVar);
        } else if ("retain_dismiss".equals(str)) {
            this.b.J();
        }
    }
}
