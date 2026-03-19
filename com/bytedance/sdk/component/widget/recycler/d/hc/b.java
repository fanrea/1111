package com.bytedance.sdk.component.widget.recycler.d.hc;

import com.alipay.sdk.m.n.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b<E> implements Cloneable {
    private static final Object d = new Object();
    private long[] b;
    private Object[] c;
    private boolean hc;
    private int u;

    public b() {
        this(10);
    }

    public b(int i) {
        this.hc = false;
        if (i == 0) {
            this.b = hc.hc;
            this.c = hc.b;
        } else {
            int iD = hc.d(i);
            this.b = new long[iD];
            this.c = new Object[iD];
        }
        this.u = 0;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b<E> clone() {
        try {
            b<E> bVar = (b) super.clone();
            bVar.b = (long[]) this.b.clone();
            bVar.c = (Object[]) this.c.clone();
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E d(long j) {
        return d(j, null);
    }

    public E d(long j, E e) {
        E e2;
        int iD = hc.d(this.b, this.u, j);
        return (iD < 0 || (e2 = (E) this.c[iD]) == d) ? e : e2;
    }

    public void delete(long j) {
        int iD = hc.d(this.b, this.u, j);
        if (iD >= 0) {
            Object[] objArr = this.c;
            Object obj = objArr[iD];
            Object obj2 = d;
            if (obj != obj2) {
                objArr[iD] = obj2;
                this.hc = true;
            }
        }
    }

    public void d(int i) {
        Object[] objArr = this.c;
        Object obj = objArr[i];
        Object obj2 = d;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.hc = true;
        }
    }

    private void c() {
        int i = this.u;
        long[] jArr = this.b;
        Object[] objArr = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != d) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.hc = false;
        this.u = i2;
    }

    public void hc(long j, E e) {
        int iD = hc.d(this.b, this.u, j);
        if (iD >= 0) {
            this.c[iD] = e;
            return;
        }
        int i = ~iD;
        int i2 = this.u;
        if (i < i2) {
            Object[] objArr = this.c;
            if (objArr[i] == d) {
                this.b[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.hc && i2 >= this.b.length) {
            c();
            i = ~hc.d(this.b, this.u, j);
        }
        int i3 = this.u;
        if (i3 >= this.b.length) {
            int iD2 = hc.d(i3 + 1);
            long[] jArr = new long[iD2];
            Object[] objArr2 = new Object[iD2];
            long[] jArr2 = this.b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.b = jArr;
            this.c = objArr2;
        }
        int i4 = this.u;
        if (i4 - i != 0) {
            long[] jArr3 = this.b;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.c;
            System.arraycopy(objArr4, i, objArr4, i5, this.u - i);
        }
        this.b[i] = j;
        this.c[i] = e;
        this.u++;
    }

    public int hc() {
        if (this.hc) {
            c();
        }
        return this.u;
    }

    public long hc(int i) {
        if (this.hc) {
            c();
        }
        return this.b[i];
    }

    public E b(int i) {
        if (this.hc) {
            c();
        }
        return (E) this.c[i];
    }

    public void b() {
        int i = this.u;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.u = 0;
        this.hc = false;
    }

    public String toString() {
        if (hc() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.u * 28);
        sb.append('{');
        for (int i = 0; i < this.u; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(hc(i));
            sb.append(a.h);
            E eB = b(i);
            if (eB != this) {
                sb.append(eB);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
