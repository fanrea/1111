package com.style.widget;

import android.content.Intent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements View.OnClickListener {
    final /* synthetic */ j a;

    s(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.x()) {
            Intent intent = new Intent();
            intent.putExtra("privacy_link", this.a.x.getPrivacyUrl());
            com.baidu.mobads.container.util.h.a(this.a.w, intent);
        }
    }
}
