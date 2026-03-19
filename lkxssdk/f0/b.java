package lkxssdk.f0;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b<E> extends AbstractQueue<E> implements Serializable, Queue, Serializable {
    public transient c<E> a;
    public transient c<E> b;
    public transient int c;
    public final int d;
    public final ReentrantLock e;
    public final Condition f;
    public final Condition g;

    public abstract class a implements Iterator<E> {
        public c<E> a;
        public E b;
        public c<E> c;

        public a() {
            ReentrantLock reentrantLock = b.this.e;
            reentrantLock.lock();
            try {
                c<E> cVarA = a();
                this.a = cVarA;
                this.b = cVarA == null ? null : cVarA.a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract c<E> a();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            c<E> cVar;
            E e;
            c<E> cVar2 = this.a;
            if (cVar2 == null) {
                throw new NoSuchElementException();
            }
            this.c = cVar2;
            E e2 = this.b;
            ReentrantLock reentrantLock = b.this.e;
            reentrantLock.lock();
            try {
                c<E> cVar3 = this.a;
                while (true) {
                    cVar = cVar3.c;
                    e = null;
                    if (cVar != null) {
                        if (cVar.a != null) {
                            break;
                        }
                        if (cVar == cVar3) {
                            cVar = b.this.a;
                            break;
                        }
                        cVar3 = cVar;
                    } else {
                        cVar = null;
                        break;
                    }
                }
                this.a = cVar;
                if (cVar != null) {
                    e = cVar.a;
                }
                this.b = e;
                return e2;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            c<E> cVar = this.c;
            if (cVar == null) {
                throw new IllegalStateException();
            }
            this.c = null;
            ReentrantLock reentrantLock = b.this.e;
            reentrantLock.lock();
            try {
                if (cVar.a != null) {
                    b.this.b(cVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* renamed from: lkxssdk.f0.b$b, reason: collision with other inner class name */
    public class C0841b extends b<E>.a {
        public C0841b() {
            super();
        }

        @Override // lkxssdk.f0.b.a
        public c<E> a() {
            return b.this.a;
        }
    }

    public static final class c<E> {
        public E a;
        public c<E> b;
        public c<E> c;

        public c(E e) {
            this.a = e;
        }
    }

    public b() {
        this(Integer.MAX_VALUE);
    }

    public b(int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        this.g = reentrantLock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.d = i;
    }

    public E a() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            c<E> cVar = this.a;
            return cVar == null ? null : cVar.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean a(E e) {
        e.getClass();
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            int i = this.c;
            boolean z = true;
            if (i >= this.d) {
                z = false;
            } else {
                c<E> cVar2 = this.a;
                cVar.c = cVar2;
                this.a = cVar;
                if (this.b == null) {
                    this.b = cVar;
                } else {
                    cVar2.b = cVar;
                }
                this.c = i + 1;
                this.f.signal();
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean a(c<E> cVar) {
        int i = this.c;
        if (i >= this.d) {
            return false;
        }
        c<E> cVar2 = this.b;
        cVar.b = cVar2;
        this.b = cVar;
        if (this.a == null) {
            this.a = cVar;
        } else {
            cVar2.c = cVar;
        }
        this.c = i + 1;
        this.f.signal();
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        e.getClass();
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            if (a((c) cVar)) {
                return true;
            }
            throw new IllegalStateException("Deque full");
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E b() {
        c<E> cVar = this.a;
        if (cVar == null) {
            return null;
        }
        c<E> cVar2 = cVar.c;
        E e = cVar.a;
        cVar.a = null;
        cVar.c = cVar;
        this.a = cVar2;
        if (cVar2 == null) {
            this.b = null;
        } else {
            cVar2.b = null;
        }
        this.c--;
        this.g.signal();
        return e;
    }

    public void b(c<E> cVar) {
        c<E> cVar2 = cVar.b;
        c<E> cVar3 = cVar.c;
        if (cVar2 == null) {
            b();
            return;
        }
        if (cVar3 != null) {
            cVar2.c = cVar3;
            cVar3.b = cVar2;
            cVar.a = null;
            this.c--;
            this.g.signal();
            return;
        }
        c<E> cVar4 = this.b;
        if (cVar4 == null) {
            return;
        }
        c<E> cVar5 = cVar4.b;
        cVar4.a = null;
        cVar4.b = cVar4;
        this.b = cVar5;
        if (cVar5 == null) {
            this.a = null;
        } else {
            cVar5.c = null;
        }
        this.c--;
        this.g.signal();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            c<E> cVar = this.a;
            while (cVar != null) {
                cVar.a = null;
                c<E> cVar2 = cVar.c;
                cVar.b = null;
                cVar.c = null;
                cVar = cVar2;
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
            for (c<E> cVar = this.a; cVar != null; cVar = cVar.c) {
                if (obj.equals(cVar.a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
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
                b();
            }
            return iMin;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        E eA = a();
        if (eA != null) {
            return eA;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0841b();
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        e.getClass();
        c<E> cVar = new c<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (!a((c) cVar)) {
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

    @Override // java.util.Queue
    public E peek() {
        return a();
    }

    @Override // java.util.Queue
    public E poll() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return b();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void put(E e) {
        e.getClass();
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        while (!a((c) cVar)) {
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

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            for (c<E> cVar = this.a; cVar != null; cVar = cVar.c) {
                if (obj.equals(cVar.a)) {
                    b(cVar);
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
                E eB = b();
                if (eB != null) {
                    return eB;
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
            c<E> cVar = this.a;
            while (cVar != null) {
                int i2 = i + 1;
                objArr[i] = cVar.a;
                cVar = cVar.c;
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
            c<E> cVar = this.a;
            while (cVar != null) {
                tArr[i] = cVar.a;
                cVar = cVar.c;
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

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            c<E> cVar = this.a;
            if (cVar == null) {
                reentrantLock.unlock();
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = cVar.a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                cVar = cVar.c;
                if (cVar == null) {
                    return sb.append(']').toString();
                }
                sb.append(StringUtil.COMMA).append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eB = b();
                if (eB != null) {
                    return eB;
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
}
