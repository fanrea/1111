package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ar implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    ar(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.bi.a(this);
        this.a.J();
    }
}
