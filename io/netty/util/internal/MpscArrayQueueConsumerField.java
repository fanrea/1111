package io.netty.util.internal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class MpscArrayQueueConsumerField<E> extends MpscArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET;
    private volatile long consumerIndex;

    static {
        try {
            C_INDEX_OFFSET = PlatformDependent0.UNSAFE.objectFieldOffset(MpscArrayQueueConsumerField.class.getDeclaredField("consumerIndex"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public MpscArrayQueueConsumerField(int i) {
        super(i);
    }

    protected final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    protected void soConsumerIndex(long j) {
        PlatformDependent0.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }
}
