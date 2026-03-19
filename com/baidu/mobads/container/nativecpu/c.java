package com.baidu.mobads.container.nativecpu;

import android.view.View;
import com.baidu.mobads.container.util.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements View.OnAttachStateChangeListener {
    final /* synthetic */ bh a;
    final /* synthetic */ a b;

    c(a aVar, bh bhVar) {
        this.b = aVar;
        this.a = bhVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.a.b();
    }
}
