package com.baidu.mobads.container.nativecpu;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class at implements View.OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ t b;

    at(t tVar, a aVar) {
        this.b = tVar;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.handleClick(view, false);
    }
}
