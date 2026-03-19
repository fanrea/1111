package com.baidu.mobads.container.rewardvideo;

import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class dh implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ cw a;

    dh(cw cwVar) {
        this.a = cwVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.a.l.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.a(this.a.l);
        return true;
    }
}
