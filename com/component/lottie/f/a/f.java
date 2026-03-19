package com.component.lottie.f.a;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class f<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean g = true;
    private static final Comparator<Comparable> h = new g();
    Comparator<? super K> a;
    C0324f<K, V>[] b;
    final C0324f<K, V> c;
    int d;
    int e;
    int f;
    private f<K, V>.c i;
    private f<K, V>.d j;

    f() {
        this(null);
    }

    f(Comparator<? super K> comparator) {
        this.d = 0;
        this.e = 0;
        this.a = comparator == null ? h : comparator;
        this.c = new C0324f<>();
        this.b = new C0324f[16];
        this.f = (this.b.length / 2) + (this.b.length / 4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        C0324f<K, V> c0324fA = a(obj);
        if (c0324fA != null) {
            return c0324fA.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0324f<K, V> c0324fA = a((f<K, V>) k, true);
        V v2 = c0324fA.h;
        c0324fA.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.b, (Object) null);
        this.d = 0;
        this.e++;
        C0324f<K, V> c0324f = this.c;
        C0324f<K, V> c0324f2 = c0324f.d;
        while (c0324f2 != c0324f) {
            C0324f<K, V> c0324f3 = c0324f2.d;
            c0324f2.e = null;
            c0324f2.d = null;
            c0324f2 = c0324f3;
        }
        c0324f.e = c0324f;
        c0324f.d = c0324f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        C0324f<K, V> c0324fB = b(obj);
        if (c0324fB != null) {
            return c0324fB.h;
        }
        return null;
    }

    C0324f<K, V> a(K k, boolean z) {
        C0324f<K, V> c0324f;
        int i;
        C0324f<K, V> c0324f2;
        Comparable comparable;
        int iCompare;
        Comparator<? super K> comparator = this.a;
        C0324f<K, V>[] c0324fArr = this.b;
        int iA = a(k.hashCode());
        int length = (c0324fArr.length - 1) & iA;
        C0324f<K, V> c0324f3 = c0324fArr[length];
        if (c0324f3 != null) {
            if (comparator == h) {
                comparable = (Comparable) k;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    iCompare = comparable.compareTo(c0324f3.f);
                } else {
                    iCompare = comparator.compare(k, c0324f3.f);
                }
                if (iCompare == 0) {
                    return c0324f3;
                }
                C0324f<K, V> c0324f4 = iCompare < 0 ? c0324f3.b : c0324f3.c;
                if (c0324f4 == null) {
                    c0324f = c0324f3;
                    i = iCompare;
                    break;
                }
                c0324f3 = c0324f4;
            }
        } else {
            c0324f = c0324f3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C0324f<K, V> c0324f5 = this.c;
        if (c0324f == null) {
            if (comparator == h && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            c0324f2 = new C0324f<>(c0324f, k, iA, c0324f5, c0324f5.e);
            c0324fArr[length] = c0324f2;
        } else {
            c0324f2 = new C0324f<>(c0324f, k, iA, c0324f5, c0324f5.e);
            if (i < 0) {
                c0324f.b = c0324f2;
            } else {
                c0324f.c = c0324f2;
            }
            b(c0324f, true);
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 > this.f) {
            a();
        }
        this.e++;
        return c0324f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    C0324f<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return a((f<K, V>) obj, false);
            } catch (ClassCastException e2) {
                return null;
            }
        }
        return null;
    }

    C0324f<K, V> a(Map.Entry<?, ?> entry) {
        C0324f<K, V> c0324fA = a(entry.getKey());
        if (c0324fA != null && a(c0324fA.h, entry.getValue())) {
            return c0324fA;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static int a(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    void a(C0324f<K, V> c0324f, boolean z) {
        int i;
        if (z) {
            c0324f.e.d = c0324f.d;
            c0324f.d.e = c0324f.e;
            c0324f.e = null;
            c0324f.d = null;
        }
        C0324f<K, V> c0324f2 = c0324f.b;
        C0324f<K, V> c0324f3 = c0324f.c;
        C0324f<K, V> c0324f4 = c0324f.a;
        int i2 = 0;
        if (c0324f2 != null && c0324f3 != null) {
            C0324f<K, V> c0324fB = c0324f2.i > c0324f3.i ? c0324f2.b() : c0324f3.a();
            a((C0324f) c0324fB, false);
            C0324f<K, V> c0324f5 = c0324f.b;
            if (c0324f5 == null) {
                i = 0;
            } else {
                i = c0324f5.i;
                c0324fB.b = c0324f5;
                c0324f5.a = c0324fB;
                c0324f.b = null;
            }
            C0324f<K, V> c0324f6 = c0324f.c;
            if (c0324f6 != null) {
                i2 = c0324f6.i;
                c0324fB.c = c0324f6;
                c0324f6.a = c0324fB;
                c0324f.c = null;
            }
            c0324fB.i = Math.max(i, i2) + 1;
            a((C0324f) c0324f, (C0324f) c0324fB);
            return;
        }
        if (c0324f2 != null) {
            a((C0324f) c0324f, (C0324f) c0324f2);
            c0324f.b = null;
        } else if (c0324f3 != null) {
            a((C0324f) c0324f, (C0324f) c0324f3);
            c0324f.c = null;
        } else {
            a((C0324f) c0324f, (C0324f) null);
        }
        b(c0324f4, false);
        this.d--;
        this.e++;
    }

    C0324f<K, V> b(Object obj) {
        C0324f<K, V> c0324fA = a(obj);
        if (c0324fA != null) {
            a((C0324f) c0324fA, true);
        }
        return c0324fA;
    }

    private void a(C0324f<K, V> c0324f, C0324f<K, V> c0324f2) {
        C0324f<K, V> c0324f3 = c0324f.a;
        c0324f.a = null;
        if (c0324f2 != null) {
            c0324f2.a = c0324f3;
        }
        if (c0324f3 != null) {
            if (c0324f3.b == c0324f) {
                c0324f3.b = c0324f2;
                return;
            } else {
                if (!g && c0324f3.c != c0324f) {
                    throw new AssertionError();
                }
                c0324f3.c = c0324f2;
                return;
            }
        }
        this.b[c0324f.g & (this.b.length - 1)] = c0324f2;
    }

    private void b(C0324f<K, V> c0324f, boolean z) {
        while (c0324f != null) {
            C0324f<K, V> c0324f2 = c0324f.b;
            C0324f<K, V> c0324f3 = c0324f.c;
            int i = c0324f2 != null ? c0324f2.i : 0;
            int i2 = c0324f3 != null ? c0324f3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C0324f<K, V> c0324f4 = c0324f3.b;
                C0324f<K, V> c0324f5 = c0324f3.c;
                int i4 = (c0324f4 != null ? c0324f4.i : 0) - (c0324f5 != null ? c0324f5.i : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a((C0324f) c0324f);
                } else {
                    if (!g && i4 != 1) {
                        throw new AssertionError();
                    }
                    b((C0324f) c0324f3);
                    a((C0324f) c0324f);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                C0324f<K, V> c0324f6 = c0324f2.b;
                C0324f<K, V> c0324f7 = c0324f2.c;
                int i5 = (c0324f6 != null ? c0324f6.i : 0) - (c0324f7 != null ? c0324f7.i : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b((C0324f) c0324f);
                } else {
                    if (!g && i5 != -1) {
                        throw new AssertionError();
                    }
                    a((C0324f) c0324f2);
                    b((C0324f) c0324f);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c0324f.i = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!g && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                c0324f.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            c0324f = c0324f.a;
        }
    }

    private void a(C0324f<K, V> c0324f) {
        C0324f<K, V> c0324f2 = c0324f.b;
        C0324f<K, V> c0324f3 = c0324f.c;
        C0324f<K, V> c0324f4 = c0324f3.b;
        C0324f<K, V> c0324f5 = c0324f3.c;
        c0324f.c = c0324f4;
        if (c0324f4 != null) {
            c0324f4.a = c0324f;
        }
        a((C0324f) c0324f, (C0324f) c0324f3);
        c0324f3.b = c0324f;
        c0324f.a = c0324f3;
        c0324f.i = Math.max(c0324f2 != null ? c0324f2.i : 0, c0324f4 != null ? c0324f4.i : 0) + 1;
        c0324f3.i = Math.max(c0324f.i, c0324f5 != null ? c0324f5.i : 0) + 1;
    }

    private void b(C0324f<K, V> c0324f) {
        C0324f<K, V> c0324f2 = c0324f.b;
        C0324f<K, V> c0324f3 = c0324f.c;
        C0324f<K, V> c0324f4 = c0324f2.b;
        C0324f<K, V> c0324f5 = c0324f2.c;
        c0324f.b = c0324f5;
        if (c0324f5 != null) {
            c0324f5.a = c0324f;
        }
        a((C0324f) c0324f, (C0324f) c0324f2);
        c0324f2.c = c0324f;
        c0324f.a = c0324f2;
        c0324f.i = Math.max(c0324f3 != null ? c0324f3.i : 0, c0324f5 != null ? c0324f5.i : 0) + 1;
        c0324f2.i = Math.max(c0324f.i, c0324f4 != null ? c0324f4.i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f<K, V>.c cVar = this.i;
        if (cVar != null) {
            return cVar;
        }
        f<K, V>.c cVar2 = new c();
        this.i = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        f<K, V>.d dVar = this.j;
        if (dVar != null) {
            return dVar;
        }
        f<K, V>.d dVar2 = new d();
        this.j = dVar2;
        return dVar2;
    }

    /* renamed from: com.component.lottie.f.a.f$f, reason: collision with other inner class name */
    static final class C0324f<K, V> implements Map.Entry<K, V> {
        C0324f<K, V> a;
        C0324f<K, V> b;
        C0324f<K, V> c;
        C0324f<K, V> d;
        C0324f<K, V> e;
        final K f;
        final int g;
        V h;
        int i;

        C0324f() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        C0324f(C0324f<K, V> c0324f, K k, int i, C0324f<K, V> c0324f2, C0324f<K, V> c0324f3) {
            this.a = c0324f;
            this.f = k;
            this.g = i;
            this.i = 1;
            this.d = c0324f2;
            this.e = c0324f3;
            c0324f3.d = this;
            c0324f2.e = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f.equals(entry.getKey())) {
                return false;
            }
            if (this.h == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.h.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.f == null ? 0 : this.f.hashCode()) ^ (this.h != null ? this.h.hashCode() : 0);
        }

        public String toString() {
            return this.f + "=" + this.h;
        }

        public C0324f<K, V> a() {
            C0324f<K, V> c0324f = this;
            for (C0324f<K, V> c0324f2 = this.b; c0324f2 != null; c0324f2 = c0324f2.b) {
                c0324f = c0324f2;
            }
            return c0324f;
        }

        public C0324f<K, V> b() {
            C0324f<K, V> c0324f = this;
            for (C0324f<K, V> c0324f2 = this.c; c0324f2 != null; c0324f2 = c0324f2.c) {
                c0324f = c0324f2;
            }
            return c0324f;
        }
    }

    private void a() {
        this.b = a((C0324f[]) this.b);
        this.f = (this.b.length / 2) + (this.b.length / 4);
    }

    static <K, V> C0324f<K, V>[] a(C0324f<K, V>[] c0324fArr) {
        int length = c0324fArr.length;
        C0324f<K, V>[] c0324fArr2 = new C0324f[length * 2];
        b bVar = new b();
        a aVar = new a();
        a aVar2 = new a();
        for (int i = 0; i < length; i++) {
            C0324f<K, V> c0324f = c0324fArr[i];
            if (c0324f != null) {
                bVar.a(c0324f);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    C0324f<K, V> c0324fA = bVar.a();
                    if (c0324fA == null) {
                        break;
                    }
                    if ((c0324fA.g & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                aVar.a(i2);
                aVar2.a(i3);
                bVar.a(c0324f);
                while (true) {
                    C0324f<K, V> c0324fA2 = bVar.a();
                    if (c0324fA2 == null) {
                        break;
                    }
                    if ((c0324fA2.g & length) == 0) {
                        aVar.a(c0324fA2);
                    } else {
                        aVar2.a(c0324fA2);
                    }
                }
                c0324fArr2[i] = i2 > 0 ? aVar.a() : null;
                c0324fArr2[i + length] = i3 > 0 ? aVar2.a() : null;
            }
        }
        return c0324fArr2;
    }

    static class b<K, V> {
        private C0324f<K, V> a;

        b() {
        }

        void a(C0324f<K, V> c0324f) {
            C0324f<K, V> c0324f2 = null;
            while (c0324f != null) {
                c0324f.a = c0324f2;
                c0324f2 = c0324f;
                c0324f = c0324f.b;
            }
            this.a = c0324f2;
        }

        public C0324f<K, V> a() {
            C0324f<K, V> c0324f = this.a;
            if (c0324f == null) {
                return null;
            }
            C0324f<K, V> c0324f2 = c0324f.a;
            c0324f.a = null;
            C0324f<K, V> c0324f3 = c0324f.c;
            while (true) {
                C0324f<K, V> c0324f4 = c0324f2;
                c0324f2 = c0324f3;
                if (c0324f2 != null) {
                    c0324f2.a = c0324f4;
                    c0324f3 = c0324f2.b;
                } else {
                    this.a = c0324f4;
                    return c0324f;
                }
            }
        }
    }

    static final class a<K, V> {
        private C0324f<K, V> a;
        private int b;
        private int c;
        private int d;

        a() {
        }

        void a(int i) {
            this.b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        void a(C0324f<K, V> c0324f) {
            c0324f.c = null;
            c0324f.a = null;
            c0324f.b = null;
            c0324f.i = 1;
            if (this.b > 0 && (this.d & 1) == 0) {
                this.d++;
                this.b--;
                this.c++;
            }
            c0324f.a = this.a;
            this.a = c0324f;
            this.d++;
            if (this.b > 0 && (this.d & 1) == 0) {
                this.d++;
                this.b--;
                this.c++;
            }
            int i = 4;
            while (true) {
                int i2 = i - 1;
                if ((this.d & i2) == i2) {
                    if (this.c != 0) {
                        if (this.c == 1) {
                            C0324f<K, V> c0324f2 = this.a;
                            C0324f<K, V> c0324f3 = c0324f2.a;
                            this.a = c0324f3;
                            c0324f3.c = c0324f2;
                            c0324f3.i = c0324f2.i + 1;
                            c0324f2.a = c0324f3;
                            this.c = 0;
                        } else if (this.c == 2) {
                            this.c = 0;
                        }
                    } else {
                        C0324f<K, V> c0324f4 = this.a;
                        C0324f<K, V> c0324f5 = c0324f4.a;
                        C0324f<K, V> c0324f6 = c0324f5.a;
                        c0324f5.a = c0324f6.a;
                        this.a = c0324f5;
                        c0324f5.b = c0324f6;
                        c0324f5.c = c0324f4;
                        c0324f5.i = c0324f4.i + 1;
                        c0324f6.a = c0324f5;
                        c0324f4.a = c0324f5;
                    }
                    i *= 2;
                } else {
                    return;
                }
            }
        }

        C0324f<K, V> a() {
            C0324f<K, V> c0324f = this.a;
            if (c0324f.a != null) {
                throw new IllegalStateException();
            }
            return c0324f;
        }
    }

    abstract class e<T> implements Iterator<T> {
        C0324f<K, V> b;
        C0324f<K, V> c = null;
        int d;

        e() {
            this.b = f.this.c.d;
            this.d = f.this.e;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b != f.this.c;
        }

        final C0324f<K, V> b() {
            C0324f<K, V> c0324f = this.b;
            if (c0324f == f.this.c) {
                throw new NoSuchElementException();
            }
            if (f.this.e != this.d) {
                throw new ConcurrentModificationException();
            }
            this.b = c0324f.d;
            this.c = c0324f;
            return c0324f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            f.this.a((C0324f) this.c, true);
            this.c = null;
            this.d = f.this.e;
        }
    }

    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new h(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && f.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            C0324f<K, V> c0324fA;
            if (!(obj instanceof Map.Entry) || (c0324fA = f.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            f.this.a((C0324f) c0324fA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }
    }

    final class d extends AbstractSet<K> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return f.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }
    }

    private Object b() {
        return new LinkedHashMap(this);
    }
}
