package com.baidu.mobads.container;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements View.OnClickListener {
    final /* synthetic */ k a;

    p(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.o && !this.a.p) {
            this.a.splashAdClick("close", "skip_view");
        } else {
            this.a.skipBtnClick();
        }
    }
}
