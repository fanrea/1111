package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class PlatformDependent0 {
    private static final long ADDRESS_FIELD_OFFSET;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long CHAR_ARRAY_BASE_OFFSET;
    private static final long CHAR_ARRAY_INDEX_SCALE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    private static final long STRING_VALUE_FIELD_OFFSET;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent0.class);

    static int hashCodeAsciiSanitize(byte b) {
        return b & 31;
    }

    static int hashCodeAsciiSanitize(int i) {
        return i & 522133279;
    }

    static int hashCodeAsciiSanitize(short s) {
        return s & 7967;
    }

    static int hashCodeAsciiSanitizeAsByte(char c) {
        return c & 31;
    }

    private static int hashCodeAsciiSanitizeFromChar(int i) {
        return (i & 31) | ((2031616 & i) >>> 8);
    }

    private static int hashCodeAsciiSanitizeFromChar(long j) {
        return (int) ((j & 31) | ((8725724278030336L & j) >>> 24) | ((133143986176L & j) >>> 16) | ((2031616 & j) >>> 8));
    }

    private static int hashCodeAsciiSanitizeFromChar(short s) {
        return s & 31;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent0.<clinit>():void");
    }

    static boolean isUnaligned() {
        return UNALIGNED;
    }

    static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    static boolean unalignedAccess() {
        return UNALIGNED;
    }

    static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    static void freeDirectBuffer(ByteBuffer byteBuffer) {
        Cleaner0.freeDirectBuffer(byteBuffer);
    }

    static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    static Object getObjectVolatile(Object obj, long j) {
        return UNSAFE.getObjectVolatile(obj, j);
    }

    static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    private static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    static short getShort(long j) {
        return UNSAFE.getShort(j);
    }

    static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    static byte getByte(byte[] bArr, int i) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static short getShort(byte[] bArr, int i) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static int getInt(byte[] bArr, int i) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static long getLong(byte[] bArr, int i) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + i);
    }

    static void putOrderedObject(Object obj, long j, Object obj2) {
        UNSAFE.putOrderedObject(obj, j, obj2);
    }

    static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    static void putShort(long j, short s) {
        UNSAFE.putShort(j, s);
    }

    static void putInt(long j, int i) {
        UNSAFE.putInt(j, i);
    }

    static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }

    static void putByte(byte[] bArr, int i, byte b) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + i, b);
    }

    static void putShort(byte[] bArr, int i, short s) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + i, s);
    }

    static void putInt(byte[] bArr, int i, int i2) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + i, i2);
    }

    static void putLong(byte[] bArr, int i, long j) {
        UNSAFE.putLong(bArr, i + BYTE_ARRAY_BASE_OFFSET, j);
    }

    static void copyMemory(long j, long j2, long j3) {
        while (j3 > 0) {
            long jMin = Math.min(j3, 1048576L);
            UNSAFE.copyMemory(j, j2, jMin);
            j3 -= jMin;
            j += jMin;
            j2 += jMin;
        }
    }

    static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        while (j6 > 0) {
            long jMin = Math.min(j6, 1048576L);
            UNSAFE.copyMemory(obj, j4, obj2, j5, jMin);
            j6 -= jMin;
            j4 += jMin;
            j5 += jMin;
        }
    }

    static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i3 == 0) {
            return true;
        }
        long j = BYTE_ARRAY_BASE_OFFSET;
        long j2 = i + j;
        long j3 = j + i2;
        int i4 = i3 & 7;
        long j4 = i4 + j2;
        long j5 = i3;
        long j6 = (j2 - 8) + j5;
        long j7 = (j3 - 8) + j5;
        while (j6 >= j4) {
            if (UNSAFE.getLong(bArr, j6) != UNSAFE.getLong(bArr2, j7)) {
                return false;
            }
            j6 -= 8;
            j7 -= 8;
        }
        switch (i4) {
            case 1:
                return UNSAFE.getByte(bArr, j2) == UNSAFE.getByte(bArr2, j3);
            case 2:
                return UNSAFE.getChar(bArr, j2) == UNSAFE.getChar(bArr2, j3);
            case 3:
                return UNSAFE.getChar(bArr, j2 + 1) == UNSAFE.getChar(bArr2, 1 + j3) && UNSAFE.getByte(bArr, j2) == UNSAFE.getByte(bArr2, j3);
            case 4:
                return UNSAFE.getInt(bArr, j2) == UNSAFE.getInt(bArr2, j3);
            case 5:
                return UNSAFE.getInt(bArr, j2 + 1) == UNSAFE.getInt(bArr2, 1 + j3) && UNSAFE.getByte(bArr, j2) == UNSAFE.getByte(bArr2, j3);
            case 6:
                return UNSAFE.getInt(bArr, j2 + 2) == UNSAFE.getInt(bArr2, 2 + j3) && UNSAFE.getChar(bArr, j2) == UNSAFE.getChar(bArr2, j3);
            case 7:
                return UNSAFE.getInt(bArr, j2 + 3) == UNSAFE.getInt(bArr2, 3 + j3) && UNSAFE.getChar(bArr, j2 + 1) == UNSAFE.getChar(bArr2, 1 + j3) && UNSAFE.getByte(bArr, j2) == UNSAFE.getByte(bArr2, j3);
            default:
                return true;
        }
    }

    static int hashCodeAscii(byte[] bArr, int i, int i2) {
        int iHashCodeAsciiSanitize;
        int iHashCodeAsciiSanitize2;
        long j = BYTE_ARRAY_BASE_OFFSET + i;
        int i3 = i2 & 7;
        int iHashCodeAsciiCompute = HASH_CODE_ASCII_SEED;
        if (i2 > 7) {
            long j2 = i3 + j;
            for (long j3 = (j - 8) + i2; j3 >= j2; j3 -= 8) {
                iHashCodeAsciiCompute = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j3), iHashCodeAsciiCompute);
            }
        }
        switch (i3) {
            case 1:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
                break;
            case 2:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j));
                break;
            case 3:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, 1 + j))) * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
                break;
            case 4:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j));
                break;
            case 5:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(hashCodeAsciiSanitize(UNSAFE.getInt(bArr, 1 + j)), 13)) * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
                break;
            case 6:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(hashCodeAsciiSanitize(UNSAFE.getInt(bArr, 2 + j)), 13)) * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j));
                break;
            case 7:
                iHashCodeAsciiSanitize = ((((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(hashCodeAsciiSanitize(UNSAFE.getInt(bArr, 3 + j)), 13)) * 31) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, 1 + j))) * 31;
                iHashCodeAsciiSanitize2 = hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
                break;
            default:
                return iHashCodeAsciiCompute;
        }
        return iHashCodeAsciiSanitize + iHashCodeAsciiSanitize2;
    }

    static int hashCodeAscii(char[] cArr) {
        int iHashCodeAsciiSanitizeFromChar;
        int iHashCodeAsciiSanitizeFromChar2;
        int length = cArr.length & 7;
        int iHashCodeAsciiComputeFromChar = HASH_CODE_ASCII_SEED;
        for (int length2 = cArr.length - 8; length2 >= length; length2 -= 8) {
            iHashCodeAsciiComputeFromChar = hashCodeAsciiComputeFromChar(UNSAFE.getLong(cArr, CHAR_ARRAY_BASE_OFFSET + (length2 * CHAR_ARRAY_INDEX_SCALE)), UNSAFE.getLong(cArr, CHAR_ARRAY_BASE_OFFSET + ((length2 + 4) * CHAR_ARRAY_INDEX_SCALE)), iHashCodeAsciiComputeFromChar);
        }
        switch (length) {
            case 1:
                iHashCodeAsciiSanitizeFromChar = iHashCodeAsciiComputeFromChar * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getShort(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            case 2:
                iHashCodeAsciiSanitizeFromChar = iHashCodeAsciiComputeFromChar * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getInt(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            case 3:
                iHashCodeAsciiSanitizeFromChar = ((iHashCodeAsciiComputeFromChar * 31) + hashCodeAsciiSanitizeFromChar(UNSAFE.getInt(cArr, CHAR_ARRAY_BASE_OFFSET + CHAR_ARRAY_INDEX_SCALE))) * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getShort(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            case 4:
                iHashCodeAsciiSanitizeFromChar = iHashCodeAsciiComputeFromChar * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getLong(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            case 5:
                iHashCodeAsciiSanitizeFromChar = ((iHashCodeAsciiComputeFromChar * 31) + Integer.rotateLeft(hashCodeAsciiSanitizeFromChar(UNSAFE.getLong(cArr, CHAR_ARRAY_BASE_OFFSET + CHAR_ARRAY_INDEX_SCALE)), 13)) * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getShort(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            case 6:
                iHashCodeAsciiSanitizeFromChar = ((iHashCodeAsciiComputeFromChar * 31) + Integer.rotateLeft(hashCodeAsciiSanitizeFromChar(UNSAFE.getLong(cArr, CHAR_ARRAY_BASE_OFFSET + (CHAR_ARRAY_INDEX_SCALE * 2))), 13)) * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getInt(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            case 7:
                iHashCodeAsciiSanitizeFromChar = ((((iHashCodeAsciiComputeFromChar * 31) + Integer.rotateLeft(hashCodeAsciiSanitizeFromChar(UNSAFE.getLong(cArr, CHAR_ARRAY_BASE_OFFSET + (CHAR_ARRAY_INDEX_SCALE * 3))), 13)) * 31) + hashCodeAsciiSanitizeFromChar(UNSAFE.getInt(cArr, CHAR_ARRAY_BASE_OFFSET + CHAR_ARRAY_INDEX_SCALE))) * 31;
                iHashCodeAsciiSanitizeFromChar2 = hashCodeAsciiSanitizeFromChar(UNSAFE.getShort(cArr, CHAR_ARRAY_BASE_OFFSET));
                break;
            default:
                return iHashCodeAsciiComputeFromChar;
        }
        return iHashCodeAsciiSanitizeFromChar + iHashCodeAsciiSanitizeFromChar2;
    }

    static char[] array(CharSequence charSequence) {
        if (STRING_VALUE_FIELD_OFFSET == -1 || charSequence.getClass() != String.class) {
            return null;
        }
        return (char[]) UNSAFE.getObject(charSequence, STRING_VALUE_FIELD_OFFSET);
    }

    static int hashCodeAsciiCompute(long j, int i) {
        return (((i * 31) + ((int) ((2242545357458243584L & j) >>> 32))) * 31) + hashCodeAsciiSanitize((int) j);
    }

    static int hashCodeAsciiComputeFromChar(long j, long j2, int i) {
        return (((i * 31) + hashCodeAsciiSanitizeFromChar(j2)) * 31) + hashCodeAsciiSanitizeFromChar(j);
    }

    static <U, W> AtomicReferenceFieldUpdater<U, W> newAtomicReferenceFieldUpdater(Class<? super U> cls, String str) {
        return new UnsafeAtomicReferenceFieldUpdater(UNSAFE, cls, str);
    }

    static <T> AtomicIntegerFieldUpdater<T> newAtomicIntegerFieldUpdater(Class<? super T> cls, String str) {
        return new UnsafeAtomicIntegerFieldUpdater(UNSAFE, cls, str);
    }

    static <T> AtomicLongFieldUpdater<T> newAtomicLongFieldUpdater(Class<? super T> cls, String str) {
        return new UnsafeAtomicLongFieldUpdater(UNSAFE, cls, str);
    }

    static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public final ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public final ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public final ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int addressSize() {
        return UNSAFE.addressSize();
    }

    static long allocateMemory(long j) {
        return UNSAFE.allocateMemory(j);
    }

    static void freeMemory(long j) {
        UNSAFE.freeMemory(j);
    }

    private PlatformDependent0() {
    }
}
