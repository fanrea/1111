package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yi {
    private static final Object d = new Object();
    private static final Map<d, Object> hc = new ConcurrentHashMap();
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static volatile int c = -1;
    private static volatile long u = 0;
    private static volatile int an = 60000;
    private static e h = null;
    private static final AtomicBoolean gb = new AtomicBoolean(false);

    public interface d {
        void d(Context context, Intent intent, boolean z, int i);
    }

    public static void d(e eVar) {
        h = eVar;
    }

    public static int d(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (u + j <= jElapsedRealtime) {
            return hc(context);
        }
        if (c == -1) {
            return hc(context);
        }
        if (jElapsedRealtime - u >= an) {
            hc(context, (Intent) null, false, false);
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            c = 0;
        } else if (gb.compareAndSet(false, true)) {
            com.bytedance.sdk.component.tc.h.hc(new com.bytedance.sdk.component.tc.tt("getNetworkType") { // from class: com.bytedance.sdk.component.utils.yi.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = yi.c = z2 ? 0 : yi.hc(context);
                    if (z) {
                        yi.hc(context, intent, yi.c, z2);
                    }
                    yi.gb.set(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Context context, Intent intent, int i, boolean z) {
        Map<d, Object> map = hc;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (d dVar : map.keySet()) {
            if (dVar != null) {
                dVar.d(context, intent, !z, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hc(Context context) {
        c = b(context);
        u = SystemClock.elapsedRealtime();
        return c;
    }

    private static int b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
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
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        e eVar = h;
                        return (eVar == null || !eVar.d(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void d(d dVar, Context context) {
        if (dVar == null) {
            return;
        }
        if (!b.get()) {
            try {
                context.registerReceiver(new hc(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                b.set(true);
            } catch (Throwable unused) {
            }
        }
        hc.put(dVar, d);
    }

    public static void d(d dVar) {
        if (dVar == null) {
            return;
        }
        hc.remove(dVar);
    }

    private static class hc extends BroadcastReceiver {
        private hc() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (yi.hc != null && yi.hc.size() > 0) {
                z = true;
            }
            yi.hc(context, intent, z, booleanExtra);
        }
    }
}
