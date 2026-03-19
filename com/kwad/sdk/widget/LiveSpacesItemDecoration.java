package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.support.v7.widget.aj;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveSpacesItemDecoration extends aj.h {
    private int space;

    public LiveSpacesItemDecoration(int i) {
        this.space = i;
    }

    @Override // android.support.v7.widget.aj.h
    public void getItemOffsets(Rect rect, View view, aj ajVar, aj.u uVar) {
        int i = this.space;
        rect.left = i;
        rect.right = i;
        rect.bottom = i;
        if (ajVar.getChildPosition(view) == 0) {
            rect.top = this.space;
        }
    }
}
