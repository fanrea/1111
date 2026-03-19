package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d<E> implements Collection<E>, Set<E> {
    private static int an;
    private static final int[] b = new int[0];
    private static final Object[] c = new Object[0];
    private static int gb;
    private static Object[] h;
    private static Object[] u;
    Object[] d;
    int hc;
    private e<E, E> tc;
    private int[] tt;

    private int d(Object obj, int i) {
        int i2 = this.hc;
        if (i2 == 0) {
            return -1;
        }
        int iD = hc.d(this.tt, i2, i);
        if (iD < 0 || obj.equals(this.d[iD])) {
            return iD;
        }
        int i3 = iD + 1;
        while (i3 < i2 && this.tt[i3] == i) {
            if (obj.equals(this.d[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iD - 1; i4 >= 0 && this.tt[i4] == i; i4--) {
            if (obj.equals(this.d[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int d() {
        int i = this.hc;
        if (i == 0) {
            return -1;
        }
        int iD = hc.d(this.tt, i, 0);
        if (iD < 0 || this.d[iD] == null) {
            return iD;
        }
        int i2 = iD + 1;
        while (i2 < i && this.tt[i2] == 0) {
            if (this.d[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iD - 1; i3 >= 0 && this.tt[i3] == 0; i3--) {
            if (this.d[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void c(int i) {
        if (i == 8) {
            synchronized (d.class) {
                Object[] objArr = h;
                if (objArr != null) {
                    this.d = objArr;
                    h = (Object[]) objArr[0];
                    this.tt = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    gb--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (d.class) {
                Object[] objArr2 = u;
                if (objArr2 != null) {
                    this.d = objArr2;
                    u = (Object[]) objArr2[0];
                    this.tt = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    an--;
                    return;
                }
            }
        }
        this.tt = new int[i];
        this.d = new Object[i];
    }

    private static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (gb < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    h = objArr;
                    gb++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (d.class) {
                if (an < 10) {
                    objArr[0] = u;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    u = objArr;
                    an++;
                }
            }
        }
    }

    public d() {
        this(0);
    }

    public d(int i) {
        if (i == 0) {
            this.tt = b;
            this.d = c;
        } else {
            c(i);
        }
        this.hc = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.hc;
        if (i != 0) {
            d(this.tt, this.d, i);
            this.tt = b;
            this.d = c;
            this.hc = 0;
        }
    }

    public void d(int i) {
        int[] iArr = this.tt;
        if (iArr.length < i) {
            Object[] objArr = this.d;
            c(i);
            int i2 = this.hc;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.tt, 0, i2);
                System.arraycopy(objArr, 0, this.d, 0, this.hc);
            }
            d(iArr, objArr, this.hc);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return d(obj) >= 0;
    }

    public int d(Object obj) {
        return obj == null ? d() : d(obj, obj.hashCode());
    }

    public E hc(int i) {
        return (E) this.d[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.hc <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iD;
        if (e == null) {
            iD = d();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iD = d(e, iHashCode);
        }
        if (iD >= 0) {
            return false;
        }
        int i2 = ~iD;
        int i3 = this.hc;
        int[] iArr = this.tt;
        if (i3 >= iArr.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            Object[] objArr = this.d;
            c(i4);
            int[] iArr2 = this.tt;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.d, 0, objArr.length);
            }
            d(iArr, objArr, this.hc);
        }
        int i5 = this.hc;
        if (i2 < i5) {
            int[] iArr3 = this.tt;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, i2, objArr2, i6, this.hc - i2);
        }
        this.tt[i2] = i;
        this.d[i2] = e;
        this.hc++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iD = d(obj);
        if (iD < 0) {
            return false;
        }
        b(iD);
        return true;
    }

    public E b(int i) {
        Object[] objArr = this.d;
        E e = (E) objArr[i];
        int i2 = this.hc;
        if (i2 <= 1) {
            d(this.tt, objArr, i2);
            this.tt = b;
            this.d = c;
            this.hc = 0;
        } else {
            int[] iArr = this.tt;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                c(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.hc--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.tt, 0, i);
                    System.arraycopy(objArr, 0, this.d, 0, i);
                }
                int i3 = this.hc;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.tt, i, i3 - i);
                    System.arraycopy(objArr, i4, this.d, i, this.hc - i);
                }
            } else {
                int i5 = i2 - 1;
                this.hc = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.d;
                    System.arraycopy(objArr2, i6, objArr2, i, this.hc - i);
                }
                this.d[this.hc] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.hc;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.hc;
        Object[] objArr = new Object[i];
        System.arraycopy(this.d, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.hc) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.hc));
        }
        System.arraycopy(this.d, 0, tArr, 0, this.hc);
        int length = tArr.length;
        int i = this.hc;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.hc; i++) {
                try {
                    if (!set.contains(hc(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.tt;
        int i = this.hc;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.hc * 14);
        sb.append('{');
        for (int i = 0; i < this.hc; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eHc = hc(i);
            if (eHc != this) {
                sb.append(eHc);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private e<E, E> hc() {
        if (this.tc == null) {
            this.tc = new e<E, E>() { // from class: com.bytedance.adsdk.lottie.d.1
                @Override // com.bytedance.adsdk.lottie.e
                protected int d() {
                    return d.this.hc;
                }

                @Override // com.bytedance.adsdk.lottie.e
                protected Object d(int i, int i2) {
                    return d.this.d[i];
                }

                @Override // com.bytedance.adsdk.lottie.e
                protected int d(Object obj) {
                    return d.this.d(obj);
                }

                @Override // com.bytedance.adsdk.lottie.e
                protected Map<E, E> hc() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.e
                protected void d(int i) {
                    d.this.b(i);
                }

                @Override // com.bytedance.adsdk.lottie.e
                protected void b() {
                    d.this.clear();
                }
            };
        }
        return this.tc;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return hc().c().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        d(this.hc + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.hc - 1; i >= 0; i--) {
            if (!collection.contains(this.d[i])) {
                b(i);
                z = true;
            }
        }
        return z;
    }
}
