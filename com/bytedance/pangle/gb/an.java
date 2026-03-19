package com.bytedance.pangle.gb;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.common.utility.StringEncryptUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class an {
    static final HashMap<String, SparseArray<uo>> d = new HashMap<>();

    static void d(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, uo uoVar) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                d(arrayMap, randomAccessFile.getFD(), uoVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            d(map.get(3), randomAccessFile, uoVar);
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void d(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, uo uoVar) throws SecurityException {
        mq mqVar = new mq(fileDescriptor, 0L, uoVar.hc);
        mq mqVar2 = new mq(fileDescriptor, uoVar.b, uoVar.c - uoVar.b);
        ByteBuffer byteBufferDuplicate = uoVar.u.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        rf.d(byteBufferDuplicate, uoVar.hc);
        gb gbVar = new gb(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrD = d(iArr, new mk[]{mqVar, mqVar2, gbVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrD[i2])) {
                    throw new SecurityException(hc(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] d(int[] iArr, mk[] mkVarArr) throws DigestException {
        String str;
        mk[] mkVarArr2 = mkVarArr;
        long j = 0;
        long jD = 0;
        for (mk mkVar : mkVarArr2) {
            jD += d(mkVar.d());
        }
        if (jD >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(jD)));
        }
        int i = (int) jD;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(u(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            d(i, bArr2, 1);
            bArr[i2] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i3 = 0;
        while (true) {
            str = " digest not supported";
            if (i3 >= iArr.length) {
                break;
            }
            String strHc = hc(iArr[i3]);
            try {
                messageDigestArr[i3] = MessageDigest.getInstance(strHc);
                i3++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strHc + " digest not supported", e);
            }
        }
        d dVar = new d(messageDigestArr);
        int length2 = mkVarArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length2) {
            mk mkVar2 = mkVarArr2[i4];
            int i7 = length2;
            int i8 = i6;
            d dVar2 = dVar;
            String str2 = str;
            long jD2 = mkVar2.d();
            long j2 = j;
            while (jD2 > j) {
                int iMin = (int) Math.min(jD2, 1048576L);
                d(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                d dVar3 = dVar2;
                try {
                    mkVar2.d(dVar3, j2, iMin);
                    dVar2 = dVar3;
                    int i10 = 0;
                    while (i10 < iArr.length) {
                        int i11 = iArr[i10];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i10];
                        int iU = u(i11);
                        mk mkVar3 = mkVar2;
                        MessageDigest messageDigest = messageDigestArr[i10];
                        int i12 = length;
                        int iDigest = messageDigest.digest(bArr5, (i8 * iU) + 5, iU);
                        if (iDigest != iU) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i10++;
                        bArr3 = bArr4;
                        mkVar2 = mkVar3;
                        length = i12;
                    }
                    long j3 = iMin;
                    j2 += j3;
                    jD2 -= j3;
                    i8++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                }
            }
            i5++;
            i4++;
            mkVarArr2 = mkVarArr;
            i6 = i8;
            dVar = dVar2;
            str = str2;
            length2 = i7;
            j = 0;
        }
        String str3 = str;
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strHc2 = hc(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strHc2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strHc2 + str3, e3);
            }
        }
        return bArr6;
    }

    static byte[] d(byte[] bArr, long j, uo uoVar) throws SecurityException {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.position(32);
        if (byteBufferOrder.getLong() != j - (uoVar.b - uoVar.hc)) {
            throw new SecurityException("APK content size did not verify");
        }
        return Arrays.copyOfRange(bArr, 0, 32);
    }

    private static void d(byte[] bArr, RandomAccessFile randomAccessFile, uo uoVar) throws SecurityException {
        try {
            if (Arrays.equals(d(bArr, randomAccessFile.length(), uoVar), h.d(randomAccessFile, uoVar, new tt() { // from class: com.bytedance.pangle.gb.an.1
                @Override // com.bytedance.pangle.gb.tt
                public ByteBuffer d(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).hc)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile) throws IOException, k {
        Pair<ByteBuffer, Long> pairD = rf.d(randomAccessFile);
        if (pairD != null) {
            return pairD;
        }
        throw new k("Not an APK file: ZIP End of Central Directory record not found");
    }

    static long d(ByteBuffer byteBuffer, long j) throws k {
        long jD = rf.d(byteBuffer);
        if (jD > j) {
            throw new k("ZIP Central Directory offset out of range: " + jD + ". ZIP End of Central Directory offset: " + j);
        }
        if (rf.hc(byteBuffer) + jD == j) {
            return jD;
        }
        throw new k("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    private static long d(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    static int d(int i, int i2) {
        return hc(d(i), d(i2));
    }

    private static int hc(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
    }

    static int d(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    static String hc(int i) {
        if (i == 1) {
            return StringEncryptUtils.SHA_256;
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return StringEncryptUtils.SHA_256;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    private static int u(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    static String b(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return com.alipay.sdk.m.n.d.a;
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
                return com.alipay.sdk.m.n.d.a;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    static Pair<String, ? extends AlgorithmParameterSpec> c(int i) {
        if (i != 513) {
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(StringEncryptUtils.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case 258:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case 259:
                                    break;
                                case 260:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    static ByteBuffer d(ByteBuffer byteBuffer, int i, int i2) {
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

    static ByteBuffer d(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
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

    static ByteBuffer d(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return d(byteBuffer, i);
    }

    static byte[] hc(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    static void d(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, long j) throws IOException, k {
        if (j < 32) {
            throw new k("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - byteBufferAllocate.capacity());
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            return null;
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new k("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - i;
        if (j3 < 0) {
            throw new k("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new k("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    static void d(String str, RandomAccessFile randomAccessFile, int... iArr) throws IOException, k {
        HashSet hashSet;
        int i;
        long j;
        int i2;
        ByteBuffer byteBuffer;
        String str2 = str;
        d.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairD = d(randomAccessFile);
        ByteBuffer byteBuffer2 = (ByteBuffer) pairD.first;
        long jLongValue = ((Long) pairD.second).longValue();
        if (rf.d(randomAccessFile, jLongValue)) {
            throw new k("ZIP64 APK not supported");
        }
        long jD = d(byteBuffer2, jLongValue);
        Pair<ByteBuffer, Long> pairD2 = d(randomAccessFile, jD);
        if (pairD2 == null) {
            return;
        }
        ByteBuffer byteBuffer3 = (ByteBuffer) pairD2.first;
        long jLongValue2 = ((Long) pairD2.second).longValue();
        b(byteBuffer3);
        int i3 = 8;
        ByteBuffer byteBufferD = d(byteBuffer3, 8, byteBuffer3.capacity() - 24);
        HashSet hashSet2 = new HashSet();
        for (int i4 : iArr) {
            hashSet2.add(Integer.valueOf(i4));
        }
        while (byteBufferD.hasRemaining() && byteBufferD.remaining() >= i3) {
            long j2 = byteBufferD.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                return;
            }
            int i5 = (int) j2;
            int iPosition = byteBufferD.position() + i5;
            if (i5 > byteBufferD.remaining()) {
                return;
            }
            int i6 = byteBufferD.getInt();
            if (hashSet2.contains(Integer.valueOf(i6))) {
                hashSet = hashSet2;
                i = iPosition;
                j = jD;
                i2 = i3;
                d.get(str2).put(i6, new uo(d(byteBufferD, i5 - 4), jLongValue2, jD, jLongValue, byteBuffer2));
                byteBuffer = byteBufferD;
            } else {
                hashSet = hashSet2;
                i = iPosition;
                j = jD;
                i2 = i3;
                byteBuffer = byteBufferD;
            }
            byteBuffer.position(i);
            hashSet2 = hashSet;
            byteBufferD = byteBuffer;
            jD = j;
            i3 = i2;
            str2 = str;
        }
    }

    private static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static class d implements tc {
        private final MessageDigest[] d;

        d(MessageDigest[] messageDigestArr) {
            this.d = messageDigestArr;
        }

        @Override // com.bytedance.pangle.gb.tc
        public void d(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.d) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }
}
