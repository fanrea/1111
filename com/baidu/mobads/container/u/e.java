package com.baidu.mobads.container.u;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements View.OnAttachStateChangeListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.a.a.a(false);
    }
}
