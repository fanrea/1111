package com.baidu.mobads.container.e;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a.b != null) {
            this.a.a.b.a();
            com.baidu.mobads.container.util.h.a(new ae(this));
            this.a.a.u();
        }
    }
}
