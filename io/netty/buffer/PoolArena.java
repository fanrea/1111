package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class PoolArena<T> implements PoolArenaMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    static final int numTinySubpagePools = 32;
    private long allocationsNormal;
    private long allocationsSmall;
    private long allocationsTiny;
    private final List<PoolChunkListMetric> chunkListMetrics;
    final int chunkSize;
    private long deallocationsNormal;
    private long deallocationsSmall;
    private long deallocationsTiny;
    private final int maxOrder;
    final int numSmallSubpagePools;
    final int pageShifts;
    final int pageSize;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;
    final int subpageOverflowMask;
    private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
    private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
    private final PoolSubpage<T>[] tinySubpagePools = newSubpagePoolArray(32);

    enum SizeClass {
        Tiny,
        Small,
        Normal
    }

    static boolean isTiny(int i) {
        return (i & (-512)) == 0;
    }

    static int smallIdx(int i) {
        int i2 = i >>> 10;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    static int tinyIdx(int i) {
        return i >>> 4;
    }

    protected abstract void destroyChunk(PoolChunk<T> poolChunk);

    abstract boolean isDirect();

    protected abstract void memoryCopy(T t, int i, T t2, int i2, int i3);

    protected abstract PooledByteBuf<T> newByteBuf(int i);

    protected abstract PoolChunk<T> newChunk(int i, int i2, int i3, int i4);

    protected abstract PoolChunk<T> newUnpooledChunk(int i);

    protected PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
        this.parent = pooledByteBufAllocator;
        this.pageSize = i;
        this.maxOrder = i2;
        this.pageShifts = i3;
        this.chunkSize = i4;
        this.subpageOverflowMask = (i - 1) ^ (-1);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.tinySubpagePools;
            if (i6 >= poolSubpageArr.length) {
                break;
            }
            poolSubpageArr[i6] = newSubpagePoolHead(i);
            i6++;
        }
        this.numSmallSubpagePools = i3 - 9;
        this.smallSubpagePools = newSubpagePoolArray(this.numSmallSubpagePools);
        while (true) {
            PoolSubpage<T>[] poolSubpageArr2 = this.smallSubpagePools;
            if (i5 < poolSubpageArr2.length) {
                poolSubpageArr2[i5] = newSubpagePoolHead(i);
                i5++;
            } else {
                this.q100 = new PoolChunkList<>(null, 100, Integer.MAX_VALUE);
                this.q075 = new PoolChunkList<>(this.q100, 75, 100);
                this.q050 = new PoolChunkList<>(this.q075, 50, 100);
                this.q025 = new PoolChunkList<>(this.q050, 25, 75);
                this.q000 = new PoolChunkList<>(this.q025, 1, 50);
                this.qInit = new PoolChunkList<>(this.q000, Integer.MIN_VALUE, 25);
                this.q100.prevList(this.q075);
                this.q075.prevList(this.q050);
                this.q050.prevList(this.q025);
                this.q025.prevList(this.q000);
                this.q000.prevList(null);
                PoolChunkList<T> poolChunkList = this.qInit;
                poolChunkList.prevList(poolChunkList);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(this.qInit);
                arrayList.add(this.q000);
                arrayList.add(this.q025);
                arrayList.add(this.q050);
                arrayList.add(this.q075);
                arrayList.add(this.q100);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
        }
    }

    private PoolSubpage<T> newSubpagePoolHead(int i) {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>(i);
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i) {
        return new PoolSubpage[i];
    }

    PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i, int i2) {
        PooledByteBuf<T> pooledByteBufNewByteBuf = newByteBuf(i2);
        allocate(poolThreadCache, pooledByteBufNewByteBuf, i);
        return pooledByteBufNewByteBuf;
    }

    boolean isTinyOrSmall(int i) {
        return (i & this.subpageOverflowMask) == 0;
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i) {
        int iSmallIdx;
        PoolSubpage<T>[] poolSubpageArr;
        int iNormalizeCapacity = normalizeCapacity(i);
        if (isTinyOrSmall(iNormalizeCapacity)) {
            boolean zIsTiny = isTiny(iNormalizeCapacity);
            if (zIsTiny) {
                if (poolThreadCache.allocateTiny(this, pooledByteBuf, i, iNormalizeCapacity)) {
                    return;
                }
                iSmallIdx = tinyIdx(iNormalizeCapacity);
                poolSubpageArr = this.tinySubpagePools;
            } else {
                if (poolThreadCache.allocateSmall(this, pooledByteBuf, i, iNormalizeCapacity)) {
                    return;
                }
                iSmallIdx = smallIdx(iNormalizeCapacity);
                poolSubpageArr = this.smallSubpagePools;
            }
            PoolSubpage<T> poolSubpage = poolSubpageArr[iSmallIdx];
            synchronized (poolSubpage) {
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                if (poolSubpage2 != poolSubpage) {
                    poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, poolSubpage2.allocate(), i);
                    if (zIsTiny) {
                        this.allocationsTiny++;
                    } else {
                        this.allocationsSmall++;
                    }
                    return;
                }
                allocateNormal(pooledByteBuf, i, iNormalizeCapacity);
                return;
            }
        }
        if (iNormalizeCapacity <= this.chunkSize) {
            if (poolThreadCache.allocateNormal(this, pooledByteBuf, i, iNormalizeCapacity)) {
                return;
            }
            allocateNormal(pooledByteBuf, i, iNormalizeCapacity);
            return;
        }
        allocateHuge(pooledByteBuf, i);
    }

    private synchronized void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        this.allocationsNormal++;
        if (!this.q050.allocate(pooledByteBuf, i, i2) && !this.q025.allocate(pooledByteBuf, i, i2) && !this.q000.allocate(pooledByteBuf, i, i2) && !this.qInit.allocate(pooledByteBuf, i, i2) && !this.q075.allocate(pooledByteBuf, i, i2) && !this.q100.allocate(pooledByteBuf, i, i2)) {
            PoolChunk<T> poolChunkNewChunk = newChunk(this.pageSize, this.maxOrder, this.pageShifts, this.chunkSize);
            poolChunkNewChunk.initBuf(pooledByteBuf, poolChunkNewChunk.allocate(i2), i);
            this.qInit.add(poolChunkNewChunk);
        }
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i) {
        this.allocationsHuge.increment();
        pooledByteBuf.initUnpooled(newUnpooledChunk(i), i);
    }

    void free(PoolChunk<T> poolChunk, long j, int i, PoolThreadCache poolThreadCache) {
        if (poolChunk.unpooled) {
            this.allocationsHuge.decrement();
            destroyChunk(poolChunk);
            return;
        }
        SizeClass sizeClass = sizeClass(i);
        if (poolThreadCache == null || !poolThreadCache.add(this, poolChunk, j, i, sizeClass)) {
            freeChunk(poolChunk, j, sizeClass);
        }
    }

    private SizeClass sizeClass(int i) {
        if (isTinyOrSmall(i)) {
            return isTiny(i) ? SizeClass.Tiny : SizeClass.Small;
        }
        return SizeClass.Normal;
    }

    /* renamed from: io.netty.buffer.PoolArena$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass = new int[SizeClass.values().length];

        static {
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    void freeChunk(PoolChunk<T> poolChunk, long j, SizeClass sizeClass) {
        boolean z;
        synchronized (this) {
            int i = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
            z = true;
            if (i == 1) {
                this.deallocationsNormal++;
            } else if (i == 2) {
                this.deallocationsSmall++;
            } else if (i == 3) {
                this.deallocationsTiny++;
            } else {
                throw new Error();
            }
            if (poolChunk.parent.free(poolChunk, j)) {
                z = false;
            }
        }
        if (z) {
            destroyChunk(poolChunk);
        }
    }

    PoolSubpage<T> findSubpagePoolHead(int i) {
        int i2;
        PoolSubpage<T>[] poolSubpageArr;
        if (isTiny(i)) {
            i2 = i >>> 4;
            poolSubpageArr = this.tinySubpagePools;
        } else {
            i2 = 0;
            int i3 = i >>> 10;
            while (i3 != 0) {
                i3 >>>= 1;
                i2++;
            }
            poolSubpageArr = this.smallSubpagePools;
        }
        return poolSubpageArr[i2];
    }

    int normalizeCapacity(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity: " + i + " (expected: 0+)");
        }
        if (i >= this.chunkSize) {
            return i;
        }
        if (isTiny(i)) {
            return (i & 15) == 0 ? i : (i & (-16)) + 16;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = (i6 | (i6 >>> 16)) + 1;
        return i7 < 0 ? i7 >>> 1 : i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void reallocate(io.netty.buffer.PooledByteBuf<T> r13, int r14, boolean r15) {
        /*
            r12 = this;
            if (r14 < 0) goto L60
            int r0 = r13.maxCapacity()
            if (r14 > r0) goto L60
            int r6 = r13.length
            if (r6 != r14) goto Ld
            return
        Ld:
            io.netty.buffer.PoolChunk<T> r7 = r13.chunk
            long r8 = r13.handle
            T r2 = r13.memory
            int r3 = r13.offset
            int r10 = r13.maxLength
            int r11 = r13.readerIndex()
            int r0 = r13.writerIndex()
            io.netty.buffer.PooledByteBufAllocator r1 = r12.parent
            io.netty.buffer.PoolThreadCache r1 = r1.threadCache()
            r12.allocate(r1, r13, r14)
            if (r14 <= r6) goto L33
            T r4 = r13.memory
            int r5 = r13.offset
            r1 = r12
            r1.memoryCopy(r2, r3, r4, r5, r6)
            goto L50
        L33:
            if (r14 >= r6) goto L50
            if (r11 >= r14) goto L4e
            if (r0 <= r14) goto L3a
            goto L3b
        L3a:
            r14 = r0
        L3b:
            int r3 = r3 + r11
            T r4 = r13.memory
            int r0 = r13.offset
            int r5 = r0 + r11
            int r6 = r14 - r11
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r0.memoryCopy(r1, r2, r3, r4, r5)
            goto L51
        L4e:
            r11 = r14
            goto L51
        L50:
            r14 = r0
        L51:
            r13.setIndex(r11, r14)
            if (r15 == 0) goto L5f
            io.netty.buffer.PoolThreadCache r5 = r13.cache
            r0 = r12
            r1 = r7
            r2 = r8
            r4 = r10
            r0.free(r1, r2, r4, r5)
        L5f:
            return
        L60:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r0 = "newCapacity: "
            r15.<init>(r0)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.PoolArena.reallocate(io.netty.buffer.PooledByteBuf, int, boolean):void");
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return this.tinySubpagePools.length;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> tinySubpages() {
        return subPageMetricList(this.tinySubpagePools);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] poolSubpageArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < poolSubpageArr.length; i++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i];
            if (poolSubpage.next != poolSubpage) {
                PoolSubpage poolSubpage2 = poolSubpage.next;
                do {
                    arrayList.add(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        return arrayList;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        return this.allocationsTiny + this.allocationsSmall + this.allocationsNormal + this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return this.allocationsTiny;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numNormalAllocations() {
        return this.allocationsNormal;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        return this.deallocationsTiny + this.deallocationsSmall + this.allocationsNormal + this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyDeallocations() {
        return this.deallocationsTiny;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallDeallocations() {
        return this.deallocationsSmall;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numNormalDeallocations() {
        return this.deallocationsNormal;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long jNumAllocations = numAllocations() - numDeallocations();
        if (jNumAllocations >= 0) {
            return jNumAllocations;
        }
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        long jNumTinyAllocations = numTinyAllocations() - numTinyDeallocations();
        if (jNumTinyAllocations >= 0) {
            return jNumTinyAllocations;
        }
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        long jNumSmallAllocations = numSmallAllocations() - numSmallDeallocations();
        if (jNumSmallAllocations >= 0) {
            return jNumSmallAllocations;
        }
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        long jNumNormalAllocations = numNormalAllocations() - numNormalDeallocations();
        if (jNumNormalAllocations >= 0) {
            return jNumNormalAllocations;
        }
        return 0L;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        long jNumHugeAllocations = numHugeAllocations() - numHugeDeallocations();
        if (jNumHugeAllocations >= 0) {
            return jNumHugeAllocations;
        }
        return 0L;
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder("Chunk(s) at 0~25%:");
        sb.append(StringUtil.NEWLINE);
        sb.append(this.qInit);
        sb.append(StringUtil.NEWLINE);
        sb.append("Chunk(s) at 0~50%:");
        sb.append(StringUtil.NEWLINE);
        sb.append(this.q000);
        sb.append(StringUtil.NEWLINE);
        sb.append("Chunk(s) at 25~75%:");
        sb.append(StringUtil.NEWLINE);
        sb.append(this.q025);
        sb.append(StringUtil.NEWLINE);
        sb.append("Chunk(s) at 50~100%:");
        sb.append(StringUtil.NEWLINE);
        sb.append(this.q050);
        sb.append(StringUtil.NEWLINE);
        sb.append("Chunk(s) at 75~100%:");
        sb.append(StringUtil.NEWLINE);
        sb.append(this.q075);
        sb.append(StringUtil.NEWLINE);
        sb.append("Chunk(s) at 100%:");
        sb.append(StringUtil.NEWLINE);
        sb.append(this.q100);
        sb.append(StringUtil.NEWLINE);
        sb.append("tiny subpages:");
        for (int i = 1; i < this.tinySubpagePools.length; i++) {
            PoolSubpage<T> poolSubpage = this.tinySubpagePools[i];
            if (poolSubpage.next != poolSubpage) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i);
                sb.append(": ");
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                do {
                    sb.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        sb.append(StringUtil.NEWLINE);
        sb.append("small subpages:");
        for (int i2 = 1; i2 < this.smallSubpagePools.length; i2++) {
            PoolSubpage<T> poolSubpage3 = this.smallSubpagePools[i2];
            if (poolSubpage3.next != poolSubpage3) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i2);
                sb.append(": ");
                PoolSubpage<T> poolSubpage4 = poolSubpage3.next;
                do {
                    sb.append(poolSubpage4);
                    poolSubpage4 = poolSubpage4.next;
                } while (poolSubpage4 != poolSubpage3);
            }
        }
        sb.append(StringUtil.NEWLINE);
        return sb.toString();
    }

    static final class HeapArena extends PoolArena<byte[]> {
        @Override // io.netty.buffer.PoolArena
        protected final void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }

        @Override // io.netty.buffer.PoolArena
        final boolean isDirect() {
            return false;
        }

        HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
            super(pooledByteBufAllocator, i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected final PoolChunk<byte[]> newChunk(int i, int i2, int i3, int i4) {
            return new PoolChunk<>(this, new byte[i4], i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected final PoolChunk<byte[]> newUnpooledChunk(int i) {
            return new PoolChunk<>(this, new byte[i], i);
        }

        @Override // io.netty.buffer.PoolArena
        protected final PooledByteBuf<byte[]> newByteBuf(int i) {
            return HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i) : PooledHeapByteBuf.newInstance(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public final void memoryCopy(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
            if (i3 == 0) {
                return;
            }
            System.arraycopy(bArr, i, bArr2, i2, i3);
        }
    }

    static final class DirectArena extends PoolArena<ByteBuffer> {
        @Override // io.netty.buffer.PoolArena
        final boolean isDirect() {
            return true;
        }

        DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
            super(pooledByteBufAllocator, i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected final PoolChunk<ByteBuffer> newChunk(int i, int i2, int i3, int i4) {
            return new PoolChunk<>(this, ByteBuffer.allocateDirect(i4), i, i2, i3, i4);
        }

        @Override // io.netty.buffer.PoolArena
        protected final PoolChunk<ByteBuffer> newUnpooledChunk(int i) {
            return new PoolChunk<>(this, ByteBuffer.allocateDirect(i), i);
        }

        @Override // io.netty.buffer.PoolArena
        protected final void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            PlatformDependent.freeDirectBuffer(poolChunk.memory);
        }

        @Override // io.netty.buffer.PoolArena
        protected final PooledByteBuf<ByteBuffer> newByteBuf(int i) {
            if (HAS_UNSAFE) {
                return PooledUnsafeDirectByteBuf.newInstance(i);
            }
            return PooledDirectByteBuf.newInstance(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public final void memoryCopy(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, int i3) {
            if (i3 == 0) {
                return;
            }
            if (HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + i, PlatformDependent.directBufferAddress(byteBuffer2) + i2, i3);
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            ByteBuffer byteBufferDuplicate2 = byteBuffer2.duplicate();
            byteBufferDuplicate.position(i).limit(i + i3);
            byteBufferDuplicate2.position(i2);
            byteBufferDuplicate2.put(byteBufferDuplicate);
        }
    }
}
