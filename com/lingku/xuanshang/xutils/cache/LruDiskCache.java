package com.lingku.xuanshang.xutils.cache;

import android.text.TextUtils;
import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.common.task.PriorityExecutor;
import com.lingku.xuanshang.xutils.common.util.FileUtil;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.common.util.MD5;
import com.lingku.xuanshang.xutils.common.util.ProcessLock;
import com.lingku.xuanshang.xutils.config.DbConfigs;
import com.lingku.xuanshang.xutils.ex.FileLockedException;
import com.lingku.xuanshang.xutils.x;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class LruDiskCache {
    public static final HashMap<String, LruDiskCache> a = new HashMap<>(5);
    public boolean b;
    public DbManager c;
    public File d;
    public long e = 104857600;
    public final Executor f = new PriorityExecutor(1, true);
    public long g = 0;

    public class a implements Runnable {
        public final /* synthetic */ DiskCacheEntity a;

        public a(DiskCacheEntity diskCacheEntity) {
            this.a = diskCacheEntity;
        }

        @Override // java.lang.Runnable
        public void run() {
            DiskCacheEntity diskCacheEntity = this.a;
            diskCacheEntity.setHits(diskCacheEntity.getHits() + 1);
            this.a.setLastAccess(System.currentTimeMillis());
            try {
                LruDiskCache.this.c.update(this.a, "hits", "lastAccess");
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LruDiskCache lruDiskCache = LruDiskCache.this;
            if (lruDiskCache.b) {
                try {
                    File[] fileArrListFiles = lruDiskCache.d.listFiles();
                    if (fileArrListFiles != null) {
                        for (File file : fileArrListFiles) {
                            try {
                                if (LruDiskCache.this.c.selector(DiskCacheEntity.class).where("path", "=", file.getAbsolutePath()).count() < 1) {
                                    IOUtil.deleteFileOrDir(file);
                                }
                            } catch (Throwable th) {
                                LogUtil.e(th.getMessage(), th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    LogUtil.e(th2.getMessage(), th2);
                }
            }
        }
    }

    public LruDiskCache(String str) {
        this.b = false;
        try {
            File cacheDir = FileUtil.getCacheDir(str);
            this.d = cacheDir;
            if (cacheDir != null && (cacheDir.exists() || this.d.mkdirs())) {
                this.b = true;
            }
            this.c = x.getDb(DbConfigs.HTTP.getConfig());
        } catch (Throwable th) {
            this.b = false;
            LogUtil.e(th.getMessage(), th);
        }
        a();
    }

    public static synchronized LruDiskCache getDiskCache(String str) {
        LruDiskCache lruDiskCache;
        if (TextUtils.isEmpty(str)) {
            str = "xUtils_cache";
        }
        HashMap<String, LruDiskCache> map = a;
        lruDiskCache = map.get(str);
        if (lruDiskCache == null) {
            lruDiskCache = new LruDiskCache(str);
            map.put(str, lruDiskCache);
        }
        return lruDiskCache;
    }

    public final void a() {
        this.f.execute(new b());
    }

    public final boolean a(String str) throws Throwable {
        ProcessLock processLockTryLock;
        try {
            processLockTryLock = ProcessLock.tryLock(str, true);
            if (processLockTryLock != null) {
                try {
                    if (processLockTryLock.isValid()) {
                        boolean zDeleteFileOrDir = IOUtil.deleteFileOrDir(new File(str));
                        IOUtil.closeQuietly(processLockTryLock);
                        return zDeleteFileOrDir;
                    }
                } catch (Throwable th) {
                    th = th;
                    IOUtil.closeQuietly(processLockTryLock);
                    throw th;
                }
            }
            IOUtil.closeQuietly(processLockTryLock);
            return false;
        } catch (Throwable th2) {
            th = th2;
            processLockTryLock = null;
        }
    }

    public void clearCacheFiles() {
        IOUtil.deleteFileOrDir(this.d);
    }

    public DiskCacheFile createDiskCacheFile(DiskCacheEntity diskCacheEntity) throws FileLockedException {
        if (!this.b || diskCacheEntity == null) {
            return null;
        }
        diskCacheEntity.setPath(new File(this.d, MD5.md5(diskCacheEntity.getKey())).getAbsolutePath());
        String str = diskCacheEntity.getPath() + ".tmp";
        ProcessLock processLockTryLock = ProcessLock.tryLock(str, true);
        if (processLockTryLock == null || !processLockTryLock.isValid()) {
            throw new FileLockedException(diskCacheEntity.getPath());
        }
        DiskCacheFile diskCacheFile = new DiskCacheFile(str, diskCacheEntity, processLockTryLock);
        if (!diskCacheFile.getParentFile().exists()) {
            diskCacheFile.mkdirs();
        }
        return diskCacheFile;
    }

    public DiskCacheEntity get(String str) {
        DiskCacheEntity diskCacheEntity;
        if (!this.b || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            diskCacheEntity = (DiskCacheEntity) this.c.selector(DiskCacheEntity.class).where("key", "=", str).findFirst();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            diskCacheEntity = null;
        }
        if (diskCacheEntity != null) {
            if (diskCacheEntity.getExpires() < System.currentTimeMillis()) {
                return null;
            }
            this.f.execute(new a(diskCacheEntity));
        }
        return diskCacheEntity;
    }

    public DiskCacheFile getDiskCacheFile(String str) {
        DiskCacheEntity diskCacheEntity;
        ProcessLock processLockTryLock;
        if (!this.b || TextUtils.isEmpty(str) || (diskCacheEntity = get(str)) == null || !new File(diskCacheEntity.getPath()).exists() || (processLockTryLock = ProcessLock.tryLock(diskCacheEntity.getPath(), false, com.alipay.sdk.m.u.b.a)) == null || !processLockTryLock.isValid()) {
            return null;
        }
        DiskCacheFile diskCacheFile = new DiskCacheFile(diskCacheEntity.getPath(), diskCacheEntity, processLockTryLock);
        if (diskCacheFile.exists()) {
            return diskCacheFile;
        }
        try {
            this.c.delete(diskCacheEntity);
            return null;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return null;
        }
    }

    public void put(DiskCacheEntity diskCacheEntity) {
        if (!this.b || diskCacheEntity == null || TextUtils.isEmpty(diskCacheEntity.getTextContent()) || diskCacheEntity.getExpires() < System.currentTimeMillis()) {
            return;
        }
        try {
            this.c.replace(diskCacheEntity);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        this.f.execute(new lkxssdk.n0.a(this));
    }

    public LruDiskCache setMaxSize(long j) {
        if (j > 0) {
            long diskAvailableSize = FileUtil.getDiskAvailableSize();
            if (diskAvailableSize > j) {
                this.e = j;
            } else {
                this.e = diskAvailableSize;
            }
        }
        return this;
    }
}
