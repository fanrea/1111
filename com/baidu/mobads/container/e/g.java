package com.baidu.mobads.container.e;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements View.OnClickListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.x != null) {
            if (this.a.x.f()) {
                this.a.m();
            } else {
                this.a.n();
            }
        }
    }
}
