package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.n.a;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ac implements a.InterfaceC0129a {
    final /* synthetic */ t a;

    ac(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.mobads.container.n.a.InterfaceC0129a
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.a.e == null) {
                return;
            }
            if (aVar.d() != null) {
                this.a.a(aVar, com.baidu.mobads.container.n.a.a);
            } else {
                this.a.c(aVar, com.baidu.mobads.container.n.a.a);
            }
            this.a.h(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.n.a.InterfaceC0129a
    public void a(String str) {
        bq.a().c(str);
    }
}
