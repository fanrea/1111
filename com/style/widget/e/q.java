package com.style.widget.e;

import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q extends cf.a {
    final /* synthetic */ f a;

    q(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        if (com.baidu.mobads.container.util.r.d(this.a.J) != 0 || this.a.J.getWindowVisibility() != 0) {
            if (this.a.f798K) {
                this.a.f798K = false;
                this.a.h();
                return;
            }
            return;
        }
        if (!this.a.f798K) {
            this.a.f798K = true;
            this.a.b();
            this.a.g();
        }
    }
}
