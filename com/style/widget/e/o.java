package com.style.widget.e;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements View.OnClickListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mobads.container.k baseAdContainer = this.a.c.f.getBaseAdContainer();
        if (baseAdContainer instanceof com.baidu.mobads.container.f.b) {
            ((com.baidu.mobads.container.f.b) baseAdContainer).b(this.a.b);
        }
    }
}
