package com.netease.htprotect.p024.p026Ooo;

import android.util.Pair;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import com.netease.htprotect.p024.p025O8oO888.O8;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class Oo0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static final short f664O8oO888 = 0;

    /* renamed from: OO〇8, reason: contains not printable characters */
    private static final int f665OO8 = 65535;
    private static final int Oo0 = 101010256;

    /* renamed from: 〇00oOOo, reason: contains not printable characters */
    private static final int f66600oOOo = 20;

    /* renamed from: 〇O, reason: contains not printable characters */
    private static final int f667O = 10;

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static final short f668O8 = 8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static final short f669Ooo = 8;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public static final short f670o0o0 = 2048;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final int f671oO = 22;

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static final int f672o0O0O = 12;

    /* renamed from: 〇〇, reason: contains not printable characters */
    private static final int f673 = 16;

    /* renamed from: com.netease.htprotect.〇〇.〇Ooo.Oo0$O8〇oO8〇88, reason: invalid class name */
    public static class O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final int f674O8oO888;

        /* renamed from: 〇O8, reason: contains not printable characters */
        public final byte[] f675O8;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public final long f676Ooo;

        public O8oO888(int i, long j, byte[] bArr) {
            this.f674O8oO888 = i;
            this.f676Ooo = j;
            this.f675O8 = bArr;
        }
    }

    private Oo0() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static int m1239O8oO888(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static long m1240O8oO888(ByteBuffer byteBuffer) {
        m1252o0o0(byteBuffer);
        return m1248O8(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Pair m1241O8oO888(O8 o8) throws IOException {
        if (o8.mo1197O8oO888() < 22) {
            return null;
        }
        Pair pairM1242O8oO888 = m1242O8oO888(o8, 0);
        return pairM1242O8oO888 != null ? pairM1242O8oO888 : m1242O8oO888(o8, 65535);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Pair m1242O8oO888(O8 o8, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long jMo1197O8oO888 = o8.mo1197O8oO888();
        if (jMo1197O8oO888 < 22) {
            return null;
        }
        int iMin = ((int) Math.min(i, jMo1197O8oO888 - 22)) + 22;
        long j = jMo1197O8oO888 - iMin;
        ByteBuffer byteBufferMo1199O8oO888 = o8.mo1199O8oO888(j, iMin);
        byteBufferMo1199O8oO888.order(ByteOrder.LITTLE_ENDIAN);
        int iOo0 = Oo0(byteBufferMo1199O8oO888);
        if (iOo0 == -1) {
            return null;
        }
        byteBufferMo1199O8oO888.position(iOo0);
        ByteBuffer byteBufferSlice = byteBufferMo1199O8oO888.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return new Pair(byteBufferSlice, Long.valueOf(j + iOo0));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    static void m1243O8oO888(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("");
        }
        byteBuffer.putShort(i, (short) i2);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    static void m1244O8oO888(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > C00oOOo.f362O8oO888) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        byteBuffer.putInt(i, (int) j);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    static void m1245O8oO888(ByteBuffer byteBuffer, long j) {
        if (j < 0 || j > C00oOOo.f362O8oO888) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        byteBuffer.putInt((int) j);
    }

    private static int Oo0(ByteBuffer byteBuffer) {
        m1252o0o0(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, 65535);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == Oo0 && m1239O8oO888(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private static int m1246O(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public static int m1247O8(ByteBuffer byteBuffer) {
        m1252o0o0(byteBuffer);
        return m1239O8oO888(byteBuffer, byteBuffer.position() + 10);
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    static long m1248O8(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & C00oOOo.f362O8oO888;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static long m1249Ooo(ByteBuffer byteBuffer) {
        m1252o0o0(byteBuffer);
        return m1248O8(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public static void m1250Ooo(ByteBuffer byteBuffer, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("uint16 value of out range: ".concat(String.valueOf(i)));
        }
        byteBuffer.putShort((short) i);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static void m1251Ooo(ByteBuffer byteBuffer, long j) {
        m1252o0o0(byteBuffer);
        m1244O8oO888(byteBuffer, byteBuffer.position() + 16, j);
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    static void m1252o0o0(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("");
        }
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    static long m1253oO(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & C00oOOo.f362O8oO888;
    }

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static O8oO888 m1254o0O0O(ByteBuffer byteBuffer) {
        byte[] bArrArray;
        int iArrayOffset;
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            byteBuffer.position(byteBuffer.limit());
        } else {
            bArrArray = new byte[iRemaining];
            byteBuffer.get(bArrArray);
            iArrayOffset = 0;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArrArray, iArrayOffset, iRemaining);
        long value = crc32.getValue();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(9, true);
        deflater.setInput(bArrArray, iArrayOffset, iRemaining);
        deflater.finish();
        byte[] bArr = new byte[65536];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
        }
        return new O8oO888(iRemaining, value, byteArrayOutputStream.toByteArray());
    }
}
