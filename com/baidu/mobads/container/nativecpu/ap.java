package com.baidu.mobads.container.nativecpu;

import android.content.Intent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ t b;

    ap(t tVar, a aVar) {
        this.b = tVar;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("privacy_link", this.a.getPrivacyUrl());
        com.baidu.mobads.container.util.h.a(this.b.i, intent);
    }
}
