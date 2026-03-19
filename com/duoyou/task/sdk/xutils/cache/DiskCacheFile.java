package com.duoyou.task.sdk.xutils.cache;

import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.ProcessLock;
import java.io.Closeable;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DiskCacheFile extends File implements Closeable {
    private final DiskCacheEntity cacheEntity;
    private final ProcessLock lock;

    public DiskCacheFile(String str, DiskCacheEntity diskCacheEntity, ProcessLock processLock) {
        super(str);
        this.cacheEntity = diskCacheEntity;
        this.lock = processLock;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtil.closeQuietly(this.lock);
    }

    public DiskCacheFile commit() {
        return getDiskCache().commitDiskCacheFile(this);
    }

    public LruDiskCache getDiskCache() {
        return LruDiskCache.getDiskCache(getParentFile().getName());
    }

    public DiskCacheEntity getCacheEntity() {
        return this.cacheEntity;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }
}
