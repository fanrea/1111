package com.kwad.tachikoma.live.message;

import android.graphics.Rect;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends al.h {
    private int Dw;

    public e(int i) {
        this.Dw = i;
    }

    @Override // android.support.v7.widget.al.h
    public final void a(Rect rect, View view, al alVar, al.u uVar) {
        int i = this.Dw;
        rect.left = i;
        rect.right = i;
        rect.bottom = i;
        if (alVar.W(view) == 0) {
            rect.top = this.Dw;
        }
    }
}
