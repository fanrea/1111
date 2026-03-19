package com.bytedance.sdk.component.widget.recycler.d.hc;

import com.alipay.sdk.m.n.a;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int hc;
    int[] u = hc.d;
    Object[] an = hc.b;
    int h = 0;

    private static int d(int[] iArr, int i, int i2) {
        try {
            return hc.d(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    int d(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int iD = d(this.u, i2, i);
        if (iD < 0 || obj.equals(this.an[iD << 1])) {
            return iD;
        }
        int i3 = iD + 1;
        while (i3 < i2 && this.u[i3] == i) {
            if (obj.equals(this.an[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iD - 1; i4 >= 0 && this.u[i4] == i; i4--) {
            if (obj.equals(this.an[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    int d() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int iD = d(this.u, i, 0);
        if (iD < 0 || this.an[iD << 1] == null) {
            return iD;
        }
        int i2 = iD + 1;
        while (i2 < i && this.u[i2] == 0) {
            if (this.an[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iD - 1; i3 >= 0 && this.u[i3] == 0; i3--) {
            if (this.an[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void c(int i) {
        if (i == 8) {
            synchronized (d.class) {
                Object[] objArr = b;
                if (objArr != null) {
                    this.an = objArr;
                    b = (Object[]) objArr[0];
                    this.u = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    c--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (d.class) {
                Object[] objArr2 = d;
                if (objArr2 != null) {
                    this.an = objArr2;
                    d = (Object[]) objArr2[0];
                    this.u = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    hc--;
                    return;
                }
            }
        }
        this.u = new int[i];
        this.an = new Object[i << 1];
    }

    private static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    b = objArr;
                    c++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (d.class) {
                if (hc < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    d = objArr;
                    hc++;
                }
            }
        }
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.u;
            Object[] objArr = this.an;
            this.u = hc.d;
            this.an = hc.b;
            this.h = 0;
            d(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public int d(Object obj) {
        return obj == null ? d() : d(obj, obj.hashCode());
    }

    int hc(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.an;
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
        return hc(obj) >= 0;
    }

    public V get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return (V) this.an[(iD << 1) + 1];
        }
        return null;
    }

    public K d(int i) {
        return (K) this.an[i << 1];
    }

    public V hc(int i) {
        return (V) this.an[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iD;
        int i2 = this.h;
        if (k == null) {
            iD = d();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iD = d(k, iHashCode);
        }
        if (iD >= 0) {
            int i3 = (iD << 1) + 1;
            Object[] objArr = this.an;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iD;
        int[] iArr = this.u;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.an;
            c(i5);
            if (i2 != this.h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.u;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.an, 0, objArr2.length);
            }
            d(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.u;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.an;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.h - i4) << 1);
        }
        int i7 = this.h;
        if (i2 == i7) {
            int[] iArr4 = this.u;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.an;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.h = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return b(iD);
        }
        return null;
    }

    public V b(int i) {
        Object[] objArr = this.an;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.h;
        int i4 = 0;
        if (i3 <= 1) {
            d(this.u, objArr, i3);
            this.u = hc.d;
            this.an = hc.b;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.u;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                c(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.u, 0, i);
                    System.arraycopy(objArr, 0, this.an, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.u, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.an, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.an;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.an;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 != this.h) {
            throw new ConcurrentModificationException();
        }
        this.h = i4;
        return v;
    }

    public int size() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (size() != uVar.size()) {
                return false;
            }
            for (int i = 0; i < this.h; i++) {
                try {
                    K kD = d(i);
                    V vHc = hc(i);
                    Object obj2 = uVar.get(kD);
                    if (vHc == null) {
                        if (obj2 != null || !uVar.containsKey(kD)) {
                            return false;
                        }
                    } else if (!vHc.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            try {
                K kD2 = d(i2);
                V vHc2 = hc(i2);
                Object obj3 = map.get(kD2);
                if (vHc2 == null) {
                    if (obj3 != null || !map.containsKey(kD2)) {
                        return false;
                    }
                } else if (!vHc2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.u;
        Object[] objArr = this.an;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kD = d(i);
            if (kD != this) {
                sb.append(kD);
            } else {
                sb.append("(this Map)");
            }
            sb.append(a.h);
            V vHc = hc(i);
            if (vHc != this) {
                sb.append(vHc);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
