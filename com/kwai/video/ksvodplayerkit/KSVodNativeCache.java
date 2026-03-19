package com.kwai.video.ksvodplayerkit;

import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.cache.CacheTask;
import com.kwai.video.cache.OfflineCacheTask;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import com.kwai.video.ksvodplayerkit.Utils.VodPlayerUtils;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodNativeCache {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface CacheTaskListener {
        void onCancelled();

        void onFailed(int i);

        void onProgress(long j, long j2);

        void onSuccessful();
    }

    public static void clearCacheDir() {
        AwesomeCache.clearCacheDir();
        KSVodPlayStatManager.getInstance().clearCacheStatus();
    }

    public static boolean isFullyCached(String str) {
        return AwesomeCache.isFullyCached(VodPlayerUtils.getCacheKey(str));
    }

    public static CacheTask exportCachedVideo(String str, final String str2, final CacheTaskListener cacheTaskListener) {
        final CacheTask cacheTaskNewExportCachedFileTask = AwesomeCache.newExportCachedFileTask(str, VodPlayerUtils.getCacheKey(str), "", str2);
        cacheTaskNewExportCachedFileTask.run(new CacheTask.CacheTaskListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodNativeCache.1
            @Override // com.kwai.video.cache.CacheTask.CacheTaskListener
            public final void onProgress(long j, long j2) {
            }

            @Override // com.kwai.video.cache.CacheTask.CacheTaskListener
            public final void onSuccessful() {
                File file = new File(str2);
                if (file.exists() && file.isFile()) {
                    CacheTaskListener cacheTaskListener2 = cacheTaskListener;
                    if (cacheTaskListener2 != null) {
                        cacheTaskListener2.onProgress(file.length(), file.length());
                        cacheTaskListener.onSuccessful();
                    }
                } else {
                    onFailed(-1);
                }
                CacheTask cacheTask = cacheTaskNewExportCachedFileTask;
                if (cacheTask != null) {
                    cacheTask.releaseAsync();
                }
            }

            @Override // com.kwai.video.cache.CacheTask.CacheTaskListener
            public final void onFailed(int i) {
                KSVodLogger.e("KSVodNativeCache", "exporCachedVideo failed, reason:" + i);
                CacheTaskListener cacheTaskListener2 = cacheTaskListener;
                if (cacheTaskListener2 != null) {
                    cacheTaskListener2.onFailed(i);
                }
                CacheTask cacheTask = cacheTaskNewExportCachedFileTask;
                if (cacheTask != null) {
                    cacheTask.releaseAsync();
                }
            }

            @Override // com.kwai.video.cache.CacheTask.CacheTaskListener
            public final void onCancelled() {
                CacheTaskListener cacheTaskListener2 = cacheTaskListener;
                if (cacheTaskListener2 != null) {
                    cacheTaskListener2.onCancelled();
                }
            }
        });
        return cacheTaskNewExportCachedFileTask;
    }

    public static OfflineCacheTask downloadVideo(final String str, final String str2, final CacheTaskListener cacheTaskListener) {
        final OfflineCacheTask offlineCacheTaskNewOfflineCachedFileTask = AwesomeCache.newOfflineCachedFileTask(str, VodPlayerUtils.getCacheKey(str), NetworkUtils.getHost(str));
        offlineCacheTaskNewOfflineCachedFileTask.run(new OfflineCacheTask.OfflineCacheTaskListener() { // from class: com.kwai.video.ksvodplayerkit.KSVodNativeCache.2
            @Override // com.kwai.video.cache.OfflineCacheTask.OfflineCacheTaskListener
            public final void onStarted(long j, long j2, long j3) {
            }

            @Override // com.kwai.video.cache.OfflineCacheTask.OfflineCacheTaskListener
            public final void onStopped(long j, long j2, String str3) {
            }

            @Override // com.kwai.video.cache.OfflineCacheTask.OfflineCacheTaskListener
            public final void onSuccessful() {
                KSVodNativeCache.exportCachedVideo(str, str2, cacheTaskListener);
                OfflineCacheTask offlineCacheTask = offlineCacheTaskNewOfflineCachedFileTask;
                if (offlineCacheTask != null) {
                    offlineCacheTask.releaseAsync();
                }
            }

            @Override // com.kwai.video.cache.OfflineCacheTask.OfflineCacheTaskListener
            public final void onFailed(int i) {
                CacheTaskListener cacheTaskListener2 = cacheTaskListener;
                if (cacheTaskListener2 != null) {
                    cacheTaskListener2.onFailed(i);
                }
                OfflineCacheTask offlineCacheTask = offlineCacheTaskNewOfflineCachedFileTask;
                if (offlineCacheTask != null) {
                    offlineCacheTask.releaseAsync();
                }
            }

            @Override // com.kwai.video.cache.OfflineCacheTask.OfflineCacheTaskListener
            public final void onCancelled() {
                CacheTaskListener cacheTaskListener2 = cacheTaskListener;
                if (cacheTaskListener2 != null) {
                    cacheTaskListener2.onCancelled();
                }
            }

            @Override // com.kwai.video.cache.OfflineCacheTask.OfflineCacheTaskListener
            public final void onProgress(long j, long j2) {
                CacheTaskListener cacheTaskListener2 = cacheTaskListener;
                if (cacheTaskListener2 != null) {
                    cacheTaskListener2.onProgress(j, j2);
                }
            }
        });
        return offlineCacheTaskNewOfflineCachedFileTask;
    }
}
