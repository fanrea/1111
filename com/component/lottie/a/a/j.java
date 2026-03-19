package com.component.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.baidu.mobads.container.util.bu;
import com.component.lottie.af;
import com.component.lottie.ba;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends a {
    private static final int d = 32;
    private final String e;
    private final boolean f;
    private final com.component.lottie.b.b<LinearGradient> g;
    private final com.component.lottie.b.b<RadialGradient> h;
    private final RectF i;
    private final com.component.lottie.d.b.g j;
    private final int k;
    private final com.component.lottie.a.b.a<com.component.lottie.d.b.d, com.component.lottie.d.b.d> l;
    private final com.component.lottie.a.b.a<PointF, PointF> m;
    private final com.component.lottie.a.b.a<PointF, PointF> n;
    private com.component.lottie.a.b.t o;

    public j(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.f fVar) {
        super(afVar, aVar, fVar.h().b(), fVar.i().b(), fVar.l(), fVar.d(), fVar.g(), fVar.j(), fVar.k());
        this.g = new com.component.lottie.b.b<>();
        this.h = new com.component.lottie.b.b<>();
        this.i = new RectF();
        this.e = fVar.a();
        this.j = fVar.b();
        this.f = fVar.m();
        this.k = (int) (afVar.C().f() / 32.0f);
        this.l = fVar.c().a();
        this.l.a(this);
        aVar.a(this.l);
        this.m = fVar.e().a();
        this.m.a(this);
        aVar.a(this.m);
        this.n = fVar.f().a();
        this.n.a(this);
        aVar.a(this.n);
    }

    @Override // com.component.lottie.a.a.a, com.component.lottie.a.a.f
    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader shaderD;
        if (this.f) {
            return;
        }
        a(this.i, matrix, false);
        if (this.j == com.component.lottie.d.b.g.LINEAR) {
            shaderD = c();
        } else {
            shaderD = d();
        }
        shaderD.setLocalMatrix(matrix);
        this.b.setShader(shaderD);
        super.a(canvas, matrix, i);
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.e;
    }

    private LinearGradient c() {
        long jE = e();
        LinearGradient linearGradientA = this.g.a(jE);
        if (linearGradientA != null) {
            return linearGradientA;
        }
        PointF pointFG = this.m.g();
        PointF pointFG2 = this.n.g();
        com.component.lottie.d.b.d dVarG = this.l.g();
        LinearGradient linearGradient = new LinearGradient(pointFG.x, pointFG.y, pointFG2.x, pointFG2.y, a(dVarG.b()), dVarG.a(), Shader.TileMode.CLAMP);
        this.g.d(jE, linearGradient);
        return linearGradient;
    }

    private RadialGradient d() {
        long jE = e();
        RadialGradient radialGradientA = this.h.a(jE);
        if (radialGradientA != null) {
            return radialGradientA;
        }
        PointF pointFG = this.m.g();
        PointF pointFG2 = this.n.g();
        com.component.lottie.d.b.d dVarG = this.l.g();
        int[] iArrA = a(dVarG.b());
        float[] fArrA = dVarG.a();
        RadialGradient radialGradient = new RadialGradient(pointFG.x, pointFG.y, (float) Math.hypot(pointFG2.x - r7, pointFG2.y - r8), iArrA, fArrA, Shader.TileMode.CLAMP);
        this.h.d(jE, radialGradient);
        return radialGradient;
    }

    private int e() {
        int i;
        int iRound = Math.round(this.m.h() * this.k);
        int iRound2 = Math.round(this.n.h() * this.k);
        int iRound3 = Math.round(this.l.h() * this.k);
        if (iRound == 0) {
            i = 17;
        } else {
            i = bu.g * iRound;
        }
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        if (iRound3 != 0) {
            return i * 31 * iRound3;
        }
        return i;
    }

    private int[] a(int[] iArr) {
        if (this.o != null) {
            Integer[] numArr = (Integer[]) this.o.g();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.component.lottie.a.a.a, com.component.lottie.d.f
    public <T> void a(T t, com.component.lottie.h.j<T> jVar) {
        super.a((j) t, (com.component.lottie.h.j<j>) jVar);
        if (t == ba.L) {
            if (this.o != null) {
                this.a.b(this.o);
            }
            if (jVar == null) {
                this.o = null;
                return;
            }
            this.o = new com.component.lottie.a.b.t(jVar);
            this.o.a(this);
            this.a.a(this.o);
        }
    }
}
