package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aq implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    aq(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.bi.a(this);
        if (!this.a.mDialogManager.a() && !this.a.v) {
            this.a.I();
        } else {
            this.a.clearSlideGuideAnim();
        }
    }
}
