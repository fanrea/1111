package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.n.a;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bd implements a.InterfaceC0129a {
    final /* synthetic */ t a;

    bd(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.mobads.container.n.a.InterfaceC0129a
    public void a(a aVar) {
        if (aVar == null || this.a.e == null) {
            return;
        }
        try {
            if (aVar.d() != null) {
                this.a.a(aVar, com.baidu.mobads.container.n.a.d);
            } else {
                this.a.b(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.n.a.InterfaceC0129a
    public void a(String str) {
        bq.a().c(str);
    }
}
