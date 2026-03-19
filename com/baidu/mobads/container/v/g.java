package com.baidu.mobads.container.v;

import com.baidu.mobads.container.util.bk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g extends com.baidu.mobads.container.d.a<Void> {
    final /* synthetic */ d a;

    g(d dVar) {
        this.a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.container.d.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void a() {
        if ("rsplash".equals(this.a.mAdContainerCxt.k())) {
            bk.a(this.a.mAppContext, this.a.mAdContainerCxt, bk.M, 6);
            this.a.checkAndSendRsplashShowLog(2, null);
        } else {
            this.a.sendImpressionLog(this.a.mAdContainerCxt.q());
            this.a.send3rdImpressionLog(this.a.mAdContainerCxt.v());
            this.a.processAdStart();
        }
        return null;
    }
}
