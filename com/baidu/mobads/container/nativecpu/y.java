package com.baidu.mobads.container.nativecpu;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements View.OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ t b;

    y(t tVar, a aVar) {
        this.b = tVar;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.unionLogoClick(this.b.a);
    }
}
