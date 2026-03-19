package com.android.gdt.qone.aa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b extends BroadcastReceiver implements Runnable {
    public static b f;
    public a b;
    public ConnectivityManager e;
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public volatile boolean c = false;
    public volatile boolean d = false;

    public static b a() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b();
                }
            }
        }
        return f;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.c) {
            return;
        }
        com.android.gdt.qone.v.a.a().a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c = true;
        if (com.android.gdt.qone.ac.a.b()) {
            Iterator it = this.a.keySet().iterator();
            while (it.hasNext()) {
                ((c) it.next()).h();
            }
        } else {
            Iterator it2 = this.a.keySet().iterator();
            while (it2.hasNext()) {
                ((c) it2.next()).i();
            }
        }
        this.c = false;
    }

    public final synchronized void a(Context context) {
        if (this.a.isEmpty()) {
            this.d = com.android.gdt.qone.ac.a.b();
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                this.b = new a(this);
                this.e = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0);
                builder.addTransportType(1);
                builder.addTransportType(3);
                builder.addTransportType(4);
                if (i >= 26) {
                    builder.addTransportType(5);
                }
                if (i >= 27) {
                    builder.addTransportType(6);
                }
                ConnectivityManager connectivityManager = this.e;
                if (connectivityManager != null) {
                    try {
                        connectivityManager.registerNetworkCallback(builder.build(), this.b);
                    } catch (SecurityException e) {
                        com.android.gdt.qone.af.c.a(e);
                    }
                }
            } else if (context != null) {
                try {
                    context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e2) {
                    com.android.gdt.qone.af.c.a(e2);
                }
            }
        }
    }
}
