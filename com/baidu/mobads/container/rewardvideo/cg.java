package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cg implements Runnable {
    final /* synthetic */ RemoteRewardActivity a;

    cg(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.m != null) {
            this.a.m.finish();
        }
    }
}
