package android.support.v4.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class m<E> implements Cloneable {
    private static final Object bE = new Object();
    private boolean bF;
    private Object[] bH;
    private int[] cc;
    private int mSize;

    public m() {
        this(10);
    }

    private m(int i) {
        this.bF = false;
        int iG = c.g(10);
        this.cc = new int[iG];
        this.bH = new Object[iG];
        this.mSize = 0;
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final m<E> clone() {
        try {
            m<E> mVar = (m) super.clone();
            mVar.cc = (int[]) this.cc.clone();
            mVar.bH = (Object[]) this.bH.clone();
            return mVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final E get(int i) {
        return get(i, null);
    }

    public final E get(int i, E e) {
        int iB = c.b(this.cc, this.mSize, i);
        if (iB >= 0) {
            Object[] objArr = this.bH;
            if (objArr[iB] != bE) {
                return (E) objArr[iB];
            }
        }
        return e;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.cc;
        Object[] objArr = this.bH;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != bE) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.bF = false;
        this.mSize = i2;
    }

    public final void put(int i, E e) {
        int iB = c.b(this.cc, this.mSize, i);
        if (iB >= 0) {
            this.bH[iB] = e;
            return;
        }
        int iB2 = iB ^ (-1);
        if (iB2 < this.mSize) {
            Object[] objArr = this.bH;
            if (objArr[iB2] == bE) {
                this.cc[iB2] = i;
                objArr[iB2] = e;
                return;
            }
        }
        if (this.bF && this.mSize >= this.cc.length) {
            gc();
            iB2 = c.b(this.cc, this.mSize, i) ^ (-1);
        }
        int i2 = this.mSize;
        if (i2 >= this.cc.length) {
            int iG = c.g(i2 + 1);
            int[] iArr = new int[iG];
            Object[] objArr2 = new Object[iG];
            int[] iArr2 = this.cc;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.bH;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.cc = iArr;
            this.bH = objArr2;
        }
        int i3 = this.mSize;
        if (i3 - iB2 != 0) {
            int[] iArr3 = this.cc;
            int i4 = iB2 + 1;
            System.arraycopy(iArr3, iB2, iArr3, i4, i3 - iB2);
            Object[] objArr4 = this.bH;
            System.arraycopy(objArr4, iB2, objArr4, i4, this.mSize - iB2);
        }
        this.cc[iB2] = i;
        this.bH[iB2] = e;
        this.mSize++;
    }

    public final int size() {
        if (this.bF) {
            gc();
        }
        return this.mSize;
    }

    private int keyAt(int i) {
        if (this.bF) {
            gc();
        }
        return this.cc[i];
    }

    public final E valueAt(int i) {
        if (this.bF) {
            gc();
        }
        return (E) this.bH[i];
    }

    public final void clear() {
        int i = this.mSize;
        Object[] objArr = this.bH;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.bF = false;
    }

    public final void append(int i, E e) {
        int i2 = this.mSize;
        if (i2 != 0 && i <= this.cc[i2 - 1]) {
            put(i, e);
            return;
        }
        if (this.bF && this.mSize >= this.cc.length) {
            gc();
        }
        int i3 = this.mSize;
        if (i3 >= this.cc.length) {
            int iG = c.g(i3 + 1);
            int[] iArr = new int[iG];
            Object[] objArr = new Object[iG];
            int[] iArr2 = this.cc;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.bH;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.cc = iArr;
            this.bH = objArr;
        }
        this.cc[i3] = i;
        this.bH[i3] = e;
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
