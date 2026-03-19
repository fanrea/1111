package com.component.lottie.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public e() {
        this(10);
    }

    public e(int i) {
        this.b = false;
        if (i == 0) {
            this.c = a.a;
            this.d = a.c;
        } else {
            int iA = a.a(i);
            this.c = new int[iA];
            this.d = new Object[iA];
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e<E> clone() {
        try {
            e<E> eVar = (e) super.clone();
            eVar.c = (int[]) this.c.clone();
            eVar.d = (Object[]) this.d.clone();
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E a(int i) {
        return a(i, (int) null);
    }

    public E a(int i, E e) {
        int iA = a.a(this.c, this.e, i);
        if (iA < 0 || this.d[iA] == a) {
            return e;
        }
        return (E) this.d[iA];
    }

    @Deprecated
    public void b(int i) {
        c(i);
    }

    public void c(int i) {
        int iA = a.a(this.c, this.e, i);
        if (iA >= 0 && this.d[iA] != a) {
            this.d[iA] = a;
            this.b = true;
        }
    }

    public boolean b(int i, Object obj) {
        int iG = g(i);
        if (iG >= 0) {
            E eF = f(iG);
            if (obj == eF || (obj != null && obj.equals(eF))) {
                d(iG);
                return true;
            }
            return false;
        }
        return false;
    }

    public void d(int i) {
        if (this.d[i] != a) {
            this.d[i] = a;
            this.b = true;
        }
    }

    public void a(int i, int i2) {
        int iMin = Math.min(this.e, i2 + i);
        while (i < iMin) {
            d(i);
            i++;
        }
    }

    public E c(int i, E e) {
        int iG = g(i);
        if (iG >= 0) {
            E e2 = (E) this.d[iG];
            this.d[iG] = e;
            return e2;
        }
        return null;
    }

    public boolean a(int i, E e, E e2) {
        int iG = g(i);
        if (iG >= 0) {
            Object obj = this.d[iG];
            if (obj == e || (e != null && e.equals(obj))) {
                this.d[iG] = e2;
                return true;
            }
            return false;
        }
        return false;
    }

    private void e() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public void d(int i, E e) {
        int iA = a.a(this.c, this.e, i);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.e && this.d[iA2] == a) {
            this.c[iA2] = i;
            this.d[iA2] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
            iA2 = a.a(this.c, this.e, i) ^ (-1);
        }
        if (this.e >= this.c.length) {
            int iA3 = a.a(this.e + 1);
            int[] iArr = new int[iA3];
            Object[] objArr = new Object[iA3];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        if (this.e - iA2 != 0) {
            int i2 = iA2 + 1;
            System.arraycopy(this.c, iA2, this.c, i2, this.e - iA2);
            System.arraycopy(this.d, iA2, this.d, i2, this.e - iA2);
        }
        this.c[iA2] = i;
        this.d[iA2] = e;
        this.e++;
    }

    public void a(e<? extends E> eVar) {
        int iB = eVar.b();
        for (int i = 0; i < iB; i++) {
            d(eVar.e(i), eVar.f(i));
        }
    }

    public E e(int i, E e) {
        E eA = a(i);
        if (eA == null) {
            d(i, e);
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

    public int e(int i) {
        if (this.b) {
            e();
        }
        return this.c[i];
    }

    public E f(int i) {
        if (this.b) {
            e();
        }
        return (E) this.d[i];
    }

    public void f(int i, E e) {
        if (this.b) {
            e();
        }
        this.d[i] = e;
    }

    public int g(int i) {
        if (this.b) {
            e();
        }
        return a.a(this.c, this.e, i);
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

    public boolean h(int i) {
        return g(i) >= 0;
    }

    public boolean b(E e) {
        return a((e<E>) e) >= 0;
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

    public void g(int i, E e) {
        if (this.e != 0 && i <= this.c[this.e - 1]) {
            d(i, e);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int iA = a.a(i2 + 1);
            int[] iArr = new int[iA];
            Object[] objArr = new Object[iA];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i2] = i;
        this.d[i2] = e;
        this.e = i2 + 1;
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
            sb.append(e(i));
            sb.append(com.alipay.sdk.m.n.a.h);
            E eF = f(i);
            if (eF != this) {
                sb.append(eF);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
