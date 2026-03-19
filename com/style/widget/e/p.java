package com.style.widget.e;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements View.OnLayoutChangeListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ View c;
    final /* synthetic */ f d;

    p(f fVar, int i, int i2, View view) {
        this.d = fVar;
        this.a = i;
        this.b = i2;
        this.c = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int iAbs = (this.a * Math.abs(i4 - i2)) / this.b;
        if (this.c instanceof com.component.a.a.q) {
            ((com.component.a.a.q) this.c).setTextSize(iAbs);
        }
    }
}
