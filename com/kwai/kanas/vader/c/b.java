package com.kwai.kanas.vader.c;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class b<E> extends c implements Collection<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.kanas.vader.c.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public abstract Collection<E> d();

    protected b() {
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return d().iterator();
    }

    @Override // java.util.Collection
    public int size() {
        return d().size();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return d().removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return d().isEmpty();
    }

    public boolean contains(Object obj) {
        return d().contains(obj);
    }

    public boolean add(E e) {
        return d().add(e);
    }

    public boolean remove(Object obj) {
        return d().remove(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return d().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return d().addAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return d().retainAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        d().clear();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return d().toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) d().toArray(tArr);
    }
}
