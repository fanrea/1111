package com.component.feed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements View.OnClickListener {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.x.f()) {
            this.a.g(true);
            this.a.m();
        } else {
            this.a.g(false);
            this.a.n();
        }
    }
}
