package com.baidu.mobads.container.e;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class al implements View.OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ l b;

    al(l lVar, View view) {
        this.b = lVar;
        this.a = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.mClickTracker.a(0);
        this.b.mClickTracker.a(this.a);
        this.b.a(this.b.q);
        this.b.a(this.b.mAdInstanceInfo, new com.baidu.mobads.container.o.b());
    }
}
