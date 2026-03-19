package com.blankj.utilcode.util;

import androidx.collection.LruCache;
import com.blankj.utilcode.constant.CacheConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CacheMemoryUtils implements CacheConstants {
    private static final Map<String, CacheMemoryUtils> CACHE_MAP = new HashMap();
    private static final int DEFAULT_MAX_COUNT = 256;
    private final String mCacheKey;
    private final LruCache<String, CacheValue> mMemoryCache;

    public static CacheMemoryUtils getInstance() {
        return getInstance(256);
    }

    public static CacheMemoryUtils getInstance(int i) {
        return getInstance(String.valueOf(i), i);
    }

    public static CacheMemoryUtils getInstance(String str, int i) {
        Map<String, CacheMemoryUtils> map = CACHE_MAP;
        CacheMemoryUtils cacheMemoryUtils = map.get(str);
        if (cacheMemoryUtils == null) {
            synchronized (CacheMemoryUtils.class) {
                cacheMemoryUtils = map.get(str);
                if (cacheMemoryUtils == null) {
                    cacheMemoryUtils = new CacheMemoryUtils(str, new LruCache(i));
                    map.put(str, cacheMemoryUtils);
                }
            }
        }
        return cacheMemoryUtils;
    }

    private CacheMemoryUtils(String str, LruCache<String, CacheValue> lruCache) {
        this.mCacheKey = str;
        this.mMemoryCache = lruCache;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }

    public void put(String str, Object obj) {
        put(str, obj, -1);
    }

    public void put(String str, Object obj, int i) {
        if (obj == null) {
            return;
        }
        this.mMemoryCache.put(str, new CacheValue(i < 0 ? -1L : System.currentTimeMillis() + (i * 1000), obj));
    }

    public <T> T get(String str) {
        return (T) get(str, null);
    }

    public <T> T get(String str, T t) {
        CacheValue cacheValue = this.mMemoryCache.get(str);
        if (cacheValue == null) {
            return t;
        }
        if (cacheValue.dueTime == -1 || cacheValue.dueTime >= System.currentTimeMillis()) {
            return (T) cacheValue.value;
        }
        this.mMemoryCache.remove(str);
        return t;
    }

    public int getCacheCount() {
        return this.mMemoryCache.size();
    }

    public Object remove(String str) {
        CacheValue cacheValueRemove = this.mMemoryCache.remove(str);
        if (cacheValueRemove == null) {
            return null;
        }
        return cacheValueRemove.value;
    }

    public void clear() {
        this.mMemoryCache.evictAll();
    }

    private static final class CacheValue {
        long dueTime;
        Object value;

        CacheValue(long j, Object obj) {
            this.dueTime = j;
            this.value = obj;
        }
    }
}
