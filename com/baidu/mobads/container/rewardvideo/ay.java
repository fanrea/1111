package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ay implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    ay(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.aT != null) {
            this.a.aT.setVisibility(8);
            this.a.aT = null;
        }
    }
}
