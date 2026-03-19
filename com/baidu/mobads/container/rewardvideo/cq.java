package com.baidu.mobads.container.rewardvideo;

import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cq implements AdVideoViewListener {
    final /* synthetic */ RemoteRewardActivity a;

    cq(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() {
        com.baidu.mobads.container.util.ce.a(this.a.G(), this.a.F, this.a.G, this.a.P, 0, 5);
        this.a.sendRVideoLog(6);
        this.a.R();
        this.a.H();
    }

    @Override // com.component.player.AdVideoViewListener
    public void playFailure(String str) {
        this.a.O = false;
        this.a.a("跳过");
        this.a.sendRVideoLog(11);
    }

    @Override // com.component.player.AdVideoViewListener
    public void renderingStart() {
        this.a.S.b("RemoteRewardActivity", "renderingStart");
        if (!this.a.J) {
            this.a.J = true;
            if (this.a.w()) {
                this.a.a("跳过");
            }
            this.a.r();
            this.a.t();
            this.a.z();
            if (!this.a.ar) {
                this.a.p();
            } else {
                this.a.o();
            }
            this.a.processAdStart();
            this.a.sendRVideoLog(5);
            this.a.E = this.a.u.h();
            dp.a(this.a.n, this.a.G, this.a.P);
            this.a.f739K.set(true);
            com.baidu.mobads.container.util.ce.a(this.a.G, this.a.P, 0, this.a.G());
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStart() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStop() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playPause() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playResume() {
    }
}
