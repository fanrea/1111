package com.kwad.sdk.lib.widget.a.a;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c<T> implements List<T> {
    private final d<T> ccU;

    public c(d<T> dVar) {
        this.ccU = dVar;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.ccU.getCurrentList().size();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.ccU.getCurrentList().isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.ccU.getCurrentList().contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return this.ccU.getCurrentList().iterator();
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer<? super T> consumer) {
        this.ccU.getCurrentList().forEach(consumer);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.ccU.getCurrentList().toArray();
    }

    @Override // java.util.List, java.util.Collection
    public final <T1> T1[] toArray(T1[] t1Arr) {
        return (T1[]) this.ccU.getCurrentList().toArray(t1Arr);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t) {
        return this.ccU.getCurrentList().add(t);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.ccU.getCurrentList().remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.ccU.getCurrentList().containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        return this.ccU.getCurrentList().addAll(collection);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection<? extends T> collection) {
        return this.ccU.getCurrentList().addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return this.ccU.getCurrentList().removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return this.ccU.getCurrentList().retainAll(collection);
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<T> unaryOperator) {
        this.ccU.getCurrentList().replaceAll(unaryOperator);
    }

    @Override // java.util.List
    public final void sort(Comparator<? super T> comparator) {
        this.ccU.getCurrentList().sort(comparator);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.ccU.getCurrentList().clear();
    }

    @Override // java.util.List
    public final T get(int i) {
        return this.ccU.getCurrentList().get(i);
    }

    @Override // java.util.List
    public final T set(int i, T t) {
        return this.ccU.getCurrentList().set(i, t);
    }

    @Override // java.util.List
    public final void add(int i, T t) {
        this.ccU.getCurrentList().add(i, t);
    }

    @Override // java.util.List
    public final T remove(int i) {
        return this.ccU.getCurrentList().remove(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.ccU.getCurrentList().indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.ccU.getCurrentList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return this.ccU.getCurrentList().listIterator();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int i) {
        return this.ccU.getCurrentList().listIterator(i);
    }

    @Override // java.util.List
    public final List<T> subList(int i, int i2) {
        return this.ccU.getCurrentList().subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Spliterator<T> spliterator() {
        return this.ccU.getCurrentList().spliterator();
    }
}
