package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class di implements Runnable {
    final /* synthetic */ cw a;

    di(cw cwVar) {
        this.a = cwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.k != null) {
            this.a.k.finish();
        }
    }
}
