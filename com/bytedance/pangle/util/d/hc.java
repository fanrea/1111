package com.bytedance.pangle.util.d;

import android.util.Pair;
import com.bytedance.pangle.util.an;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static String d = "";

    public static String[] d(File file) {
        String str;
        String strD = "";
        try {
            ByteBuffer byteBufferHc = hc(file);
            if (d(byteBufferHc)) {
                strD = an.d(byteBufferHc.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = strD;
        }
        return new String[]{strD, d, str};
    }

    private static ByteBuffer hc(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Pair<ByteBuffer, Long> pairD = d(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) pairD.first;
            long jLongValue = ((Long) pairD.second).longValue();
            if (b.d(randomAccessFile, jLongValue)) {
                throw new Exception("ZIP64 APK not supported");
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) d(randomAccessFile, d(byteBuffer, jLongValue)).first;
            randomAccessFile.close();
            return byteBuffer2;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> pairD = b.d(randomAccessFile);
        if (pairD != null) {
            return pairD;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long d(ByteBuffer byteBuffer, long j) throws Exception {
        long jD = b.d(byteBuffer);
        if (jD > j) {
            throw new Exception("ZIP Central Directory offset out of range: " + jD + ". ZIP End of Central Directory offset: " + j);
        }
        if (b.hc(byteBuffer) + jD == j) {
            return jD;
        }
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, long j) throws Exception {
        if (j < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - byteBufferAllocate.capacity());
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - i;
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    private static boolean d(ByteBuffer byteBuffer) throws Exception {
        hc(byteBuffer);
        ByteBuffer byteBufferD = d(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferD.hasRemaining()) {
            i++;
            if (byteBufferD.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            long j = byteBufferD.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int iPosition = byteBufferD.position() + i2;
            if (i2 > byteBufferD.remaining()) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferD.remaining());
            }
            int i3 = byteBufferD.getInt();
            if (i3 == -262969152) {
                d = "V3";
                return true;
            }
            if (i3 == 1896449818) {
                d = "V2";
                return true;
            }
            byteBufferD.position(iPosition);
        }
        return false;
    }

    private static void hc(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer d(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }
}
