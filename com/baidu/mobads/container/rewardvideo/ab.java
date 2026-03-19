package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    ab(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.mActivity != null) {
            this.a.mActivity.finish();
        }
    }
}
