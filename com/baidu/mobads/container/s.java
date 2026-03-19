package com.baidu.mobads.container;

import com.baidu.mobads.container.util.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements bh.a {
    final /* synthetic */ int a;
    final /* synthetic */ k b;

    s(k kVar, int i) {
        this.b = kVar;
        this.a = i;
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a() {
        if (this.b.mAdContainerCxt != null) {
            int iD = com.baidu.mobads.container.util.r.d(this.b.mAdContainerCxt.v());
            this.b.sendSplashViewState(iD, false, this.a, 423, this.b.showRecord);
            if (this.b.mAdContainerCxt.q() != null) {
                if (iD != 0) {
                    this.b.sendSplashFailedLog(iD + "");
                }
                com.baidu.mobads.container.components.h.c.f.a(this.b.mAppContext).a(this.b.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_FAILED);
                com.baidu.mobads.container.components.h.d.a(this.b.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_IMPRESSION_FAILED);
            }
        }
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a(int i) {
        if (this.b.mAdContainerCxt != null) {
            int iD = com.baidu.mobads.container.util.r.d(this.b.mAdContainerCxt.v());
            StringBuilder sb = new StringBuilder();
            k kVar = this.b;
            kVar.showRecord = sb.append(kVar.showRecord).append(iD).toString();
            if (this.b.showRecord.endsWith("00")) {
                if (this.b.h != null) {
                    this.b.h.i();
                }
                this.b.sendImpressionLog(this.b.mAdContainerCxt.q());
                this.b.send3rdImpressionLog(this.b.mAdContainerCxt.v());
                this.b.sendSplashViewState(9, true, this.a, 423, this.b.showRecord);
                com.baidu.mobads.container.components.h.c.f.a(this.b.mAppContext).a(this.b.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS);
                if (this.b.u != null) {
                    this.b.u.b();
                    this.b.u = null;
                }
                this.b.isSendValidSplashImpressionLoged.set(true);
            }
        }
    }
}
