package io.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;
    private final Iterator<E> i1;
    private final Iterator<E> i2;

    CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        if (it == null) {
            throw new NullPointerException("i1");
        }
        if (it2 == null) {
            throw new NullPointerException("i2");
        }
        this.i1 = it;
        this.i2 = it2;
        this.currentIterator = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.i1) {
                return false;
            }
            this.currentIterator = this.i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e) {
                if (this.currentIterator != this.i1) {
                    throw e;
                }
                this.currentIterator = this.i2;
            }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.currentIterator.remove();
    }
}
