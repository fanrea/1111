package aegon.chrome.base.metrics;

import aegon.chrome.base.annotations.JNINamespace;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RecordHistogram {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Map<String, Long> sCache = Collections.synchronizedMap(new HashMap());
    private static Throwable sDisabledBy;

    private static int clampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    private static native int nativeGetHistogramTotalCountForTesting(String str);

    private static native int nativeGetHistogramValueCountForTesting(String str, int i);

    private static native long nativeRecordBooleanHistogram(String str, long j, boolean z);

    private static native long nativeRecordCustomCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordEnumeratedHistogram(String str, long j, int i, int i2);

    private static native long nativeRecordLinearCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordSparseHistogram(String str, long j, int i);

    public static void setDisabledForTests(boolean z) {
        if (z && sDisabledBy != null) {
            throw new IllegalStateException("Histograms are already disabled.", sDisabledBy);
        }
        sDisabledBy = z ? new Throwable() : null;
    }

    private static long getCachedHistogramKey(String str) {
        Long l = sCache.get(str);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public static void recordBooleanHistogram(String str, boolean z) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordBooleanHistogram = nativeRecordBooleanHistogram(str, cachedHistogramKey, z);
        if (jNativeRecordBooleanHistogram != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordBooleanHistogram));
        }
    }

    public static void recordEnumeratedHistogram(String str, int i, int i2) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordEnumeratedHistogram = nativeRecordEnumeratedHistogram(str, cachedHistogramKey, i, i2);
        if (jNativeRecordEnumeratedHistogram != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordEnumeratedHistogram));
        }
    }

    public static void recordCountHistogram(String str, int i) {
        recordCustomCountHistogram(str, i, 1, 1000000, 50);
    }

    public static void recordCount100Histogram(String str, int i) {
        recordCustomCountHistogram(str, i, 1, 100, 50);
    }

    public static void recordCount1000Histogram(String str, int i) {
        recordCustomCountHistogram(str, i, 1, 1000, 50);
    }

    public static void recordCustomCountHistogram(String str, int i, int i2, int i3, int i4) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordCustomCountHistogram = nativeRecordCustomCountHistogram(str, cachedHistogramKey, i, i2, i3, i4);
        if (jNativeRecordCustomCountHistogram != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordCustomCountHistogram));
        }
    }

    public static void recordLinearCountHistogram(String str, int i, int i2, int i3, int i4) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordLinearCountHistogram = nativeRecordLinearCountHistogram(str, cachedHistogramKey, i, i2, i3, i4);
        if (jNativeRecordLinearCountHistogram != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordLinearCountHistogram));
        }
    }

    public static void recordPercentageHistogram(String str, int i) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordEnumeratedHistogram = nativeRecordEnumeratedHistogram(str, cachedHistogramKey, i, 101);
        if (jNativeRecordEnumeratedHistogram != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordEnumeratedHistogram));
        }
    }

    public static void recordSparseHistogram(String str, int i) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordSparseHistogram = nativeRecordSparseHistogram(str, cachedHistogramKey, i);
        if (jNativeRecordSparseHistogram != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordSparseHistogram));
        }
    }

    public static void recordTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 50);
    }

    public static void recordMediumTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 10L, 180000L, 50);
    }

    public static void recordLongTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 3600000L, 50);
    }

    public static void recordLongTimesHistogram100(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 3600000L, 100);
    }

    public static void recordCustomTimesHistogram(String str, long j, long j2, long j3, int i) {
        recordCustomTimesHistogramMilliseconds(str, j, j2, j3, i);
    }

    public static void recordMemoryKBHistogram(String str, int i) {
        recordCustomCountHistogram(str, i, 1000, 500000, 50);
    }

    private static void recordCustomTimesHistogramMilliseconds(String str, long j, long j2, long j3, int i) {
        if (sDisabledBy != null) {
            return;
        }
        long cachedHistogramKey = getCachedHistogramKey(str);
        long jNativeRecordCustomTimesHistogramMilliseconds = nativeRecordCustomTimesHistogramMilliseconds(str, cachedHistogramKey, clampToInt(j), clampToInt(j2), clampToInt(j3), i);
        if (jNativeRecordCustomTimesHistogramMilliseconds != cachedHistogramKey) {
            sCache.put(str, Long.valueOf(jNativeRecordCustomTimesHistogramMilliseconds));
        }
    }

    public static int getHistogramValueCountForTesting(String str, int i) {
        return nativeGetHistogramValueCountForTesting(str, i);
    }

    public static int getHistogramTotalCountForTesting(String str) {
        return nativeGetHistogramTotalCountForTesting(str);
    }
}
