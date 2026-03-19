package io.netty.util.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import sun.misc.Unsafe;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class UnsafeAtomicIntegerFieldUpdater<T> extends AtomicIntegerFieldUpdater<T> {
    private final long offset;
    private final Unsafe unsafe;

    UnsafeAtomicIntegerFieldUpdater(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!Modifier.isVolatile(declaredField.getModifiers())) {
            throw new IllegalArgumentException("Must be volatile");
        }
        this.unsafe = unsafe;
        this.offset = unsafe.objectFieldOffset(declaredField);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public final boolean compareAndSet(T t, int i, int i2) {
        return this.unsafe.compareAndSwapInt(t, this.offset, i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public final boolean weakCompareAndSet(T t, int i, int i2) {
        return this.unsafe.compareAndSwapInt(t, this.offset, i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public final void set(T t, int i) {
        this.unsafe.putIntVolatile(t, this.offset, i);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public final void lazySet(T t, int i) {
        this.unsafe.putOrderedInt(t, this.offset, i);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public final int get(T t) {
        return this.unsafe.getIntVolatile(t, this.offset);
    }
}
