package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList<>();
    }

    public VolatileSizeArrayList(int i) {
        this.list = new ArrayList<>(i);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return get();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public final <E> E[] toArray(E[] eArr) {
        return (E[]) this.list.toArray(eArr);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t) {
        boolean zAdd = this.list.add(t);
        lazySet(this.list.size());
        return zAdd;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        boolean zRemove = this.list.remove(obj);
        lazySet(this.list.size());
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        boolean zAddAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return zAddAll;
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection<? extends T> collection) {
        boolean zAddAll = this.list.addAll(i, collection);
        lazySet(this.list.size());
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        boolean zRemoveAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return zRemoveAll;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        boolean zRetainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return zRetainAll;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List
    public final T get(int i) {
        return this.list.get(i);
    }

    @Override // java.util.List
    public final T set(int i, T t) {
        return this.list.set(i, t);
    }

    @Override // java.util.List
    public final void add(int i, T t) {
        this.list.add(i, t);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public final T remove(int i) {
        T tRemove = this.list.remove(i);
        lazySet(this.list.size());
        return tRemove;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int i) {
        return this.list.listIterator(i);
    }

    @Override // java.util.List
    public final List<T> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.list.equals(((VolatileSizeArrayList) obj).list);
        }
        return this.list.equals(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final String toString() {
        return this.list.toString();
    }
}
