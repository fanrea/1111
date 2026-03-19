package com.kwai.kanas.vader.c;

import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class d<E> extends b<E> implements Queue<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.kanas.vader.c.b, com.kwai.kanas.vader.c.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract Queue<E> d();

    protected d() {
    }

    public boolean offer(E e) {
        return d().offer(e);
    }

    @Override // java.util.Queue
    public E poll() {
        return d().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return d().remove();
    }

    @Override // java.util.Queue
    public E peek() {
        return d().peek();
    }

    @Override // java.util.Queue
    public E element() {
        return d().element();
    }
}
