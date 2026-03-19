package com.tk.component.scroll.b.b;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tk.component.scroll.b.b.h;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class f extends h.e {
    private final LinearLayoutManager FE;
    private h.g Wj;

    @Override // com.tk.component.scroll.b.b.h.e
    public final void di(int i) {
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void dj(int i) {
    }

    f(LinearLayoutManager linearLayoutManager) {
        this.FE = linearLayoutManager;
    }

    final h.g oi() {
        return this.Wj;
    }

    final void setPageTransformer(h.g gVar) {
        this.Wj = gVar;
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void a(int i, float f, int i2) {
        if (this.Wj == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.FE.getChildCount(); i3++) {
            View childAt = this.FE.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.FE.getChildCount())));
            }
            this.Wj.c(childAt, (LinearLayoutManager.ae(childAt) - i) + f2);
        }
    }
}
