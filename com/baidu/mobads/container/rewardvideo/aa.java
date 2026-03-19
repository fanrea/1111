package com.baidu.mobads.container.rewardvideo;

import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ NativeRewardActivity a;

    aa(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.a.fatherOfFullScreen.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.b(this.a.fatherOfFullScreen);
        return true;
    }
}
