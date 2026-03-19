package com.baidu.mobads.container.v.b;

import android.view.View;
import com.baidu.mobads.container.util.bh;
import com.baidu.mobads.container.util.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements bh.a {
    final /* synthetic */ View a;
    final /* synthetic */ a b;

    c(a aVar, View view) {
        this.b = aVar;
        this.a = view;
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a() {
        this.b.g.b();
        this.b.h.set(false);
        if (this.b.i) {
            this.b.a(this.b.mAdContainerCxt.q(), 362);
        }
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a(int i) {
        this.b.f = r.d(this.a);
        StringBuilder sb = new StringBuilder();
        a aVar = this.b;
        aVar.e = sb.append(aVar.e).append(this.b.f).toString();
        if (this.b.e.endsWith("00")) {
            this.b.g.b();
            this.b.h.set(false);
            this.b.sendImpressionLog(this.b.mAdContainerCxt.q());
            this.b.send3rdImpressionLog(this.a);
            if (this.b.i) {
                this.b.a(this.b.mAdContainerCxt.q(), 362);
            }
            this.b.i = false;
        }
    }
}
