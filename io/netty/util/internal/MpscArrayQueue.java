package io.netty.util.internal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class MpscArrayQueue<E> extends MpscArrayQueueConsumerField<E> {
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;
    long p40;
    long p41;
    long p42;
    long p43;
    long p44;
    long p45;
    long p46;

    public MpscArrayQueue(int i) {
        super(i);
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        long jLvProducerIndex;
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j = this.mask;
        long j2 = j + 1;
        long jLvConsumerIndexCache = lvConsumerIndexCache();
        do {
            jLvProducerIndex = lvProducerIndex();
            long j3 = jLvProducerIndex - j2;
            if (jLvConsumerIndexCache <= j3) {
                jLvConsumerIndexCache = lvConsumerIndex();
                if (jLvConsumerIndexCache <= j3) {
                    return false;
                }
                svConsumerIndexCache(jLvConsumerIndexCache);
            }
        } while (!casProducerIndex(jLvProducerIndex, jLvProducerIndex + 1));
        soElement(calcElementOffset(jLvProducerIndex, j), e);
        return true;
    }

    public final int weakOffer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j = this.mask;
        long jLvProducerIndex = lvProducerIndex();
        long j2 = jLvProducerIndex - (j + 1);
        if (lvConsumerIndexCache() <= j2) {
            long jLvConsumerIndex = lvConsumerIndex();
            if (jLvConsumerIndex <= j2) {
                return 1;
            }
            svConsumerIndexCache(jLvConsumerIndex);
        }
        if (!casProducerIndex(jLvProducerIndex, 1 + jLvProducerIndex)) {
            return -1;
        }
        soElement(calcElementOffset(jLvProducerIndex, j), e);
        return 0;
    }

    @Override // java.util.Queue
    public final E poll() {
        long jLvConsumerIndex = lvConsumerIndex();
        long jCalcElementOffset = calcElementOffset(jLvConsumerIndex);
        E[] eArr = this.buffer;
        E e = (E) lvElement(eArr, jCalcElementOffset);
        if (e == null) {
            if (jLvConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e = (E) lvElement(eArr, jCalcElementOffset);
            } while (e == null);
        }
        spElement(eArr, jCalcElementOffset, null);
        soConsumerIndex(jLvConsumerIndex + 1);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.buffer;
        long jLvConsumerIndex = lvConsumerIndex();
        long jCalcElementOffset = calcElementOffset(jLvConsumerIndex);
        E e = (E) lvElement(eArr, jCalcElementOffset);
        if (e == null) {
            if (jLvConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e = (E) lvElement(eArr, jCalcElementOffset);
            } while (e == null);
        }
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long jLvConsumerIndex = lvConsumerIndex();
        while (true) {
            long jLvProducerIndex = lvProducerIndex();
            long jLvConsumerIndex2 = lvConsumerIndex();
            if (jLvConsumerIndex == jLvConsumerIndex2) {
                return (int) (jLvProducerIndex - jLvConsumerIndex2);
            }
            jLvConsumerIndex = jLvConsumerIndex2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }
}
