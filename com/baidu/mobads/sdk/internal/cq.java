package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class cq {
    private static volatile cq a;

    private cq() {
    }

    public static cq a() {
        if (a == null) {
            synchronized (cq.class) {
                if (a == null) {
                    a = new cq();
                }
            }
        }
        return a;
    }

    public Boolean a(Context context) {
        try {
            boolean z = true;
            if (bn.a(context).a() < 29) {
                NetworkInfo networkInfoB = b(context);
                if (networkInfoB == null || !networkInfoB.isConnected() || networkInfoB.getType() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            NetworkCapabilities networkCapabilitiesC = c(context);
            if (networkCapabilitiesC == null || !networkCapabilitiesC.hasCapability(12) || !networkCapabilitiesC.hasCapability(16) || !networkCapabilitiesC.hasTransport(1)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return false;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.b) == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.b) != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (Throwable unused) {
            return null;
        }
    }
}
