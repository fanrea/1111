package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ai implements Runnable {
    final /* synthetic */ com.component.a.a.f a;
    final /* synthetic */ NativeRewardActivity b;

    ai(NativeRewardActivity nativeRewardActivity, com.component.a.a.f fVar) {
        this.b = nativeRewardActivity;
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.mobads.container.util.cf.b(this.a);
    }
}
