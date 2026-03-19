package com.component.feed;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ay extends ViewOutlineProvider {
    final /* synthetic */ ax a;

    ay(ax axVar) {
        this.a = axVar;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(this.a.i, this.a.k[0]);
    }
}
