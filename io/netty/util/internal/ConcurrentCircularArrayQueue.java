package io.netty.util.internal;

import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    private static final long REF_ARRAY_BASE;
    protected static final int REF_BUFFER_PAD;
    private static final int REF_ELEMENT_SHIFT;
    protected final E[] buffer;
    protected final long mask;

    static {
        int iArrayIndexScale = PlatformDependent0.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == iArrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_BUFFER_PAD = 128 / iArrayIndexScale;
        REF_ARRAY_BASE = PlatformDependent0.UNSAFE.arrayBaseOffset(Object[].class) + (REF_BUFFER_PAD * iArrayIndexScale);
    }

    public ConcurrentCircularArrayQueue(int i) {
        int iRoundToPowerOfTwo = roundToPowerOfTwo(i);
        this.mask = iRoundToPowerOfTwo - 1;
        this.buffer = (E[]) new Object[iRoundToPowerOfTwo + (REF_BUFFER_PAD * 2)];
    }

    private static int roundToPowerOfTwo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    protected final long calcElementOffset(long j) {
        return calcElementOffset(j, this.mask);
    }

    protected static final long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << REF_ELEMENT_SHIFT);
    }

    protected final void spElement(long j, E e) {
        spElement(this.buffer, j, e);
    }

    protected static final <E> void spElement(E[] eArr, long j, E e) {
        PlatformDependent0.UNSAFE.putObject(eArr, j, e);
    }

    protected final void soElement(long j, E e) {
        soElement(this.buffer, j, e);
    }

    protected static final <E> void soElement(E[] eArr, long j, E e) {
        PlatformDependent0.UNSAFE.putOrderedObject(eArr, j, e);
    }

    protected final E lpElement(long j) {
        return (E) lpElement(this.buffer, j);
    }

    protected static final <E> E lpElement(E[] eArr, long j) {
        return (E) PlatformDependent0.UNSAFE.getObject(eArr, j);
    }

    protected final E lvElement(long j) {
        return (E) lvElement(this.buffer, j);
    }

    protected static final <E> E lvElement(E[] eArr, long j) {
        return (E) PlatformDependent0.UNSAFE.getObjectVolatile(eArr, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public int capacity() {
        return (int) (this.mask + 1);
    }
}
