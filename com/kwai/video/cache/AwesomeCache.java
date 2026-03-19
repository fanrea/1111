package com.kwai.video.cache;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.cache.OfflineCacheVodAdaptiveTaskBuilder;
import com.kwai.video.hodor.util.Timber;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AwesomeCache {
    public static final int DATA_SOURCE_TYPE_ASYNC_V2 = 0;
    public static final int DATA_SOURCE_TYPE_LIVE = 1;
    public static final int DATA_SOURCE_TYPE_SEGMENT = 2;
    public static final int UPSTREAM_TYPE_CRONET = 3;
    public static final int UPSTREAM_TYPE_CURL = 0;
    public static final int UPSTREAM_TYPE_FFURL = 1;
    public static final int UPSTREAM_TYPE_P2SP = 2;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface DataSourceType {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class OfflineCacheDataSpec {
        int bandWidthThreshold;
        int cacheMode;
        int connectTimeoutMs;
        long durMs;
        boolean enableLimitSpeedWhenCancel;
        String host;
        String key;
        long len;
        int maxSpeedKbps;
        long pos;
        int readTimeoutMs;
        int socketBufSizeKb;
        String url;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface UpstreamType {
    }

    private static native void _clearCacheDir();

    private static native long _getCachedBytesForKey(String str);

    private static native long _getTotalBytesForKey(String str);

    private static native boolean _importToCache(String str, String str2);

    private static native boolean _isFullyCached(String str);

    private static native long _newExportCachedFileTask(Object obj, String str, String str2, String str3, String str4);

    private static native long _newOfflineCacheVodAdaptiveTask(Object obj, Object obj2, Object obj3, Object obj4);

    private static native long _newOfflineCacheVodFileTask(Object obj, Object obj2, Object obj3);

    private static native long _newOfflineCachedFileTask(Object obj, String str, String str2, String str3);

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public static void clearCacheDir() {
        _clearCacheDir();
    }

    public static boolean isFullyCached(String str) {
        return _isFullyCached(str);
    }

    public static long getCachedBytesForKey(String str) {
        return _getCachedBytesForKey(str);
    }

    public static int getCachedPercentForKey(String str) {
        long cachedBytesForKey = getCachedBytesForKey(str);
        long totalBytesForKey = getTotalBytesForKey(str);
        Timber.i("[AwesomeCache] getCachedPercentForKey. key:%s cached:%d total:%d", str, Long.valueOf(cachedBytesForKey), Long.valueOf(totalBytesForKey));
        if (totalBytesForKey > 0) {
            return (int) ((cachedBytesForKey * 100) / totalBytesForKey);
        }
        return 0;
    }

    public static long getTotalBytesForKey(String str) {
        return _getTotalBytesForKey(str);
    }

    public static CacheTask newExportCachedFileTask(String str, String str2, String str3, String str4) {
        CacheTask cacheTask = new CacheTask();
        cacheTask.setNativeTask(_newExportCachedFileTask(cacheTask, str, str2, str3, str4));
        return cacheTask;
    }

    public static OfflineCacheTask newOfflineCachedFileTask(String str, String str2, String str3) {
        OfflineCacheTask offlineCacheTask = new OfflineCacheTask();
        offlineCacheTask.setNativeTask(_newOfflineCachedFileTask(offlineCacheTask, str, str2, str3));
        return offlineCacheTask;
    }

    public static OfflineCacheVodTask newOfflineCacheVodAdaptiveTask(OfflineCacheDataSpec offlineCacheDataSpec, AwesomeCacheCallback awesomeCacheCallback, OfflineCacheVodAdaptiveTaskBuilder.VodAdaptiveInit vodAdaptiveInit) {
        OfflineCacheVodTask offlineCacheVodTask = new OfflineCacheVodTask();
        offlineCacheVodTask.setNativeTask(_newOfflineCacheVodAdaptiveTask(offlineCacheVodTask, offlineCacheDataSpec, awesomeCacheCallback, vodAdaptiveInit));
        return offlineCacheVodTask;
    }

    public static OfflineCacheVodTask newOfflineCacheVodFileTask(OfflineCacheDataSpec offlineCacheDataSpec, AwesomeCacheCallback awesomeCacheCallback) {
        OfflineCacheVodTask offlineCacheVodTask = new OfflineCacheVodTask();
        offlineCacheVodTask.setNativeTask(_newOfflineCacheVodFileTask(offlineCacheVodTask, offlineCacheDataSpec, awesomeCacheCallback));
        return offlineCacheVodTask;
    }

    public static boolean importToCache(String str, String str2) {
        return _importToCache(str, str2);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class VodAdaptive {
        public static final int NET_WORK_TYPE_FIVE_G = 5;
        public static final int NET_WORK_TYPE_FOUR_G = 2;
        public static final int NET_WORK_TYPE_THREE_G = 3;
        public static final int NET_WORK_TYPE_TWO_G = 4;
        public static final int NET_WORK_TYPE_UNKNOW = 0;
        public static final int NET_WORK_TYPE_WIFI = 1;

        private static native String _vodAdaptiveGetHistoryData();

        private static native void _vodAdaptiveSetHistoryData(String str);

        public static void init(Context context) {
            String vodAdaptiveData = PlayerPreferrenceUtil.getInstance().getVodAdaptiveData(context);
            if (TextUtils.isEmpty(vodAdaptiveData)) {
                return;
            }
            setHistoryData(vodAdaptiveData);
        }

        public static void setHistoryData(String str) {
            _vodAdaptiveSetHistoryData(str);
        }

        public static String getHistoryData() {
            return _vodAdaptiveGetHistoryData();
        }
    }
}
