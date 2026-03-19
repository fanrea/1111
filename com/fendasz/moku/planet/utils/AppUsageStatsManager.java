package com.fendasz.moku.planet.utils;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AppUsageStatsManager {
    private static final String TAG = "AppUsageStatsManager=>";
    private static AppUsageStatsManager appUsageStatsManager;

    public static AppUsageStatsManager getInstance() {
        if (appUsageStatsManager == null) {
            appUsageStatsManager = new AppUsageStatsManager();
        }
        return appUsageStatsManager;
    }

    private AppUsageStatsManager() {
    }

    public long getAppTotalTimeInForeground(Context context, String str) {
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long time = DateUtils.getDate("2020-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime();
        if (usageStatsManager == null) {
            LogUtils.logD(TAG, "usm is null,return 0");
            return 0L;
        }
        UsageStats usageStats = usageStatsManager.queryAndAggregateUsageStats(time, jCurrentTimeMillis).get(str);
        if (usageStats != null) {
            long totalTimeInForeground = usageStats.getTotalTimeInForeground();
            LogUtils.logD(TAG, "usageStats time:" + totalTimeInForeground);
            return totalTimeInForeground;
        }
        LogUtils.logD(TAG, "usageStats is null");
        return 0L;
    }

    public long getAppTotalTimeInForeground(Context context, String str, long j, long j2) {
        UsageStatsManager usageStatsManager;
        UsageEvents usageEventsQueryEvents;
        long timeStamp;
        if (Build.VERSION.SDK_INT < 22 || (usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats")) == null || (usageEventsQueryEvents = usageStatsManager.queryEvents(j, j2)) == null) {
            return 0L;
        }
        UsageEvents.Event event = new UsageEvents.Event();
        long jMin = 0;
        loop0: while (true) {
            timeStamp = -1;
            while (usageEventsQueryEvents.hasNextEvent()) {
                usageEventsQueryEvents.getNextEvent(event);
                if (str.equals(event.getPackageName())) {
                    if (event.getEventType() == 1) {
                        timeStamp = event.getTimeStamp();
                    } else if (event.getEventType() != 2 || timeStamp <= 0) {
                    }
                }
            }
            jMin += Math.min(event.getTimeStamp(), j2) - timeStamp;
        }
        if (timeStamp > 0) {
            jMin += j2 - timeStamp;
        }
        Log.d(TAG, "Total foreground time for " + str + " from " + j + " to " + j2 + " is: " + jMin);
        return jMin / 1000;
    }

    public boolean isAppExistEver(Context context, String str) {
        try {
            UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
            long jCurrentTimeMillis = System.currentTimeMillis();
            long time = DateUtils.getDate("2020-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime();
            if (usageStatsManager == null) {
                return false;
            }
            return usageStatsManager.queryAndAggregateUsageStats(time, jCurrentTimeMillis).get(str) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
