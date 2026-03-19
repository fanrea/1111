package android.support.v4.d;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class e<E> implements Cloneable {
    private static final Object bL = new Object();
    private long[] bM;
    private Object[] bN;
    private boolean mGarbage;
    private int mSize;

    public e() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e(int i) {
        this.mGarbage = false;
        int iJ = c.j(10);
        this.bM = new long[iJ];
        this.bN = new Object[iJ];
        this.mSize = 0;
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.bM = (long[]) this.bM.clone();
            eVar.bN = (Object[]) this.bN.clone();
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final E get(long j) {
        return get(j, null);
    }

    public final E get(long j, E e) {
        int iA = c.a(this.bM, this.mSize, j);
        if (iA >= 0) {
            Object[] objArr = this.bN;
            if (objArr[iA] != bL) {
                return (E) objArr[iA];
            }
        }
        return e;
    }

    public final void delete(long j) {
        int iA = c.a(this.bM, this.mSize, j);
        if (iA >= 0) {
            Object[] objArr = this.bN;
            Object obj = objArr[iA];
            Object obj2 = bL;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public final void removeAt(int i) {
        Object[] objArr = this.bN;
        Object obj = objArr[i];
        Object obj2 = bL;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.mGarbage = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        long[] jArr = this.bM;
        Object[] objArr = this.bN;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != bL) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public final void put(long j, E e) {
        int iA = c.a(this.bM, this.mSize, j);
        if (iA >= 0) {
            this.bN[iA] = e;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.mSize) {
            Object[] objArr = this.bN;
            if (objArr[iA2] == bL) {
                this.bM[iA2] = j;
                objArr[iA2] = e;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.bM.length) {
            gc();
            iA2 = c.a(this.bM, this.mSize, j) ^ (-1);
        }
        int i = this.mSize;
        if (i >= this.bM.length) {
            int iJ = c.j(i + 1);
            long[] jArr = new long[iJ];
            Object[] objArr2 = new Object[iJ];
            long[] jArr2 = this.bM;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.bN;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.bM = jArr;
            this.bN = objArr2;
        }
        int i2 = this.mSize;
        if (i2 - iA2 != 0) {
            long[] jArr3 = this.bM;
            int i3 = iA2 + 1;
            System.arraycopy(jArr3, iA2, jArr3, i3, i2 - iA2);
            Object[] objArr4 = this.bN;
            System.arraycopy(objArr4, iA2, objArr4, i3, this.mSize - iA2);
        }
        this.bM[iA2] = j;
        this.bN[iA2] = e;
        this.mSize++;
    }

    public final int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.bM[i];
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

    public final void append(long j, E e) {
        int i = this.mSize;
        if (i != 0 && j <= this.bM[i - 1]) {
            put(j, e);
            return;
        }
        if (this.mGarbage && this.mSize >= this.bM.length) {
            gc();
        }
        int i2 = this.mSize;
        if (i2 >= this.bM.length) {
            int iJ = c.j(i2 + 1);
            long[] jArr = new long[iJ];
            Object[] objArr = new Object[iJ];
            long[] jArr2 = this.bM;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.bN;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.bM = jArr;
            this.bN = objArr;
        }
        this.bM[i2] = j;
        this.bN[i2] = e;
        this.mSize = i2 + 1;
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
