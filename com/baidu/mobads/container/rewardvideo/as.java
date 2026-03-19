package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class as implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    as(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.a.mDialogManager.a() && this.a.isCurrentPageResumed) {
            this.a.I();
        }
    }
}
