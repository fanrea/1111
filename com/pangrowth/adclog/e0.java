package com.pangrowth.adclog;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.RemoteException;
import androidx.core.content.ContextCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e0 {
    public static volatile int a = -1;

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        return i > 22 && i < 28 && ContextCompat.checkSelfPermission(v.a, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static long a(Context context, long j, long j2, int i) throws PackageManager.NameNotFoundException, RemoteException, SecurityException {
        NetworkStatsManager networkStatsManager;
        long rxBytes = 0;
        if (!a() || (networkStatsManager = (NetworkStatsManager) context.getApplicationContext().getSystemService("netstats")) == null) {
            return 0L;
        }
        NetworkStats networkStatsQuerySummary = null;
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        try {
            networkStatsQuerySummary = networkStatsManager.querySummary(i, null, j, j2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long txBytes = 0;
        while (networkStatsQuerySummary != null && networkStatsQuerySummary.hasNextBucket()) {
            networkStatsQuerySummary.getNextBucket(bucket);
            int uid = bucket.getUid();
            if (a == -1) {
                try {
                    PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 128);
                    if (packageInfo != null) {
                        a = packageInfo.applicationInfo.uid;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            if (a == uid) {
                rxBytes += bucket.getRxBytes();
                txBytes += bucket.getTxBytes();
            }
        }
        if (networkStatsQuerySummary != null) {
            networkStatsQuerySummary.close();
        }
        return rxBytes + txBytes;
    }
}
