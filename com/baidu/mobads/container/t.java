package com.baidu.mobads.container;

import android.view.View;
import com.baidu.mobads.container.o.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class t implements View.OnClickListener {
    final /* synthetic */ k a;

    t(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.splashAdClick("click", j.a.SPLASH_ACTION_VIEW.c());
    }
}
