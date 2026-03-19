package com.fc.tjcpl.sdk.h;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class g<E> extends AbstractQueue<E> implements Object<E>, Serializable, Serializable {
    public transient d<E> a;
    public transient d<E> b;
    public transient int c;
    public final int d;
    public final ReentrantLock e;
    public final Condition f;
    public final Condition g;

    public abstract class a implements Iterator<E> {
        public d<E> a;
        public E b;
        public d<E> c;

        public a() {
            ReentrantLock reentrantLock = g.this.e;
            reentrantLock.lock();
            try {
                d<E> dVarA = a();
                this.a = dVarA;
                this.b = dVarA == null ? null : dVarA.a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract d<E> a();

        public abstract d<E> a(d<E> dVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            d<E> dVarA;
            E e;
            d<E> dVar = this.a;
            if (dVar == null) {
                throw new NoSuchElementException();
            }
            this.c = dVar;
            E e2 = this.b;
            ReentrantLock reentrantLock = g.this.e;
            reentrantLock.lock();
            try {
                d<E> dVar2 = this.a;
                while (true) {
                    dVarA = a(dVar2);
                    e = null;
                    if (dVarA != null) {
                        if (dVarA.a != null) {
                            break;
                        }
                        if (dVarA == dVar2) {
                            dVarA = a();
                            break;
                        }
                        dVar2 = dVarA;
                    } else {
                        dVarA = null;
                        break;
                    }
                }
                this.a = dVarA;
                if (dVarA != null) {
                    e = dVarA.a;
                }
                this.b = e;
                return e2;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            d<E> dVar = this.c;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            this.c = null;
            ReentrantLock reentrantLock = g.this.e;
            reentrantLock.lock();
            try {
                if (dVar.a != null) {
                    g.this.b(dVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public class b extends g<E>.a {
        public b() {
            super();
        }

        @Override // com.fc.tjcpl.sdk.h.g.a
        public d<E> a() {
            return g.this.b;
        }

        @Override // com.fc.tjcpl.sdk.h.g.a
        public d<E> a(d<E> dVar) {
            return dVar.b;
        }
    }

    public class c extends g<E>.a {
        public c() {
            super();
        }

        @Override // com.fc.tjcpl.sdk.h.g.a
        public d<E> a() {
            return g.this.a;
        }

        @Override // com.fc.tjcpl.sdk.h.g.a
        public d<E> a(d<E> dVar) {
            return dVar.c;
        }
    }

    public static final class d<E> {
        public E a;
        public d<E> b;
        public d<E> c;

        public d(E e) {
            this.a = e;
        }
    }

    public g() {
        this(Integer.MAX_VALUE);
    }

    public g(int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        this.g = reentrantLock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.d = i;
    }

    public final E a() {
        d<E> dVar = this.a;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.c;
        E e = dVar.a;
        dVar.a = null;
        dVar.c = dVar;
        this.a = dVar2;
        if (dVar2 == null) {
            this.b = null;
        } else {
            dVar2.b = null;
        }
        this.c--;
        this.g.signal();
        return e;
    }

    public final boolean a(d<E> dVar) {
        int i = this.c;
        if (i >= this.d) {
            return false;
        }
        d<E> dVar2 = this.b;
        dVar.b = dVar2;
        this.b = dVar;
        if (this.a == null) {
            this.a = dVar;
        } else {
            dVar2.c = dVar;
        }
        this.c = i + 1;
        this.f.signal();
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        if (offerLast(e)) {
            return true;
        }
        throw new IllegalStateException("Deque full");
    }

    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public final E b() {
        d<E> dVar = this.b;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.b;
        E e = dVar.a;
        dVar.a = null;
        dVar.b = dVar;
        this.b = dVar2;
        if (dVar2 == null) {
            this.a = null;
        } else {
            dVar2.c = null;
        }
        this.c--;
        this.g.signal();
        return e;
    }

    public void b(d<E> dVar) {
        d<E> dVar2 = dVar.b;
        d<E> dVar3 = dVar.c;
        if (dVar2 == null) {
            a();
            return;
        }
        if (dVar3 == null) {
            b();
            return;
        }
        dVar2.c = dVar3;
        dVar3.b = dVar2;
        dVar.a = null;
        this.c--;
        this.g.signal();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            d<E> dVar = this.a;
            while (dVar != null) {
                dVar.a = null;
                d<E> dVar2 = dVar.c;
                dVar.b = null;
                dVar.c = null;
                dVar = dVar2;
            }
            this.b = null;
            this.a = null;
            this.c = 0;
            this.g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            for (d<E> dVar = this.a; dVar != null; dVar = dVar.c) {
                if (obj.equals(dVar.a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new b();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        collection.getClass();
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            int iMin = Math.min(i, this.c);
            for (int i2 = 0; i2 < iMin; i2++) {
                collection.add(this.a.a);
                a();
            }
            return iMin;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E ePeekFirst = peekFirst();
        if (ePeekFirst != null) {
            return ePeekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E ePeekLast = peekLast();
        if (ePeekLast != null) {
            return ePeekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new c();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        e.getClass();
        d<E> dVar = new d<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (!a(dVar)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.g.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public boolean offerFirst(E e) {
        e.getClass();
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            int i = this.c;
            boolean z = true;
            if (i >= this.d) {
                z = false;
            } else {
                d<E> dVar2 = this.a;
                dVar.c = dVar2;
                this.a = dVar;
                if (this.b == null) {
                    this.b = dVar;
                } else {
                    dVar2.b = dVar;
                }
                this.c = i + 1;
                this.f.signal();
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e) {
        e.getClass();
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return a(dVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            d<E> dVar = this.a;
            return dVar == null ? null : dVar.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            d<E> dVar = this.b;
            return dVar == null ? null : dVar.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eA = a();
                if (eA != null) {
                    return eA;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return a();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return b();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void put(E e) {
        e.getClass();
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        while (!a(dVar)) {
            try {
                this.g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return this.d - this.c;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E removeFirst() {
        E ePollFirst = pollFirst();
        if (ePollFirst != null) {
            return ePollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            for (d<E> dVar = this.a; dVar != null; dVar = dVar.c) {
                if (obj.equals(dVar.a)) {
                    b(dVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E ePollLast = pollLast();
        if (ePollLast != null) {
            return ePollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            for (d<E> dVar = this.b; dVar != null; dVar = dVar.b) {
                if (obj.equals(dVar.a)) {
                    b(dVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return this.c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        while (true) {
            try {
                E eA = a();
                if (eA != null) {
                    return eA;
                }
                this.f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.c];
            int i = 0;
            d<E> dVar = this.a;
            while (dVar != null) {
                int i2 = i + 1;
                objArr[i] = dVar.a;
                dVar = dVar.c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            if (tArr.length < this.c) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.c));
            }
            int i = 0;
            d<E> dVar = this.a;
            while (dVar != null) {
                tArr[i] = dVar.a;
                dVar = dVar.c;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            d<E> dVar = this.a;
            if (dVar == null) {
                reentrantLock.unlock();
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = dVar.a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                dVar = dVar.c;
                if (dVar == null) {
                    return sb.append(']').toString();
                }
                sb.append(StringUtil.COMMA).append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
