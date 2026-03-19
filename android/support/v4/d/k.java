package android.support.v4.d;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class k<K, V> {
    static Object[] cc;
    static int cd;
    static Object[] ce;
    static int cg;
    int[] bI = c.EMPTY_INTS;
    Object[] bJ = c.EMPTY_OBJECTS;
    int mSize = 0;

    private static int c(int[] iArr, int i, int i2) {
        try {
            return c.b(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iC = c(this.bI, i2, i);
        if (iC < 0 || obj.equals(this.bJ[iC << 1])) {
            return iC;
        }
        int i3 = iC + 1;
        while (i3 < i2 && this.bI[i3] == i) {
            if (obj.equals(this.bJ[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iC - 1; i4 >= 0 && this.bI[i4] == i; i4--) {
            if (obj.equals(this.bJ[i4 << 1])) {
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
        int iC = c(this.bI, i, 0);
        if (iC < 0 || this.bJ[iC << 1] == null) {
            return iC;
        }
        int i2 = iC + 1;
        while (i2 < i && this.bI[i2] == 0) {
            if (this.bJ[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iC - 1; i3 >= 0 && this.bI[i3] == 0; i3--) {
            if (this.bJ[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    private void i(int i) {
        if (i == 8) {
            synchronized (a.class) {
                if (ce != null) {
                    Object[] objArr = ce;
                    this.bJ = objArr;
                    ce = (Object[]) objArr[0];
                    this.bI = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    cg--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (cc != null) {
                    Object[] objArr2 = cc;
                    this.bJ = objArr2;
                    cc = (Object[]) objArr2[0];
                    this.bI = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    cd--;
                    return;
                }
            }
        }
        this.bI = new int[i];
        this.bJ = new Object[i << 1];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (cg < 10) {
                    objArr[0] = ce;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    ce = objArr;
                    cg++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (a.class) {
                if (cd < 10) {
                    objArr[0] = cc;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    cc = objArr;
                    cd++;
                }
            }
        }
    }

    public void clear() {
        int i = this.mSize;
        if (i > 0) {
            int[] iArr = this.bI;
            Object[] objArr = this.bJ;
            this.bI = c.EMPTY_INTS;
            this.bJ = c.EMPTY_OBJECTS;
            this.mSize = 0;
            a(iArr, objArr, i);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void ensureCapacity(int i) {
        int i2 = this.mSize;
        int[] iArr = this.bI;
        if (iArr.length < i) {
            Object[] objArr = this.bJ;
            i(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.bI, 0, i2);
                System.arraycopy(objArr, 0, this.bJ, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.mSize != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? P() : indexOf(obj, obj.hashCode());
    }

    final int indexOfValue(Object obj) {
        int i = this.mSize * 2;
        Object[] objArr = this.bJ;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return (V) this.bJ[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    public final K keyAt(int i) {
        return (K) this.bJ[i << 1];
    }

    public final V valueAt(int i) {
        return (V) this.bJ[(i << 1) + 1];
    }

    public final V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.bJ;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iIndexOf;
        int i2 = this.mSize;
        if (k == null) {
            iIndexOf = P();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iIndexOf = indexOf(k, iHashCode);
        }
        if (iIndexOf >= 0) {
            int i3 = (iIndexOf << 1) + 1;
            Object[] objArr = this.bJ;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = iIndexOf ^ (-1);
        if (i2 >= this.bI.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.bI;
            Object[] objArr2 = this.bJ;
            i(i5);
            if (i2 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.bI;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.bJ, 0, objArr2.length);
            }
            a(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.bI;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.bJ;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.mSize - i4) << 1);
        }
        int i7 = this.mSize;
        if (i2 == i7) {
            int[] iArr4 = this.bI;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.bJ;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.mSize = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public final V removeAt(int i) {
        int i2;
        Object[] objArr = this.bJ;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.mSize;
        if (i4 <= 1) {
            a(this.bI, objArr, i4);
            this.bI = c.EMPTY_INTS;
            this.bJ = c.EMPTY_OBJECTS;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.bI;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.bI;
                Object[] objArr2 = this.bJ;
                i(i5);
                if (i4 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.bI, 0, i);
                    System.arraycopy(objArr2, 0, this.bJ, 0, i3);
                }
                if (i < i2) {
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, this.bI, i, i7);
                    System.arraycopy(objArr2, i6 << 1, this.bJ, i3, i7 << 1);
                }
            } else {
                if (i < i2) {
                    int[] iArr3 = this.bI;
                    int i8 = i + 1;
                    int i9 = i2 - i;
                    System.arraycopy(iArr3, i8, iArr3, i, i9);
                    Object[] objArr3 = this.bJ;
                    System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                Object[] objArr4 = this.bJ;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i2;
        return v;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (size() != kVar.size()) {
                return false;
            }
            for (int i = 0; i < this.mSize; i++) {
                try {
                    K kKeyAt = keyAt(i);
                    V vValueAt = valueAt(i);
                    Object obj2 = kVar.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !kVar.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.mSize; i2++) {
                try {
                    K kKeyAt2 = keyAt(i2);
                    V vValueAt2 = valueAt(i2);
                    Object obj3 = map.get(kKeyAt2);
                    if (vValueAt2 == null) {
                        if (obj3 != null || !map.containsKey(kKeyAt2)) {
                            return false;
                        }
                    } else if (!vValueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.bI;
        Object[] objArr = this.bJ;
        int i = this.mSize;
        int i2 = 0;
        int iHashCode = 0;
        int i3 = 1;
        while (i2 < i) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(i);
            if (kKeyAt != this) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append(com.alipay.sdk.m.n.a.h);
            V vValueAt = valueAt(i);
            if (vValueAt != this) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
