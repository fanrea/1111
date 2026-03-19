package com.kwad.sdk.lib.widget;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<T> implements List<T> {
    private List<T> ccM;

    public b(List<T> list) {
        this.ccM = list;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.ccM.size();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.ccM.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.ccM.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return this.ccM.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return this.ccM.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public final <T1> T1[] toArray(T1[] t1Arr) {
        return (T1[]) this.ccM.toArray(t1Arr);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(T t) {
        return this.ccM.add(t);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.ccM.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        return this.ccM.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        return this.ccM.addAll(collection);
    }

    @Override // java.util.List
    public final void add(int i, T t) {
        this.ccM.add(i, t);
    }

    @Override // java.util.List
    public final T remove(int i) {
        return this.ccM.remove(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.ccM.indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.ccM.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator() {
        return this.ccM.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<T> listIterator(int i) {
        return this.ccM.listIterator(i);
    }

    @Override // java.util.List
    public final List<T> subList(int i, int i2) {
        return this.ccM.subList(i, i2);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection<? extends T> collection) {
        return this.ccM.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return this.ccM.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return this.ccM.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.ccM.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public final T get(int i) {
        T t = this.ccM.get(i);
        if (t instanceof CtAdTemplate) {
            ((CtAdTemplate) t).setShowPosition(i);
        }
        return t;
    }

    @Override // java.util.List
    public final T set(int i, T t) {
        return this.ccM.set(i, t);
    }
}
