package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bu implements Runnable {
    final /* synthetic */ RemoteRewardActivity a;

    bu(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.q != null) {
            this.a.q.bringToFront();
            this.a.q.startAnimation(this.a.a(this.a.q));
            this.a.q.setVisibility(0);
            this.a.p = true;
        }
    }
}
