package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultAttributeMap implements AttributeMap {
    private static final int BUCKET_SIZE = 4;
    private static final int MASK = 3;
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, AtomicReferenceArray> updater;
    private volatile AtomicReferenceArray<DefaultAttribute<?>> attributes;

    static {
        AtomicReferenceFieldUpdater<DefaultAttributeMap, AtomicReferenceArray> atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(DefaultAttributeMap.class, "attributes");
        if (atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater == null) {
            atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, AtomicReferenceArray.class, "attributes");
        }
        updater = atomicReferenceFieldUpdaterNewAtomicReferenceFieldUpdater;
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        if (attributeKey == null) {
            throw new NullPointerException("key");
        }
        AtomicReferenceArray<DefaultAttribute<?>> atomicReferenceArray = this.attributes;
        if (atomicReferenceArray == null) {
            atomicReferenceArray = new AtomicReferenceArray<>(4);
            if (!updater.compareAndSet(this, null, atomicReferenceArray)) {
                atomicReferenceArray = this.attributes;
            }
        }
        int iIndex = index(attributeKey);
        DefaultAttribute<?> defaultAttribute = atomicReferenceArray.get(iIndex);
        if (defaultAttribute == null) {
            DefaultAttribute<?> defaultAttribute2 = new DefaultAttribute<>(attributeKey);
            if (atomicReferenceArray.compareAndSet(iIndex, null, defaultAttribute2)) {
                return defaultAttribute2;
            }
            defaultAttribute = atomicReferenceArray.get(iIndex);
        }
        synchronized (defaultAttribute) {
            DefaultAttribute<?> defaultAttribute3 = defaultAttribute;
            while (true) {
                if (!((DefaultAttribute) defaultAttribute3).removed && ((DefaultAttribute) defaultAttribute3).key == attributeKey) {
                    return defaultAttribute3;
                }
                DefaultAttribute<?> defaultAttribute4 = ((DefaultAttribute) defaultAttribute3).next;
                if (defaultAttribute4 == null) {
                    DefaultAttribute defaultAttribute5 = new DefaultAttribute(defaultAttribute, attributeKey);
                    ((DefaultAttribute) defaultAttribute3).next = defaultAttribute5;
                    defaultAttribute5.prev = defaultAttribute3;
                    return defaultAttribute5;
                }
                defaultAttribute3 = defaultAttribute4;
            }
        }
    }

    @Override // io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        DefaultAttribute<?> defaultAttribute;
        if (attributeKey == null) {
            throw new NullPointerException("key");
        }
        AtomicReferenceArray<DefaultAttribute<?>> atomicReferenceArray = this.attributes;
        if (atomicReferenceArray == null || (defaultAttribute = atomicReferenceArray.get(index(attributeKey))) == null) {
            return false;
        }
        if (((DefaultAttribute) defaultAttribute).key == attributeKey && !((DefaultAttribute) defaultAttribute).removed) {
            return true;
        }
        synchronized (defaultAttribute) {
            for (DefaultAttribute defaultAttribute2 = ((DefaultAttribute) defaultAttribute).next; defaultAttribute2 != null; defaultAttribute2 = defaultAttribute2.next) {
                if (!defaultAttribute2.removed && defaultAttribute2.key == attributeKey) {
                    return true;
                }
            }
            return false;
        }
    }

    private static int index(AttributeKey<?> attributeKey) {
        return attributeKey.id() & 3;
    }

    static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final long serialVersionUID = -2661411462200283011L;
        private final DefaultAttribute<?> head;
        private final AttributeKey<T> key;
        private DefaultAttribute<?> next;
        private DefaultAttribute<?> prev;
        private volatile boolean removed;

        DefaultAttribute(DefaultAttribute<?> defaultAttribute, AttributeKey<T> attributeKey) {
            this.head = defaultAttribute;
            this.key = attributeKey;
        }

        /* JADX WARN: Multi-variable type inference failed */
        DefaultAttribute(AttributeKey<T> attributeKey) {
            this.head = this;
            this.key = attributeKey;
        }

        @Override // io.netty.util.Attribute
        public final AttributeKey<T> key() {
            return this.key;
        }

        @Override // io.netty.util.Attribute
        public final T setIfAbsent(T t) {
            T t2;
            do {
                t2 = null;
                if (compareAndSet(null, t)) {
                    break;
                }
                t2 = get();
            } while (t2 == null);
            return t2;
        }

        @Override // io.netty.util.Attribute
        public final T getAndRemove() {
            this.removed = true;
            T andSet = getAndSet(null);
            remove0();
            return andSet;
        }

        @Override // io.netty.util.Attribute
        public final void remove() {
            this.removed = true;
            set(null);
            remove0();
        }

        private void remove0() {
            synchronized (this.head) {
                if (this.prev != null) {
                    this.prev.next = this.next;
                    if (this.next != null) {
                        this.next.prev = this.prev;
                    }
                    this.prev = null;
                    this.next = null;
                }
            }
        }
    }
}
