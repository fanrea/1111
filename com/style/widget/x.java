package com.style.widget;

import android.content.Intent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x implements View.OnClickListener {
    final /* synthetic */ v a;

    x(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("privacy_link", this.a.l);
        if (this.a.p != null) {
            this.a.p.a(false);
        }
        com.baidu.mobads.container.util.h.a(this.a.o, intent);
        this.a.a(this.a.o);
    }
}
