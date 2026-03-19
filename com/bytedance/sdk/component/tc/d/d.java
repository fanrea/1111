package com.bytedance.sdk.component.tc.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d<T> implements BlockingQueue<T> {
    private final BlockingQueue<T> d;

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    public d(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.d = new SynchronousQueue();
        } else {
            this.d = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.d.take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.d.poll(j, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    public final String d() {
        return this.d.getClass().getName();
    }

    public final BlockingQueue hc() {
        return this.d;
    }

    public int b() {
        return this.d.size();
    }

    @Override // java.util.Collection
    public final int size() {
        return b();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.d.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.d.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.d.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.d.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.d.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.d.drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.d.drainTo(collection, i);
    }

    @Override // java.util.Queue
    public T element() {
        return this.d.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.d.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.d.offer(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.d.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.d.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        return this.d.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.d.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.d.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.d.remove();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.d.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.d.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.d.retainAll(collection);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
