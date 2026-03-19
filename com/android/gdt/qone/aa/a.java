package com.android.gdt.qone.aa;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Iterator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        if (this.a.d) {
            return;
        }
        this.a.d = true;
        com.android.gdt.qone.af.c.b("QM", "current network switched to the available state", new Object[0]);
        Iterator it = this.a.a.keySet().iterator();
        while (it.hasNext()) {
            ((c) it.next()).h();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.a.d = false;
        com.android.gdt.qone.af.c.b("QM", "current network lost", new Object[0]);
        Iterator it = this.a.a.keySet().iterator();
        while (it.hasNext()) {
            ((c) it.next()).i();
        }
    }
}
