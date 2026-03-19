package com.baidu.mobads.container.u;

import android.transition.ChangeBounds;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ ImageView a;
    final /* synthetic */ b b;

    j(b bVar, ImageView imageView) {
        this.b = bVar;
        this.a = imageView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.b.q.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b.j == 2) {
            this.b.a(new a(), this.b.q, this.a, this.b.g.a(), 1000);
            return true;
        }
        this.b.a(new ChangeBounds(), this.b.q, this.b.q, this.a, 240);
        return true;
    }
}
