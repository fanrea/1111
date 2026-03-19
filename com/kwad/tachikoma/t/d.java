package com.kwad.tachikoma.t;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d<T> implements List<T> {
    private List<T> EU;

    public d(List<T> list) {
        this.EU = list;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.EU.size();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.EU.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.EU.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return this.EU.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.EU.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public final <T1> T1[] toArray(T1[] t1Arr) {
        return (T1[]) this.EU.toArray(t1Arr);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t) {
        return this.EU.add(t);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.EU.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.EU.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        return this.EU.addAll(collection);
    }

    @Override // java.util.List
    public final void add(int i, T t) {
        this.EU.add(i, t);
    }

    @Override // java.util.List
    public final T remove(int i) {
        return this.EU.remove(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.EU.indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.EU.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return this.EU.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int i) {
        return this.EU.listIterator(i);
    }

    @Override // java.util.List
    public final List<T> subList(int i, int i2) {
        return this.EU.subList(i, i2);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection<? extends T> collection) {
        return this.EU.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return this.EU.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return this.EU.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.EU.clear();
    }

    @Override // java.util.List
    public final T get(int i) {
        return this.EU.get(i);
    }

    @Override // java.util.List
    public final T set(int i, T t) {
        return this.EU.set(i, t);
    }
}
