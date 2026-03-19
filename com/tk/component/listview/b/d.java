package com.tk.component.listview.b;

import android.graphics.Rect;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends a {
    private final int qo;

    public d(int i, int i2, int i3, boolean z) {
        super(i2, i3, false);
        this.qo = i;
    }

    @Override // com.tk.component.listview.b.a
    public final void a(Rect rect, View view, al alVar, int i) {
        int iDi = ((StaggeredGridLayoutManager.b) view.getLayoutParams()).di();
        if (com.tk.component.listview.b.h(alVar.getLayoutManager())) {
            if (this.Ts) {
                int i2 = this.Tw;
                rect.left = i2 - ((iDi * i2) / this.qo);
                int i3 = (iDi + 1) * this.Tw;
                int i4 = this.qo;
                rect.right = i3 / i4;
                if (i < i4) {
                    rect.top = this.Tv;
                }
                rect.bottom = this.Tv;
                return;
            }
            rect.left = (this.Tw * iDi) / this.qo;
            int i5 = this.Tw;
            int i6 = (iDi + 1) * this.Tw;
            int i7 = this.qo;
            rect.right = i5 - (i6 / i7);
            if (i >= i7) {
                rect.top = this.Tv;
                return;
            }
            return;
        }
        if (this.Ts) {
            int i8 = this.Tv;
            rect.top = i8 - ((iDi * i8) / this.qo);
            int i9 = (iDi + 1) * this.Tv;
            int i10 = this.qo;
            rect.bottom = i9 / i10;
            if (i < i10) {
                rect.left = this.Tw;
            }
            rect.right = this.Tw;
            return;
        }
        rect.top = (this.Tv * iDi) / this.qo;
        int i11 = this.Tv;
        int i12 = (iDi + 1) * this.Tv;
        int i13 = this.qo;
        rect.bottom = i11 - (i12 / i13);
        if (i >= i13) {
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
