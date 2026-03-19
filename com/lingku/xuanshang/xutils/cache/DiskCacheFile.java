package com.lingku.xuanshang.xutils.cache;

import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.ProcessLock;
import java.io.Closeable;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DiskCacheFile extends File implements Closeable {
    public final DiskCacheEntity a;
    public final ProcessLock b;

    public DiskCacheFile(String str, DiskCacheEntity diskCacheEntity, ProcessLock processLock) {
        super(str);
        this.a = diskCacheEntity;
        this.b = processLock;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtil.closeQuietly(this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.lingku.xuanshang.xutils.cache.DiskCacheFile commit() throws java.lang.Throwable {
        /*
            r7 = this;
            com.lingku.xuanshang.xutils.cache.LruDiskCache r0 = r7.getDiskCache()
            boolean r1 = r0.b
            if (r1 == 0) goto Laf
            com.lingku.xuanshang.xutils.cache.DiskCacheEntity r1 = r7.getCacheEntity()
            java.lang.String r2 = r7.getName()
            java.lang.String r3 = ".tmp"
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto Laf
            r2 = 0
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L85 java.lang.InterruptedException -> L89
            r4 = 1
            r5 = 3000(0xbb8, double:1.482E-320)
            com.lingku.xuanshang.xutils.common.util.ProcessLock r4 = com.lingku.xuanshang.xutils.common.util.ProcessLock.tryLock(r3, r4, r5)     // Catch: java.lang.Throwable -> L85 java.lang.InterruptedException -> L89
            if (r4 == 0) goto L7b
            boolean r5 = r4.isValid()     // Catch: java.lang.Throwable -> L81 java.lang.InterruptedException -> L83
            if (r5 == 0) goto L7b
            com.lingku.xuanshang.xutils.cache.DiskCacheFile r5 = new com.lingku.xuanshang.xutils.cache.DiskCacheFile     // Catch: java.lang.Throwable -> L81 java.lang.InterruptedException -> L83
            r5.<init>(r3, r1, r4)     // Catch: java.lang.Throwable -> L81 java.lang.InterruptedException -> L83
            boolean r3 = r7.renameTo(r5)     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            if (r3 == 0) goto L59
            com.lingku.xuanshang.xutils.DbManager r2 = r0.c     // Catch: java.lang.Throwable -> L3d
            r2.replace(r1)     // Catch: java.lang.Throwable -> L3d
            goto L45
        L3d:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L78
            com.lingku.xuanshang.xutils.common.util.LogUtil.e(r2, r1)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L78
        L45:
            java.util.concurrent.Executor r1 = r0.f     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L78
            lkxssdk.n0.a r2 = new lkxssdk.n0.a     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L78
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L78
            r1.execute(r2)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L78
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r7)
            com.lingku.xuanshang.xutils.common.util.IOUtil.deleteFileOrDir(r7)
            goto Lb0
        L56:
            r0 = move-exception
            r2 = r5
            goto L9c
        L59:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            r1.<init>()     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            java.lang.String r3 = "rename:"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            java.lang.String r3 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
            throw r0     // Catch: java.lang.Throwable -> L76 java.lang.InterruptedException -> L78
        L76:
            r0 = move-exception
            goto L9c
        L78:
            r0 = move-exception
            r2 = r5
            goto L8b
        L7b:
            com.lingku.xuanshang.xutils.ex.FileLockedException r0 = new com.lingku.xuanshang.xutils.ex.FileLockedException     // Catch: java.lang.Throwable -> L81 java.lang.InterruptedException -> L83
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L81 java.lang.InterruptedException -> L83
            throw r0     // Catch: java.lang.Throwable -> L81 java.lang.InterruptedException -> L83
        L81:
            r0 = move-exception
            goto L87
        L83:
            r0 = move-exception
            goto L8b
        L85:
            r0 = move-exception
            r4 = r2
        L87:
            r5 = r2
            goto L9c
        L89:
            r0 = move-exception
            r4 = r2
        L8b:
            java.lang.String r1 = r0.getMessage()     // Catch: java.lang.Throwable -> L99
            com.lingku.xuanshang.xutils.common.util.LogUtil.e(r1, r0)     // Catch: java.lang.Throwable -> L99
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r7)
            com.lingku.xuanshang.xutils.common.util.IOUtil.deleteFileOrDir(r7)
            goto Laf
        L99:
            r0 = move-exception
            r5 = r2
            r2 = r7
        L9c:
            if (r2 != 0) goto La8
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r5)
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r4)
            com.lingku.xuanshang.xutils.common.util.IOUtil.deleteFileOrDir(r5)
            goto Lae
        La8:
            com.lingku.xuanshang.xutils.common.util.IOUtil.closeQuietly(r7)
            com.lingku.xuanshang.xutils.common.util.IOUtil.deleteFileOrDir(r7)
        Lae:
            throw r0
        Laf:
            r5 = r7
        Lb0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.xutils.cache.DiskCacheFile.commit():com.lingku.xuanshang.xutils.cache.DiskCacheFile");
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public DiskCacheEntity getCacheEntity() {
        return this.a;
    }

    public LruDiskCache getDiskCache() {
        return LruDiskCache.getDiskCache(getParentFile().getName());
    }
}
