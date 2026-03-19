package com.kwai.video.ksvodplayerkit.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.container.util.e.a;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NetworkUtils {
    private static final String NETWORK_TYPE_2G = "2g";
    private static final String NETWORK_TYPE_3G = "3g";
    private static final String NETWORK_TYPE_4G = "4g";
    private static final String NETWORK_TYPE_UNKNOWN = "Notfound";

    public static boolean isIp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strTrim = str.trim();
        if (!strTrim.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            return false;
        }
        String[] strArrSplit = strTrim.split("\\.");
        return Integer.parseInt(strArrSplit[0]) < 255 && Integer.parseInt(strArrSplit[1]) < 255 && Integer.parseInt(strArrSplit[2]) < 255 && Integer.parseInt(strArrSplit[3]) < 255;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnected()) ? false : true;
    }

    public static String getCurrentWifiName(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        if (wifiInfo != null) {
            return wifiInfo.getSSID();
        }
        return null;
    }

    private static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(a.a);
        if (wifiManager == null) {
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isMobileNetworkConnected(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || !networkInfo.isConnected()) ? false : true;
    }

    public static String getHost(String str) {
        try {
            return Uri.parse(str).getHost().toLowerCase(Locale.US);
        } catch (Exception e) {
            throw new RuntimeException("Illegal url:" + str, e);
        }
    }

    public static String getNetworkType(Context context) {
        try {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            }
            return NETWORK_TYPE_UNKNOWN;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getAdaptiveNetType(android.content.Context r5) {
        /*
            boolean r0 = isWifiConnected(r5)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            java.lang.String r5 = getNetworkType(r5)
            r5.hashCode()
            r0 = -1
            int r2 = r5.hashCode()
            r3 = 2
            r4 = 0
            switch(r2) {
                case 1653: goto L2f;
                case 1684: goto L26;
                case 1715: goto L1b;
                default: goto L19;
            }
        L19:
            r1 = r0
            goto L39
        L1b:
            java.lang.String r1 = "4g"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L24
            goto L19
        L24:
            r1 = r3
            goto L39
        L26:
            java.lang.String r2 = "3g"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L39
            goto L19
        L2f:
            java.lang.String r1 = "2g"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L38
            goto L19
        L38:
            r1 = r4
        L39:
            switch(r1) {
                case 0: goto L40;
                case 1: goto L3e;
                case 2: goto L3d;
                default: goto L3c;
            }
        L3c:
            return r4
        L3d:
            return r3
        L3e:
            r5 = 3
            return r5
        L40:
            r5 = 4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.video.ksvodplayerkit.Utils.NetworkUtils.getAdaptiveNetType(android.content.Context):int");
    }
}
