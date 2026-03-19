package io.netty.util.internal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class MpscArrayQueueHeadCacheField<E> extends MpscArrayQueueMidPad<E> {
    private volatile long headCache;

    public MpscArrayQueueHeadCacheField(int i) {
        super(i);
    }

    protected final long lvConsumerIndexCache() {
        return this.headCache;
    }

    protected final void svConsumerIndexCache(long j) {
        this.headCache = j;
    }
}
