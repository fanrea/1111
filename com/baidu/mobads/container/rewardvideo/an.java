package com.baidu.mobads.container.rewardvideo;

import com.baidu.mobads.container.util.cf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class an extends cf.a {
    final /* synthetic */ String a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ NativeRewardActivity c;

    an(NativeRewardActivity nativeRewardActivity, String str, Runnable runnable) {
        this.c = nativeRewardActivity;
        this.a = str;
        this.b = runnable;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        com.baidu.mobads.container.components.c.g.a().a(this.a, new ao(this));
    }
}
