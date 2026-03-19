package com.baidu.mobads.container.rewardvideo;

import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cf implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ RemoteRewardActivity a;

    cf(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.a.n.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.a(this.a.n);
        return true;
    }
}
