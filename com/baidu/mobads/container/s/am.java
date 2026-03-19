package com.baidu.mobads.container.s;

import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class am extends cf.a {
    final /* synthetic */ al a;

    am(al alVar) {
        this.a = alVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        if (this.a.s != null) {
            this.a.s.start();
        }
    }
}
