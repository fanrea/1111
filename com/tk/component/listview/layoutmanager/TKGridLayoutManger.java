package com.tk.component.listview.layoutmanager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.al;
import android.util.AttributeSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKGridLayoutManger extends GridLayoutManager implements a {
    private b yx;

    public TKGridLayoutManger(Context context, int i, int i2, boolean z) {
        super(context, i, i2, false);
        ae();
    }

    public TKGridLayoutManger(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ae();
    }

    private void ae() {
        this.yx = new b();
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void bC(int i) {
        this.yx.bC(i);
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void gO() {
        this.yx.gO();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.support.v7.widget.al$t, com.tk.component.listview.layoutmanager.b$a] */
    public final void a(al alVar, al.u uVar, int i) {
        a(this.yx.f(alVar, i));
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void N(int i, int i2) {
        super.N(i, i2);
    }

    @Override // com.tk.component.listview.layoutmanager.a
    public final void setDuration(int i) {
        this.yx.setDuration(i);
    }

    public final void c(al.p pVar, al.u uVar) {
        try {
            super.c(pVar, uVar);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKGridLayoutManger", "onLayoutChildren", e);
        }
    }

    public final int a(int i, al.p pVar, al.u uVar) {
        try {
            return super.a(i, pVar, uVar);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKGridLayoutManger", "scrollHorizontallyBy", e);
            return 0;
        }
    }

    public final int b(int i, al.p pVar, al.u uVar) {
        try {
            return super.b(i, pVar, uVar);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKGridLayoutManger", "scrollHorizontallyBy", e);
            return 0;
        }
    }
}
