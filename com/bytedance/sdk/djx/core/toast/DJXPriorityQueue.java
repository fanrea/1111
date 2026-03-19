package com.bytedance.sdk.djx.core.toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DJXPriorityQueue<E> extends AbstractQueue<E> implements Serializable {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final long serialVersionUID = 156525540690621702L;
    private final Comparator<? super E> comparator;
    transient int modCount;
    transient Object[] queue;
    int size;

    public E get(int i) {
        if (i < 0) {
            return null;
        }
        Object[] objArr = this.queue;
        if (i < objArr.length) {
            return (E) objArr[i];
        }
        return null;
    }

    public DJXPriorityQueue() {
        this(11, null);
    }

    public DJXPriorityQueue(int i) {
        this(i, null);
    }

    public DJXPriorityQueue(Comparator<? super E> comparator) {
        this(11, comparator);
    }

    public DJXPriorityQueue(int i, Comparator<? super E> comparator) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new Object[i];
        this.comparator = comparator;
    }

    public DJXPriorityQueue(Collection<? extends E> collection) {
        if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) collection;
            this.comparator = sortedSet.comparator();
            initElementsFromCollection(sortedSet);
        } else if (collection instanceof DJXPriorityQueue) {
            DJXPriorityQueue<? extends E> dJXPriorityQueue = (DJXPriorityQueue) collection;
            this.comparator = dJXPriorityQueue.comparator();
            initFromPriorityQueue(dJXPriorityQueue);
        } else {
            this.comparator = null;
            initFromCollection(collection);
        }
    }

    public DJXPriorityQueue(DJXPriorityQueue<? extends E> dJXPriorityQueue) {
        this.comparator = dJXPriorityQueue.comparator();
        initFromPriorityQueue(dJXPriorityQueue);
    }

    public DJXPriorityQueue(SortedSet<? extends E> sortedSet) {
        this.comparator = sortedSet.comparator();
        initElementsFromCollection(sortedSet);
    }

    private void initFromPriorityQueue(DJXPriorityQueue<? extends E> dJXPriorityQueue) {
        if (dJXPriorityQueue.getClass() == DJXPriorityQueue.class) {
            this.queue = dJXPriorityQueue.toArray();
            this.size = dJXPriorityQueue.size();
        } else {
            initFromCollection(dJXPriorityQueue);
        }
    }

    private void initElementsFromCollection(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        if (array.getClass() != Object[].class) {
            array = Arrays.copyOf(array, array.length, Object[].class);
        }
        if (array.length == 1 || this.comparator != null) {
            for (Object obj : array) {
                obj.getClass();
            }
        }
        this.queue = array;
        this.size = array.length;
    }

    private void initFromCollection(Collection<? extends E> collection) {
        initElementsFromCollection(collection);
        heapify();
    }

    private void grow(int i) {
        int length = this.queue.length;
        int iHugeCapacity = length + (length < 64 ? length + 2 : length >> 1);
        if (iHugeCapacity - MAX_ARRAY_SIZE > 0) {
            iHugeCapacity = hugeCapacity(i);
        }
        this.queue = Arrays.copyOf(this.queue, iHugeCapacity);
    }

    private static int hugeCapacity(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > MAX_ARRAY_SIZE) {
            return Integer.MAX_VALUE;
        }
        return MAX_ARRAY_SIZE;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        return offer(e);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        e.getClass();
        this.modCount++;
        int i = this.size;
        if (i >= this.queue.length) {
            grow(i + 1);
        }
        this.size = i + 1;
        if (i == 0) {
            this.queue[0] = e;
        } else {
            siftUp(i, e);
        }
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        if (this.size == 0) {
            return null;
        }
        return (E) this.queue[0];
    }

    private int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(this.queue[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    boolean removeEq(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (obj == this.queue[i]) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int i = this.size;
        if (tArr.length < i) {
            return (T[]) Arrays.copyOf(this.queue, i, tArr.getClass());
        }
        System.arraycopy(this.queue, 0, tArr, 0, i);
        if (tArr.length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    private final class Itr implements Iterator<E> {
        private int cursor;
        private int expectedModCount;
        private ArrayDeque<E> forgetMeNot;
        private int lastRet;
        private E lastRetElt;

        private Itr() {
            this.lastRet = -1;
            this.expectedModCount = DJXPriorityQueue.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            ArrayDeque<E> arrayDeque;
            return this.cursor < DJXPriorityQueue.this.size || !((arrayDeque = this.forgetMeNot) == null || arrayDeque.isEmpty());
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.expectedModCount != DJXPriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.cursor < DJXPriorityQueue.this.size) {
                Object[] objArr = DJXPriorityQueue.this.queue;
                int i = this.cursor;
                this.cursor = i + 1;
                this.lastRet = i;
                return (E) objArr[i];
            }
            ArrayDeque<E> arrayDeque = this.forgetMeNot;
            if (arrayDeque != null) {
                this.lastRet = -1;
                E ePoll = arrayDeque.poll();
                this.lastRetElt = ePoll;
                if (ePoll != null) {
                    return ePoll;
                }
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            if (this.expectedModCount != DJXPriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            }
            int i = this.lastRet;
            if (i != -1) {
                Object objRemoveAt = DJXPriorityQueue.this.removeAt(i);
                this.lastRet = -1;
                if (objRemoveAt == null) {
                    this.cursor--;
                } else {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque<>();
                    }
                    this.forgetMeNot.add(objRemoveAt);
                }
            } else {
                E e = this.lastRetElt;
                if (e != null) {
                    DJXPriorityQueue.this.removeEq(e);
                    this.lastRetElt = null;
                } else {
                    throw new IllegalStateException();
                }
            }
            this.expectedModCount = DJXPriorityQueue.this.modCount;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.modCount++;
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = null;
        }
        this.size = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue
    public E poll() {
        int i = this.size;
        if (i == 0) {
            return null;
        }
        int i2 = i - 1;
        this.size = i2;
        this.modCount++;
        Object[] objArr = this.queue;
        E e = (E) objArr[0];
        Object obj = objArr[i2];
        objArr[i2] = null;
        if (i2 != 0) {
            siftDown(0, obj);
        }
        return e;
    }

    E removeAt(int i) {
        this.modCount++;
        int i2 = this.size - 1;
        this.size = i2;
        if (i2 == i) {
            this.queue[i] = null;
        } else {
            Object[] objArr = this.queue;
            E e = (E) objArr[i2];
            objArr[i2] = null;
            siftDown(i, e);
            if (this.queue[i] == e) {
                siftUp(i, e);
                if (this.queue[i] != e) {
                    return e;
                }
            }
        }
        return null;
    }

    private void siftUp(int i, E e) {
        if (this.comparator != null) {
            siftUpUsingComparator(i, e);
        } else {
            siftUpComparable(i, e);
        }
    }

    private void siftUpComparable(int i, E e) {
        Comparable comparable = (Comparable) e;
        while (i > 0) {
            int i2 = (i - 1) >>> 1;
            Object obj = this.queue[i2];
            if (comparable.compareTo(obj) >= 0) {
                break;
            }
            this.queue[i] = obj;
            i = i2;
        }
        this.queue[i] = comparable;
    }

    private void siftUpUsingComparator(int i, E e) {
        while (i > 0) {
            int i2 = (i - 1) >>> 1;
            Object obj = this.queue[i2];
            if (this.comparator.compare(e, obj) >= 0) {
                break;
            }
            this.queue[i] = obj;
            i = i2;
        }
        this.queue[i] = e;
    }

    private void siftDown(int i, E e) {
        if (this.comparator != null) {
            siftDownUsingComparator(i, e);
        } else {
            siftDownComparable(i, e);
        }
    }

    private void siftDownComparable(int i, E e) {
        Comparable comparable = (Comparable) e;
        int i2 = this.size >>> 1;
        while (i < i2) {
            int i3 = (i << 1) + 1;
            Object[] objArr = this.queue;
            Object obj = objArr[i3];
            int i4 = i3 + 1;
            if (i4 < this.size && ((Comparable) obj).compareTo(objArr[i4]) > 0) {
                obj = this.queue[i4];
                i3 = i4;
            }
            if (comparable.compareTo(obj) <= 0) {
                break;
            }
            this.queue[i] = obj;
            i = i3;
        }
        this.queue[i] = comparable;
    }

    private void siftDownUsingComparator(int i, E e) {
        int i2 = this.size >>> 1;
        while (i < i2) {
            int i3 = (i << 1) + 1;
            Object[] objArr = this.queue;
            Object obj = objArr[i3];
            int i4 = i3 + 1;
            if (i4 < this.size && this.comparator.compare(obj, objArr[i4]) > 0) {
                obj = this.queue[i4];
                i3 = i4;
            }
            if (this.comparator.compare(e, obj) <= 0) {
                break;
            }
            this.queue[i] = obj;
            i = i3;
        }
        this.queue[i] = e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void heapify() {
        for (int i = (this.size >>> 1) - 1; i >= 0; i--) {
            siftDown(i, this.queue[i]);
        }
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(Math.max(2, this.size + 1));
        for (int i = 0; i < this.size; i++) {
            objectOutputStream.writeObject(this.queue[i]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        objectInputStream.readInt();
        this.queue = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = objectInputStream.readObject();
        }
        heapify();
    }
}
