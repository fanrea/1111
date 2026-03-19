package com.lingku.xuanshang.xutils.common.util;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.lingku.xuanshang.xutils.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ProcessLock implements Closeable {
    public static final DoubleKeyValueMap<String, Integer, ProcessLock> a = new DoubleKeyValueMap<>();
    public static final DecimalFormat b;
    public final String c;
    public final FileLock d;
    public final File e;
    public final Closeable f;
    public final boolean g;

    static {
        IOUtil.deleteFileOrDir(x.app().getDir("process_lock", 0));
        b = new DecimalFormat("0.##################");
    }

    public ProcessLock(String str, File file, FileLock fileLock, Closeable closeable, boolean z) {
        this.c = str;
        this.d = fileLock;
        this.e = file;
        this.f = closeable;
        this.g = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ProcessLock a(String str, String str2, boolean z) {
        Throwable th;
        FileInputStream fileInputStream;
        FileChannel channel;
        DoubleKeyValueMap<String, Integer, ProcessLock> doubleKeyValueMap = a;
        synchronized (doubleKeyValueMap) {
            ConcurrentHashMap<Integer, ProcessLock> concurrentHashMap = doubleKeyValueMap.get(str);
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                Iterator<Map.Entry<Integer, ProcessLock>> it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    ProcessLock value = it.next().getValue();
                    if (value == null || !value.isValid()) {
                        it.remove();
                    } else {
                        if (z) {
                            return null;
                        }
                        if (value.g) {
                            return null;
                        }
                    }
                }
            }
            try {
                boolean z2 = false;
                File file = new File(x.app().getDir("process_lock", 0), str2);
                if (file.exists() || file.createNewFile()) {
                    if (z) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                        channel = fileOutputStream.getChannel();
                        fileInputStream = fileOutputStream;
                    } else {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        channel = fileInputStream2.getChannel();
                        fileInputStream = fileInputStream2;
                    }
                    try {
                        if (channel == null) {
                            throw new IOException("can not get file channel:" + file.getAbsolutePath());
                        }
                        FileLock fileLockTryLock = channel.tryLock(0L, LocationRequestCompat.PASSIVE_INTERVAL, !z);
                        if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                            z2 = true;
                        }
                        if (z2) {
                            ProcessLock processLock = new ProcessLock(str, file, fileLockTryLock, fileInputStream, z);
                            a.put(str, Integer.valueOf(fileLockTryLock.hashCode()), processLock);
                            return processLock;
                        }
                        a(str, fileLockTryLock, file, fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        LogUtil.d("tryLock: " + str + ", " + th.getMessage());
                        IOUtil.closeQuietly(fileInputStream);
                        IOUtil.closeQuietly(channel);
                        a.notifyAll();
                        return null;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                channel = null;
            }
            a.notifyAll();
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        double d = 0.0d;
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length(); i++) {
            d = ((d * 255.0d) + bytes[i]) * 0.005d;
        }
        return b.format(d);
    }

    public static void a(String str, FileLock fileLock, File file, Closeable closeable) {
        DoubleKeyValueMap<String, Integer, ProcessLock> doubleKeyValueMap = a;
        synchronized (doubleKeyValueMap) {
            if (fileLock != null) {
                try {
                    doubleKeyValueMap.remove(str, Integer.valueOf(fileLock.hashCode()));
                    ConcurrentHashMap<Integer, ProcessLock> concurrentHashMap = doubleKeyValueMap.get(str);
                    if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                        IOUtil.deleteFileOrDir(file);
                    }
                    if (fileLock.channel().isOpen()) {
                        fileLock.release();
                    }
                } finally {
                    try {
                        IOUtil.closeQuietly(fileLock.channel());
                    } catch (Throwable th) {
                    }
                }
                IOUtil.closeQuietly(fileLock.channel());
            }
            IOUtil.closeQuietly(closeable);
            a.notifyAll();
        }
    }

    public static ProcessLock tryLock(String str, boolean z) {
        return a(str, a(str), z);
    }

    public static ProcessLock tryLock(String str, boolean z, long j) {
        ProcessLock processLockA;
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        String strA = a(str);
        synchronized (a) {
            processLockA = null;
            while (System.currentTimeMillis() < jCurrentTimeMillis && (processLockA = a(str, strA, z)) == null) {
                try {
                    a.wait(10L);
                } catch (InterruptedException e) {
                    throw e;
                } catch (Throwable unused) {
                }
            }
        }
        return processLockA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release();
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public boolean isValid() {
        FileLock fileLock = this.d;
        return fileLock != null && fileLock.isValid();
    }

    public void release() {
        a(this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return this.c + ": " + this.e.getName();
    }
}
