package com.baidu.mobads.container.util;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cg implements View.OnAttachStateChangeListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ long b;

    cg(Runnable runnable, long j) {
        this.a = runnable;
        this.b = j;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (view != null) {
            view.removeOnAttachStateChangeListener(this);
            cf.b(view, this.a, this.b);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
