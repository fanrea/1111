package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ch extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Runnable a;
    final /* synthetic */ RemoteRewardActivity b;

    ch(RemoteRewardActivity remoteRewardActivity, Runnable runnable) {
        this.b = remoteRewardActivity;
        this.a = runnable;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        this.b.m.runOnUiThread(this.a);
        return null;
    }
}
