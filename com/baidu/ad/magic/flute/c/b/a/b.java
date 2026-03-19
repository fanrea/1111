package com.baidu.ad.magic.flute.c.b.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements d {
    public static final int a = 16;
    public static final int b = 64;
    public static final int c = 8;
    public static final int d = 32;
    public static final int e = 32;
    private static final int[] f = c(new byte[]{101, com.sigmob.sdk.archives.tar.e.R, 112, 97, 110, 100, 32, com.sigmob.sdk.archives.tar.e.f789K, com.sigmob.sdk.archives.tar.e.J, 45, 98, 121, 116, 101, 32, 107});
    private final int g;

    public b(int i) {
        this.g = i;
    }

    private static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iRemaining = byteBuffer2.remaining();
        int i = (iRemaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBufferA = a(bArr, bArr2, this.g + i2);
            if (i2 == i - 1) {
                a.a(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                a.a(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    static void a(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            a(iArr, 0, 4, 8, 12);
            a(iArr, 1, 5, 9, 13);
            a(iArr, 2, 6, 10, 14);
            a(iArr, 3, 7, 11, 15);
            a(iArr, 0, 5, 10, 15);
            a(iArr, 1, 6, 11, 12);
            a(iArr, 2, 7, 8, 13);
            a(iArr, 3, 4, 9, 14);
        }
    }

    static void a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = a(iArr[i2] ^ iArr[i3], 7);
    }

    static void a(int[] iArr, int[] iArr2) {
        System.arraycopy(f, 0, iArr, 0, f.length);
        System.arraycopy(iArr2, 0, iArr, f.length, 8);
    }

    static int[] c(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    int a() {
        return 12;
    }

    ByteBuffer a(byte[] bArr, byte[] bArr2, int i) {
        int[] iArrA = a(c(bArr), c(bArr2), i);
        int[] iArr = (int[]) iArrA.clone();
        a(iArr);
        for (int i2 = 0; i2 < iArrA.length; i2++) {
            iArrA[i2] = iArrA[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrA, 0, 16);
        return byteBufferOrder;
    }

    void a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() - a() < bArr.length) {
            throw new IllegalArgumentException("data output is too small");
        }
        if (bArr2 == null) {
            bArr2 = new byte[a()];
            new Random().nextBytes(bArr2);
        }
        byteBuffer.put(bArr2);
        a(bArr2, e.a(), byteBuffer, ByteBuffer.wrap(bArr));
    }

    byte[] a(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() < a()) {
            throw new GeneralSecurityException("data too short");
        }
        byte[] bArr = new byte[a()];
        byteBuffer.get(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        a(bArr, e.b(), byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    @Override // com.baidu.ad.magic.flute.c.b.a.d
    public byte[] a(byte[] bArr) {
        return a(bArr, (byte[]) null);
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - a()) {
            throw new GeneralSecurityException("data too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(a() + bArr.length);
        a(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    int[] a(int[] iArr, int[] iArr2, int i) {
        if (iArr.length != a() / 4) {
            throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
        }
        int[] iArr3 = new int[16];
        a(iArr3, iArr2);
        iArr3[12] = i;
        System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
        return iArr3;
    }

    @Override // com.baidu.ad.magic.flute.c.b.a.d
    public byte[] b(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }
}
