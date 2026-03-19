package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final int DEFAULT_TINY_CACHE_SIZE;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PooledByteBufAllocator.class);
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final int tinyCacheSize;

    static {
        Object obj;
        int i = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object th = null;
        try {
            validateAndCalculatePageShifts(i);
            obj = null;
        } catch (Throwable th2) {
            obj = th2;
            i = 8192;
        }
        DEFAULT_PAGE_SIZE = i;
        int i2 = 11;
        int i3 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 11);
        try {
            validateAndCalculateChunkSize(DEFAULT_PAGE_SIZE, i3);
            i2 = i3;
        } catch (Throwable th3) {
            th = th3;
        }
        DEFAULT_MAX_ORDER = i2;
        Runtime runtime = Runtime.getRuntime();
        long jAvailableProcessors = runtime.availableProcessors() * 2;
        long j = DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER;
        DEFAULT_NUM_HEAP_ARENA = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(jAvailableProcessors, ((runtime.maxMemory() / j) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(jAvailableProcessors, ((PlatformDependent.maxDirectMemory() / j) / 2) / 3)));
        DEFAULT_TINY_CACHE_SIZE = SystemPropertyUtil.getInt("io.netty.allocator.tinyCacheSize", 512);
        DEFAULT_SMALL_CACHE_SIZE = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_NORMAL_CACHE_SIZE = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_CACHE_TRIM_INTERVAL = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(DEFAULT_NUM_HEAP_ARENA));
            logger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(DEFAULT_NUM_DIRECT_ARENA));
            if (obj == null) {
                logger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(DEFAULT_PAGE_SIZE));
            } else {
                logger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(DEFAULT_PAGE_SIZE), obj);
            }
            if (th == null) {
                logger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(DEFAULT_MAX_ORDER));
            } else {
                logger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(DEFAULT_MAX_ORDER), th);
            }
            logger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER));
            logger.debug("-Dio.netty.allocator.tinyCacheSize: {}", Integer.valueOf(DEFAULT_TINY_CACHE_SIZE));
            logger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(DEFAULT_SMALL_CACHE_SIZE));
            logger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(DEFAULT_NORMAL_CACHE_SIZE));
            logger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(DEFAULT_MAX_CACHED_BUFFER_CAPACITY));
            logger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(DEFAULT_CACHE_TRIM_INTERVAL));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public PooledByteBufAllocator(boolean z) {
        this(z, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    public PooledByteBufAllocator(int i, int i2, int i3, int i4) {
        this(false, i, i2, i3, i4);
    }

    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4) {
        this(z, i, i2, i3, i4, DEFAULT_TINY_CACHE_SIZE, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(z);
        this.threadCache = new PoolThreadLocalCache();
        this.tinyCacheSize = i5;
        this.smallCacheSize = i6;
        this.normalCacheSize = i7;
        int iValidateAndCalculateChunkSize = validateAndCalculateChunkSize(i3, i4);
        if (i < 0) {
            throw new IllegalArgumentException("nHeapArena: " + i + " (expected: >= 0)");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("nDirectArea: " + i2 + " (expected: >= 0)");
        }
        int iValidateAndCalculatePageShifts = validateAndCalculatePageShifts(i3);
        if (i > 0) {
            this.heapArenas = newArenaArray(i);
            ArrayList arrayList = new ArrayList(this.heapArenas.length);
            for (int i8 = 0; i8 < this.heapArenas.length; i8++) {
                PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i3, i4, iValidateAndCalculatePageShifts, iValidateAndCalculateChunkSize);
                this.heapArenas[i8] = heapArena;
                arrayList.add(heapArena);
            }
            this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
        } else {
            this.heapArenas = null;
            this.heapArenaMetrics = Collections.emptyList();
        }
        if (i2 > 0) {
            this.directArenas = newArenaArray(i2);
            ArrayList arrayList2 = new ArrayList(this.directArenas.length);
            for (int i9 = 0; i9 < this.directArenas.length; i9++) {
                PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i3, i4, iValidateAndCalculatePageShifts, iValidateAndCalculateChunkSize);
                this.directArenas[i9] = directArena;
                arrayList2.add(directArena);
            }
            this.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            return;
        }
        this.directArenas = null;
        this.directArenaMetrics = Collections.emptyList();
    }

    private static <T> PoolArena<T>[] newArenaArray(int i) {
        return new PoolArena[i];
    }

    private static int validateAndCalculatePageShifts(int i) {
        if (i < 4096) {
            throw new IllegalArgumentException("pageSize: " + i + " (expected: 4096+)");
        }
        if (((i - 1) & i) != 0) {
            throw new IllegalArgumentException("pageSize: " + i + " (expected: power of 2)");
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    private static int validateAndCalculateChunkSize(int i, int i2) {
        if (i2 > 14) {
            throw new IllegalArgumentException("maxOrder: " + i2 + " (expected: 0-14)");
        }
        int i3 = i;
        for (int i4 = i2; i4 > 0; i4--) {
            if (i3 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i), Integer.valueOf(i2), 1073741824));
            }
            i3 <<= 1;
        }
        return i3;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i, int i2) {
        AbstractByteBuf unpooledHeapByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            unpooledHeapByteBuf = poolArena.allocate(poolThreadCache, i, i2);
        } else {
            unpooledHeapByteBuf = new UnpooledHeapByteBuf(this, i, i2);
        }
        return toLeakAwareBuffer(unpooledHeapByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i, int i2) {
        ByteBuf unpooledDirectByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        if (poolArena != null) {
            unpooledDirectByteBuf = poolArena.allocate(poolThreadCache, i, i2);
        } else if (PlatformDependent.hasUnsafe()) {
            unpooledDirectByteBuf = new UnpooledUnsafeDirectByteBuf(this, i, i2);
        } else {
            unpooledDirectByteBuf = new UnpooledDirectByteBuf(this, i, i2);
        }
        return toLeakAwareBuffer(unpooledDirectByteBuf);
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultTinyCacheSize() {
        return DEFAULT_TINY_CACHE_SIZE;
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final AtomicInteger index = new AtomicInteger();
        final AtomicInteger caches = new AtomicInteger();

        PoolThreadLocalCache() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public final PoolThreadCache initialValue() {
            this.caches.incrementAndGet();
            int andIncrement = this.index.getAndIncrement();
            return new PoolThreadCache(PooledByteBufAllocator.this.heapArenas != null ? PooledByteBufAllocator.this.heapArenas[Math.abs(andIncrement % PooledByteBufAllocator.this.heapArenas.length)] : null, PooledByteBufAllocator.this.directArenas != null ? PooledByteBufAllocator.this.directArenas[Math.abs(andIncrement % PooledByteBufAllocator.this.directArenas.length)] : null, PooledByteBufAllocator.this.tinyCacheSize, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public final void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free();
            this.caches.decrementAndGet();
        }
    }

    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public int numThreadLocalCaches() {
        return this.threadCache.caches.get();
    }

    public int tinyCacheSize() {
        return this.tinyCacheSize;
    }

    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }
}
