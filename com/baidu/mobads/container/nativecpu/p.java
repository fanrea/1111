package com.baidu.mobads.container.nativecpu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ com.baidu.mobads.container.adrequest.j b;
    final /* synthetic */ j c;

    p(j jVar, Context context, com.baidu.mobads.container.adrequest.j jVar2) {
        this.c = jVar;
        this.a = context;
        this.b = jVar2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if ((this.a instanceof Activity) && com.baidu.mobads.container.util.x.a(this.a).a() >= 17 && !((Activity) this.a).isDestroyed()) {
            dialogInterface.dismiss();
            this.c.a(this.a, this.b);
            this.c.i(this.b);
        }
    }
}
