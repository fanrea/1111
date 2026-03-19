package com.baidu.mobads.container.landingpage;

import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ App2Activity a;

    j(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.a.mBottomView.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.runBottomViewEnterAnimation(this.a.mBackgroundView, this.a.mBottomView);
        return true;
    }
}
