package com.kwad.sdk.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveAutoIndexTemplateList<T> implements List<T> {
    private List<T> mBaseList;

    public LiveAutoIndexTemplateList(List<T> list) {
        this.mBaseList = list;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.mBaseList.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.mBaseList.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.mBaseList.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.mBaseList.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.mBaseList.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T1> T1[] toArray(T1[] t1Arr) {
        return (T1[]) this.mBaseList.toArray(t1Arr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        return this.mBaseList.add(t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.mBaseList.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.mBaseList.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        return this.mBaseList.addAll(collection);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.mBaseList.add(i, t);
    }

    @Override // java.util.List
    public T remove(int i) {
        return this.mBaseList.remove(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.mBaseList.indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.mBaseList.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.mBaseList.listIterator();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        return this.mBaseList.listIterator(i);
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        return this.mBaseList.subList(i, i2);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        return this.mBaseList.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.mBaseList.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.mBaseList.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.mBaseList.clear();
    }

    @Override // java.util.List
    public T get(int i) {
        return this.mBaseList.get(i);
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return this.mBaseList.set(i, t);
    }
}
