package com.style.widget.e;

import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m extends cf.a {
    final /* synthetic */ f a;

    m(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        if (this.a.x != null) {
            this.a.w = this.a.x.getBottom() + 10;
        }
    }
}
