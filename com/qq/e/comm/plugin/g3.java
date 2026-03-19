package com.qq.e.comm.plugin;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class g3 {
    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static ByteBuffer b(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i2 = i + iPosition;
            if (i2 >= iPosition && i2 <= iLimit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return byteBufferSlice;
                } finally {
                    byteBuffer.limit(iLimit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i);
    }

    /* compiled from: A */
    static class a {
        public final List<X509Certificate> a;
        public final List<Integer> b;

        public a(List<X509Certificate> list, List<Integer> list2) {
            this.a = list;
            this.b = list2;
        }
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int i) throws bz {
        a(byteBuffer);
        ByteBuffer byteBufferA = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferA.hasRemaining()) {
            i2++;
            if (byteBufferA.remaining() >= 8) {
                long j = byteBufferA.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i3 = (int) j;
                    int iPosition = byteBufferA.position() + i3;
                    if (i3 <= byteBufferA.remaining()) {
                        if (byteBufferA.getInt() == i) {
                            return b(byteBufferA, i3 - 4);
                        }
                        byteBufferA.position(iPosition);
                    } else {
                        throw new bz("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferA.remaining());
                    }
                } else {
                    throw new bz("APK Signing Block entry #" + i2 + " size out of range: " + j);
                }
            } else {
                throw new bz("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
        }
        throw new bz("No block with ID " + i + " in APK Signing Block.");
    }

    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j) throws bz, IOException {
        if (j >= 32) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(j - byteBufferAllocate.capacity());
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) == 2334950737559900225L && byteBufferAllocate.getLong(16) == 3617552046287187010L) {
                long j2 = byteBufferAllocate.getLong(0);
                if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
                    throw new bz("APK Signing Block size out of range: " + j2);
                }
                int i = (int) (8 + j2);
                long j3 = j - i;
                if (j3 >= 0) {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
                    byteBufferAllocate2.order(byteOrder);
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
                    long j4 = byteBufferAllocate2.getLong(0);
                    if (j4 == j2) {
                        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
                    }
                    throw new bz("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                }
                throw new bz("APK Signing Block offset out of range: " + j3);
            }
            throw new bz("No APK Signing Block before ZIP Central Directory");
        }
        throw new bz("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
    }

    static az a(RandomAccessFile randomAccessFile, int i) throws bz, IOException {
        Pair<ByteBuffer, Long> pairA = a(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) pairA.first;
        long jLongValue = ((Long) pairA.second).longValue();
        if (!t60.a(randomAccessFile, jLongValue)) {
            long jA = a(byteBuffer, jLongValue);
            Pair<ByteBuffer, Long> pairA2 = a(randomAccessFile, jA);
            ByteBuffer byteBuffer2 = (ByteBuffer) pairA2.first;
            return new az(a(byteBuffer2, i), ((Long) pairA2.second).longValue(), jA, jLongValue, byteBuffer);
        }
        throw new bz("ZIP64 APK not supported");
    }

    static long a(ByteBuffer byteBuffer, long j) throws bz {
        long jC = t60.c(byteBuffer);
        if (jC <= j) {
            if (t60.d(byteBuffer) + jC == j) {
                return jC;
            }
            throw new bz("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new bz("ZIP Central Directory offset out of range: " + jC + ". ZIP End of Central Directory offset: " + j);
    }

    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) throws bz, IOException {
        Pair<ByteBuffer, Long> pairA = t60.a(randomAccessFile);
        if (pairA != null) {
            return pairA;
        }
        throw new bz("Not an APK file: ZIP End of Central Directory record not found");
    }

    static byte[] a(byte[] bArr, long j, az azVar) throws SecurityException {
        if (bArr.length == 40) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.position(32);
            if (byteBufferOrder.getLong() == j - (azVar.c - azVar.b)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 >= i) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
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
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
    }
}
