package com.baidu.mobads.container.activity;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements View.OnClickListener {
    final /* synthetic */ FeedBackWindowActivity a;

    r(FeedBackWindowActivity feedBackWindowActivity) {
        this.a = feedBackWindowActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.mProxyctivity != null) {
            this.a.mProxyctivity.finish();
        }
    }
}
