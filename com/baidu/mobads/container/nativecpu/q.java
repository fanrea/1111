package com.baidu.mobads.container.nativecpu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class q implements DialogInterface.OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ j b;

    q(j jVar, Context context) {
        this.b = jVar;
        this.a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if ((this.a instanceof Activity) && com.baidu.mobads.container.util.x.a(this.a).a() >= 17 && !((Activity) this.a).isDestroyed()) {
            dialogInterface.dismiss();
        }
    }
}
