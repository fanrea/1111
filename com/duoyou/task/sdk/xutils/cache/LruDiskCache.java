package com.duoyou.task.sdk.xutils.cache;

import android.text.TextUtils;
import com.alipay.sdk.m.u.b;
import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.common.task.PriorityExecutor;
import com.duoyou.task.sdk.xutils.common.util.FileUtil;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.common.util.MD5;
import com.duoyou.task.sdk.xutils.common.util.ProcessLock;
import com.duoyou.task.sdk.xutils.config.DbConfigs;
import com.duoyou.task.sdk.xutils.db.sqlite.WhereBuilder;
import com.duoyou.task.sdk.xutils.ex.FileLockedException;
import com.duoyou.task.sdk.xutils.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class LruDiskCache {
    private static final String CACHE_DIR_NAME = "xUtils_cache";
    private static final HashMap<String, LruDiskCache> DISK_CACHE_MAP = new HashMap<>(5);
    private static final int LIMIT_COUNT = 5000;
    private static final long LIMIT_SIZE = 104857600;
    private static final int LOCK_WAIT = 3000;
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private static final long TRIM_TIME_SPAN = 1000;
    private boolean available;
    private DbManager cacheDb;
    private File cacheDir;
    private long diskCacheSize = LIMIT_SIZE;
    private final Executor trimExecutor = new PriorityExecutor(1, true);
    private long lastTrimTime = 0;

    public static synchronized LruDiskCache getDiskCache(String str) {
        LruDiskCache lruDiskCache;
        if (TextUtils.isEmpty(str)) {
            str = CACHE_DIR_NAME;
        }
        HashMap<String, LruDiskCache> map = DISK_CACHE_MAP;
        lruDiskCache = map.get(str);
        if (lruDiskCache == null) {
            lruDiskCache = new LruDiskCache(str);
            map.put(str, lruDiskCache);
        }
        return lruDiskCache;
    }

    private LruDiskCache(String str) {
        this.available = false;
        try {
            File cacheDir = FileUtil.getCacheDir(str);
            this.cacheDir = cacheDir;
            if (cacheDir != null && (cacheDir.exists() || this.cacheDir.mkdirs())) {
                this.available = true;
            }
            this.cacheDb = x.getDb(DbConfigs.HTTP.getConfig());
        } catch (Throwable th) {
            this.available = false;
            LogUtil.e(th.getMessage(), th);
        }
        deleteNoIndexFiles();
    }

    public LruDiskCache setMaxSize(long j) {
        if (j > 0) {
            long diskAvailableSize = FileUtil.getDiskAvailableSize();
            if (diskAvailableSize > j) {
                this.diskCacheSize = j;
            } else {
                this.diskCacheSize = diskAvailableSize;
            }
        }
        return this;
    }

    public DiskCacheEntity get(String str) {
        final DiskCacheEntity diskCacheEntity;
        if (!this.available || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            diskCacheEntity = (DiskCacheEntity) this.cacheDb.selector(DiskCacheEntity.class).where("key", "=", str).findFirst();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            diskCacheEntity = null;
        }
        if (diskCacheEntity != null) {
            if (diskCacheEntity.getExpires() < System.currentTimeMillis()) {
                return null;
            }
            this.trimExecutor.execute(new Runnable() { // from class: com.duoyou.task.sdk.xutils.cache.LruDiskCache.1
                @Override // java.lang.Runnable
                public void run() {
                    DiskCacheEntity diskCacheEntity2 = diskCacheEntity;
                    diskCacheEntity2.setHits(diskCacheEntity2.getHits() + 1);
                    diskCacheEntity.setLastAccess(System.currentTimeMillis());
                    try {
                        LruDiskCache.this.cacheDb.update(diskCacheEntity, "hits", "lastAccess");
                    } catch (Throwable th2) {
                        LogUtil.e(th2.getMessage(), th2);
                    }
                }
            });
        }
        return diskCacheEntity;
    }

    public void put(DiskCacheEntity diskCacheEntity) {
        if (!this.available || diskCacheEntity == null || TextUtils.isEmpty(diskCacheEntity.getTextContent()) || diskCacheEntity.getExpires() < System.currentTimeMillis()) {
            return;
        }
        try {
            this.cacheDb.replace(diskCacheEntity);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        trimSize();
    }

    public DiskCacheFile getDiskCacheFile(String str) {
        DiskCacheEntity diskCacheEntity;
        ProcessLock processLockTryLock;
        if (!this.available || TextUtils.isEmpty(str) || (diskCacheEntity = get(str)) == null || !new File(diskCacheEntity.getPath()).exists() || (processLockTryLock = ProcessLock.tryLock(diskCacheEntity.getPath(), false, b.a)) == null || !processLockTryLock.isValid()) {
            return null;
        }
        DiskCacheFile diskCacheFile = new DiskCacheFile(diskCacheEntity.getPath(), diskCacheEntity, processLockTryLock);
        if (diskCacheFile.exists()) {
            return diskCacheFile;
        }
        try {
            this.cacheDb.delete(diskCacheEntity);
            return null;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return null;
        }
    }

    public DiskCacheFile createDiskCacheFile(DiskCacheEntity diskCacheEntity) throws FileLockedException {
        if (!this.available || diskCacheEntity == null) {
            return null;
        }
        diskCacheEntity.setPath(new File(this.cacheDir, MD5.md5(diskCacheEntity.getKey())).getAbsolutePath());
        String str = diskCacheEntity.getPath() + ".tmp";
        ProcessLock processLockTryLock = ProcessLock.tryLock(str, true);
        if (processLockTryLock != null && processLockTryLock.isValid()) {
            DiskCacheFile diskCacheFile = new DiskCacheFile(str, diskCacheEntity, processLockTryLock);
            if (!diskCacheFile.getParentFile().exists()) {
                diskCacheFile.mkdirs();
            }
            return diskCacheFile;
        }
        throw new FileLockedException(diskCacheEntity.getPath());
    }

    public void clearCacheFiles() {
        IOUtil.deleteFileOrDir(this.cacheDir);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.duoyou.task.sdk.xutils.common.util.ProcessLock] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.duoyou.task.sdk.xutils.cache.DiskCacheFile commitDiskCacheFile(com.duoyou.task.sdk.xutils.cache.DiskCacheFile r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r6.available
            if (r0 == 0) goto La6
            if (r7 != 0) goto L8
            goto La6
        L8:
            com.duoyou.task.sdk.xutils.cache.DiskCacheEntity r0 = r7.getCacheEntity()
            java.lang.String r1 = r7.getName()
            java.lang.String r2 = ".tmp"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto La6
            r1 = 0
            java.lang.String r2 = r0.getPath()     // Catch: java.lang.Throwable -> L7a java.lang.InterruptedException -> L7e
            r3 = 1
            r4 = 3000(0xbb8, double:1.482E-320)
            com.duoyou.task.sdk.xutils.common.util.ProcessLock r3 = com.duoyou.task.sdk.xutils.common.util.ProcessLock.tryLock(r2, r3, r4)     // Catch: java.lang.Throwable -> L7a java.lang.InterruptedException -> L7e
            if (r3 == 0) goto L6d
            boolean r4 = r3.isValid()     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L76
            if (r4 == 0) goto L6d
            com.duoyou.task.sdk.xutils.cache.DiskCacheFile r4 = new com.duoyou.task.sdk.xutils.cache.DiskCacheFile     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L76
            r4.<init>(r2, r0, r3)     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L76
            boolean r2 = r7.renameTo(r4)     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            if (r2 == 0) goto L4c
            com.duoyou.task.sdk.xutils.DbManager r1 = r6.cacheDb     // Catch: java.lang.Throwable -> L3d
            r1.replace(r0)     // Catch: java.lang.Throwable -> L3d
            goto L45
        L3d:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()     // Catch: java.lang.Throwable -> L49 java.lang.InterruptedException -> L6b
            com.duoyou.task.sdk.xutils.common.util.LogUtil.e(r1, r0)     // Catch: java.lang.Throwable -> L49 java.lang.InterruptedException -> L6b
        L45:
            r6.trimSize()     // Catch: java.lang.Throwable -> L49 java.lang.InterruptedException -> L6b
            goto L88
        L49:
            r0 = move-exception
            r1 = r4
            goto L93
        L4c:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            r2.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            java.lang.String r5 = "rename:"
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            java.lang.String r5 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
            throw r0     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6b
        L69:
            r0 = move-exception
            goto L93
        L6b:
            r0 = move-exception
            goto L78
        L6d:
            com.duoyou.task.sdk.xutils.ex.FileLockedException r0 = new com.duoyou.task.sdk.xutils.ex.FileLockedException     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L76
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L76
            throw r0     // Catch: java.lang.Throwable -> L73 java.lang.InterruptedException -> L76
        L73:
            r0 = move-exception
            r4 = r1
            goto L93
        L76:
            r0 = move-exception
            r4 = r1
        L78:
            r1 = r3
            goto L80
        L7a:
            r0 = move-exception
            r3 = r1
            r4 = r3
            goto L93
        L7e:
            r0 = move-exception
            r4 = r1
        L80:
            java.lang.String r2 = r0.getMessage()     // Catch: java.lang.Throwable -> L90
            com.duoyou.task.sdk.xutils.common.util.LogUtil.e(r2, r0)     // Catch: java.lang.Throwable -> L90
            r4 = r7
        L88:
            com.duoyou.task.sdk.xutils.common.util.IOUtil.closeQuietly(r7)
            com.duoyou.task.sdk.xutils.common.util.IOUtil.deleteFileOrDir(r7)
            r7 = r4
            goto La6
        L90:
            r0 = move-exception
            r3 = r1
            r1 = r7
        L93:
            if (r1 != 0) goto L9f
            com.duoyou.task.sdk.xutils.common.util.IOUtil.closeQuietly(r4)
            com.duoyou.task.sdk.xutils.common.util.IOUtil.closeQuietly(r3)
            com.duoyou.task.sdk.xutils.common.util.IOUtil.deleteFileOrDir(r4)
            goto La5
        L9f:
            com.duoyou.task.sdk.xutils.common.util.IOUtil.closeQuietly(r7)
            com.duoyou.task.sdk.xutils.common.util.IOUtil.deleteFileOrDir(r7)
        La5:
            throw r0
        La6:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duoyou.task.sdk.xutils.cache.LruDiskCache.commitDiskCacheFile(com.duoyou.task.sdk.xutils.cache.DiskCacheFile):com.duoyou.task.sdk.xutils.cache.DiskCacheFile");
    }

    private void trimSize() {
        this.trimExecutor.execute(new Runnable() { // from class: com.duoyou.task.sdk.xutils.cache.LruDiskCache.2
            @Override // java.lang.Runnable
            public void run() {
                List<DiskCacheEntity> listFindAll;
                if (LruDiskCache.this.available) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - LruDiskCache.this.lastTrimTime < 1000) {
                        return;
                    }
                    LruDiskCache.this.lastTrimTime = jCurrentTimeMillis;
                    LruDiskCache.this.deleteExpiry();
                    try {
                        int iCount = (int) LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).count();
                        if (iCount > 5010 && (listFindAll = LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).orderBy("lastAccess").orderBy("hits").limit(iCount - 5000).offset(0).findAll()) != null && listFindAll.size() > 0) {
                            for (DiskCacheEntity diskCacheEntity : listFindAll) {
                                try {
                                    LruDiskCache.this.cacheDb.delete(diskCacheEntity);
                                    String path = diskCacheEntity.getPath();
                                    if (!TextUtils.isEmpty(path)) {
                                        LruDiskCache.this.deleteFileWithLock(path);
                                        LruDiskCache.this.deleteFileWithLock(path + ".tmp");
                                    }
                                } catch (Throwable th) {
                                    LogUtil.e(th.getMessage(), th);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        LogUtil.e(th2.getMessage(), th2);
                    }
                    while (FileUtil.getFileOrDirSize(LruDiskCache.this.cacheDir) > LruDiskCache.this.diskCacheSize) {
                        try {
                            List<DiskCacheEntity> listFindAll2 = LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).orderBy("lastAccess").orderBy("hits").limit(10).offset(0).findAll();
                            if (listFindAll2 != null && listFindAll2.size() > 0) {
                                for (DiskCacheEntity diskCacheEntity2 : listFindAll2) {
                                    try {
                                        LruDiskCache.this.cacheDb.delete(diskCacheEntity2);
                                        String path2 = diskCacheEntity2.getPath();
                                        if (!TextUtils.isEmpty(path2)) {
                                            LruDiskCache.this.deleteFileWithLock(path2);
                                            LruDiskCache.this.deleteFileWithLock(path2 + ".tmp");
                                        }
                                    } catch (Throwable th3) {
                                        LogUtil.e(th3.getMessage(), th3);
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            LogUtil.e(th4.getMessage(), th4);
                            return;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteExpiry() {
        if (this.available) {
            try {
                WhereBuilder whereBuilderB = WhereBuilder.b("expires", "<", Long.valueOf(System.currentTimeMillis()));
                List listFindAll = this.cacheDb.selector(DiskCacheEntity.class).where(whereBuilderB).findAll();
                this.cacheDb.delete(DiskCacheEntity.class, whereBuilderB);
                if (listFindAll == null || listFindAll.size() <= 0) {
                    return;
                }
                Iterator it = listFindAll.iterator();
                while (it.hasNext()) {
                    String path = ((DiskCacheEntity) it.next()).getPath();
                    if (!TextUtils.isEmpty(path)) {
                        deleteFileWithLock(path);
                    }
                }
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
    }

    private void deleteNoIndexFiles() {
        this.trimExecutor.execute(new Runnable() { // from class: com.duoyou.task.sdk.xutils.cache.LruDiskCache.3
            @Override // java.lang.Runnable
            public void run() {
                if (LruDiskCache.this.available) {
                    try {
                        File[] fileArrListFiles = LruDiskCache.this.cacheDir.listFiles();
                        if (fileArrListFiles != null) {
                            for (File file : fileArrListFiles) {
                                try {
                                    if (LruDiskCache.this.cacheDb.selector(DiskCacheEntity.class).where("path", "=", file.getAbsolutePath()).count() < 1) {
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteFileWithLock(String str) throws Throwable {
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
}
