package com.tk.component.listview.b;

import android.graphics.Rect;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class a extends al.h {
    protected final boolean Ts;
    protected int Tt;
    protected int Tu;
    protected final int Tv;
    protected final int Tw;

    protected void a(Rect rect, View view, al alVar, int i) {
    }

    public abstract int e(al alVar, int i);

    public abstract int q(al alVar);

    public a(int i, int i2, boolean z) {
        this.Tw = i;
        this.Tv = i2;
        this.Ts = z;
    }

    @Override // android.support.v7.widget.al.h
    public final void a(Rect rect, View view, al alVar, al.u uVar) {
        int iY = al.Y(view);
        int i = this.Tt;
        if (i > 0) {
            if (iY < i) {
                return;
            }
        }
        if (this.Tu > 0) {
            al.a adapter = alVar.getAdapter();
            if (adapter == null) {
                return;
            }
            if (iY >= adapter.getItemCount() - this.Tu) {
                return;
            }
        }
        int i2 = this.Tt;
        if (i2 > 0) {
            a(rect, view, alVar, Math.max(0, iY - i2));
        } else {
            a(rect, view, alVar, iY);
        }
    }

    public final void db(int i) {
        this.Tt = i;
    }

    public final void dc(int i) {
        this.Tu = i;
    }
}
