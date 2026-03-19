package com.android.gdt.qone.u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.gdt.qone.ao.j;
import com.sigmob.sdk.base.n;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d extends BroadcastReceiver {
    public final j a;
    public final Context b = com.android.gdt.qone.ar.d.h().a();
    public final String c;

    public d(j jVar, String str) {
        this.a = jVar;
        this.c = str;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter("com.qone.qm.spread");
        Context context = this.b;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 34) {
                context.registerReceiver(this, intentFilter, 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null || !"com.qone.qm.spread".equals(intent.getAction()) || intent.getExtras() == null) {
            return;
        }
        String string = intent.getExtras().getString("appKey");
        String string2 = intent.getExtras().getString(n.l);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return;
        }
        if (!this.c.equals(string + string2)) {
            Bundle extras = intent.getExtras();
            String str = intent.getPackage();
            goAsync();
            new c(this.a, str, extras).execute(new String[0]);
        }
    }
}
