package com.duoyou.task.sdk.xutils.common.util;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.duoyou.task.sdk.xutils.x;
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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ProcessLock implements Closeable {
    private static final DecimalFormat FORMAT;
    private static final String LOCK_FILE_DIR = "process_lock";
    private static final DoubleKeyValueMap<String, Integer, ProcessLock> LOCK_MAP = new DoubleKeyValueMap<>();
    private final File mFile;
    private final FileLock mFileLock;
    private final String mLockName;
    private final Closeable mStream;
    private final boolean mWriteMode;

    static {
        IOUtil.deleteFileOrDir(x.app().getDir(LOCK_FILE_DIR, 0));
        FORMAT = new DecimalFormat("0.##################");
    }

    private ProcessLock(String str, File file, FileLock fileLock, Closeable closeable, boolean z) {
        this.mLockName = str;
        this.mFileLock = fileLock;
        this.mFile = file;
        this.mStream = closeable;
        this.mWriteMode = z;
    }

    public static ProcessLock tryLock(String str, boolean z) {
        return tryLockInternal(str, customHash(str), z);
    }

    public static ProcessLock tryLock(String str, boolean z, long j) {
        ProcessLock processLockTryLockInternal;
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        String strCustomHash = customHash(str);
        synchronized (LOCK_MAP) {
            processLockTryLockInternal = null;
            while (System.currentTimeMillis() < jCurrentTimeMillis && (processLockTryLockInternal = tryLockInternal(str, strCustomHash, z)) == null) {
                try {
                    LOCK_MAP.wait(10L);
                } catch (InterruptedException e) {
                    throw e;
                } catch (Throwable unused) {
                }
            }
        }
        return processLockTryLockInternal;
    }

    public boolean isValid() {
        return isValid(this.mFileLock);
    }

    public void release() {
        release(this.mLockName, this.mFileLock, this.mFile, this.mStream);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release();
    }

    private static boolean isValid(FileLock fileLock) {
        return fileLock != null && fileLock.isValid();
    }

    private static void release(String str, FileLock fileLock, File file, Closeable closeable) {
        DoubleKeyValueMap<String, Integer, ProcessLock> doubleKeyValueMap = LOCK_MAP;
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
            LOCK_MAP.notifyAll();
        }
    }

    private static String customHash(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        double d = 0.0d;
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length(); i++) {
            d = ((d * 255.0d) + bytes[i]) * 0.005d;
        }
        return FORMAT.format(d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ProcessLock tryLockInternal(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        FileChannel channel;
        FileInputStream fileInputStream2;
        DoubleKeyValueMap<String, Integer, ProcessLock> doubleKeyValueMap = LOCK_MAP;
        synchronized (doubleKeyValueMap) {
            ConcurrentHashMap<Integer, ProcessLock> concurrentHashMap = doubleKeyValueMap.get(str);
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                Iterator<Map.Entry<Integer, ProcessLock>> it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    ProcessLock value = it.next().getValue();
                    if (value != null) {
                        if (!value.isValid()) {
                            it.remove();
                        } else {
                            if (z) {
                                return null;
                            }
                            if (value.mWriteMode) {
                                return null;
                            }
                        }
                    } else {
                        it.remove();
                    }
                }
            }
            try {
                File file = new File(x.app().getDir(LOCK_FILE_DIR, 0), str2);
                if (file.exists() || file.createNewFile()) {
                    if (z) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                        channel = fileOutputStream.getChannel();
                        fileInputStream2 = fileOutputStream;
                    } else {
                        FileInputStream fileInputStream3 = new FileInputStream(file);
                        channel = fileInputStream3.getChannel();
                        fileInputStream2 = fileInputStream3;
                    }
                    try {
                        if (channel != null) {
                            FileLock fileLockTryLock = channel.tryLock(0L, LocationRequestCompat.PASSIVE_INTERVAL, !z);
                            if (isValid(fileLockTryLock)) {
                                ProcessLock processLock = new ProcessLock(str, file, fileLockTryLock, fileInputStream2, z);
                                LOCK_MAP.put(str, Integer.valueOf(fileLockTryLock.hashCode()), processLock);
                                return processLock;
                            }
                            release(str, fileLockTryLock, file, fileInputStream2);
                        } else {
                            throw new IOException("can not get file channel:" + file.getAbsolutePath());
                        }
                    } catch (Throwable th) {
                        fileInputStream = fileInputStream2;
                        th = th;
                        LogUtil.d("tryLock: " + str + ", " + th.getMessage());
                        IOUtil.closeQuietly(fileInputStream);
                        IOUtil.closeQuietly(channel);
                        LOCK_MAP.notifyAll();
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                channel = null;
            }
            LOCK_MAP.notifyAll();
            return null;
        }
    }

    public String toString() {
        return this.mLockName + ": " + this.mFile.getName();
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }
}
