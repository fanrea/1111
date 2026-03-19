package com.baidu.mobads.container.activity;

import com.style.widget.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements a.b {
    final /* synthetic */ FeedBackWindowActivity a;

    p(FeedBackWindowActivity feedBackWindowActivity) {
        this.a = feedBackWindowActivity;
    }

    @Override // com.style.widget.a.b
    public void a(String str) {
        this.a.sendBroadcastWithReason(str);
        if (this.a.mProxyctivity != null) {
            this.a.mProxyctivity.finish();
        }
    }
}
