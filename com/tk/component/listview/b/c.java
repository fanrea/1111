package com.tk.component.listview.b;

import android.graphics.Rect;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends a {
    public c(int i, int i2, boolean z) {
        super(i, i2, false);
    }

    @Override // com.tk.component.listview.b.a
    public final void a(Rect rect, View view, al alVar, int i) {
        if (com.tk.component.listview.b.h(alVar.getLayoutManager())) {
            if (!this.Ts) {
                if (i > 0) {
                    rect.top = this.Tv;
                    return;
                }
                return;
            } else {
                rect.left = this.Tw;
                rect.right = this.Tw;
                rect.bottom = this.Tv;
                if (i == 0) {
                    rect.top = this.Tv;
                    return;
                }
                return;
            }
        }
        if (!this.Ts) {
            if (i > 0) {
                rect.left = this.Tw;
            }
        } else {
            rect.top = this.Tv;
            rect.bottom = this.Tv;
            rect.right = this.Tw;
            if (i == 0) {
                rect.left = this.Tw;
            }
        }
    }

    @Override // com.tk.component.listview.b.a
    public final int e(al alVar, int i) {
        if (com.tk.component.listview.b.h(alVar.getLayoutManager())) {
            if (this.Ts) {
                if (i == 0) {
                    return this.Tv;
                }
                return 0;
            }
            if (i > 0) {
                return this.Tv;
            }
            return 0;
        }
        if (this.Ts) {
            if (i == 0) {
                return this.Tw;
            }
            return 0;
        }
        if (i > 0) {
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
