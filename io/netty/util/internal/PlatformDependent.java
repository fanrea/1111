package io.netty.util.internal;

import com.sigmob.sdk.base.mta.PointCategory;
import io.netty.util.internal.chmv8.ConcurrentHashMapV8;
import io.netty.util.internal.chmv8.LongAdderV8;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Deque;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PlatformDependent {
    private static final int ADDRESS_SIZE;
    public static final boolean BIG_ENDIAN_NATIVE_ORDER;
    private static final int BIT_MODE;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final boolean CAN_USE_CHM_V8;
    private static final boolean DIRECT_BUFFER_PREFERRED;
    private static final boolean HAS_JAVASSIST;
    private static final boolean HAS_UNSAFE;
    private static volatile Boolean IS_ROOT;
    private static final long MAX_DIRECT_MEMORY;
    private static final File TMPDIR;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent.class);
    private static final Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
    private static final boolean IS_ANDROID = isAndroid0();
    private static final boolean IS_WINDOWS = isWindows0();
    private static final int JAVA_VERSION = javaVersion0();
    private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = !isAndroid();

    static {
        boolean zHasUnsafe0 = hasUnsafe0();
        HAS_UNSAFE = zHasUnsafe0;
        CAN_USE_CHM_V8 = zHasUnsafe0 && JAVA_VERSION < 8;
        DIRECT_BUFFER_PREFERRED = HAS_UNSAFE && !SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false);
        MAX_DIRECT_MEMORY = maxDirectMemory0();
        BYTE_ARRAY_BASE_OFFSET = PlatformDependent0.byteArrayBaseOffset();
        HAS_JAVASSIST = hasJavassist0();
        TMPDIR = tmpdir0();
        BIT_MODE = bitMode0();
        ADDRESS_SIZE = addressSize0();
        BIG_ENDIAN_NATIVE_ORDER = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(true ^ DIRECT_BUFFER_PREFERRED));
        }
        if (hasUnsafe() || isAndroid()) {
            return;
        }
        logger.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system unstability.");
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    public static boolean isRoot() {
        if (IS_ROOT == null) {
            synchronized (PlatformDependent.class) {
                if (IS_ROOT == null) {
                    IS_ROOT = Boolean.valueOf(isRoot0());
                }
            }
        }
        return IS_ROOT.booleanValue();
    }

    public static int javaVersion() {
        return JAVA_VERSION;
    }

    public static boolean canEnableTcpNoDelayByDefault() {
        return CAN_ENABLE_TCP_NODELAY_BY_DEFAULT;
    }

    public static boolean hasUnsafe() {
        return HAS_UNSAFE;
    }

    public static boolean isUnaligned() {
        return PlatformDependent0.isUnaligned();
    }

    public static boolean directBufferPreferred() {
        return DIRECT_BUFFER_PREFERRED;
    }

    public static long maxDirectMemory() {
        return MAX_DIRECT_MEMORY;
    }

    public static boolean hasJavassist() {
        return HAS_JAVASSIST;
    }

    public static File tmpdir() {
        return TMPDIR;
    }

    public static int bitMode() {
        return BIT_MODE;
    }

    public static int addressSize() {
        return ADDRESS_SIZE;
    }

    public static long allocateMemory(long j) {
        return PlatformDependent0.allocateMemory(j);
    }

    public static void freeMemory(long j) {
        PlatformDependent0.freeMemory(j);
    }

    public static void throwException(Throwable th) throws Throwable {
        if (hasUnsafe()) {
            PlatformDependent0.throwException(th);
        } else {
            throwException0(th);
        }
    }

    private static <E extends Throwable> void throwException0(Throwable th) throws Throwable {
        throw th;
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8();
        }
        return new ConcurrentHashMap();
    }

    public static LongCounter newLongCounter() {
        if (HAS_UNSAFE) {
            return new LongAdderV8();
        }
        return new AtomicLongCounter();
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(i);
        }
        return new ConcurrentHashMap(i);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i, float f) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(i, f);
        }
        return new ConcurrentHashMap(i, f);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(int i, float f, int i2) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(i, f, i2);
        }
        return new ConcurrentHashMap(i, f, i2);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap(Map<? extends K, ? extends V> map) {
        if (CAN_USE_CHM_V8) {
            return new ConcurrentHashMapV8(map);
        }
        return new ConcurrentHashMap(map);
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (!hasUnsafe() || isAndroid()) {
            return;
        }
        PlatformDependent0.freeDirectBuffer(byteBuffer);
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent0.directBufferAddress(byteBuffer);
    }

    public static Object getObject(Object obj, long j) {
        return PlatformDependent0.getObject(obj, j);
    }

    public static Object getObjectVolatile(Object obj, long j) {
        return PlatformDependent0.getObjectVolatile(obj, j);
    }

    public static int getInt(Object obj, long j) {
        return PlatformDependent0.getInt(obj, j);
    }

    public static long objectFieldOffset(Field field) {
        return PlatformDependent0.objectFieldOffset(field);
    }

    public static byte getByte(long j) {
        return PlatformDependent0.getByte(j);
    }

    public static short getShort(long j) {
        return PlatformDependent0.getShort(j);
    }

    public static int getInt(long j) {
        return PlatformDependent0.getInt(j);
    }

    public static long getLong(long j) {
        return PlatformDependent0.getLong(j);
    }

    public static byte getByte(byte[] bArr, int i) {
        return PlatformDependent0.getByte(bArr, i);
    }

    public static short getShort(byte[] bArr, int i) {
        return PlatformDependent0.getShort(bArr, i);
    }

    public static int getInt(byte[] bArr, int i) {
        return PlatformDependent0.getInt(bArr, i);
    }

    public static long getLong(byte[] bArr, int i) {
        return PlatformDependent0.getLong(bArr, i);
    }

    private static long getLongSafe(byte[] bArr, int i) {
        if (BIG_ENDIAN_NATIVE_ORDER) {
            return (bArr[i + 7] & 255) | (bArr[i] << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        }
        return ((bArr[i + 7] & 255) << 56) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 5] & 255) << 40);
    }

    private static long getLongFromBytesSafe(CharSequence charSequence, int i) {
        if (BIG_ENDIAN_NATIVE_ORDER) {
            return (charSequence.charAt(i + 7) & 255) | (charSequence.charAt(i) << 56) | ((charSequence.charAt(i + 1) & 255) << 48) | ((charSequence.charAt(i + 2) & 255) << 40) | ((charSequence.charAt(i + 3) & 255) << 32) | ((charSequence.charAt(i + 4) & 255) << 24) | ((charSequence.charAt(i + 5) & 255) << 16) | ((charSequence.charAt(i + 6) & 255) << 8);
        }
        return ((charSequence.charAt(i + 7) & 255) << 56) | ((charSequence.charAt(i + 6) & 255) << 48) | ((charSequence.charAt(i + 4) & 255) << 32) | ((charSequence.charAt(i + 2) & 255) << 16) | (charSequence.charAt(i) & 255) | ((charSequence.charAt(i + 1) & 255) << 8) | ((charSequence.charAt(i + 3) & 255) << 24) | ((charSequence.charAt(i + 5) & 255) << 40);
    }

    private static int getIntSafe(byte[] bArr, int i) {
        int i2;
        int i3;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i2 = (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            i3 = bArr[i + 3] & 255;
        } else {
            i2 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            i3 = bArr[i + 3] << 24;
        }
        return i3 | i2;
    }

    private static int getIntFromBytesSafe(CharSequence charSequence, int i) {
        int iCharAt;
        int iCharAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            iCharAt = (charSequence.charAt(i) << 24) | ((charSequence.charAt(i + 1) & 255) << 16) | ((charSequence.charAt(i + 2) & 255) << 8);
            iCharAt2 = charSequence.charAt(i + 3) & 255;
        } else {
            iCharAt = (charSequence.charAt(i) & 255) | ((charSequence.charAt(i + 1) & 255) << 8) | ((charSequence.charAt(i + 2) & 255) << 16);
            iCharAt2 = charSequence.charAt(i + 3) << 24;
        }
        return iCharAt2 | iCharAt;
    }

    private static short getShortSafe(byte[] bArr, int i) {
        int i2;
        int i3;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            i2 = bArr[i] << 8;
            i3 = bArr[i + 1] & 255;
        } else {
            i2 = bArr[i] & 255;
            i3 = bArr[i + 1] << 8;
        }
        return (short) (i3 | i2);
    }

    private static short getShortFromBytesSafe(CharSequence charSequence, int i) {
        int iCharAt;
        int iCharAt2;
        if (BIG_ENDIAN_NATIVE_ORDER) {
            iCharAt = charSequence.charAt(i) << '\b';
            iCharAt2 = charSequence.charAt(i + 1) & 255;
        } else {
            iCharAt = charSequence.charAt(i) & 255;
            iCharAt2 = charSequence.charAt(i + 1) << '\b';
        }
        return (short) (iCharAt2 | iCharAt);
    }

    public static void putOrderedObject(Object obj, long j, Object obj2) {
        PlatformDependent0.putOrderedObject(obj, j, obj2);
    }

    public static void putByte(long j, byte b) {
        PlatformDependent0.putByte(j, b);
    }

    public static void putShort(long j, short s) {
        PlatformDependent0.putShort(j, s);
    }

    public static void putInt(long j, int i) {
        PlatformDependent0.putInt(j, i);
    }

    public static void putLong(long j, long j2) {
        PlatformDependent0.putLong(j, j2);
    }

    public static void putByte(byte[] bArr, int i, byte b) {
        PlatformDependent0.putByte(bArr, i, b);
    }

    public static void putShort(byte[] bArr, int i, short s) {
        PlatformDependent0.putShort(bArr, i, s);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        PlatformDependent0.putInt(bArr, i, i2);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        PlatformDependent0.putLong(bArr, i, j);
    }

    public static void copyMemory(long j, long j2, long j3) {
        PlatformDependent0.copyMemory(j, j2, j3);
    }

    public static void copyMemory(byte[] bArr, int i, long j, long j2) {
        PlatformDependent0.copyMemory(bArr, BYTE_ARRAY_BASE_OFFSET + i, null, j, j2);
    }

    public static void copyMemory(long j, byte[] bArr, int i, long j2) {
        PlatformDependent0.copyMemory(null, j, bArr, BYTE_ARRAY_BASE_OFFSET + i, j2);
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (!hasUnsafe() || !PlatformDependent0.unalignedAccess()) {
            return equalsSafe(bArr, i, bArr2, i2, i3);
        }
        return PlatformDependent0.equals(bArr, i, bArr2, i2, i3);
    }

    public static int hashCodeAscii(byte[] bArr, int i, int i2) {
        if (!hasUnsafe() || !PlatformDependent0.unalignedAccess()) {
            return hashCodeAsciiSafe(bArr, i, i2);
        }
        return PlatformDependent0.hashCodeAscii(bArr, i, i2);
    }

    public static int hashCodeAscii(CharSequence charSequence) {
        char[] cArrArray;
        if (!hasUnsafe() || !PlatformDependent0.unalignedAccess() || (cArrArray = PlatformDependent0.array(charSequence)) == null) {
            return hashCodeAsciiSafe(charSequence);
        }
        return PlatformDependent0.hashCodeAscii(cArrArray);
    }

    public static <U, W> AtomicReferenceFieldUpdater<U, W> newAtomicReferenceFieldUpdater(Class<? super U> cls, String str) {
        if (!hasUnsafe()) {
            return null;
        }
        try {
            return PlatformDependent0.newAtomicReferenceFieldUpdater(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> AtomicIntegerFieldUpdater<T> newAtomicIntegerFieldUpdater(Class<? super T> cls, String str) {
        if (!hasUnsafe()) {
            return null;
        }
        try {
            return PlatformDependent0.newAtomicIntegerFieldUpdater(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> AtomicLongFieldUpdater<T> newAtomicLongFieldUpdater(Class<? super T> cls, String str) {
        if (!hasUnsafe()) {
            return null;
        }
        try {
            return PlatformDependent0.newAtomicLongFieldUpdater(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> Queue<T> newMpscQueue() {
        return new MpscLinkedQueue();
    }

    public static <T> Queue<T> newFixedMpscQueue(int i) {
        if (hasUnsafe()) {
            return new MpscArrayQueue(i);
        }
        return new LinkedBlockingQueue(i);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return PlatformDependent0.getClassLoader(cls);
    }

    public static ClassLoader getContextClassLoader() {
        return PlatformDependent0.getContextClassLoader();
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static <C> Deque<C> newConcurrentDeque() {
        if (javaVersion() < 7) {
            return new LinkedBlockingDeque();
        }
        return new ConcurrentLinkedDeque();
    }

    private static boolean isAndroid0() {
        boolean z = false;
        try {
            Class.forName("android.app.Application", false, getSystemClassLoader());
            z = true;
        } catch (Throwable unused) {
        }
        if (z) {
            logger.debug("Platform: Android");
        }
        return z;
    }

    private static boolean isWindows0() {
        boolean zContains = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).contains(PointCategory.WIN);
        if (zContains) {
            logger.debug("Platform: Windows");
        }
        return zContains;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0060 A[EXC_TOP_SPLITTER, PHI: r7 r8
  0x0060: PHI (r7v1 java.lang.String) = (r7v0 java.lang.String), (r7v3 java.lang.String) binds: [B:30:0x0073, B:19:0x005e] A[DONT_GENERATE, DONT_INLINE]
  0x0060: PHI (r8v4 java.lang.Process) = (r8v3 java.lang.Process), (r8v8 java.lang.Process) binds: [B:30:0x0073, B:19:0x005e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRoot0() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.isRoot0():boolean");
    }

    private static int javaVersion0() {
        int i = 6;
        if (!isAndroid()) {
            try {
                try {
                    Class.forName("java.time.Clock", false, getClassLoader(Object.class));
                    i = 8;
                } catch (Throwable unused) {
                    Class.forName("java.util.concurrent.LinkedTransferQueue", false, getClassLoader(BlockingQueue.class));
                    i = 7;
                }
            } catch (Throwable unused2) {
            }
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Java version: {}", Integer.valueOf(i));
        }
        return i;
    }

    private static boolean hasUnsafe0() {
        boolean z;
        boolean z2 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        logger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z2));
        if (isAndroid()) {
            logger.debug("sun.misc.Unsafe: unavailable (Android)");
            return false;
        }
        if (z2) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return false;
        }
        if (SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            z = SystemPropertyUtil.getBoolean("io.netty.tryUnsafe", true);
        } else {
            z = SystemPropertyUtil.getBoolean("org.jboss.netty.tryUnsafe", true);
        }
        if (!z) {
            logger.debug("sun.misc.Unsafe: unavailable (io.netty.tryUnsafe/org.jboss.netty.tryUnsafe)");
            return false;
        }
        try {
            boolean zHasUnsafe = PlatformDependent0.hasUnsafe();
            logger.debug("sun.misc.Unsafe: {}", zHasUnsafe ? "available" : "unavailable");
            return zHasUnsafe;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0075, code lost:
    
        r5 = java.lang.Long.parseLong(r8.group(1));
        r0 = r8.group(2).charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
    
        if (r0 == 'G') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008c, code lost:
    
        if (r0 == 'K') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0090, code lost:
    
        if (r0 == 'M') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
    
        if (r0 == 'g') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
    
        if (r0 == 'k') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
    
        if (r0 == 'm') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009f, code lost:
    
        r3 = 1048576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        r3 = 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
    
        r3 = 1073741824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
    
        r5 = r5 * r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long maxDirectMemory0() {
        /*
            r0 = 0
            r1 = 0
            r3 = 1
            r4 = 0
            java.lang.String r5 = "sun.misc.VM"
            java.lang.ClassLoader r6 = getSystemClassLoader()     // Catch: java.lang.Throwable -> L24
            java.lang.Class r5 = java.lang.Class.forName(r5, r3, r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = "maxDirectMemory"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L24
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch: java.lang.Throwable -> L24
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L24
            java.lang.Object r5 = r5.invoke(r0, r6)     // Catch: java.lang.Throwable -> L24
            java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L24
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L24
            goto L25
        L24:
            r5 = r1
        L25:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L2a
            return r5
        L2a:
            java.lang.String r7 = "java.lang.management.ManagementFactory"
            java.lang.ClassLoader r8 = getSystemClassLoader()     // Catch: java.lang.Throwable -> Lac
            java.lang.Class r7 = java.lang.Class.forName(r7, r3, r8)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r8 = "java.lang.management.RuntimeMXBean"
            java.lang.ClassLoader r9 = getSystemClassLoader()     // Catch: java.lang.Throwable -> Lac
            java.lang.Class r8 = java.lang.Class.forName(r8, r3, r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = "getRuntimeMXBean"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lac
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r9, r10)     // Catch: java.lang.Throwable -> Lac
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r0 = r7.invoke(r0, r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r7 = "getInputArguments"
            java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lac
            java.lang.reflect.Method r7 = r8.getDeclaredMethod(r7, r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r0 = r7.invoke(r0, r8)     // Catch: java.lang.Throwable -> Lac
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> Lac
            int r7 = r0.size()     // Catch: java.lang.Throwable -> Lac
            int r7 = r7 - r3
        L61:
            if (r7 < 0) goto Lb1
            java.util.regex.Pattern r8 = io.netty.util.internal.PlatformDependent.MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r9 = r0.get(r7)     // Catch: java.lang.Throwable -> Lac
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch: java.lang.Throwable -> Lac
            java.util.regex.Matcher r8 = r8.matcher(r9)     // Catch: java.lang.Throwable -> Lac
            boolean r9 = r8.matches()     // Catch: java.lang.Throwable -> Lac
            if (r9 == 0) goto Lae
            java.lang.String r0 = r8.group(r3)     // Catch: java.lang.Throwable -> Lac
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> Lac
            r0 = 2
            java.lang.String r0 = r8.group(r0)     // Catch: java.lang.Throwable -> Lac
            char r0 = r0.charAt(r4)     // Catch: java.lang.Throwable -> Lac
            r3 = 71
            if (r0 == r3) goto La6
            r3 = 75
            if (r0 == r3) goto La3
            r3 = 77
            if (r0 == r3) goto L9f
            r3 = 103(0x67, float:1.44E-43)
            if (r0 == r3) goto La6
            r3 = 107(0x6b, float:1.5E-43)
            if (r0 == r3) goto La3
            r3 = 109(0x6d, float:1.53E-43)
            if (r0 == r3) goto L9f
            goto Lb1
        L9f:
            r3 = 1048576(0x100000, double:5.180654E-318)
            goto La9
        La3:
            r3 = 1024(0x400, double:5.06E-321)
            goto La9
        La6:
            r3 = 1073741824(0x40000000, double:5.304989477E-315)
        La9:
            long r5 = r5 * r3
            goto Lb1
        Lac:
            goto Lb1
        Lae:
            int r7 = r7 + (-1)
            goto L61
        Lb1:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 > 0) goto Lc9
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            long r5 = r0.maxMemory()
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.PlatformDependent.logger
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "maxDirectMemory: {} bytes (maybe)"
            r0.debug(r2, r1)
            goto Ld4
        Lc9:
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.PlatformDependent.logger
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = "maxDirectMemory: {} bytes"
            r0.debug(r2, r1)
        Ld4:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent.maxDirectMemory0():long");
    }

    private static boolean hasJavassist0() {
        if (isAndroid()) {
            return false;
        }
        boolean z = SystemPropertyUtil.getBoolean("io.netty.noJavassist", false);
        logger.debug("-Dio.netty.noJavassist: {}", Boolean.valueOf(z));
        if (z) {
            logger.debug("Javassist: unavailable (io.netty.noJavassist)");
            return false;
        }
        try {
            JavassistTypeParameterMatcherGenerator.generate(Object.class, getClassLoader(PlatformDependent.class));
            logger.debug("Javassist: available");
            return true;
        } catch (Throwable unused) {
            logger.debug("Javassist: unavailable");
            logger.debug("You don't have Javassist in your class path or you don't have enough permission to load dynamically generated classes.  Please check the configuration for better performance.");
            return false;
        }
    }

    private static File tmpdir0() {
        File file;
        File directory;
        try {
            directory = toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
        } catch (Throwable unused) {
        }
        if (directory != null) {
            logger.debug("-Dio.netty.tmpdir: {}", directory);
            return directory;
        }
        File directory2 = toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
        if (directory2 != null) {
            logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", directory2);
            return directory2;
        }
        if (isWindows()) {
            File directory3 = toDirectory(System.getenv("TEMP"));
            if (directory3 != null) {
                logger.debug("-Dio.netty.tmpdir: {} (%TEMP%)", directory3);
                return directory3;
            }
            String str = System.getenv("USERPROFILE");
            if (str != null) {
                File directory4 = toDirectory(str + "\\AppData\\Local\\Temp");
                if (directory4 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\AppData\\Local\\Temp)", directory4);
                    return directory4;
                }
                File directory5 = toDirectory(str + "\\Local Settings\\Temp");
                if (directory5 != null) {
                    logger.debug("-Dio.netty.tmpdir: {} (%USERPROFILE%\\Local Settings\\Temp)", directory5);
                    return directory5;
                }
            }
        } else {
            File directory6 = toDirectory(System.getenv("TMPDIR"));
            if (directory6 != null) {
                logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", directory6);
                return directory6;
            }
        }
        if (isWindows()) {
            file = new File("C:\\Windows\\Temp");
        } else {
            file = new File("/tmp");
        }
        logger.warn("Failed to get the temporary directory; falling back to: {}", file);
        return file;
    }

    private static File toDirectory(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            return file.getAbsoluteFile();
        } catch (Exception unused) {
            return file;
        }
    }

    private static int bitMode0() {
        int i = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
        if (i > 0) {
            logger.debug("-Dio.netty.bitMode: {}", Integer.valueOf(i));
            return i;
        }
        int i2 = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
        if (i2 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", Integer.valueOf(i2));
            return i2;
        }
        int i3 = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
        if (i3 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", Integer.valueOf(i3));
            return i3;
        }
        String strTrim = SystemPropertyUtil.get("os.arch", "").toLowerCase(Locale.US).trim();
        if ("amd64".equals(strTrim) || "x86_64".equals(strTrim)) {
            i3 = 64;
        } else if ("i386".equals(strTrim) || "i486".equals(strTrim) || "i586".equals(strTrim) || "i686".equals(strTrim)) {
            i3 = 32;
        }
        if (i3 > 0) {
            logger.debug("-Dio.netty.bitMode: {} (os.arch: {})", Integer.valueOf(i3), strTrim);
        }
        Matcher matcher = Pattern.compile("([1-9][0-9]+)-?bit").matcher(SystemPropertyUtil.get("java.vm.name", "").toLowerCase(Locale.US));
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 64;
    }

    private static int addressSize0() {
        if (hasUnsafe()) {
            return PlatformDependent0.addressSize();
        }
        return -1;
    }

    private static boolean equalsSafe(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    static int hashCodeAsciiSafe(byte[] bArr, int i, int i2) {
        int iHashCodeAsciiSanitize;
        int iHashCodeAsciiSanitize2;
        int i3 = i2 & 7;
        int i4 = i + i3;
        int iHashCodeAsciiCompute = -1028477387;
        for (int i5 = (i - 8) + i2; i5 >= i4; i5 -= 8) {
            iHashCodeAsciiCompute = PlatformDependent0.hashCodeAsciiCompute(getLongSafe(bArr, i5), iHashCodeAsciiCompute);
        }
        switch (i3) {
            case 1:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(bArr[i]);
                break;
            case 2:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i));
                break;
            case 3:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i + 1))) * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(bArr[i]);
                break;
            case 4:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i));
                break;
            case 5:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 1)), 13)) * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(bArr[i]);
                break;
            case 6:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 2)), 13)) * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i));
                break;
            case 7:
                iHashCodeAsciiSanitize = ((((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(PlatformDependent0.hashCodeAsciiSanitize(getIntSafe(bArr, i + 3)), 13)) * 31) + PlatformDependent0.hashCodeAsciiSanitize(getShortSafe(bArr, i + 1))) * 31;
                iHashCodeAsciiSanitize2 = PlatformDependent0.hashCodeAsciiSanitize(bArr[i]);
                break;
            default:
                return iHashCodeAsciiCompute;
        }
        return iHashCodeAsciiSanitize + iHashCodeAsciiSanitize2;
    }

    static int hashCodeAsciiSafe(CharSequence charSequence) {
        int iHashCodeAsciiSanitize;
        int iHashCodeAsciiSanitizeAsByte;
        int length = charSequence.length() & 7;
        int iHashCodeAsciiCompute = -1028477387;
        for (int length2 = charSequence.length() - 8; length2 >= length; length2 -= 8) {
            iHashCodeAsciiCompute = PlatformDependent0.hashCodeAsciiCompute(getLongFromBytesSafe(charSequence, length2), iHashCodeAsciiCompute);
        }
        switch (length) {
            case 1:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitizeAsByte(charSequence.charAt(0));
                break;
            case 2:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitize(getShortFromBytesSafe(charSequence, 0));
                break;
            case 3:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + PlatformDependent0.hashCodeAsciiSanitize(getShortFromBytesSafe(charSequence, 1))) * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitizeAsByte(charSequence.charAt(0));
                break;
            case 4:
                iHashCodeAsciiSanitize = iHashCodeAsciiCompute * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitize(getIntFromBytesSafe(charSequence, 0));
                break;
            case 5:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(PlatformDependent0.hashCodeAsciiSanitize(getIntFromBytesSafe(charSequence, 1)), 13)) * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitizeAsByte(charSequence.charAt(0));
                break;
            case 6:
                iHashCodeAsciiSanitize = ((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(PlatformDependent0.hashCodeAsciiSanitize(getIntFromBytesSafe(charSequence, 2)), 13)) * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitize(getShortFromBytesSafe(charSequence, 0));
                break;
            case 7:
                iHashCodeAsciiSanitize = ((((iHashCodeAsciiCompute * 31) + Integer.rotateLeft(PlatformDependent0.hashCodeAsciiSanitize(getIntFromBytesSafe(charSequence, 3)), 13)) * 31) + PlatformDependent0.hashCodeAsciiSanitize(getShortFromBytesSafe(charSequence, 1))) * 31;
                iHashCodeAsciiSanitizeAsByte = PlatformDependent0.hashCodeAsciiSanitizeAsByte(charSequence.charAt(0));
                break;
            default:
                return iHashCodeAsciiCompute;
        }
        return iHashCodeAsciiSanitize + iHashCodeAsciiSanitizeAsByte;
    }

    static final class AtomicLongCounter extends AtomicLong implements LongCounter {
        private static final long serialVersionUID = 4074772784610639305L;

        private AtomicLongCounter() {
        }

        @Override // io.netty.util.internal.LongCounter
        public final void add(long j) {
            addAndGet(j);
        }

        @Override // io.netty.util.internal.LongCounter
        public final void increment() {
            incrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public final void decrement() {
            decrementAndGet();
        }

        @Override // io.netty.util.internal.LongCounter
        public final long value() {
            return get();
        }
    }

    private PlatformDependent() {
    }
}
