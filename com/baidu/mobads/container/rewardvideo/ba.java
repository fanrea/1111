package com.baidu.mobads.container.rewardvideo;

import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ba implements AdVideoViewListener.b {
    final /* synthetic */ NativeRewardActivity a;

    ba(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.player.AdVideoViewListener.b
    public void a() {
        com.baidu.mobads.container.util.ce.c(this.a.mAdInstanceInfo, this.a.mAdContainerCxt, 1);
    }
}
