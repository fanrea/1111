package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class PoolChunkList<T> implements PoolChunkListMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Iterator<PoolChunkMetric> EMPTY_METRICS = Collections.emptyList().iterator();
    private PoolChunk<T> head;
    private final int maxUsage;
    private final int minUsage;
    private final PoolChunkList<T> nextList;
    private PoolChunkList<T> prevList;

    PoolChunkList(PoolChunkList<T> poolChunkList, int i, int i2) {
        this.nextList = poolChunkList;
        this.minUsage = i;
        this.maxUsage = i2;
    }

    final void prevList(PoolChunkList<T> poolChunkList) {
        this.prevList = poolChunkList;
    }

    final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        PoolChunk<T> poolChunk = this.head;
        if (poolChunk == null) {
            return false;
        }
        do {
            long jAllocate = poolChunk.allocate(i2);
            if (jAllocate < 0) {
                poolChunk = poolChunk.next;
            } else {
                poolChunk.initBuf(pooledByteBuf, jAllocate, i);
                if (poolChunk.usage() < this.maxUsage) {
                    return true;
                }
                remove(poolChunk);
                this.nextList.add(poolChunk);
                return true;
            }
        } while (poolChunk != null);
        return false;
    }

    final boolean free(PoolChunk<T> poolChunk, long j) {
        poolChunk.free(j);
        if (poolChunk.usage() < this.minUsage) {
            remove(poolChunk);
            PoolChunkList<T> poolChunkList = this.prevList;
            if (poolChunkList == null) {
                return false;
            }
            poolChunkList.add(poolChunk);
        }
        return true;
    }

    final void add(PoolChunk<T> poolChunk) {
        PoolChunkList<T> poolChunkList = this;
        while (poolChunk.usage() >= poolChunkList.maxUsage) {
            poolChunkList = poolChunkList.nextList;
        }
        poolChunk.parent = poolChunkList;
        PoolChunk<T> poolChunk2 = poolChunkList.head;
        if (poolChunk2 == null) {
            poolChunkList.head = poolChunk;
            poolChunk.prev = null;
            poolChunk.next = null;
        } else {
            poolChunk.prev = null;
            poolChunk.next = poolChunk2;
            poolChunk2.prev = poolChunk;
            poolChunkList.head = poolChunk;
        }
    }

    private void remove(PoolChunk<T> poolChunk) {
        if (poolChunk == this.head) {
            this.head = poolChunk.next;
            PoolChunk<T> poolChunk2 = this.head;
            if (poolChunk2 != null) {
                poolChunk2.prev = null;
                return;
            }
            return;
        }
        PoolChunk<T> poolChunk3 = poolChunk.next;
        poolChunk.prev.next = poolChunk3;
        if (poolChunk3 != null) {
            poolChunk3.prev = poolChunk.prev;
        }
    }

    @Override // io.netty.buffer.PoolChunkListMetric
    public final int minUsage() {
        return this.minUsage;
    }

    @Override // io.netty.buffer.PoolChunkListMetric
    public final int maxUsage() {
        return this.maxUsage;
    }

    @Override // java.lang.Iterable
    public final Iterator<PoolChunkMetric> iterator() {
        if (this.head == null) {
            return EMPTY_METRICS;
        }
        ArrayList arrayList = new ArrayList();
        PoolChunk<T> poolChunk = this.head;
        do {
            arrayList.add(poolChunk);
            poolChunk = poolChunk.next;
        } while (poolChunk != null);
        return arrayList.iterator();
    }

    public final String toString() {
        if (this.head == null) {
            return "none";
        }
        StringBuilder sb = new StringBuilder();
        PoolChunk<T> poolChunk = this.head;
        while (true) {
            sb.append(poolChunk);
            poolChunk = poolChunk.next;
            if (poolChunk != null) {
                sb.append(StringUtil.NEWLINE);
            } else {
                return sb.toString();
            }
        }
    }
}
