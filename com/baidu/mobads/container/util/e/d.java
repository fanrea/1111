package com.baidu.mobads.container.util.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d extends BroadcastReceiver {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        boolean z2;
        this.a.h.a(c.a, "onReceive: " + intent.getAction());
        boolean z3 = false;
        if (intent.getExtras() == null) {
            z = false;
            z2 = false;
        } else {
            z2 = intent.getExtras().getBoolean("connected");
            z = intent.getExtras().getBoolean("adb");
        }
        c cVar = this.a;
        if (this.a.b(context) && z2 && z) {
            z3 = true;
        }
        cVar.f = z3;
    }
}
