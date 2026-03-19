package com.kwad.sdk.glide.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.kwad.sdk.glide.a.c;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class e implements c {
    final c.a bYE;
    boolean bYF;
    private boolean bYG;
    private final BroadcastReceiver buW = new BroadcastReceiver() { // from class: com.kwad.sdk.glide.a.e.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean z = e.this.bYF;
            e.this.bYF = e.cA(context);
            if (z != e.this.bYF) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.bYF);
                }
                e.this.bYE.cO(e.this.bYF);
            }
        }
    };
    private final Context dR;

    @Override // com.kwad.sdk.glide.a.i
    public final void onDestroy() {
    }

    e(Context context, c.a aVar) {
        this.dR = context.getApplicationContext();
        this.bYE = aVar;
    }

    private void register() {
        if (this.bYG) {
            return;
        }
        this.bYF = cA(this.dR);
        try {
            this.dR.registerReceiver(this.buW, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.bYG = true;
        } catch (Throwable th) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", th);
            }
        }
    }

    private void unregister() {
        if (this.bYG) {
            this.dR.unregisterReceiver(this.buW);
            this.bYG = false;
        }
    }

    static boolean cA(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ax.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onStart() {
        register();
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onStop() {
        unregister();
    }
}
