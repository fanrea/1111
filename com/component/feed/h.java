package com.component.feed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements View.OnClickListener {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ("ad_click".equals(this.a.L)) {
            this.a.a(view);
        }
        this.a.g(false);
        this.a.l();
    }
}
