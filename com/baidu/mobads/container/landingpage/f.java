package com.baidu.mobads.container.landingpage;

import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ App2Activity a;

    f(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.a.wvTool.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.runActivityStartAnimation(this.a.wvTool);
        return true;
    }
}
