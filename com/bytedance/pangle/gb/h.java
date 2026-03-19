package com.bytedance.pangle.gb;

import com.bytedance.common.utility.StringEncryptUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class h {
    private static final byte[] d = new byte[8];

    static class d {
        public final ByteBuffer d;
        public final byte[] hc;

        d(ByteBuffer byteBuffer, byte[] bArr) {
            this.d = byteBuffer;
            this.hc = bArr;
        }
    }

    static d d(RandomAccessFile randomAccessFile, uo uoVar, tt ttVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int i = hc(randomAccessFile.length() - (uoVar.b - uoVar.hc))[r0.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferD = ttVar.d(i2);
        byteBufferD.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBufferD2 = d(byteBufferD, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferD3 = d(byteBufferD, i, i3);
        ByteBuffer byteBufferD4 = d(byteBufferD, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        d(randomAccessFile, uoVar, byteBufferD2, byteBufferWrap, byteBufferD3, byteBufferD4);
        byteBufferD.position(i3 + byteBufferD4.limit());
        byteBufferD.putInt(byteBufferD4.limit() + 64 + 4);
        byteBufferD.flip();
        return new d(byteBufferD, bArr);
    }

    private static void d(RandomAccessFile randomAccessFile, uo uoVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        d(uoVar);
        long j = uoVar.b - uoVar.hc;
        int[] iArrHc = hc(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrD = d(randomAccessFile, uoVar, d, iArrHc, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrD);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            d(byteBuffer3, randomAccessFile.length(), iArrHc.length - 1, d);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            d(byteBuffer4, uoVar.hc, j, uoVar.c);
        }
    }

    private static class hc implements tc {
        private final MessageDigest b;
        private final byte[] c;
        private int d;
        private final ByteBuffer hc;
        private final byte[] u;

        private hc(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.c = new byte[32];
            this.u = bArr;
            this.hc = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance(StringEncryptUtils.SHA_256);
            this.b = messageDigest;
            messageDigest.update(bArr);
            this.d = 0;
        }

        @Override // com.bytedance.pangle.gb.tc
        public void d(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.d);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.b.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.d + iMin;
                this.d = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.b;
                    byte[] bArr = this.c;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.hc.put(this.c);
                    this.b.update(this.u);
                    this.d = 0;
                }
            }
        }

        public void d() throws DigestException {
            if (this.d != 0) {
                throw new IllegalStateException("Buffer is not empty: " + this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hc() {
            int iPosition = this.hc.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.hc.put(ByteBuffer.allocate(4096 - iPosition));
        }
    }

    private static void d(tc tcVar, mk mkVar, int i) throws DigestException, IOException {
        long jD = mkVar.d();
        long j = 0;
        while (jD > 0) {
            int iMin = (int) Math.min(jD, i);
            mkVar.d(tcVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jD -= j2;
        }
    }

    private static void d(RandomAccessFile randomAccessFile, uo uoVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        hc hcVar = new hc(bArr, byteBuffer);
        d(hcVar, new mq(randomAccessFile.getFD(), 0L, uoVar.hc), 1048576);
        long j = uoVar.c + 16;
        d(hcVar, new mq(randomAccessFile.getFD(), uoVar.b, j - uoVar.b), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(d(uoVar.hc));
        byteBufferOrder.flip();
        hcVar.d(byteBufferOrder);
        long j2 = j + 4;
        d(hcVar, new mq(randomAccessFile.getFD(), j2, randomAccessFile.length() - j2), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            hcVar.d(ByteBuffer.allocate(4096 - length));
        }
        hcVar.d();
        hcVar.hc();
    }

    private static byte[] d(RandomAccessFile randomAccessFile, uo uoVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        d(randomAccessFile, uoVar, bArr, d(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferD = d(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferD2 = d(byteBuffer, iArr[length], iArr[i]);
                gb gbVar = new gb(byteBufferD);
                hc hcVar = new hc(bArr, byteBufferD2);
                d(hcVar, gbVar, 4096);
                hcVar.d();
                hcVar.hc();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                hc hcVar2 = new hc(bArr, ByteBuffer.wrap(bArr2));
                hcVar2.d(d(byteBuffer, 0, 4096));
                hcVar2.d();
                return bArr2;
            }
        }
    }

    private static ByteBuffer d(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException("salt is not 8 bytes long");
        }
        byteBuffer.put("TrueBrew".getBytes());
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 12);
        byteBuffer.put((byte) 7);
        byteBuffer.putShort((short) 1);
        byteBuffer.putShort((short) 1);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putLong(j);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 0);
        byteBuffer.put(bArr);
        d(byteBuffer, 22);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static ByteBuffer d(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        d(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        d(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(d(j));
        d(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static int[] hc(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = d(j, 4096L) * 32;
            arrayList.add(Long.valueOf(d(j, 4096L) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + d(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static void d(uo uoVar) {
        if (uoVar.hc % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + uoVar.hc);
        }
        if ((uoVar.b - uoVar.hc) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (uoVar.b - uoVar.hc));
        }
    }

    private static ByteBuffer d(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void d(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long d(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int d(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
