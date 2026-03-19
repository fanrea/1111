package com.baidu.mobads.container.rewardvideo;

import com.baidu.mobads.container.util.by;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cs implements com.component.player.m {
    final /* synthetic */ RemoteRewardActivity a;

    cs(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // com.component.player.m
    public void a() {
        com.baidu.mobads.container.util.ce.a(this.a.G, (List<String>) null);
        by.a.a(this.a.R.getApplicationContext()).a(1008).a(this.a.ak).a("subtype", 808L).a("is_use_videocache", "false").a(this.a.G).f();
    }
}
