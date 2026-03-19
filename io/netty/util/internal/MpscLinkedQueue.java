package io.netty.util.internal;

import com.alipay.sdk.m.p0.b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class MpscLinkedQueue<E> extends MpscLinkedQueueTailRef<E> implements Queue<E> {
    private static final long serialVersionUID = -1878402552271506449L;
    long p00;
    long p01;
    long p02;
    long p03;
    long p04;
    long p05;
    long p06;
    long p07;
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;

    MpscLinkedQueue() {
        DefaultNode defaultNode = new DefaultNode(null);
        setHeadRef(defaultNode);
        setTailRef(defaultNode);
    }

    private MpscLinkedQueueNode<E> peekNode() {
        MpscLinkedQueueNode<E> mpscLinkedQueueNodeHeadRef = headRef();
        MpscLinkedQueueNode<E> next = mpscLinkedQueueNodeHeadRef.next();
        if (next == null && mpscLinkedQueueNodeHeadRef != tailRef()) {
            do {
                next = mpscLinkedQueueNodeHeadRef.next();
            } while (next == null);
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public final boolean offer(E e) {
        MpscLinkedQueueNode<E> defaultNode;
        if (e == 0) {
            throw new NullPointerException(b.d);
        }
        if (e instanceof MpscLinkedQueueNode) {
            defaultNode = (MpscLinkedQueueNode) e;
            defaultNode.setNext(null);
        } else {
            defaultNode = new DefaultNode(e);
        }
        getAndSetTailRef(defaultNode).setNext(defaultNode);
        return true;
    }

    @Override // java.util.Queue
    public final E poll() {
        MpscLinkedQueueNode<E> mpscLinkedQueueNodePeekNode = peekNode();
        if (mpscLinkedQueueNodePeekNode == null) {
            return null;
        }
        MpscLinkedQueueNode<E> mpscLinkedQueueNodeHeadRef = headRef();
        lazySetHeadRef(mpscLinkedQueueNodePeekNode);
        mpscLinkedQueueNodeHeadRef.unlink();
        return mpscLinkedQueueNodePeekNode.clearMaybe();
    }

    @Override // java.util.Queue
    public final E peek() {
        MpscLinkedQueueNode<E> mpscLinkedQueueNodePeekNode = peekNode();
        if (mpscLinkedQueueNodePeekNode == null) {
            return null;
        }
        return mpscLinkedQueueNodePeekNode.value();
    }

    @Override // java.util.Collection
    public final int size() {
        MpscLinkedQueueNode<E> mpscLinkedQueueNodePeekNode = peekNode();
        int i = 0;
        while (mpscLinkedQueueNodePeekNode != null && mpscLinkedQueueNodePeekNode.value() != null) {
            MpscLinkedQueueNode<E> next = mpscLinkedQueueNodePeekNode.next();
            if (mpscLinkedQueueNodePeekNode == next || (i = i + 1) == Integer.MAX_VALUE) {
                break;
            }
            mpscLinkedQueueNodePeekNode = next;
        }
        return i;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return headRef() == tailRef();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        E eValue;
        MpscLinkedQueueNode<E> mpscLinkedQueueNodePeekNode = peekNode();
        while (mpscLinkedQueueNodePeekNode != null && (eValue = mpscLinkedQueueNodePeekNode.value()) != null) {
            if (eValue == obj) {
                return true;
            }
            MpscLinkedQueueNode<E> next = mpscLinkedQueueNodePeekNode.next();
            if (mpscLinkedQueueNodePeekNode == next) {
                return false;
            }
            mpscLinkedQueueNodePeekNode = next;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new ReadOnlyIterator(toList().iterator());
    }

    @Override // java.util.Queue, java.util.Collection
    public final boolean add(E e) {
        if (offer(e)) {
            return true;
        }
        throw new IllegalStateException("queue full");
    }

    @Override // java.util.Queue
    public final E remove() {
        E ePoll = poll();
        if (ePoll != null) {
            return ePoll;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Queue
    public final E element() {
        E ePeek = peek();
        if (ePeek != null) {
            return ePeek;
        }
        throw new NoSuchElementException();
    }

    private List<E> toList(int i) {
        return toList(new ArrayList(i));
    }

    private List<E> toList() {
        return toList(new ArrayList());
    }

    private List<E> toList(List<E> list) {
        MpscLinkedQueueNode<E> next;
        MpscLinkedQueueNode<E> mpscLinkedQueueNodePeekNode = peekNode();
        while (mpscLinkedQueueNodePeekNode != null) {
            E eValue = mpscLinkedQueueNodePeekNode.value();
            if (eValue == null || !list.add(eValue) || mpscLinkedQueueNodePeekNode == (next = mpscLinkedQueueNodePeekNode.next())) {
                break;
            }
            mpscLinkedQueueNodePeekNode = next;
        }
        return list;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return toList().toArray();
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) toList(tArr.length).toArray(tArr);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("c");
        }
        if (collection == this) {
            throw new IllegalArgumentException("c == this");
        }
        boolean z = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
            z = true;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        while (poll() != null) {
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeObject(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        DefaultNode defaultNode = new DefaultNode(null);
        setHeadRef(defaultNode);
        setTailRef(defaultNode);
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                add(object);
            }
        }
    }

    static final class DefaultNode<T> extends MpscLinkedQueueNode<T> {
        private T value;

        DefaultNode(T t) {
            this.value = t;
        }

        @Override // io.netty.util.internal.MpscLinkedQueueNode
        public final T value() {
            return this.value;
        }

        @Override // io.netty.util.internal.MpscLinkedQueueNode
        protected final T clearMaybe() {
            T t = this.value;
            this.value = null;
            return t;
        }
    }
}
