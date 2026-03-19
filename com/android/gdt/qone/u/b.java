package com.android.gdt.qone.u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import com.android.gdt.qone.ak.h;
import com.android.gdt.qone.ap.f;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b extends BroadcastReceiver {
    public final h a;
    public final Context b = com.android.gdt.qone.ar.d.h().a();

    public b(h hVar) {
        this.a = hVar;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter("com.qone.qm.mulprocess_share");
        Context context = this.b;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 34) {
                context.registerReceiver(this, intentFilter, 4);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            Process.myPid();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        h hVar;
        Context context2;
        try {
            action = intent.getAction();
        } catch (Exception e) {
            com.android.gdt.qone.af.c.a(e);
            action = null;
        }
        if (action == null || !action.equals("com.qone.qm.mulprocess_share") || (hVar = this.a) == null) {
            return;
        }
        com.android.gdt.qone.ak.c.a(hVar.g).a(f.b(hVar.g));
        com.android.gdt.qone.ak.b bVar = com.android.gdt.qone.ak.c.a(hVar.g).b;
        if (bVar == null || bVar.c()) {
            return;
        }
        Process.myPid();
        new com.android.gdt.qone.ar.a(hVar.g).d();
        b bVar2 = hVar.b;
        if (bVar2 == null || (context2 = bVar2.b) == null) {
            return;
        }
        try {
            context2.unregisterReceiver(bVar2);
            Process.myPid();
        } catch (IllegalArgumentException e2) {
            com.android.gdt.qone.af.c.a(e2);
        }
    }
}
