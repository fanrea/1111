package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> refCntUpdater;
    private volatile int refCnt;

    protected abstract void deallocate();

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        return this;
    }

    static {
        AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        if (atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater == null) {
            atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        }
        refCntUpdater = atomicIntegerFieldUpdaterNewAtomicIntegerFieldUpdater;
    }

    protected AbstractReferenceCountedByteBuf(int i) {
        super(i);
        this.refCnt = 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.refCnt;
    }

    public final void setRefCnt(int i) {
        this.refCnt = i;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        int i;
        do {
            i = this.refCnt;
            if (i == 0) {
                throw new IllegalReferenceCountException(0, 1);
            }
            if (i == Integer.MAX_VALUE) {
                throw new IllegalReferenceCountException(Integer.MAX_VALUE, 1);
            }
        } while (!refCntUpdater.compareAndSet(this, i, i + 1));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i) {
        int i2;
        if (i <= 0) {
            throw new IllegalArgumentException("increment: " + i + " (expected: > 0)");
        }
        do {
            i2 = this.refCnt;
            if (i2 == 0) {
                throw new IllegalReferenceCountException(0, i);
            }
            if (i2 > Integer.MAX_VALUE - i) {
                throw new IllegalReferenceCountException(i2, i);
            }
        } while (!refCntUpdater.compareAndSet(this, i2, i2 + i));
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        int i;
        do {
            i = this.refCnt;
            if (i == 0) {
                throw new IllegalReferenceCountException(0, -1);
            }
        } while (!refCntUpdater.compareAndSet(this, i, i - 1));
        if (i != 1) {
            return false;
        }
        deallocate();
        return true;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        int i2;
        if (i <= 0) {
            throw new IllegalArgumentException("decrement: " + i + " (expected: > 0)");
        }
        do {
            i2 = this.refCnt;
            if (i2 < i) {
                throw new IllegalReferenceCountException(i2, -i);
            }
        } while (!refCntUpdater.compareAndSet(this, i2, i2 - i));
        if (i2 != i) {
            return false;
        }
        deallocate();
        return true;
    }
}
