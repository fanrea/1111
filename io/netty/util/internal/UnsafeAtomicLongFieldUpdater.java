package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class UnsafeAtomicLongFieldUpdater<T> extends AtomicLongFieldUpdater<T> {
    private final long offset;
    private final Unsafe unsafe;

    UnsafeAtomicLongFieldUpdater(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!Modifier.isVolatile(declaredField.getModifiers())) {
            throw new IllegalArgumentException("Must be volatile");
        }
        this.unsafe = unsafe;
        this.offset = unsafe.objectFieldOffset(declaredField);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public final boolean compareAndSet(T t, long j, long j2) {
        return this.unsafe.compareAndSwapLong(t, this.offset, j, j2);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public final boolean weakCompareAndSet(T t, long j, long j2) {
        return this.unsafe.compareAndSwapLong(t, this.offset, j, j2);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public final void set(T t, long j) {
        this.unsafe.putLongVolatile(t, this.offset, j);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public final void lazySet(T t, long j) {
        this.unsafe.putOrderedLong(t, this.offset, j);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public final long get(T t) {
        return this.unsafe.getLongVolatile(t, this.offset);
    }
}
