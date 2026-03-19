package com.android.gdt.qone.ac;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.android.gdt.qone.af.c;
import com.android.gdt.qone.ar.d;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static boolean a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        boolean z = i >= 23 && (networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(2) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4));
        if (i >= 26) {
            z = z || networkCapabilities.hasTransport(5);
        }
        return i >= 27 ? z || networkCapabilities.hasTransport(6) : z;
    }

    public static boolean b() {
        ConnectivityManager connectivityManager;
        boolean zA;
        Context contextA = d.h().a();
        boolean z = false;
        if (contextA == null || (connectivityManager = (ConnectivityManager) contextA.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            zA = Build.VERSION.SDK_INT >= 23 ? a(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) : false;
            if (!zA) {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                } catch (SecurityException e) {
                    e = e;
                    e.printStackTrace();
                    c.a("NET", "No network status query permission, please add in AndroidManifest file  <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />", new Object[0]);
                    return zA;
                } catch (Exception e2) {
                    e = e2;
                    z = zA;
                    c.a(e);
                    return z;
                }
            }
        } catch (SecurityException e3) {
            e = e3;
            zA = false;
        } catch (Exception e4) {
            e = e4;
        }
        return zA;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.ac.a.a():java.lang.String");
    }
}
