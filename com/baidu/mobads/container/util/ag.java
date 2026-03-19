package com.baidu.mobads.container.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ag {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 100;
    public static final int h = 101;
    public static final int i = 999;

    public static int a(Context context) {
        NetworkInfo networkInfo;
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 != null && a(networkInfo2.getState())) {
            return 100;
        }
        if (x.a(applicationContext).a() >= 13 && (networkInfo = connectivityManager.getNetworkInfo(9)) != null && a(networkInfo.getState())) {
            return 101;
        }
        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
        if (networkInfo3 != null && a(networkInfo3.getState())) {
            switch (((TelephonyManager) applicationContext.getSystemService("phone")).getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    return 1;
                case 20:
                    return 5;
            }
        }
        return 999;
    }

    private static boolean a(NetworkInfo.State state) {
        return state != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING);
    }
}
