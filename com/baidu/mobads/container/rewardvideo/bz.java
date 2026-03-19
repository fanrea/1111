package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bz implements com.style.widget.b.h {
    final /* synthetic */ by a;

    bz(by byVar) {
        this.a = byVar;
    }

    @Override // com.style.widget.b.h
    public void a() {
        this.a.a.M = true;
        this.a.a.onPause();
    }

    @Override // com.style.widget.b.h
    public void b() {
        this.a.a.M = false;
        this.a.a.onResume();
    }
}
