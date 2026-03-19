package com.qq.e.comm.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class fp extends u40<ep> {
    @Override // com.qq.e.comm.plugin.u40
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout.LayoutParams a(rk rkVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) new tq(rkVar));
        layoutParams.gravity = rkVar.n();
        return layoutParams;
    }

    @Override // com.qq.e.comm.plugin.u40
    public ViewGroup.LayoutParams j() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.qq.e.comm.plugin.v40
    public rk a(View view) {
        return new t8();
    }

    public fp(w40 w40Var, ep epVar) {
        super(w40Var, epVar);
        k();
    }

    private void k() {
        ((ep) this.b).setOrientation(0);
    }

    void c(int i) {
        ((ep) this.b).setGravity(i);
    }
}
