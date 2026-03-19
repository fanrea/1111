package com.kwai.kanas.vader.c;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class a<E> extends d<E> {
    final int a;
    private final Queue<E> b;

    private a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxSize (%s) must >= 0." + i);
        }
        this.b = new ArrayDeque(i);
        this.a = i;
    }

    public static <E> a<E> a(int i) {
        return new a<>(i);
    }

    public int a() {
        return this.a - size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.kanas.vader.c.d, com.kwai.kanas.vader.c.b, com.kwai.kanas.vader.c.c
    /* renamed from: b */
    public Queue<E> d() {
        return this.b;
    }

    @Override // com.kwai.kanas.vader.c.d, java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    @Override // com.kwai.kanas.vader.c.b, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        if (this.a == 0) {
            return true;
        }
        if (size() == this.a) {
            this.b.remove();
        }
        this.b.add(e);
        return true;
    }

    @Override // com.kwai.kanas.vader.c.b, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kwai.kanas.vader.c.b, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        return d().contains(obj);
    }

    @Override // com.kwai.kanas.vader.c.b, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        return d().remove(obj);
    }
}
