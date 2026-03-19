package com.kwad.sdk.glide.a;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.glide.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f implements d {
    @Override // com.kwad.sdk.glide.a.d
    public final c a(Context context, c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.b) == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new e(context, aVar) : new j();
    }
}
