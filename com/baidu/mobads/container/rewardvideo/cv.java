package com.baidu.mobads.container.rewardvideo;

import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cv implements AdVideoViewListener.b {
    final /* synthetic */ RemoteRewardActivity a;

    cv(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // com.component.player.AdVideoViewListener.b
    public void a() {
        com.baidu.mobads.container.util.ce.c(this.a.G, this.a.P, 1);
    }
}
