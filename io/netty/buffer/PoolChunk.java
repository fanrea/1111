package io.netty.buffer;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class PoolChunk<T> implements PoolChunkMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final PoolArena<T> arena;
    private final int chunkSize;
    private final byte[] depthMap;
    private int freeBytes;
    private final int log2ChunkSize;
    private final int maxOrder;
    private final int maxSubpageAllocs;
    final T memory;
    private final byte[] memoryMap;
    PoolChunk<T> next;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    private final int subpageOverflowMask;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;
    private final byte unusable;

    PoolChunk(PoolArena<T> poolArena, T t, int i, int i2, int i3, int i4) {
        this.unpooled = false;
        this.arena = poolArena;
        this.memory = t;
        this.pageSize = i;
        this.pageShifts = i3;
        this.maxOrder = i2;
        this.chunkSize = i4;
        this.unusable = (byte) (i2 + 1);
        this.log2ChunkSize = log2(i4);
        this.subpageOverflowMask = (i - 1) ^ (-1);
        this.freeBytes = i4;
        this.maxSubpageAllocs = 1 << i2;
        this.memoryMap = new byte[this.maxSubpageAllocs << 1];
        this.depthMap = new byte[this.memoryMap.length];
        int i5 = 0;
        int i6 = 1;
        while (i5 <= i2) {
            int i7 = 1 << i5;
            int i8 = i6;
            for (int i9 = 0; i9 < i7; i9++) {
                byte b = (byte) i5;
                this.memoryMap[i8] = b;
                this.depthMap[i8] = b;
                i8++;
            }
            i5++;
            i6 = i8;
        }
        this.subpages = newSubpageArray(this.maxSubpageAllocs);
    }

    PoolChunk(PoolArena<T> poolArena, T t, int i) {
        this.unpooled = true;
        this.arena = poolArena;
        this.memory = t;
        this.memoryMap = null;
        this.depthMap = null;
        this.subpages = null;
        this.subpageOverflowMask = 0;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.maxOrder = 0;
        this.unusable = (byte) (this.maxOrder + 1);
        this.chunkSize = i;
        this.log2ChunkSize = log2(this.chunkSize);
        this.maxSubpageAllocs = 0;
    }

    private PoolSubpage<T>[] newSubpageArray(int i) {
        return new PoolSubpage[i];
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public final int usage() {
        int i = this.freeBytes;
        if (i == 0) {
            return 100;
        }
        int i2 = (int) ((i * 100) / this.chunkSize);
        if (i2 == 0) {
            return 99;
        }
        return 100 - i2;
    }

    final long allocate(int i) {
        if ((this.subpageOverflowMask & i) != 0) {
            return allocateRun(i);
        }
        return allocateSubpage(i);
    }

    private void updateParentsAlloc(int i) {
        while (i > 1) {
            int i2 = i >>> 1;
            byte bValue = value(i);
            byte bValue2 = value(i ^ 1);
            if (bValue < bValue2) {
                bValue2 = bValue;
            }
            setValue(i2, bValue2);
            i = i2;
        }
    }

    private void updateParentsFree(int i) {
        int iDepth = depth(i) + 1;
        while (i > 1) {
            int i2 = i >>> 1;
            byte bValue = value(i);
            byte bValue2 = value(i ^ 1);
            iDepth--;
            if (bValue == iDepth && bValue2 == iDepth) {
                setValue(i2, (byte) (iDepth - 1));
            } else {
                if (bValue < bValue2) {
                    bValue2 = bValue;
                }
                setValue(i2, bValue2);
            }
            i = i2;
        }
    }

    private int allocateNode(int i) {
        int i2 = 1;
        int i3 = -(1 << i);
        byte bValue = value(1);
        if (bValue > i) {
            return -1;
        }
        while (true) {
            if (bValue < i || (i2 & i3) == 0) {
                i2 <<= 1;
                bValue = value(i2);
                if (bValue > i) {
                    i2 ^= 1;
                    bValue = value(i2);
                }
            } else {
                value(i2);
                setValue(i2, this.unusable);
                updateParentsAlloc(i2);
                return i2;
            }
        }
    }

    private long allocateRun(int i) {
        int iAllocateNode = allocateNode(this.maxOrder - (log2(i) - this.pageShifts));
        if (iAllocateNode < 0) {
            return iAllocateNode;
        }
        this.freeBytes -= runLength(iAllocateNode);
        return iAllocateNode;
    }

    private long allocateSubpage(int i) {
        PoolSubpage<T> poolSubpageFindSubpagePoolHead = this.arena.findSubpagePoolHead(i);
        synchronized (poolSubpageFindSubpagePoolHead) {
            int iAllocateNode = allocateNode(this.maxOrder);
            if (iAllocateNode < 0) {
                return iAllocateNode;
            }
            PoolSubpage<T>[] poolSubpageArr = this.subpages;
            int i2 = this.pageSize;
            this.freeBytes -= i2;
            int iSubpageIdx = subpageIdx(iAllocateNode);
            PoolSubpage<T> poolSubpage = poolSubpageArr[iSubpageIdx];
            if (poolSubpage == null) {
                PoolSubpage<T> poolSubpage2 = new PoolSubpage<>(poolSubpageFindSubpagePoolHead, this, iAllocateNode, runOffset(iAllocateNode), i2, i);
                poolSubpageArr[iSubpageIdx] = poolSubpage2;
                poolSubpage = poolSubpage2;
            } else {
                poolSubpage.init(poolSubpageFindSubpagePoolHead, i);
            }
            return poolSubpage.allocate();
        }
    }

    final void free(long j) {
        int i = (int) j;
        int i2 = (int) (j >>> 32);
        if (i2 != 0) {
            PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(i)];
            PoolSubpage<T> poolSubpageFindSubpagePoolHead = this.arena.findSubpagePoolHead(poolSubpage.elemSize);
            synchronized (poolSubpageFindSubpagePoolHead) {
                if (poolSubpage.free(poolSubpageFindSubpagePoolHead, i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK)) {
                    return;
                }
            }
        }
        this.freeBytes += runLength(i);
        setValue(i, depth(i));
        updateParentsFree(i);
    }

    final void initBuf(PooledByteBuf<T> pooledByteBuf, long j, int i) {
        int i2 = (int) j;
        int i3 = (int) (j >>> 32);
        if (i3 == 0) {
            value(i2);
            pooledByteBuf.init(this, j, runOffset(i2), i, runLength(i2), this.arena.parent.threadCache());
        } else {
            initBufWithSubpage(pooledByteBuf, j, i3, i);
        }
    }

    final void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, long j, int i) {
        initBufWithSubpage(pooledByteBuf, j, (int) (j >>> 32), i);
    }

    private void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, long j, int i, int i2) {
        int i3 = (int) j;
        PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(i3)];
        pooledByteBuf.init(this, j, runOffset(i3) + ((i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK) * poolSubpage.elemSize), i2, poolSubpage.elemSize, this.arena.parent.threadCache());
    }

    private byte value(int i) {
        return this.memoryMap[i];
    }

    private void setValue(int i, byte b) {
        this.memoryMap[i] = b;
    }

    private byte depth(int i) {
        return this.depthMap[i];
    }

    private static int log2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    private int runLength(int i) {
        return 1 << (this.log2ChunkSize - depth(i));
    }

    private int runOffset(int i) {
        return ((1 << depth(i)) ^ i) * runLength(i);
    }

    private int subpageIdx(int i) {
        return i ^ this.maxSubpageAllocs;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public final int freeBytes() {
        return this.freeBytes;
    }

    public final String toString() {
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage() + "%, " + (this.chunkSize - this.freeBytes) + '/' + this.chunkSize + ')';
    }
}
