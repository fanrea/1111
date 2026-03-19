package com.baidu.mobads.container.rewardvideo;

import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class be implements AdVideoViewListener {
    final /* synthetic */ NativeRewardActivity a;

    be(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() {
        com.baidu.mobads.container.util.ce.a(this.a.v(), this.a.C, this.a.mAdInstanceInfo, this.a.mAdContainerCxt, 0, 5);
        this.a.w = true;
        this.a.a(this.a.t, this.a.u, -1);
        this.a.sendRVideoLog(6);
        this.a.addEndPage();
        this.a.videoPlayCompletion();
    }

    @Override // com.component.player.AdVideoViewListener
    public void playFailure(String str) {
        this.a.J = false;
        this.a.showSkipView();
        this.a.sendRVideoLog(11);
    }

    @Override // com.component.player.AdVideoViewListener
    public void renderingStart() {
        this.a.L.b("RemoteRewardActivity", "renderingStart");
        if (!this.a.F) {
            this.a.F = true;
            this.a.w = false;
            this.a.startTimer();
            this.a.sendRVideoLog(5);
            this.a.mDuration = this.a.x.h();
            this.a.onInitializeComponents(this.a.mDuration);
            dp.a(this.a.fatherOfFullScreen, this.a.mAdInstanceInfo, this.a.mAdContainerCxt);
            this.a.mSendImpressionLog.set(true);
            this.a.a(com.component.a.g.b.b.b);
            this.a.processAdStart();
            this.a.a(0, new Object[0]);
            this.a.N();
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
