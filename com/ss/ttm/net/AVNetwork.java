package com.ss.ttm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.ttm.utils.AVLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class AVNetwork {
    public static final int IS_MOBILE_NETWORK = 2;
    public static final int IS_UNKOWN_NETWORK = 0;
    public static final int IS_WIFF_NETWORK = 1;

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Throwable unused) {
        }
        if (activeNetworkInfo == null) {
            AVLogger.d("AVNetwork", "NetworkInfo is null");
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            AVLogger.d("AVNetwork", "NetworkInfo is wifi");
            return 1;
        }
        if (type == 0) {
            AVLogger.d("AVNetwork", "NetworkInfo is mobile");
            return 2;
        }
        return 0;
    }
}
