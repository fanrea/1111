package com.baidu.mobads.container.rewardvideo;

import com.component.a.g.c.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bf implements m.b.a {
    final /* synthetic */ NativeRewardActivity a;

    bf(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.g.c.m.b.a
    public void a(int i, int i2) {
        if (this.a.mSegReward) {
            this.a.rewardVerify();
        }
    }

    @Override // com.component.a.g.c.m.b.a
    public void b(int i, int i2) {
    }
}
