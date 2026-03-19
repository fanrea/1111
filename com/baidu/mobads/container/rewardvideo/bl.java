package com.baidu.mobads.container.rewardvideo;

import com.component.player.AdVideoViewListener;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bl implements AdVideoViewListener {
    final /* synthetic */ RemoteRewardActivity a;

    bl(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.a.O = false;
        com.baidu.mobads.container.util.ce.a(this.a.G(), this.a.F, this.a.G, this.a.P, 0, 5);
        this.a.sendRVideoLog(6);
        this.a.sendRVideoLog(10);
        if (this.a.B != null) {
            this.a.B.setVisibility(4);
        }
        this.a.A();
        if (this.a.s != null) {
            this.a.s.setVisibility(4);
        }
        if (this.a.q != null) {
            this.a.q.setVisibility(4);
        }
        if (this.a.v != null && this.a.n != null) {
            if (-1 != this.a.n.indexOfChild(this.a.v)) {
                this.a.n.removeView(this.a.v);
            }
            this.a.n.addView(this.a.v, this.a.u.getLayoutParams());
            this.a.u.setVisibility(4);
        }
        if (this.a.v != null) {
            this.a.v.setOnClickListener(new bm(this));
        }
        this.a.S();
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
