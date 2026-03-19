package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cu implements Runnable {
    final /* synthetic */ RemoteRewardActivity a;

    cu(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.ao != null) {
            this.a.ao.cancel();
            this.a.ao = null;
        }
    }
}
