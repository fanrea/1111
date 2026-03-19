package com.qq.e.comm.plugin;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.dl;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class v40<V extends View & dl> {
    protected final w40<v40<V>, V> a;
    protected final V b;
    private Boolean c;
    private boolean d = false;
    private boolean e = false;
    private int f;
    private int g;
    private int h;
    private int i;
    private int[] j;
    private int[] k;

    public v40(w40<v40<V>, V> w40Var, V v) {
        this.a = w40Var;
        this.b = v;
    }

    public Pair<Integer, Integer> b(int i, int i2) {
        if (g()) {
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
        rk rkVarW = this.a.w();
        float fE = rkVarW.e();
        if (fE > 0.0f) {
            if (rkVarW.g() == 0 && rkVarW.h() != 0) {
                double size = fE * View.MeasureSpec.getSize(i2);
                Double.isNaN(size);
                i = View.MeasureSpec.makeMeasureSpec((int) (size + 0.5d), 1073741824);
                this.c = Boolean.TRUE;
            } else if (rkVarW.g() != 0 && rkVarW.h() == 0) {
                double size2 = View.MeasureSpec.getSize(i) / fE;
                Double.isNaN(size2);
                i2 = View.MeasureSpec.makeMeasureSpec((int) (size2 + 0.5d), 1073741824);
                this.c = Boolean.FALSE;
            }
        }
        Pair<Integer, Integer> pairA = a(rkVarW, i, i2);
        Integer num = (Integer) pairA.first;
        int iIntValue = num.intValue();
        Integer num2 = (Integer) pairA.second;
        boolean zC = c(iIntValue, num2.intValue());
        boolean zI = i();
        if ((zC || zI) && this.d && (this.a instanceof zn)) {
            a();
        }
        return new Pair<>(num, num2);
    }

    private boolean i() {
        int iD = this.a.D().d();
        int iF = this.a.D().f();
        if (this.h == iD && this.g == iF) {
            return false;
        }
        this.h = iD;
        this.i = iF;
        return true;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.e) {
            rk rkVarW = this.a.w();
            View viewA = this.a.A();
            if (viewA == null) {
                return;
            }
            if (rkVarW.a(new r8(i, i2, i3, i4))) {
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.width = rkVarW.g();
                    marginLayoutParams.height = rkVarW.h();
                    marginLayoutParams.leftMargin = rkVarW.m();
                    marginLayoutParams.rightMargin = rkVarW.a();
                    marginLayoutParams.topMargin = rkVarW.q();
                    marginLayoutParams.bottomMargin = rkVarW.k();
                }
            }
            u8 u8VarB = this.a.B();
            if (u8VarB.a(new r8(i, i2, i3, i4))) {
                viewA.setPadding(u8VarB.c(), u8VarB.e(), u8VarB.d(), u8VarB.b());
            }
            this.a.k();
        }
    }

    public boolean f() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    private static int b(int i, int i2, int i3, int i4) {
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        if (mode == Integer.MIN_VALUE) {
            if (i > 0 && Math.max(size, i3) > i) {
                i4 = View.MeasureSpec.makeMeasureSpec(i, mode);
            }
            return (i2 <= 0 || Math.min(i3, size) >= i2) ? i4 : View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (i > 0 && size > i) {
            i4 = View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(i4));
        }
        return (i2 <= 0 || size >= i2) ? i4 : View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    }

    private boolean g() {
        w40<v40<V>, V> w40Var = this.a;
        if (w40Var != null && (this.j != null || this.k != null)) {
            im imVarD = w40Var.D();
            if (imVarD == null) {
                return false;
            }
            z = a(imVarD.d(), this.j) || a(imVarD.f(), this.k);
            this.a.a(z);
        }
        return z;
    }

    public void h() {
        u8 u8VarB = this.a.B();
        if (u8VarB.f()) {
            this.b.setPadding(u8VarB.c(), u8VarB.e(), u8VarB.d(), u8VarB.b());
            u8VarB.a();
        }
        zn znVarC = this.a.C();
        if (znVarC == null || this.b.getLayoutParams() == null) {
            return;
        }
        rk rkVarW = this.a.w();
        if (rkVarW.f()) {
            this.b.setLayoutParams(znVarC.a(rkVarW));
            rkVarW.d();
        }
    }

    public int e() {
        return this.b.getMeasuredWidth();
    }

    public int d() {
        return this.b.getMeasuredHeight();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<java.lang.Integer, java.lang.Integer> a(int r9, int r10) {
        /*
            r8 = this;
            com.qq.e.comm.plugin.w40<com.qq.e.comm.plugin.v40<V extends android.view.View & com.qq.e.comm.plugin.dl>, V extends android.view.View & com.qq.e.comm.plugin.dl> r0 = r8.a
            int r5 = r0.y()
            com.qq.e.comm.plugin.w40<com.qq.e.comm.plugin.v40<V extends android.view.View & com.qq.e.comm.plugin.dl>, V extends android.view.View & com.qq.e.comm.plugin.dl> r0 = r8.a
            int r6 = r0.z()
            java.lang.Boolean r0 = r8.c
            if (r0 == 0) goto L85
            boolean r0 = r0.booleanValue()
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L51
            int r0 = android.view.View.MeasureSpec.getMode(r10)
            if (r0 != r4) goto L85
            int r0 = android.view.View.MeasureSpec.getSize(r10)
            if (r0 == r5) goto L85
            float r9 = (float) r5
            com.qq.e.comm.plugin.w40<com.qq.e.comm.plugin.v40<V extends android.view.View & com.qq.e.comm.plugin.dl>, V extends android.view.View & com.qq.e.comm.plugin.dl> r10 = r8.a
            com.qq.e.comm.plugin.rk r10 = r10.w()
            float r10 = r10.e()
            float r9 = r9 * r10
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r9 = r9 + r2
            int r9 = (int) r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r1)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r4)
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r0.<init>(r1, r2)
            goto L86
        L51:
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            if (r0 != r4) goto L85
            int r0 = android.view.View.MeasureSpec.getSize(r9)
            if (r0 == r6) goto L85
            float r9 = (float) r6
            com.qq.e.comm.plugin.w40<com.qq.e.comm.plugin.v40<V extends android.view.View & com.qq.e.comm.plugin.dl>, V extends android.view.View & com.qq.e.comm.plugin.dl> r10 = r8.a
            com.qq.e.comm.plugin.rk r10 = r10.w()
            float r10 = r10.e()
            float r9 = r9 / r10
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r9 = r9 + r2
            int r9 = (int) r9
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r1)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            r0.<init>(r1, r2)
            goto L86
        L85:
            r0 = 0
        L86:
            r2 = r9
            r3 = r10
            r4 = r0
            com.qq.e.comm.plugin.w40<com.qq.e.comm.plugin.v40<V extends android.view.View & com.qq.e.comm.plugin.dl>, V extends android.view.View & com.qq.e.comm.plugin.dl> r9 = r8.a
            com.qq.e.comm.plugin.rk r7 = r9.w()
            r1 = r8
            android.util.Pair r9 = r1.a(r2, r3, r4, r5, r6, r7)
            if (r9 == 0) goto La9
            java.lang.Object r10 = r9.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r0 = r9.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r8.c(r10, r0)
        La9:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.v40.a(int, int):android.util.Pair");
    }

    private boolean c(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.f == size && this.g == size2) {
            return false;
        }
        this.f = size;
        this.g = size2;
        return true;
    }

    public int b() {
        return this.g;
    }

    public void b(boolean z) {
        this.e = z;
    }

    protected void a() {
        zn znVar = (zn) this.a;
        int iO = znVar.O();
        for (int i = 0; i < iO; i++) {
            v40 v40VarV = znVar.m(i).v();
            if (v40VarV != null) {
                v40VarV.a(this.f, this.g, this.h, this.i);
            }
        }
    }

    private static int a(int i, int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        if (i > 0 && size > i) {
            i3 = View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(i3));
        }
        return (i2 <= 0 || size >= i2) ? i3 : View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
    }

    public void b(int[] iArr) {
        this.j = iArr;
    }

    private boolean a(int i, int[] iArr) {
        if (i <= 0 || iArr == null || iArr.length > 2) {
            return false;
        }
        int iB = zu.b(i);
        return iB < iArr[0] || iB > iArr[1];
    }

    public void b(int i) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i;
        this.b.setLayoutParams(layoutParams);
    }

    public void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = i;
        this.b.setLayoutParams(layoutParams);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(int[] iArr) {
        this.k = iArr;
    }

    protected Pair<Integer, Integer> a(int i, int i2, Pair<Integer, Integer> pair, int i3, int i4, rk rkVar) {
        int iP = rkVar.p();
        int iC = rkVar.c();
        int iJ = rkVar.j();
        int iB = rkVar.b();
        if (pair == null && ((iP <= 0 || i4 <= iP) && ((iC <= 0 || i4 >= iC) && ((iJ <= 0 || i3 <= iJ) && (iB <= 0 || i3 >= iB))))) {
            return pair;
        }
        return new Pair<>(Integer.valueOf(b(iP, iC, i4, i)), Integer.valueOf(b(iJ, iB, i3, i2)));
    }

    protected Pair<Integer, Integer> a(rk rkVar, int i, int i2) {
        return new Pair<>(Integer.valueOf(a(rkVar.p(), rkVar.c(), i)), Integer.valueOf(a(rkVar.j(), rkVar.b(), i2)));
    }

    public rk a(View view) {
        return new t8();
    }
}
