package android.support.v4.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class g<K, V> {
    g<K, V>.b bS;
    g<K, V>.c bT;
    g<K, V>.e bU;

    protected abstract int M();

    protected abstract Map<K, V> N();

    protected abstract void O();

    protected abstract V a(int i, V v);

    protected abstract void a(K k, V v);

    protected abstract Object d(int i, int i2);

    protected abstract void h(int i);

    protected abstract int i(Object obj);

    protected abstract int j(Object obj);

    g() {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    final class a<T> implements Iterator<T> {
        final int bV;
        boolean bW = false;
        int mIndex;
        int mSize;

        a(int i) {
            this.bV = i;
            this.mSize = g.this.M();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) g.this.d(this.mIndex, this.bV);
            this.mIndex++;
            this.bW = true;
            return t;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.bW) {
                throw new IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.bW = false;
            g.this.h(this.mIndex);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int bY;
        boolean bZ = false;
        int mIndex = -1;

        d() {
            this.bY = g.this.M() - 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.mIndex < this.bY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.mIndex++;
            this.bZ = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.bZ) {
                throw new IllegalStateException();
            }
            g.this.h(this.mIndex);
            this.mIndex--;
            this.bY--;
            this.bZ = false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (!this.bZ) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) g.this.d(this.mIndex, 0);
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (!this.bZ) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) g.this.d(this.mIndex, 1);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (!this.bZ) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) g.this.a(this.mIndex, (int) v);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.bZ) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return android.support.v4.d.c.b(entry.getKey(), g.this.d(this.mIndex, 0)) && android.support.v4.d.c.b(entry.getValue(), g.this.d(this.mIndex, 1));
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.bZ) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objD = g.this.d(this.mIndex, 0);
            Object objD2 = g.this.d(this.mIndex, 1);
            return (objD == null ? 0 : objD.hashCode()) ^ (objD2 != null ? objD2.hashCode() : 0);
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        public final /* synthetic */ boolean add(Object obj) {
            return U();
        }

        private static boolean U() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iM = g.this.M();
            for (Map.Entry<K, V> entry : collection) {
                g.this.a((g) entry.getKey(), (K) entry.getValue());
            }
            return iM != g.this.M();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            g.this.O();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int i = g.this.i(entry.getKey());
            if (i < 0) {
                return false;
            }
            return android.support.v4.d.c.b(g.this.d(i, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return g.this.M() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return g.this.M();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int iHashCode = 0;
            for (int iM = g.this.M() - 1; iM >= 0; iM--) {
                Object objD = g.this.d(iM, 0);
                Object objD2 = g.this.d(iM, 1);
                iHashCode += (objD == null ? 0 : objD.hashCode()) ^ (objD2 == null ? 0 : objD2.hashCode());
            }
            return iHashCode;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            g.this.O();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return g.this.i(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            return g.a((Map) g.this.N(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return g.this.M() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            int i = g.this.i(obj);
            if (i < 0) {
                return false;
            }
            g.this.h(i);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            return g.b(g.this.N(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            return g.c(g.this.N(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return g.this.M();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            return g.this.k(0);
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.a(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int iHashCode = 0;
            for (int iM = g.this.M() - 1; iM >= 0; iM--) {
                Object objD = g.this.d(iM, 0);
                iHashCode += objD == null ? 0 : objD.hashCode();
            }
            return iHashCode;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            g.this.O();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return g.this.j(obj) >= 0;
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
        public final boolean isEmpty() {
            return g.this.M() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            int iJ = g.this.j(obj);
            if (iJ < 0) {
                return false;
            }
            g.this.h(iJ);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            int iM = g.this.M();
            int i = 0;
            boolean z = false;
            while (i < iM) {
                if (collection.contains(g.this.d(i, 1))) {
                    g.this.h(i);
                    i--;
                    iM--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            int iM = g.this.M();
            int i = 0;
            boolean z = false;
            while (i < iM) {
                if (!collection.contains(g.this.d(i, 1))) {
                    g.this.h(i);
                    i--;
                    iM--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return g.this.M();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            return g.this.k(1);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) g.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] k(int i) {
        int iM = M();
        Object[] objArr = new Object[iM];
        for (int i2 = 0; i2 < iM; i2++) {
            objArr[i2] = d(i2, i);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i) {
        int iM = M();
        if (tArr.length < iM) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iM));
        }
        for (int i2 = 0; i2 < iM; i2++) {
            tArr[i2] = d(i2, i);
        }
        if (tArr.length > iM) {
            tArr[iM] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> R() {
        if (this.bS == null) {
            this.bS = new b();
        }
        return this.bS;
    }

    public final Set<K> S() {
        if (this.bT == null) {
            this.bT = new c();
        }
        return this.bT;
    }

    public final Collection<V> T() {
        if (this.bU == null) {
            this.bU = new e();
        }
        return this.bU;
    }
}
