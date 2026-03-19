package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class af extends u40<qq> {
    @Override // com.qq.e.comm.plugin.u40
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams a(rk rkVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) new tq(rkVar));
        layoutParams.gravity = rkVar.n();
        return layoutParams;
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams j() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.qq.e.comm.plugin.v40
    public rk a(View view) {
        return new t8();
    }

    public af(w40 w40Var, qq qqVar) {
        super(w40Var, qqVar);
    }
}
