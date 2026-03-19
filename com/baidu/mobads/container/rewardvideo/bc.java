package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bc implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    bc(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.aM) {
                this.a.a(false, false, (com.baidu.mobads.container.o.b) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
