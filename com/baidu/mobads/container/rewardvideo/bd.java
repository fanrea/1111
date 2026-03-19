package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bd implements Runnable {
    final /* synthetic */ NativeRewardActivity a;

    bd(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.aS != null) {
            this.a.aS.setText(((this.a.R - this.a.aP) / 1000) + "s");
        }
        this.a.aP += this.a.aQ;
        if (this.a.aP <= this.a.R) {
            this.a.aR.postDelayed(this.a.c, this.a.aQ);
        } else {
            this.a.i();
        }
    }
}
