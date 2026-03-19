package com.baidu.mobads.container.s;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ ab b;

    ac(ab abVar, int i) {
        this.b = abVar;
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.m != null) {
            this.b.m.a(this.a);
        }
    }
}
