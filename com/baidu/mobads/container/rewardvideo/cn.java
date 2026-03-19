package com.baidu.mobads.container.rewardvideo;

import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.by;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cn implements ab.b {
    final /* synthetic */ int a;
    final /* synthetic */ com.baidu.mobads.container.adrequest.j b;
    final /* synthetic */ RemoteRewardActivity c;

    cn(RemoteRewardActivity remoteRewardActivity, int i, com.baidu.mobads.container.adrequest.j jVar) {
        this.c = remoteRewardActivity;
        this.a = i;
        this.b = jVar;
    }

    @Override // com.baidu.mobads.container.util.ab.b
    public void a(boolean z) {
        if (z) {
            this.c.a(false, com.baidu.mobads.container.util.e.a.i(this.c.R).booleanValue(), this.a);
        }
        this.c.M = false;
        this.c.onResume();
        by.a.a(this.c.R).a(1046).a(this.c.P.z()).a(this.b).b(this.c.P.l()).a("msg", z ? "confirmed" : "cancel").a(com.baidu.mobads.container.components.command.j.F, z ? 0L : 1L).a("prod", "rvideo").a("dl_type", "ac_rvideo").a("confirmPolicy", this.c.al).f();
    }
}
