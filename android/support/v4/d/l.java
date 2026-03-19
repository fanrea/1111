package android.support.v4.d;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class l<E> implements Cloneable {
    private static final Object bL = new Object();
    private Object[] bN;
    private int[] ci;
    private boolean mGarbage;
    private int mSize;

    public l() {
        this(10);
    }

    private l(int i) {
        this.mGarbage = false;
        int iIdealIntArraySize = c.idealIntArraySize(10);
        this.ci = new int[iIdealIntArraySize];
        this.bN = new Object[iIdealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final l<E> clone() {
        try {
            l<E> lVar = (l) super.clone();
            lVar.ci = (int[]) this.ci.clone();
            lVar.bN = (Object[]) this.bN.clone();
            return lVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final E get(int i) {
        return get(i, null);
    }

    public final E get(int i, E e) {
        int iB = c.b(this.ci, this.mSize, i);
        if (iB >= 0) {
            Object[] objArr = this.bN;
            if (objArr[iB] != bL) {
                return (E) objArr[iB];
            }
        }
        return e;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.ci;
        Object[] objArr = this.bN;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != bL) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public final void put(int i, E e) {
        int iB = c.b(this.ci, this.mSize, i);
        if (iB >= 0) {
            this.bN[iB] = e;
            return;
        }
        int iB2 = iB ^ (-1);
        if (iB2 < this.mSize) {
            Object[] objArr = this.bN;
            if (objArr[iB2] == bL) {
                this.ci[iB2] = i;
                objArr[iB2] = e;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.ci.length) {
            gc();
            iB2 = c.b(this.ci, this.mSize, i) ^ (-1);
        }
        int i2 = this.mSize;
        if (i2 >= this.ci.length) {
            int iIdealIntArraySize = c.idealIntArraySize(i2 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr2 = new Object[iIdealIntArraySize];
            int[] iArr2 = this.ci;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.bN;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.ci = iArr;
            this.bN = objArr2;
        }
        int i3 = this.mSize;
        if (i3 - iB2 != 0) {
            int[] iArr3 = this.ci;
            int i4 = iB2 + 1;
            System.arraycopy(iArr3, iB2, iArr3, i4, i3 - iB2);
            Object[] objArr4 = this.bN;
            System.arraycopy(objArr4, iB2, objArr4, i4, this.mSize - iB2);
        }
        this.ci[iB2] = i;
        this.bN[iB2] = e;
        this.mSize++;
    }

    public final int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public final int keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.ci[i];
    }

    public final E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.bN[i];
    }

    public final void clear() {
        int i = this.mSize;
        Object[] objArr = this.bN;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public final void append(int i, E e) {
        int i2 = this.mSize;
        if (i2 != 0 && i <= this.ci[i2 - 1]) {
            put(i, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.ci.length) {
            gc();
        }
        int i3 = this.mSize;
        if (i3 >= this.ci.length) {
            int iIdealIntArraySize = c.idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr = new Object[iIdealIntArraySize];
            int[] iArr2 = this.ci;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.bN;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.ci = iArr;
            this.bN = objArr;
        }
        this.ci[i3] = i;
        this.bN[i3] = e;
        this.mSize = i3 + 1;
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i));
            sb.append(com.alipay.sdk.m.n.a.h);
            E eValueAt = valueAt(i);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
