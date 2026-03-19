package io.netty.util.internal;

import io.netty.util.internal.PriorityQueueNode;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PriorityQueue<T extends PriorityQueueNode<T>> extends AbstractQueue<T> implements Queue<T> {
    private static final PriorityQueueNode[] EMPTY_QUEUE = new PriorityQueueNode[0];
    private T[] queue;
    private int size;

    public PriorityQueue() {
        this(8);
    }

    public PriorityQueue(int i) {
        this.queue = (T[]) (i != 0 ? new PriorityQueueNode[i] : EMPTY_QUEUE);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        PriorityQueueNode priorityQueueNode;
        int iPriorityQueueIndex;
        return (obj instanceof PriorityQueueNode) && (iPriorityQueueIndex = (priorityQueueNode = (PriorityQueueNode) obj).priorityQueueIndex()) >= 0 && iPriorityQueueIndex < this.size && priorityQueueNode.equals(this.queue[iPriorityQueueIndex]);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        for (int i = 0; i < this.size; i++) {
            T t = this.queue[i];
            if (t != null) {
                t.priorityQueueIndex(-1);
                this.queue[i] = null;
            }
        }
        this.size = 0;
    }

    @Override // java.util.Queue
    public final boolean offer(T t) {
        ObjectUtil.checkNotNull(t, "e");
        if (t.priorityQueueIndex() != -1) {
            throw new IllegalArgumentException("e.priorityQueueIndex(): " + t.priorityQueueIndex() + " (expected: -1)");
        }
        int i = this.size;
        T[] tArr = this.queue;
        if (i >= tArr.length) {
            this.queue = (T[]) ((PriorityQueueNode[]) Arrays.copyOf(tArr, tArr.length + (tArr.length < 64 ? tArr.length + 2 : tArr.length >>> 1)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        bubbleUp(i2, t);
        return true;
    }

    @Override // java.util.Queue
    public final T poll() {
        if (this.size == 0) {
            return null;
        }
        T t = this.queue[0];
        t.priorityQueueIndex(-1);
        T[] tArr = this.queue;
        int i = this.size - 1;
        this.size = i;
        T t2 = tArr[i];
        int i2 = this.size;
        tArr[i2] = null;
        if (i2 != 0) {
            bubbleDown(0, t2);
        }
        return t;
    }

    @Override // java.util.Queue
    public final T peek() {
        if (this.size == 0) {
            return null;
        }
        return this.queue[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        if (!contains(obj)) {
            return false;
        }
        PriorityQueueNode priorityQueueNode = (PriorityQueueNode) obj;
        int iPriorityQueueIndex = priorityQueueNode.priorityQueueIndex();
        priorityQueueNode.priorityQueueIndex(-1);
        int i2 = this.size - 1;
        this.size = i2;
        if (i2 == 0 || (i = this.size) == iPriorityQueueIndex) {
            this.queue[iPriorityQueueIndex] = null;
            return true;
        }
        T[] tArr = this.queue;
        T t = tArr[i];
        tArr[iPriorityQueueIndex] = t;
        tArr[i] = null;
        if (priorityQueueNode.compareTo(t) < 0) {
            bubbleDown(iPriorityQueueIndex, t);
        } else {
            bubbleUp(iPriorityQueueIndex, t);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <X> X[] toArray(X[] xArr) {
        int length = xArr.length;
        int i = this.size;
        if (length < i) {
            return (X[]) Arrays.copyOf(this.queue, i, xArr.getClass());
        }
        System.arraycopy(this.queue, 0, xArr, 0, i);
        int length2 = xArr.length;
        int i2 = this.size;
        if (length2 > i2) {
            xArr[i2] = null;
        }
        return xArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }

    final class PriorityQueueIterator implements Iterator<T> {
        private int index;

        private PriorityQueueIterator() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < PriorityQueue.this.size;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.index < PriorityQueue.this.size) {
                PriorityQueueNode[] priorityQueueNodeArr = PriorityQueue.this.queue;
                int i = this.index;
                this.index = i + 1;
                return (T) priorityQueueNodeArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private void bubbleDown(int i, T t) {
        int i2 = this.size >>> 1;
        while (i < i2) {
            int i3 = (i << 1) + 1;
            T[] tArr = this.queue;
            T t2 = tArr[i3];
            int i4 = i3 + 1;
            if (i4 < this.size && t2.compareTo(tArr[i4]) > 0) {
                t2 = this.queue[i4];
                i3 = i4;
            }
            if (t.compareTo(t2) <= 0) {
                break;
            }
            this.queue[i] = t2;
            t2.priorityQueueIndex(i);
            i = i3;
        }
        this.queue[i] = t;
        t.priorityQueueIndex(i);
    }

    private void bubbleUp(int i, T t) {
        while (i > 0) {
            int i2 = (i - 1) >>> 1;
            T t2 = this.queue[i2];
            if (t.compareTo(t2) >= 0) {
                break;
            }
            this.queue[i] = t2;
            t2.priorityQueueIndex(i);
            i = i2;
        }
        this.queue[i] = t;
        t.priorityQueueIndex(i);
    }
}
