package com.tkruntime.v8;

import android.util.LruCache;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8MemBufferFromJS {
    private static final String EMPTY = "";
    private static int sAvailIndex = -1;
    public static boolean sEndianInited = false;
    public static boolean sIsBigEndian = false;
    private static V8MemBufferFromJS[] sBuffers = new V8MemBufferFromJS[16];
    public static Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static LruCache<Integer, String> sWeakCache = new LruCache<>(256);
    private V8 mV8 = null;
    private int mCnt = 0;
    private int mReadIndex = 0;
    private BufferAbbrev mBuffer = null;

    static {
        isBigEndian();
    }

    public static class BufferAbbrev {
        byte[] bytes = null;
        int bufferLen = 0;
        int byteIndex = 0;
        boolean bigEndian = false;
        int intLen = 0;
        int longLen = 0;
        int doubleLen = 0;

        byte readByte() {
            byte[] bArr = this.bytes;
            int i = this.byteIndex;
            this.byteIndex = i + 1;
            return bArr[i];
        }

        void skip(int i) {
            this.byteIndex += i;
        }

        short readShort() {
            int i;
            int i2;
            if (!this.bigEndian) {
                byte[] bArr = this.bytes;
                int i3 = this.byteIndex;
                this.byteIndex = i3 + 1;
                i = (bArr[i3] & 255) << 0;
                int i4 = this.byteIndex;
                this.byteIndex = i4 + 1;
                i2 = (bArr[i4] & 255) << 8;
            } else {
                byte[] bArr2 = this.bytes;
                int i5 = this.byteIndex;
                this.byteIndex = i5 + 1;
                i = (bArr2[i5] & 255) << 8;
                int i6 = this.byteIndex;
                this.byteIndex = i6 + 1;
                i2 = (bArr2[i6] & 255) << 0;
            }
            return (short) (i2 | i);
        }

        int readInt() {
            int i;
            int i2;
            if (!this.bigEndian) {
                byte[] bArr = this.bytes;
                int i3 = this.byteIndex;
                this.byteIndex = i3 + 1;
                int i4 = (bArr[i3] & 255) << 0;
                int i5 = this.byteIndex;
                this.byteIndex = i5 + 1;
                int i6 = i4 | ((bArr[i5] & 255) << 8);
                int i7 = this.byteIndex;
                this.byteIndex = i7 + 1;
                i = i6 | ((bArr[i7] & 255) << 16);
                int i8 = this.byteIndex;
                this.byteIndex = i8 + 1;
                i2 = (bArr[i8] & 255) << 24;
            } else {
                byte[] bArr2 = this.bytes;
                int i9 = this.byteIndex;
                this.byteIndex = i9 + 1;
                int i10 = (bArr2[i9] & 255) << 24;
                int i11 = this.byteIndex;
                this.byteIndex = i11 + 1;
                int i12 = i10 | ((bArr2[i11] & 255) << 16);
                int i13 = this.byteIndex;
                this.byteIndex = i13 + 1;
                i = i12 | ((bArr2[i13] & 255) << 8);
                int i14 = this.byteIndex;
                this.byteIndex = i14 + 1;
                i2 = (bArr2[i14] & 255) << 0;
            }
            return i2 | i;
        }

        long readLong() {
            if (!this.bigEndian) {
                byte[] bArr = this.bytes;
                int i = this.byteIndex;
                this.byteIndex = i + 1;
                int i2 = (bArr[i] & 255) << 0;
                int i3 = this.byteIndex;
                this.byteIndex = i3 + 1;
                int i4 = i2 | ((bArr[i3] & 255) << 8);
                int i5 = this.byteIndex;
                this.byteIndex = i5 + 1;
                int i6 = i4 | ((bArr[i5] & 255) << 16);
                int i7 = this.byteIndex;
                this.byteIndex = i7 + 1;
                int i8 = i6 | ((bArr[i7] & 255) << 24);
                int i9 = this.byteIndex;
                this.byteIndex = i9 + 1;
                int i10 = (bArr[i9] & 255) << 0;
                int i11 = this.byteIndex;
                this.byteIndex = i11 + 1;
                int i12 = i10 | ((bArr[i11] & 255) << 8);
                int i13 = this.byteIndex;
                this.byteIndex = i13 + 1;
                int i14 = i12 | ((bArr[i13] & 255) << 16);
                this.byteIndex = this.byteIndex + 1;
                return (C00oOOo.f362O8oO888 & i8) | ((((bArr[r6] & 255) << 24) | i14) << 32);
            }
            byte[] bArr2 = this.bytes;
            int i15 = this.byteIndex;
            this.byteIndex = i15 + 1;
            int i16 = (bArr2[i15] & 255) << 24;
            int i17 = this.byteIndex;
            this.byteIndex = i17 + 1;
            int i18 = i16 | ((bArr2[i17] & 255) << 16);
            int i19 = this.byteIndex;
            this.byteIndex = i19 + 1;
            int i20 = i18 | ((bArr2[i19] & 255) << 8);
            int i21 = this.byteIndex;
            this.byteIndex = i21 + 1;
            int i22 = i20 | ((bArr2[i21] & 255) << 0);
            int i23 = this.byteIndex;
            this.byteIndex = i23 + 1;
            int i24 = (bArr2[i23] & 255) << 24;
            int i25 = this.byteIndex;
            this.byteIndex = i25 + 1;
            int i26 = i24 | ((bArr2[i25] & 255) << 16);
            int i27 = this.byteIndex;
            this.byteIndex = i27 + 1;
            int i28 = i26 | ((bArr2[i27] & 255) << 8);
            this.byteIndex = this.byteIndex + 1;
            return (C00oOOo.f362O8oO888 & (((bArr2[r6] & 255) << 0) | i28)) | (i22 << 32);
        }

        double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        void clear() {
            this.bufferLen = 0;
            this.byteIndex = 0;
        }
    }

    public static boolean isBigEndian() {
        if (!sEndianInited) {
            try {
                sIsBigEndian = V8._isBigEndian();
            } catch (Throwable unused) {
                sIsBigEndian = false;
            }
            sEndianInited = true;
        }
        return sIsBigEndian;
    }

    public static long readLong(byte[] bArr, int i) {
        long j;
        long j2;
        if (!sIsBigEndian) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = ((bArr[i] & 255) << 0) | ((bArr[i2] & 255) << 8);
            int i5 = i3 + 1;
            int i6 = i4 | ((bArr[i3] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 24);
            int i9 = i7 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i9] & 255) << 8) | ((bArr[i7] & 255) << 0) | ((bArr[i10] & 255) << 16);
            j = (((bArr[i10 + 1] & 255) << 24) | i11) << 32;
            j2 = i8;
        } else {
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i] & 255) << 24) | ((bArr[i12] & 255) << 16);
            int i15 = i13 + 1;
            int i16 = i14 | ((bArr[i13] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 | ((bArr[i15] & 255) << 0);
            int i19 = i17 + 1;
            int i20 = i19 + 1;
            j = i18 << 32;
            j2 = ((bArr[i20 + 1] & 255) << 0) | ((bArr[i19] & 255) << 16) | ((bArr[i17] & 255) << 24) | ((bArr[i20] & 255) << 8);
        }
        return (j2 & C00oOOo.f362O8oO888) | j;
    }

    public static void loadIntIntoBytes(byte[] bArr, int i, int i2) {
        if (!sIsBigEndian) {
            bArr[i] = (byte) (i2 & 255);
            bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
            bArr[i + 2] = (byte) ((i2 >>> 16) & 255);
            bArr[i + 3] = (byte) ((i2 >>> 24) & 255);
            return;
        }
        bArr[i] = (byte) ((i2 >>> 24) & 255);
        bArr[i + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i + 3] = (byte) (i2 & 255);
    }

    public static void loadLongIntoBytes(byte[] bArr, int i, long j) {
        if (!sIsBigEndian) {
            int i2 = (int) (j & C00oOOo.f362O8oO888);
            int i3 = (int) ((j >>> 32) & C00oOOo.f362O8oO888);
            loadIntIntoBytes(bArr, i, i2);
            loadIntIntoBytes(bArr, i + 4, i3);
            return;
        }
        int i4 = (int) (j & C00oOOo.f362O8oO888);
        loadIntIntoBytes(bArr, i, (int) ((j >>> 32) & C00oOOo.f362O8oO888));
        loadIntIntoBytes(bArr, i + 4, i4);
    }

    public static void loadDoubleIntoBytes(byte[] bArr, int i, double d) {
        loadLongIntoBytes(bArr, i, Double.doubleToLongBits(d));
    }

    public static V8MemBufferFromJS obtain(ByteBuffer byteBuffer, V8 v8) {
        V8MemBufferFromJS v8MemBufferFromJS;
        synchronized (sBuffers) {
            if (sAvailIndex >= 0) {
                v8MemBufferFromJS = sBuffers[sAvailIndex];
                V8MemBufferFromJS[] v8MemBufferFromJSArr = sBuffers;
                int i = sAvailIndex;
                sAvailIndex = i - 1;
                v8MemBufferFromJSArr[i] = null;
            } else {
                v8MemBufferFromJS = null;
            }
        }
        if (v8MemBufferFromJS == null) {
            v8MemBufferFromJS = new V8MemBufferFromJS();
        }
        v8MemBufferFromJS.init(byteBuffer, byteBuffer.arrayOffset(), v8);
        return v8MemBufferFromJS;
    }

    public void recycle() {
        synchronized (sBuffers) {
            if (sAvailIndex >= sBuffers.length - 1) {
                return;
            }
            V8MemBufferFromJS[] v8MemBufferFromJSArr = sBuffers;
            int i = sAvailIndex + 1;
            sAvailIndex = i;
            v8MemBufferFromJSArr[i] = this;
            this.mV8 = null;
        }
    }

    protected V8MemBufferFromJS() {
    }

    void init(ByteBuffer byteBuffer, int i, V8 v8) {
        this.mV8 = v8;
        byte[] bArrArray = byteBuffer.array();
        if (bArrArray == null) {
            this.mCnt = 0;
            return;
        }
        this.mReadIndex = 0;
        if (this.mBuffer == null) {
            this.mBuffer = obtainBuffer();
        }
        BufferAbbrev bufferAbbrev = this.mBuffer;
        bufferAbbrev.bytes = bArrArray;
        bufferAbbrev.byteIndex = i;
        bufferAbbrev.bufferLen = bArrArray.length;
        bufferAbbrev.bigEndian = sIsBigEndian;
        bufferAbbrev.skip(4);
        this.mCnt = this.mBuffer.readInt();
    }

    protected static BufferAbbrev obtainBuffer() {
        return new BufferAbbrev();
    }

    public int getObjectCnt() {
        return this.mCnt;
    }

    public BufferAbbrev getBuffer() {
        return this.mBuffer;
    }

    public boolean hasRemaining() {
        return this.mReadIndex < this.mCnt - 1;
    }

    public Object[] getAllObjects() {
        int i = this.mCnt;
        int i2 = this.mReadIndex;
        if (i - i2 <= 0) {
            return EMPTY_OBJECT_ARRAY;
        }
        Object[] objArr = new Object[i - i2];
        int i3 = 0;
        while (i2 < this.mCnt) {
            objArr[i3] = readObject();
            i2++;
            i3++;
        }
        return objArr;
    }

    public Object readObject() {
        return _readObject();
    }

    public int readInt() {
        if (this.mReadIndex >= this.mCnt) {
            throw new RuntimeException("nothing to read anymore!");
        }
        int i = this.mBuffer.readByte() & 255;
        this.mReadIndex++;
        if (i == 1) {
            return this.mBuffer.readInt();
        }
        throw new RuntimeException("expect integer ,but provide type = " + i);
    }

    public long readLong() {
        if (this.mReadIndex >= this.mCnt) {
            throw new RuntimeException("nothing to read anymore!");
        }
        this.mBuffer.readByte();
        this.mReadIndex++;
        return this.mBuffer.readLong();
    }

    private Object _readObject() {
        if (this.mReadIndex >= this.mCnt) {
            throw new RuntimeException("nothing to read anymore!");
        }
        int i = this.mBuffer.readByte() & 255;
        this.mReadIndex++;
        String str = null;
        if (i == 10) {
            int i2 = this.mBuffer.readInt();
            if (i2 <= 0) {
                return null;
            }
            this.mBuffer.skip(i2);
            long j = this.mBuffer.readLong();
            Object trackedObj = this.mV8.getTrackedObj(j);
            return trackedObj != null ? trackedObj : new V8ArrayBuffer(this.mV8, j, null);
        }
        if (i != 17) {
            switch (i) {
                case 0:
                    return null;
                case 1:
                    return Integer.valueOf(this.mBuffer.readInt());
                case 2:
                    return Double.valueOf(this.mBuffer.readDouble());
                case 3:
                    if (this.mBuffer.readByte() == 0) {
                        return Boolean.FALSE;
                    }
                    return Boolean.TRUE;
                case 4:
                    break;
                case 5:
                    long j2 = this.mBuffer.readLong();
                    Object trackedObj2 = this.mV8.getTrackedObj(j2);
                    return trackedObj2 != null ? trackedObj2 : new V8Array(this.mV8, j2);
                case 6:
                    long j3 = this.mBuffer.readLong();
                    Object trackedObj3 = this.mV8.getTrackedObj(j3);
                    return trackedObj3 != null ? trackedObj3 : new V8Object(this.mV8, j3);
                case 7:
                    long j4 = this.mBuffer.readLong();
                    Object trackedObj4 = this.mV8.getTrackedObj(j4);
                    return trackedObj4 != null ? trackedObj4 : new V8Function(this.mV8, j4);
                case 8:
                    long j5 = this.mBuffer.readLong();
                    Object trackedObj5 = this.mV8.getTrackedObj(j5);
                    return trackedObj5 != null ? trackedObj5 : new V8TypedArray(this.mV8, j5);
                default:
                    switch (i) {
                        case 20:
                            break;
                        case 21:
                            int i3 = this.mBuffer.readInt();
                            if (i3 < 0 || i3 >= StringPool.sSortedHighFrequencyStrings.length) {
                                return null;
                            }
                            return StringPool.sSortedHighFrequencyStrings[i3];
                        case 22:
                            long j6 = this.mBuffer.readLong();
                            Object trackedObj6 = this.mV8.getTrackedObj(j6);
                            return trackedObj6 != null ? trackedObj6 : new V8Map(this.mV8, j6);
                        case 23:
                            return Long.valueOf(this.mBuffer.readLong());
                        default:
                            this.mReadIndex--;
                            throw new RuntimeException("unknown type  " + i);
                    }
            }
            int i4 = this.mBuffer.readInt();
            if (i4 != 0) {
                synchronized (sWeakCache) {
                    str = sWeakCache.get(Integer.valueOf(i4));
                }
            }
            int i5 = this.mBuffer.readInt();
            int i6 = i5 / 2;
            if (str != null && i6 == str.length()) {
                this.mBuffer.skip(i5);
                return str;
            }
            if (i5 <= 0) {
                return "";
            }
            char[] cArr = new char[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                cArr[i7] = (char) this.mBuffer.readShort();
            }
            String str2 = new String(cArr);
            if (i4 != 0) {
                synchronized (sWeakCache) {
                    sWeakCache.put(Integer.valueOf(i4), str2);
                }
            }
            return str2;
        }
        return this.mV8.getTrackedObj(this.mBuffer.readLong());
    }
}
