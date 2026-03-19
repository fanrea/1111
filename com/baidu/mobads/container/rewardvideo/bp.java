package com.baidu.mobads.container.rewardvideo;

import com.style.widget.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bp implements v.c {
    final /* synthetic */ RemoteRewardActivity a;

    bp(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // com.style.widget.v.c
    public void a(boolean z) {
        if (z) {
            this.a.M = true;
            this.a.onPause();
        }
    }

    @Override // com.style.widget.v.c
    public void b(boolean z) {
        if (z) {
            this.a.M = false;
            this.a.onResume();
        }
    }
}
