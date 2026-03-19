package com.baidu.enan.e.c.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.enan.f.b;
import com.kuaishou.weapon.p0.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return String.valueOf(b(context));
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static int b(Context context) {
        try {
            if (b.a(context, new String[]{g.b})) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (Build.VERSION.SDK_INT > 20) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (connectivityManager.getNetworkCapabilities(network).hasTransport(4)) {
                            return 17;
                        }
                    }
                } else {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
                    if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                        return 17;
                    }
                }
                if (!TextUtils.isEmpty(a())) {
                    return 16;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return -1;
    }

    private static String a() {
        try {
            String property = System.getProperties().getProperty(b.a("aHR0cC5wcm94eUhvc3Q="));
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }
}
