package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cherry {
    public static final HashMap<String, Cif> a = new HashMap<>();
    public static final Object b;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Cherry$do, reason: invalid class name */
    public class Cdo implements Runnable {
        public final /* synthetic */ Cif a;

        public Cdo(Cif cif) {
            this.a = cif;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            FileChannel channel;
            RandomAccessFile randomAccessFile;
            System.currentTimeMillis();
            String string = this.a.toString();
            synchronized (Ccase.class) {
                context = Ccase.a;
            }
            File file = new File(context.getDir("turingfd", 0), Ginkgo.f);
            int length = string.length();
            synchronized (Cherry.b) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FileLock fileLockLock = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        channel = randomAccessFile.getChannel();
                    } catch (Throwable unused) {
                        channel = null;
                    }
                } catch (Throwable unused2) {
                    channel = null;
                    randomAccessFile = null;
                }
                try {
                    fileLockLock = channel.lock();
                    if (randomAccessFile.length() != 0) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
                        while (true) {
                            int i = channel.read(byteBufferAllocate);
                            if (i <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(byteBufferAllocate.array(), 0, i);
                            byteBufferAllocate.clear();
                        }
                        string = byteArrayOutputStream + "," + string;
                        if (string.length() > (length + 1) * 50) {
                            string = string.substring(string.indexOf(",") + 1);
                        }
                    }
                    channel.position(0L);
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(string.getBytes());
                    while (byteBufferWrap.hasRemaining()) {
                        channel.write(byteBufferWrap);
                    }
                    channel.truncate(byteBufferWrap.position());
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    Auriga.a(channel);
                } catch (Throwable unused4) {
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused5) {
                        }
                    }
                    Auriga.a(channel);
                    Auriga.a(randomAccessFile);
                }
                Auriga.a(randomAccessFile);
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Cherry$if, reason: invalid class name */
    public static final class Cif {
        public final long a;
        public final String b;

        public Cif(long j, String str) {
            this.a = j;
            this.b = str;
        }

        public String toString() {
            return this.a + ":" + this.b;
        }
    }

    static {
        new AtomicBoolean(false);
        b = new Object();
        new AtomicReference();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(long j, String str) {
        long j2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Cif cif = new Cif(j, str);
        byte[] bytes = str.getBytes();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        int length = bytes.length;
        long j3 = length * (-4132994306676758123L);
        for (int i = 0; i < (length >> 3); i++) {
            int i2 = i << 3;
            long j4 = ((byteBufferWrap.get(i2) & 255) + ((byteBufferWrap.get(i2 + 1) & 255) << 8) + ((byteBufferWrap.get(i2 + 2) & 255) << 16) + ((byteBufferWrap.get(i2 + 3) & 255) << 24) + ((byteBufferWrap.get(i2 + 4) & 255) << 32) + ((byteBufferWrap.get(i2 + 5) & 255) << 40) + ((byteBufferWrap.get(i2 + 6) & 255) << 48) + ((byteBufferWrap.get(i2 + 7) & 255) << 56)) * (-4132994306676758123L);
            j3 = (j3 ^ ((j4 ^ (j4 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        switch (length & 7) {
            case 1:
                long j5 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j5 * (-4132994306676758123L);
                break;
            case 2:
                j3 ^= byteBufferWrap.get((length - r5) + 1) << 8;
                long j52 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j52 * (-4132994306676758123L);
                break;
            case 3:
                j3 ^= byteBufferWrap.get((length - r5) + 2) << 16;
                j3 ^= byteBufferWrap.get((length - r5) + 1) << 8;
                long j522 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j522 * (-4132994306676758123L);
                break;
            case 4:
                j3 ^= byteBufferWrap.get((length - r5) + 3) << 24;
                j3 ^= byteBufferWrap.get((length - r5) + 2) << 16;
                j3 ^= byteBufferWrap.get((length - r5) + 1) << 8;
                long j5222 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j5222 * (-4132994306676758123L);
                break;
            case 5:
                j3 ^= byteBufferWrap.get((length - r5) + 4) << 32;
                j3 ^= byteBufferWrap.get((length - r5) + 3) << 24;
                j3 ^= byteBufferWrap.get((length - r5) + 2) << 16;
                j3 ^= byteBufferWrap.get((length - r5) + 1) << 8;
                long j52222 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j52222 * (-4132994306676758123L);
                break;
            case 6:
                j3 ^= byteBufferWrap.get((length - r5) + 5) << 40;
                j3 ^= byteBufferWrap.get((length - r5) + 4) << 32;
                j3 ^= byteBufferWrap.get((length - r5) + 3) << 24;
                j3 ^= byteBufferWrap.get((length - r5) + 2) << 16;
                j3 ^= byteBufferWrap.get((length - r5) + 1) << 8;
                long j522222 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j522222 * (-4132994306676758123L);
                break;
            case 7:
                j3 ^= byteBufferWrap.get((length - r5) + 6) << 48;
                j3 ^= byteBufferWrap.get((length - r5) + 5) << 40;
                j3 ^= byteBufferWrap.get((length - r5) + 4) << 32;
                j3 ^= byteBufferWrap.get((length - r5) + 3) << 24;
                j3 ^= byteBufferWrap.get((length - r5) + 2) << 16;
                j3 ^= byteBufferWrap.get((length - r5) + 1) << 8;
                long j5222222 = byteBufferWrap.get(length - r5) ^ j3;
                j2 = -4132994306676758123L;
                j3 = j5222222 * (-4132994306676758123L);
                break;
            default:
                j2 = -4132994306676758123L;
                break;
        }
        long j6 = (j3 ^ (j3 >>> 47)) * j2;
        String strValueOf = String.valueOf((j6 >>> 47) ^ j6);
        HashMap<String, Cif> map = a;
        synchronized (map) {
            map.put(strValueOf, cif);
        }
        Cpackage.a.submit(new Cdo(cif));
    }
}
