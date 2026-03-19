package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class UnsafeAtomicReferenceFieldUpdater<U, M> extends AtomicReferenceFieldUpdater<U, M> {
    private final long offset;
    private final Unsafe unsafe;

    UnsafeAtomicReferenceFieldUpdater(Unsafe unsafe, Class<? super U> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!Modifier.isVolatile(declaredField.getModifiers())) {
            throw new IllegalArgumentException("Must be volatile");
        }
        this.unsafe = unsafe;
        this.offset = unsafe.objectFieldOffset(declaredField);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public final boolean compareAndSet(U u, M m, M m2) {
        return this.unsafe.compareAndSwapObject(u, this.offset, m, m2);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public final boolean weakCompareAndSet(U u, M m, M m2) {
        return this.unsafe.compareAndSwapObject(u, this.offset, m, m2);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public final void set(U u, M m) {
        this.unsafe.putObjectVolatile(u, this.offset, m);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public final void lazySet(U u, M m) {
        this.unsafe.putOrderedObject(u, this.offset, m);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public final M get(U u) {
        return (M) this.unsafe.getObjectVolatile(u, this.offset);
    }
}
