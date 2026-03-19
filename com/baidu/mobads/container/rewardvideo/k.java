package com.baidu.mobads.container.rewardvideo;

import com.baidu.mobads.container.util.by;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements com.component.player.m {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    @Override // com.component.player.m
    public void a() {
        com.baidu.mobads.container.util.ce.a(this.a.a.mAdInstanceInfo, (List<String>) null);
        by.a.a(this.a.a.mAppContext.getApplicationContext()).a(1008).a(this.a.a.X).a("subtype", 808L).a("is_use_videocache", "false").a(this.a.a.mAdInstanceInfo).f();
    }
}
