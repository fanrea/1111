package com.style.widget.b;

import android.content.DialogInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements DialogInterface.OnDismissListener {
    final /* synthetic */ i a;

    l(i iVar) {
        this.a = iVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.a.b();
    }
}
