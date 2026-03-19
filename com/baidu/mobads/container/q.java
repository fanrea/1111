package com.baidu.mobads.container;

import com.baidu.mobads.container.components.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements a.InterfaceC0120a {
    final /* synthetic */ k a;

    q(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.mobads.container.components.a.InterfaceC0120a
    public void a(int i) {
    }

    @Override // com.baidu.mobads.container.components.a.InterfaceC0120a
    public void a() {
        if (this.a.c) {
            this.a.closeAd("time_end");
        }
        if (this.a.h != null) {
            this.a.h.m();
        }
    }
}
