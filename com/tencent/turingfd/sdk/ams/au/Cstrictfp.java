package com.tencent.turingfd.sdk.ams.au;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.strictfp, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cstrictfp {
    public static final HashMap<String, Cdo> a = new HashMap<>();

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.strictfp$do, reason: invalid class name */
    public static final class Cdo {
        public final ReentrantReadWriteLock a = new ReentrantReadWriteLock();
        public final AtomicInteger b = new AtomicInteger(0);
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable, java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    public static boolean a(String str, byte[] bArr, boolean z) throws IOException {
        Cdo cdo;
        ?? r8;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        FileLock fileLockLock = null;
        if (z) {
            HashMap<String, Cdo> map = a;
            synchronized (map) {
                cdo = map.get(str);
                if (cdo == null) {
                    cdo = new Cdo();
                    map.put(str, cdo);
                }
                cdo.b.incrementAndGet();
            }
            cdo.a.writeLock().lock();
        } else {
            cdo = null;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                ?? channel = randomAccessFile.getChannel();
                if (z) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Throwable unused) {
                        fileLock = fileLockLock;
                        fileLockLock = channel;
                        FileLock fileLock2 = fileLockLock;
                        fileLockLock = fileLock;
                        r8 = fileLock2;
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        Auriga.a(r8);
                        Auriga.a(randomAccessFile);
                        if (cdo == null) {
                            return false;
                        }
                        HashMap<String, Cdo> map2 = a;
                        synchronized (map2) {
                            cdo.a.writeLock().unlock();
                            if (cdo.b.decrementAndGet() == 0) {
                                map2.remove(str);
                            }
                        }
                        return false;
                    }
                }
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                randomAccessFile.setLength(bArr.length);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused3) {
                    }
                }
                Auriga.a(channel);
                Auriga.a(randomAccessFile);
                if (cdo == null) {
                    return true;
                }
                HashMap<String, Cdo> map3 = a;
                synchronized (map3) {
                    cdo.a.writeLock().unlock();
                    if (cdo.b.decrementAndGet() == 0) {
                        map3.remove(str);
                    }
                }
                return true;
            } catch (Throwable unused4) {
                fileLock = null;
            }
        } catch (Throwable unused5) {
            r8 = 0;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r10, boolean r11) throws java.io.IOException {
        /*
            r0 = 0
            if (r11 == 0) goto L29
            java.util.HashMap<java.lang.String, com.tencent.turingfd.sdk.ams.au.strictfp$do> r1 = com.tencent.turingfd.sdk.ams.au.Cstrictfp.a
            monitor-enter(r1)
            java.lang.Object r2 = r1.get(r10)     // Catch: java.lang.Throwable -> L26
            com.tencent.turingfd.sdk.ams.au.strictfp$do r2 = (com.tencent.turingfd.sdk.ams.au.Cstrictfp.Cdo) r2     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L16
            com.tencent.turingfd.sdk.ams.au.strictfp$do r2 = new com.tencent.turingfd.sdk.ams.au.strictfp$do     // Catch: java.lang.Throwable -> L26
            r2.<init>()     // Catch: java.lang.Throwable -> L26
            r1.put(r10, r2)     // Catch: java.lang.Throwable -> L26
        L16:
            java.util.concurrent.atomic.AtomicInteger r3 = r2.b     // Catch: java.lang.Throwable -> L26
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L26
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L26
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r2.a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.lock()
            goto L2a
        L26:
            r10 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L26
            throw r10
        L29:
            r2 = r0
        L2a:
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "r"
            r1.<init>(r10, r3)     // Catch: java.lang.Throwable -> L98
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L48
            r5 = 0
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9 = 1
            r4 = r3
            java.nio.channels.FileLock r11 = r4.lock(r5, r7, r9)     // Catch: java.lang.Throwable -> L45
            goto L49
        L45:
            r11 = r0
            goto L9c
        L48:
            r11 = r0
        L49:
            long r4 = r1.length()     // Catch: java.lang.Throwable -> L92
            int r6 = (int) r4     // Catch: java.lang.Throwable -> L92
            long r7 = (long) r6     // Catch: java.lang.Throwable -> L92
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 != 0) goto L8a
            byte[] r4 = new byte[r6]     // Catch: java.lang.Throwable -> L92
            r1.readFully(r4)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L65
            boolean r0 = r11.isValid()
            if (r0 == 0) goto L65
            r11.release()     // Catch: java.io.IOException -> L64
            goto L65
        L64:
        L65:
            com.tencent.turingfd.sdk.ams.au.Auriga.a(r3)
            com.tencent.turingfd.sdk.ams.au.Auriga.a(r1)
            if (r2 == 0) goto L89
            java.util.HashMap<java.lang.String, com.tencent.turingfd.sdk.ams.au.strictfp$do> r11 = com.tencent.turingfd.sdk.ams.au.Cstrictfp.a
            monitor-enter(r11)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r2.a     // Catch: java.lang.Throwable -> L86
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()     // Catch: java.lang.Throwable -> L86
            r0.unlock()     // Catch: java.lang.Throwable -> L86
            java.util.concurrent.atomic.AtomicInteger r0 = r2.b     // Catch: java.lang.Throwable -> L86
            int r0 = r0.decrementAndGet()     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L84
            r11.remove(r10)     // Catch: java.lang.Throwable -> L86
        L84:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L86
            goto L89
        L86:
            r10 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L86
            throw r10
        L89:
            return r4
        L8a:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L92
            java.lang.String r5 = ""
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L92
            throw r4     // Catch: java.lang.Throwable -> L92
        L92:
            goto L9c
        L94:
            r11 = r0
            r3 = r11
            goto L9c
        L98:
            r11 = r0
            r1 = r11
            r3 = r1
        L9c:
            if (r11 == 0) goto La9
            boolean r4 = r11.isValid()
            if (r4 == 0) goto La9
            r11.release()     // Catch: java.io.IOException -> La8
            goto La9
        La8:
        La9:
            com.tencent.turingfd.sdk.ams.au.Auriga.a(r3)
            com.tencent.turingfd.sdk.ams.au.Auriga.a(r1)
            if (r2 == 0) goto Lcd
            java.util.HashMap<java.lang.String, com.tencent.turingfd.sdk.ams.au.strictfp$do> r11 = com.tencent.turingfd.sdk.ams.au.Cstrictfp.a
            monitor-enter(r11)
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r2.a     // Catch: java.lang.Throwable -> Lca
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch: java.lang.Throwable -> Lca
            r1.unlock()     // Catch: java.lang.Throwable -> Lca
            java.util.concurrent.atomic.AtomicInteger r1 = r2.b     // Catch: java.lang.Throwable -> Lca
            int r1 = r1.decrementAndGet()     // Catch: java.lang.Throwable -> Lca
            if (r1 != 0) goto Lc8
            r11.remove(r10)     // Catch: java.lang.Throwable -> Lca
        Lc8:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lca
            goto Lcd
        Lca:
            r10 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lca
            throw r10
        Lcd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cstrictfp.a(java.lang.String, boolean):byte[]");
    }

    public static byte[] a(String str, int i) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i];
                int i2 = 0;
                do {
                    int i3 = fileInputStream.read(bArr, i2, i - i2);
                    if (i3 == -1) {
                        break;
                    }
                    i2 += i3;
                } while (i2 < i);
                if (i2 == 0) {
                    Auriga.a(fileInputStream);
                    return null;
                }
                if (i2 < i) {
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    bArr = bArr2;
                }
                Auriga.a(fileInputStream);
                return bArr;
            } catch (Throwable unused) {
                Auriga.a(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static byte[] a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            Auriga.a(fileInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                byteArray = "".getBytes();
            }
            return byteArray;
        } catch (Throwable th4) {
            th = th4;
            try {
                throw th;
            } finally {
                Auriga.a(fileInputStream);
                Auriga.a(byteArrayOutputStream);
            }
        }
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            try {
                return file.delete();
            } catch (Throwable unused) {
                return false;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        try {
            return file.delete();
        } catch (Throwable unused2) {
            return false;
        }
    }
}
