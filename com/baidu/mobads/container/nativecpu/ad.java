package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.n.a;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ad implements a.InterfaceC0129a {
    final /* synthetic */ t a;

    ad(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.mobads.container.n.a.InterfaceC0129a
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.a.b == null) {
                return;
            }
            if ("news".equals(aVar.getType())) {
                this.a.e(aVar);
            } else if (aVar.d() != null) {
                this.a.b(aVar, com.baidu.mobads.container.n.a.b);
            } else {
                int styleType = aVar.getStyleType();
                aVar.b(true);
                if (styleType == 37) {
                    this.a.f(aVar);
                } else if (styleType == 41) {
                    this.a.g(aVar);
                } else if (styleType == 33) {
                    this.a.c(aVar);
                } else {
                    this.a.d(aVar);
                }
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
