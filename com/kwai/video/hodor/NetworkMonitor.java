package com.kwai.video.hodor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Pair;
import com.kwai.video.hodor.util.Timber;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NetworkMonitor {
    private static final int HodorMobileType_MOBILE_2G = 1;
    private static final int HodorMobileType_MOBILE_3G = 2;
    private static final int HodorMobileType_MOBILE_4G = 3;
    private static final int HodorMobileType_MOBILE_5G = 4;
    private static final int HodorMobileType_UNKNOWN = 0;

    private static String emptyStringIfNull(String str) {
        return str == null ? "" : str;
    }

    private static native void onNetworkInvalidated();

    private static native void onNewActiveNetwork(boolean z, boolean z2, String str, String str2, String str3, int i);

    public static void initNetworkChangeReceiver(Context context) {
        if (context != null) {
            context.getApplicationContext().registerReceiver(new BroadcastReceiver() { // from class: com.kwai.video.hodor.NetworkMonitor.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) {
                    NetworkMonitor.onNetworkChange(context2, intent);
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            Timber.e("initNetworkChangeReceiver fail, context is null", new Object[0]);
        }
    }

    public static void onNetworkChange(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Pair<Integer, String> mobileType = getMobileType(context);
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    Timber.w("[onNetworkChange], get ConnectivityManager ok, get getActiveNetworkInfo fail, current supportMobileType:%s", mobileType.second);
                    onNetworkInvalidated();
                    return;
                }
                Object[] objArr = new Object[6];
                objArr[0] = Boolean.valueOf(activeNetworkInfo.isConnected());
                objArr[1] = Boolean.valueOf(activeNetworkInfo.getType() == 1);
                objArr[2] = activeNetworkInfo.getTypeName();
                objArr[3] = activeNetworkInfo.getState().toString();
                objArr[4] = "";
                objArr[5] = mobileType.second;
                Timber.d("[onNetworkChange], get ConnectivityManager ok, get getActiveNetworkInfo ok, isConnected:%b, isWifi:%b, netTypeName:%s, connectionState:%s, getExtraInfo:%s, supportMobileType:%s", objArr);
                onNewActiveNetwork(activeNetworkInfo.isConnected(), activeNetworkInfo.getType() == 1, emptyStringIfNull(activeNetworkInfo.getTypeName()), emptyStringIfNull(activeNetworkInfo.getState().toString()), emptyStringIfNull(null), ((Integer) mobileType.first).intValue());
                return;
            }
            onNetworkInvalidated();
            Timber.e("[onNetworkChange], get ConnectivityManager fail, current supportMobileType:%s", mobileType.second);
        } catch (Exception unused) {
            onNetworkInvalidated();
            Timber.e("[onNetworkChange], get ConnectivityManager fail, current supportMobileType", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0027 -> B:15:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.String> getMobileType(android.content.Context r6) {
        /*
            java.lang.String r0 = "UNKNOWN"
            r1 = 0
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Exception -> L81
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Exception -> L81
            r3 = 1
            if (r2 == 0) goto L34
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.RuntimeException -> L26 java.lang.Exception -> L81
            r5 = 30
            if (r4 < r5) goto L21
            java.lang.String r4 = "android.permission.READ_PHONE_STATE"
            int r6 = androidx.core.app.ActivityCompat.checkSelfPermission(r6, r4)     // Catch: java.lang.RuntimeException -> L26 java.lang.Exception -> L81
            if (r6 != 0) goto L34
            int r6 = r2.getNetworkType()     // Catch: java.lang.RuntimeException -> L26 java.lang.Exception -> L81
            goto L35
        L21:
            int r6 = r2.getNetworkType()     // Catch: java.lang.RuntimeException -> L26 java.lang.Exception -> L81
            goto L35
        L26:
            r6 = move-exception
            java.lang.String r2 = "[NetworkMonitor.getMobileType]fail, exception:%s"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L81
            java.lang.String r6 = android.util.Log.getStackTraceString(r6)     // Catch: java.lang.Exception -> L81
            r4[r1] = r6     // Catch: java.lang.Exception -> L81
            com.kwai.video.hodor.util.Timber.w(r2, r4)     // Catch: java.lang.Exception -> L81
        L34:
            r6 = r1
        L35:
            java.lang.String r2 = "[NetworkMonitor.getMobileType]mobileType:%d"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L81
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L81
            r4[r1] = r5     // Catch: java.lang.Exception -> L81
            com.kwai.video.hodor.util.Timber.d(r2, r4)     // Catch: java.lang.Exception -> L81
            r2 = 20
            if (r6 == r2) goto L75
            switch(r6) {
                case 1: goto L6a;
                case 2: goto L6a;
                case 3: goto L5e;
                case 4: goto L6a;
                case 5: goto L5e;
                case 6: goto L5e;
                case 7: goto L6a;
                case 8: goto L5e;
                case 9: goto L5e;
                case 10: goto L5e;
                case 11: goto L6a;
                case 12: goto L5e;
                case 13: goto L52;
                case 14: goto L5e;
                case 15: goto L5e;
                default: goto L49;
            }     // Catch: java.lang.Exception -> L81
        L49:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L81
            android.util.Pair r6 = android.util.Pair.create(r6, r0)     // Catch: java.lang.Exception -> L81
            return r6
        L52:
            r6 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L81
            java.lang.String r2 = "4G"
            android.util.Pair r6 = android.util.Pair.create(r6, r2)     // Catch: java.lang.Exception -> L81
            return r6
        L5e:
            r6 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L81
            java.lang.String r2 = "3G"
            android.util.Pair r6 = android.util.Pair.create(r6, r2)     // Catch: java.lang.Exception -> L81
            return r6
        L6a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L81
            java.lang.String r2 = "2G"
            android.util.Pair r6 = android.util.Pair.create(r6, r2)     // Catch: java.lang.Exception -> L81
            return r6
        L75:
            r6 = 4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L81
            java.lang.String r2 = "5G"
            android.util.Pair r6 = android.util.Pair.create(r6, r2)     // Catch: java.lang.Exception -> L81
            return r6
        L81:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            android.util.Pair r6 = android.util.Pair.create(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.video.hodor.NetworkMonitor.getMobileType(android.content.Context):android.util.Pair");
    }
}
