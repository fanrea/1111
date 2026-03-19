package com.baidu.mobads.container.s;

import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.removeView(this.a.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.a.c.a(this.a.c.m.F);
        layoutParams.gravity = 16;
        this.a.a.addView(this.a.c.c(), layoutParams);
    }
}
