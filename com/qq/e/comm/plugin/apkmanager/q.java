package com.qq.e.comm.plugin.apkmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class q extends BroadcastReceiver {
    private final a a;

    /* compiled from: A */
    public interface a {
        void a();

        void b();
    }

    public q(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        if (this.a == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            this.a.b();
        } else if (type == 1 && activeNetworkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) {
            this.a.a();
        }
    }
}
