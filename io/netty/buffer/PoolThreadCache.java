package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.Recycler;
import io.netty.util.ThreadDeathWatcher;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class PoolThreadCache {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PoolThreadCache.class);
    private int allocations;
    final PoolArena<ByteBuffer> directArena;
    private final int freeSweepAllocationThreshold;
    final PoolArena<byte[]> heapArena;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final int numShiftsNormalDirect;
    private final int numShiftsNormalHeap;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] tinySubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] tinySubPageHeapCaches;
    private final Thread thread = Thread.currentThread();
    private final Runnable freeTask = new Runnable() { // from class: io.netty.buffer.PoolThreadCache.1
        @Override // java.lang.Runnable
        public void run() {
            PoolThreadCache.this.free0();
        }
    };

    private static int log2(int i) {
        int i2 = 0;
        while (i > 1) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int i, int i2, int i3, int i4, int i5) {
        if (i4 < 0) {
            throw new IllegalArgumentException("maxCachedBufferCapacity: " + i4 + " (expected: >= 0)");
        }
        if (i5 <= 0) {
            throw new IllegalArgumentException("freeSweepAllocationThreshold: " + i4 + " (expected: > 0)");
        }
        this.freeSweepAllocationThreshold = i5;
        this.heapArena = poolArena;
        this.directArena = poolArena2;
        if (poolArena2 != null) {
            this.tinySubPageDirectCaches = createSubPageCaches(i, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageDirectCaches = createSubPageCaches(i2, poolArena2.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalDirect = log2(poolArena2.pageSize);
            this.normalDirectCaches = createNormalCaches(i3, i4, poolArena2);
        } else {
            this.tinySubPageDirectCaches = null;
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
            this.numShiftsNormalDirect = -1;
        }
        if (poolArena != null) {
            this.tinySubPageHeapCaches = createSubPageCaches(i, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageHeapCaches = createSubPageCaches(i2, poolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalHeap = log2(poolArena.pageSize);
            this.normalHeapCaches = createNormalCaches(i3, i4, poolArena);
        } else {
            this.tinySubPageHeapCaches = null;
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
            this.numShiftsNormalHeap = -1;
        }
        ThreadDeathWatcher.watch(this.thread, this.freeTask);
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int i, int i2, PoolArena.SizeClass sizeClass) {
        if (i <= 0) {
            return null;
        }
        MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            memoryRegionCacheArr[i3] = new SubPageMemoryRegionCache(i, sizeClass);
        }
        return memoryRegionCacheArr;
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int i, int i2, PoolArena<T> poolArena) {
        if (i <= 0) {
            return null;
        }
        int iMax = Math.max(1, log2(Math.min(poolArena.chunkSize, i2) / poolArena.pageSize) + 1);
        MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[iMax];
        for (int i3 = 0; i3 < iMax; i3++) {
            memoryRegionCacheArr[i3] = new NormalMemoryRegionCache(i);
        }
        return memoryRegionCacheArr;
    }

    final boolean allocateTiny(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i, int i2) {
        return allocate(cacheForTiny(poolArena, i2), pooledByteBuf, i);
    }

    final boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i, int i2) {
        return allocate(cacheForSmall(poolArena, i2), pooledByteBuf, i);
    }

    final boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i, int i2) {
        return allocate(cacheForNormal(poolArena, i2), pooledByteBuf, i);
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int i) {
        if (memoryRegionCache == null) {
            return false;
        }
        boolean zAllocate = memoryRegionCache.allocate(pooledByteBuf, i);
        int i2 = this.allocations + 1;
        this.allocations = i2;
        if (i2 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return zAllocate;
    }

    final boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, long j, int i, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> memoryRegionCacheCache = cache(poolArena, i, sizeClass);
        if (memoryRegionCacheCache == null) {
            return false;
        }
        return memoryRegionCacheCache.add(poolChunk, j);
    }

    /* renamed from: io.netty.buffer.PoolThreadCache$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass = new int[PoolArena.SizeClass.values().length];

        static {
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int i, PoolArena.SizeClass sizeClass) {
        int i2 = AnonymousClass2.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
        if (i2 == 1) {
            return cacheForNormal(poolArena, i);
        }
        if (i2 == 2) {
            return cacheForSmall(poolArena, i);
        }
        if (i2 == 3) {
            return cacheForTiny(poolArena, i);
        }
        throw new Error();
    }

    final void free() {
        ThreadDeathWatcher.unwatch(this.thread, this.freeTask);
        free0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void free0() {
        int iFree = free(this.tinySubPageDirectCaches) + free(this.smallSubPageDirectCaches) + free(this.normalDirectCaches) + free((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches) + free((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches) + free((MemoryRegionCache<?>[]) this.normalHeapCaches);
        if (iFree <= 0 || !logger.isDebugEnabled()) {
            return;
        }
        logger.debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(iFree), this.thread.getName());
    }

    private static int free(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return 0;
        }
        int iFree = 0;
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            iFree += free(memoryRegionCache);
        }
        return iFree;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free();
    }

    final void trim() {
        trim(this.tinySubPageDirectCaches);
        trim(this.smallSubPageDirectCaches);
        trim(this.normalDirectCaches);
        trim((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.normalHeapCaches);
    }

    private static void trim(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return;
        }
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            trim(memoryRegionCache);
        }
    }

    private static void trim(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return;
        }
        memoryRegionCache.trim();
    }

    private MemoryRegionCache<?> cacheForTiny(PoolArena<?> poolArena, int i) {
        int iTinyIdx = PoolArena.tinyIdx(i);
        if (poolArena.isDirect()) {
            return cache(this.tinySubPageDirectCaches, iTinyIdx);
        }
        return cache(this.tinySubPageHeapCaches, iTinyIdx);
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int i) {
        int iSmallIdx = PoolArena.smallIdx(i);
        if (poolArena.isDirect()) {
            return cache(this.smallSubPageDirectCaches, iSmallIdx);
        }
        return cache(this.smallSubPageHeapCaches, iSmallIdx);
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int i) {
        if (poolArena.isDirect()) {
            return cache(this.normalDirectCaches, log2(i >> this.numShiftsNormalDirect));
        }
        return cache(this.normalHeapCaches, log2(i >> this.numShiftsNormalHeap));
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] memoryRegionCacheArr, int i) {
        if (memoryRegionCacheArr == null || i > memoryRegionCacheArr.length - 1) {
            return null;
        }
        return memoryRegionCacheArr[i];
    }

    static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        SubPageMemoryRegionCache(int i, PoolArena.SizeClass sizeClass) {
            super(i, sizeClass);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected final void initBuf(PoolChunk<T> poolChunk, long j, PooledByteBuf<T> pooledByteBuf, int i) {
            poolChunk.initBufWithSubpage(pooledByteBuf, j, i);
        }
    }

    static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        NormalMemoryRegionCache(int i) {
            super(i, PoolArena.SizeClass.Normal);
        }

        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected final void initBuf(PoolChunk<T> poolChunk, long j, PooledByteBuf<T> pooledByteBuf, int i) {
            poolChunk.initBuf(pooledByteBuf, j, i);
        }
    }

    static abstract class MemoryRegionCache<T> {
        private static final Recycler<Entry> RECYCLER = new Recycler<Entry>() { // from class: io.netty.buffer.PoolThreadCache.MemoryRegionCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject, reason: merged with bridge method [inline-methods] */
            public final Entry newObject2(Recycler.Handle<Entry> handle) {
                return new Entry(handle);
            }
        };
        private int allocations;
        private final Queue<Entry<T>> queue;
        private final int size;
        private final PoolArena.SizeClass sizeClass;

        protected abstract void initBuf(PoolChunk<T> poolChunk, long j, PooledByteBuf<T> pooledByteBuf, int i);

        MemoryRegionCache(int i, PoolArena.SizeClass sizeClass) {
            this.size = MathUtil.findNextPositivePowerOfTwo(i);
            this.queue = PlatformDependent.newFixedMpscQueue(this.size);
            this.sizeClass = sizeClass;
        }

        public final boolean add(PoolChunk<T> poolChunk, long j) {
            Entry<T> entryNewEntry = newEntry(poolChunk, j);
            boolean zOffer = this.queue.offer(entryNewEntry);
            if (!zOffer) {
                entryNewEntry.recycle();
            }
            return zOffer;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i) {
            Entry<T> entryPoll = this.queue.poll();
            if (entryPoll == null) {
                return false;
            }
            initBuf(entryPoll.chunk, entryPoll.handle, pooledByteBuf, i);
            entryPoll.recycle();
            this.allocations++;
            return true;
        }

        public final int free() {
            return free(Integer.MAX_VALUE);
        }

        private int free(int i) {
            int i2 = 0;
            while (i2 < i) {
                Entry<T> entryPoll = this.queue.poll();
                if (entryPoll == null) {
                    break;
                }
                freeEntry(entryPoll);
                i2++;
            }
            return i2;
        }

        public final void trim() {
            int i = this.size - this.allocations;
            this.allocations = 0;
            if (i > 0) {
                free(i);
            }
        }

        private void freeEntry(Entry entry) {
            PoolChunk<T> poolChunk = entry.chunk;
            long j = entry.handle;
            entry.recycle();
            poolChunk.arena.freeChunk(poolChunk, j, this.sizeClass);
        }

        static final class Entry<T> {
            PoolChunk<T> chunk;
            long handle = -1;
            final Recycler.Handle recyclerHandle;

            Entry(Recycler.Handle handle) {
                this.recyclerHandle = handle;
            }

            final void recycle() {
                this.chunk = null;
                this.handle = -1L;
                MemoryRegionCache.RECYCLER.recycle(this, this.recyclerHandle);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> poolChunk, long j) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.handle = j;
            return entry;
        }
    }
}
