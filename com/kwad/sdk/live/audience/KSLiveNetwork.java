package com.kwad.sdk.live.audience;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveNetwork {
    public static final String DIANXIN_OPERATOR_NAME = "CTCC";
    public static final String LIANTONG_OPERATOR_NAME = "CUCC";
    private static final String NONE_NETWORK_NAME = "unknown";
    public static final String YIDONG_OPERATOR_NAME = "CMCC";

    private KSLiveNetwork() {
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isMobileNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context, 0);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context, 1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static String getActiveNetworkTypeName(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type != 1 ? "unknown" : activeNetworkInfo.getTypeName();
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        return TextUtils.isEmpty(subtypeName) ? activeNetworkInfo.getTypeName() : subtypeName;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static NetworkInfo getNetworkInfo(Context context, int i) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return null;
        }
        try {
            return connectivityManager.getNetworkInfo(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getIsp(Context context) {
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return "";
            }
            switch (simOperator) {
            }
            return "";
        }
    }

    private static ConnectivityManager getConnectivityManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            return (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            return null;
        }
    }
}
