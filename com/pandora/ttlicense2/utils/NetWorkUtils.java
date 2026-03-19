package com.pandora.ttlicense2.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NetWorkUtils {
    public static int NETWORK_INFO_EXPIRED_TIME_MS = 1000;
    private static final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.pandora.ttlicense2.utils.NetWorkUtils.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfoListener networkInfoListener;
            if (isInitialStickyBroadcast() || intent == null || !TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            NetworkInfo activeNetworkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            NetWorkUtils.updateNetworkInfoCache(activeNetworkInfo);
            if (activeNetworkInfo == null) {
                activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context);
            }
            synchronized (NetWorkUtils.class) {
                networkInfoListener = NetWorkUtils.sListener;
            }
            if (networkInfoListener == null || activeNetworkInfo == null) {
                return;
            }
            networkInfoListener.onNetworkConnectionChanged(activeNetworkInfo);
        }
    };
    private static volatile boolean sEnable;
    private static NetworkInfoListener sListener;
    private static NetworkInfo sNetworkInfo;
    private static long sNetworkInfoUpdateTimeMS;
    private static boolean sRegistered;

    public interface NetworkInfoListener {
        void onNetworkConnectionChanged(NetworkInfo networkInfo);
    }

    public static boolean isNetAvailableOptANR(Context context) {
        resister(context);
        NetworkInfo networkInfoOptANR = getNetworkInfoOptANR(context);
        return networkInfoOptANR != null && networkInfoOptANR.isConnected();
    }

    public static boolean isNetAvailable(Context context) {
        resister(context);
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static NetworkInfo getNetworkInfoOptANR(Context context) {
        NetworkInfo networkInfo;
        synchronized (NetWorkUtils.class) {
            networkInfo = sNetworkInfo;
        }
        return (networkInfo == null || isNetworkInfoCacheExpired()) ? getActiveNetworkInfo(context) : networkInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (!sEnable || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        updateNetworkInfoCache(activeNetworkInfo);
        return activeNetworkInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateNetworkInfoCache(NetworkInfo networkInfo) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (NetWorkUtils.class) {
            sNetworkInfo = networkInfo;
            sNetworkInfoUpdateTimeMS = jUptimeMillis;
        }
    }

    private static boolean isNetworkInfoCacheExpired() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (NetWorkUtils.class) {
            z = jUptimeMillis - sNetworkInfoUpdateTimeMS > ((long) NETWORK_INFO_EXPIRED_TIME_MS);
        }
        return z;
    }

    public static void setNetworkInfoListener(Context context, final NetworkInfoListener listener) {
        synchronized (NetWorkUtils.class) {
            sListener = listener;
        }
        resister(context);
    }

    private static synchronized void resister(Context context) {
        if (sEnable) {
            synchronized (NetWorkUtils.class) {
                if (sRegistered) {
                    return;
                }
                sRegistered = true;
                context.registerReceiver(receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        }
    }

    private static synchronized void unregister(Context context) {
        if (sRegistered) {
            sRegistered = false;
            context.unregisterReceiver(receiver);
        }
    }

    public static void setEnable(Context applicationContext, boolean enable) {
        sEnable = enable;
        if (enable) {
            resister(applicationContext);
        } else {
            unregister(applicationContext);
        }
    }
}
