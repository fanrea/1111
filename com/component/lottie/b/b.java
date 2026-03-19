package com.component.lottie.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private long[] c;
    private Object[] d;
    private int e;

    public b() {
        this(10);
    }

    public b(int i) {
        this.b = false;
        if (i == 0) {
            this.c = a.b;
            this.d = a.c;
        } else {
            int iB = a.b(i);
            this.c = new long[iB];
            this.d = new Object[iB];
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b<E> clone() {
        try {
            b<E> bVar = (b) super.clone();
            bVar.c = (long[]) this.c.clone();
            bVar.d = (Object[]) this.d.clone();
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E a(long j) {
        return a(j, (long) null);
    }

    public E a(long j, E e) {
        int iA = a.a(this.c, this.e, j);
        if (iA < 0 || this.d[iA] == a) {
            return e;
        }
        return (E) this.d[iA];
    }

    @Deprecated
    public void b(long j) {
        c(j);
    }

    public void c(long j) {
        int iA = a.a(this.c, this.e, j);
        if (iA >= 0 && this.d[iA] != a) {
            this.d[iA] = a;
            this.b = true;
        }
    }

    public boolean b(long j, Object obj) {
        int iD = d(j);
        if (iD >= 0) {
            E eC = c(iD);
            if (obj == eC || (obj != null && obj.equals(eC))) {
                a(iD);
                return true;
            }
            return false;
        }
        return false;
    }

    public void a(int i) {
        if (this.d[i] != a) {
            this.d[i] = a;
            this.b = true;
        }
    }

    public E c(long j, E e) {
        int iD = d(j);
        if (iD >= 0) {
            E e2 = (E) this.d[iD];
            this.d[iD] = e;
            return e2;
        }
        return null;
    }

    public boolean a(long j, E e, E e2) {
        int iD = d(j);
        if (iD >= 0) {
            Object obj = this.d[iD];
            if (obj == e || (e != null && e.equals(obj))) {
                this.d[iD] = e2;
                return true;
            }
            return false;
        }
        return false;
    }

    private void e() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public void d(long j, E e) {
        int iA = a.a(this.c, this.e, j);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.e && this.d[iA2] == a) {
            this.c[iA2] = j;
            this.d[iA2] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
            iA2 = a.a(this.c, this.e, j) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int iB = a.b(this.e + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        if (this.e - iA2 != 0) {
            int i = iA2 + 1;
            System.arraycopy(this.c, iA2, this.c, i, this.e - iA2);
            System.arraycopy(this.d, iA2, this.d, i, this.e - iA2);
        }
        this.c[iA2] = j;
        this.d[iA2] = e;
        this.e++;
    }

    public void a(b<? extends E> bVar) {
        int iB = bVar.b();
        for (int i = 0; i < iB; i++) {
            d(bVar.b(i), bVar.c(i));
        }
    }

    public E e(long j, E e) {
        E eA = a(j);
        if (eA == null) {
            d(j, e);
        }
        return eA;
    }

    public int b() {
        if (this.b) {
            e();
        }
        return this.e;
    }

    public boolean c() {
        return b() == 0;
    }

    public long b(int i) {
        if (this.b) {
            e();
        }
        return this.c[i];
    }

    public E c(int i) {
        if (this.b) {
            e();
        }
        return (E) this.d[i];
    }

    public void a(int i, E e) {
        if (this.b) {
            e();
        }
        this.d[i] = e;
    }

    public int d(long j) {
        if (this.b) {
            e();
        }
        return a.a(this.c, this.e, j);
    }

    public int a(E e) {
        if (this.b) {
            e();
        }
        for (int i = 0; i < this.e; i++) {
            if (this.d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean e(long j) {
        return d(j) >= 0;
    }

    public boolean b(E e) {
        return a((b<E>) e) >= 0;
    }

    public void d() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void f(long j, E e) {
        if (this.e != 0 && j <= this.c[this.e - 1]) {
            d(j, e);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
        }
        int i = this.e;
        if (i >= this.c.length) {
            int iB = a.b(i + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e = i + 1;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append(com.alipay.sdk.m.n.a.h);
            E eC = c(i);
            if (eC != this) {
                sb.append(eC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
