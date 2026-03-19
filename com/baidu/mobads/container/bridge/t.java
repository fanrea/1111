package com.baidu.mobads.container.bridge;

import android.content.DialogInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class t implements DialogInterface.OnClickListener {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ i b;

    t(i iVar, com.baidu.mobads.container.adrequest.j jVar) {
        this.b = iVar;
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.setActionOnlyWifi(true);
        this.a.setSecondConfirmed(true);
        this.b.k.onAdClicked(this.a);
        this.b.a(this.a, 361);
        com.baidu.mobads.container.components.h.d.a(this.a.getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_CLICK);
    }
}
