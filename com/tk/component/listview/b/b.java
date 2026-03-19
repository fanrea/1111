package com.tk.component.listview.b;

import android.graphics.Rect;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends a {
    private final int qo;

    public b(int i, int i2, int i3, boolean z) {
        super(i2, i3, false);
        this.qo = i;
    }

    @Override // com.tk.component.listview.b.a
    public final void a(Rect rect, View view, al alVar, int i) {
        int i2 = i % this.qo;
        if (com.tk.component.listview.b.h(alVar.getLayoutManager())) {
            if (this.Ts) {
                int i3 = this.Tw;
                rect.left = i3 - ((i2 * i3) / this.qo);
                int i4 = (i2 + 1) * this.Tw;
                int i5 = this.qo;
                rect.right = i4 / i5;
                if (i < i5) {
                    rect.top = this.Tv;
                }
                rect.bottom = this.Tv;
                return;
            }
            rect.left = (this.Tw * i2) / this.qo;
            int i6 = this.Tw;
            int i7 = (i2 + 1) * this.Tw;
            int i8 = this.qo;
            rect.right = i6 - (i7 / i8);
            if (i >= i8) {
                rect.top = this.Tv;
                return;
            }
            return;
        }
        if (this.Ts) {
            int i9 = this.Tv;
            rect.top = i9 - ((i2 * i9) / this.qo);
            int i10 = (i2 + 1) * this.Tv;
            int i11 = this.qo;
            rect.bottom = i10 / i11;
            if (i < i11) {
                rect.left = this.Tw;
            }
            rect.right = this.Tw;
            return;
        }
        rect.top = (this.Tv * i2) / this.qo;
        int i12 = this.Tv;
        int i13 = (i2 + 1) * this.Tv;
        int i14 = this.qo;
        rect.bottom = i12 - (i13 / i14);
        if (i >= i14) {
            rect.left = this.Tw;
        }
    }

    @Override // com.tk.component.listview.b.a
    public final int e(al alVar, int i) {
        if (com.tk.component.listview.b.h(alVar.getLayoutManager())) {
            if (this.Ts) {
                if (i < this.qo) {
                    return this.Tv;
                }
                return 0;
            }
            if (i >= this.qo) {
                return this.Tv;
            }
            return 0;
        }
        if (this.Ts) {
            if (i < this.qo) {
                return this.Tw;
            }
            return 0;
        }
        if (i >= this.qo) {
            return this.Tw;
        }
        return 0;
    }

    @Override // com.tk.component.listview.b.a
    public final int q(al alVar) {
        if (!this.Ts) {
            return 0;
        }
        if (com.tk.component.listview.b.h(alVar.getLayoutManager())) {
            return this.Tv;
        }
        return this.Tw;
    }
}
