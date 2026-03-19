package com.component.feed;

import com.baidu.mobads.container.util.ce;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements com.component.player.m {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.m
    public void a() {
        try {
            ce.a((com.baidu.mobads.container.adrequest.j) null, this.a.r.getThirdTrackers(a.p));
            this.a.b(a.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
