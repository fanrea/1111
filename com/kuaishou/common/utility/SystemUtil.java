package com.kuaishou.common.utility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.location.LocationRequestCompat;
import com.kwai.video.player.KsMediaMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SystemUtil {
    private static final long MB = 1048576;
    private static LEVEL mDeviceLevel;
    private static long mLowMemoryThresold;
    private static int mMemoryClass;
    private static long mTotalMemory;

    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);

        int value;

        LEVEL(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static long getTotalMemory(Context context) {
        long j = mTotalMemory;
        if (0 != j) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 16) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        activityManager.getMemoryInfo(memoryInfo);
        mTotalMemory = memoryInfo.totalMem;
        mLowMemoryThresold = memoryInfo.threshold;
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (jMaxMemory == LocationRequestCompat.PASSIVE_INTERVAL) {
            mMemoryClass = activityManager.getMemoryClass();
        } else {
            mMemoryClass = (int) (jMaxMemory / 1048576);
        }
        Log.i("DeviceInfo", "getTotalMemory cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + ", total_mem:" + mTotalMemory + ", LowMemoryThresold:" + mLowMemoryThresold + ", Memory Class:" + mMemoryClass);
        return mTotalMemory;
    }

    public static LEVEL getLevel(Context context) {
        LEVEL level = mDeviceLevel;
        if (level != null) {
            return level;
        }
        long totalMemory = getTotalMemory(context);
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (totalMemory >= KsMediaMeta.AV_CH_WIDE_RIGHT) {
            mDeviceLevel = LEVEL.BEST;
        } else if (totalMemory >= 3221225472L) {
            mDeviceLevel = LEVEL.HIGH;
        } else if (totalMemory >= KsMediaMeta.AV_CH_WIDE_LEFT) {
            if (iAvailableProcessors >= 4) {
                mDeviceLevel = LEVEL.HIGH;
            } else if (iAvailableProcessors >= 2) {
                mDeviceLevel = LEVEL.MIDDLE;
            } else if (iAvailableProcessors > 0) {
                mDeviceLevel = LEVEL.LOW;
            }
        } else if (totalMemory >= 1073741824) {
            if (iAvailableProcessors >= 4) {
                mDeviceLevel = LEVEL.MIDDLE;
            } else if (iAvailableProcessors >= 2 || iAvailableProcessors > 0) {
                mDeviceLevel = LEVEL.LOW;
            }
        } else if (0 <= totalMemory && totalMemory < 1073741824) {
            mDeviceLevel = LEVEL.BAD;
        } else {
            mDeviceLevel = LEVEL.UN_KNOW;
        }
        return mDeviceLevel;
    }
}
