package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.Utils.VodPlayerUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class KSVodPlayStatManager {
    private static final int MAX_CACHE_SIZE = 100;
    private static KSVodPlayStatManager mVodPlayStatManager;
    private final Object mLock = new Object();
    private Map<String, PlayStat> mPlayStatMap = new LinkedHashMap(100);
    private CacheKeyGenerator mCacheKeyGenerator = new CacheKeyGenerator() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayStatManager.1
        @Override // com.kwai.video.ksvodplayerkit.CacheKeyGenerator
        public String getCacheKey(String str) {
            return VodPlayerUtils.getCacheKey(str);
        }
    };

    private KSVodPlayStatManager() {
    }

    static synchronized KSVodPlayStatManager getInstance() {
        if (mVodPlayStatManager == null) {
            mVodPlayStatManager = new KSVodPlayStatManager();
        }
        return mVodPlayStatManager;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class PlayStat {
        boolean isFullyCached;
        long playPosition;

        private PlayStat() {
            this.isFullyCached = false;
            this.playPosition = 0L;
        }
    }

    String add(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        KSVodLogger.v("KSVodPlayStatManager", "size:" + this.mPlayStatMap.size() + ", add url:" + str);
        synchronized (this.mLock) {
            if (this.mPlayStatMap.size() >= 100) {
                int i = 0;
                Iterator<Map.Entry<String, PlayStat>> it = this.mPlayStatMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                    i++;
                    if (i >= 20) {
                        break;
                    }
                }
            }
            String cacheKey = this.mCacheKeyGenerator.getCacheKey(str);
            if (this.mPlayStatMap.containsKey(cacheKey)) {
                return cacheKey;
            }
            PlayStat playStat = new PlayStat();
            playStat.isFullyCached = AwesomeCache.isFullyCached(cacheKey);
            this.mPlayStatMap.put(cacheKey, playStat);
            return cacheKey;
        }
    }

    void updateCacheStatus(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String cacheKey = this.mCacheKeyGenerator.getCacheKey(str);
        synchronized (this.mLock) {
            if (!this.mPlayStatMap.containsKey(cacheKey)) {
                add(cacheKey);
            }
            PlayStat playStat = this.mPlayStatMap.get(cacheKey);
            if (playStat != null) {
                playStat.isFullyCached = z;
            }
        }
    }

    boolean getCacheStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isFullyCached(this.mCacheKeyGenerator.getCacheKey(str));
    }

    long getPlayPosition(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String cacheKey = this.mCacheKeyGenerator.getCacheKey(str);
        synchronized (this.mLock) {
            if (!this.mPlayStatMap.containsKey(cacheKey)) {
                return 0L;
            }
            PlayStat playStat = this.mPlayStatMap.get(cacheKey);
            if (playStat == null) {
                return 0L;
            }
            return playStat.playPosition;
        }
    }

    void updatePlayPosition(String str, long j) {
        if (TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        String cacheKey = this.mCacheKeyGenerator.getCacheKey(str);
        synchronized (this.mLock) {
            if (!this.mPlayStatMap.containsKey(cacheKey)) {
                add(str);
            }
            PlayStat playStat = this.mPlayStatMap.get(cacheKey);
            if (playStat != null) {
                playStat.playPosition = j;
            }
        }
    }

    public void clearCacheStatus() {
        synchronized (this.mLock) {
            Iterator<PlayStat> it = this.mPlayStatMap.values().iterator();
            while (it.hasNext()) {
                it.next().isFullyCached = false;
            }
        }
    }

    private boolean isFullyCached(String str) {
        return AwesomeCache.isFullyCached(str);
    }
}
