package com.style.widget.e;

import android.view.View;
import com.baidu.mobads.container.util.cf;
import com.style.widget.e.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements View.OnAttachStateChangeListener {
    final /* synthetic */ f.b a;

    s(f.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        cf.a(this.a.a, (cf.a) new t(this), this.a.c);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.a.a.removeOnAttachStateChangeListener(this);
    }
}
