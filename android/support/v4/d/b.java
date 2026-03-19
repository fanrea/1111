package android.support.v4.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] bC = new int[0];
    private static final Object[] bD = new Object[0];
    private static Object[] bE;
    private static int bF;
    private static Object[] bG;
    private static int bH;
    private g<E, E> bA;
    private int[] bI;
    Object[] bJ;
    int mSize;

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iB = c.b(this.bI, i2, i);
        if (iB < 0 || obj.equals(this.bJ[iB])) {
            return iB;
        }
        int i3 = iB + 1;
        while (i3 < i2 && this.bI[i3] == i) {
            if (obj.equals(this.bJ[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iB - 1; i4 >= 0 && this.bI[i4] == i; i4--) {
            if (obj.equals(this.bJ[i4])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    private int P() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int iB = c.b(this.bI, i, 0);
        if (iB < 0 || this.bJ[iB] == null) {
            return iB;
        }
        int i2 = iB + 1;
        while (i2 < i && this.bI[i2] == 0) {
            if (this.bJ[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iB - 1; i3 >= 0 && this.bI[i3] == 0; i3--) {
            if (this.bJ[i3] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    private void i(int i) {
        if (i == 8) {
            synchronized (b.class) {
                if (bG != null) {
                    Object[] objArr = bG;
                    this.bJ = objArr;
                    bG = (Object[]) objArr[0];
                    this.bI = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    bH--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                if (bE != null) {
                    Object[] objArr2 = bE;
                    this.bJ = objArr2;
                    bE = (Object[]) objArr2[0];
                    this.bI = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    bF--;
                    return;
                }
            }
        }
        this.bI = new int[i];
        this.bJ = new Object[i];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (bH < 10) {
                    objArr[0] = bG;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    bG = objArr;
                    bH++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (bF < 10) {
                    objArr[0] = bE;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    bE = objArr;
                    bF++;
                }
            }
        }
    }

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.bI = bC;
            this.bJ = bD;
        } else {
            i(i);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.mSize;
        if (i != 0) {
            a(this.bI, this.bJ, i);
            this.bI = bC;
            this.bJ = bD;
            this.mSize = 0;
        }
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.bI;
        if (iArr.length < i) {
            Object[] objArr = this.bJ;
            i(i);
            int i2 = this.mSize;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.bI, 0, i2);
                System.arraycopy(objArr, 0, this.bJ, 0, this.mSize);
            }
            a(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final int indexOf(Object obj) {
        return obj == null ? P() : indexOf(obj, obj.hashCode());
    }

    private E valueAt(int i) {
        return (E) this.bJ[i];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e) {
        int i;
        int iIndexOf;
        if (e == null) {
            iIndexOf = P();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iIndexOf = indexOf(e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i2 = iIndexOf ^ (-1);
        int i3 = this.mSize;
        if (i3 >= this.bI.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.bI;
            Object[] objArr = this.bJ;
            i(i4);
            int[] iArr2 = this.bI;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.bJ, 0, objArr.length);
            }
            a(iArr, objArr, this.mSize);
        }
        int i5 = this.mSize;
        if (i2 < i5) {
            int[] iArr3 = this.bI;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.bJ;
            System.arraycopy(objArr2, i2, objArr2, i6, this.mSize - i2);
        }
        this.bI[i2] = i;
        this.bJ[i2] = e;
        this.mSize++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final E removeAt(int i) {
        Object[] objArr = this.bJ;
        E e = (E) objArr[i];
        int i2 = this.mSize;
        if (i2 <= 1) {
            a(this.bI, objArr, i2);
            this.bI = bC;
            this.bJ = bD;
            this.mSize = 0;
        } else {
            int[] iArr = this.bI;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = this.bI;
                Object[] objArr2 = this.bJ;
                i(i3);
                this.mSize--;
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.bI, 0, i);
                    System.arraycopy(objArr2, 0, this.bJ, 0, i);
                }
                int i4 = this.mSize;
                if (i < i4) {
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, this.bI, i, i4 - i);
                    System.arraycopy(objArr2, i5, this.bJ, i, this.mSize - i);
                }
            } else {
                this.mSize--;
                int i6 = this.mSize;
                if (i < i6) {
                    int[] iArr3 = this.bI;
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, iArr3, i, i6 - i);
                    Object[] objArr3 = this.bJ;
                    System.arraycopy(objArr3, i7, objArr3, i, this.mSize - i);
                }
                this.bJ[this.mSize] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i = this.mSize;
        Object[] objArr = new Object[i];
        System.arraycopy(this.bJ, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        System.arraycopy(this.bJ, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i = this.mSize;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.mSize; i++) {
                try {
                    if (!set.contains(valueAt(i))) {
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
    public final int hashCode() {
        int[] iArr = this.bI;
        int i = this.mSize;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eValueAt = valueAt(i);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private g<E, E> L() {
        if (this.bA == null) {
            this.bA = new g<E, E>() { // from class: android.support.v4.d.b.1
                @Override // android.support.v4.d.g
                protected final int M() {
                    return b.this.mSize;
                }

                @Override // android.support.v4.d.g
                protected final Object d(int i, int i2) {
                    return b.this.bJ[i];
                }

                @Override // android.support.v4.d.g
                protected final int i(Object obj) {
                    return b.this.indexOf(obj);
                }

                @Override // android.support.v4.d.g
                protected final int j(Object obj) {
                    return b.this.indexOf(obj);
                }

                @Override // android.support.v4.d.g
                protected final Map<E, E> N() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.d.g
                protected final void a(E e, E e2) {
                    b.this.add(e);
                }

                @Override // android.support.v4.d.g
                protected final E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.d.g
                protected final void h(int i) {
                    b.this.removeAt(i);
                }

                @Override // android.support.v4.d.g
                protected final void O() {
                    b.this.clear();
                }
            };
        }
        return this.bA;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return L().S().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.bJ[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }
}
