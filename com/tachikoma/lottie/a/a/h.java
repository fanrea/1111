package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.baidu.mobads.container.util.bu;
import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h implements e, k, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final com.tachikoma.lottie.model.layer.a IC;
    private final com.tachikoma.lottie.a.b.a<Integer, Integer> IH;
    private com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> IK;
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<com.tachikoma.lottie.model.content.c, com.tachikoma.lottie.model.content.c> IX;
    private final GradientType Jc;
    private final com.tachikoma.lottie.a.b.a<PointF, PointF> Jd;
    private final com.tachikoma.lottie.a.b.a<PointF, PointF> Je;
    private com.tachikoma.lottie.a.b.p Jf;
    private final int Jg;
    private final String name;
    private final android.support.v4.d.e<LinearGradient> IY = new android.support.v4.d.e<>();
    private final android.support.v4.d.e<RadialGradient> IZ = new android.support.v4.d.e<>();
    private final Matrix Ja = new Matrix();
    private final Path Iz = new Path();
    private final Paint IF = new com.tachikoma.lottie.a.a(1);
    private final RectF Jb = new RectF();
    private final List<m> IL = new ArrayList();

    public h(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.d dVar) {
        this.IC = aVar;
        this.name = dVar.getName();
        this.IO = dVar.isHidden();
        this.Gt = gVar;
        this.Jc = dVar.kS();
        this.Iz.setFillType(dVar.getFillType());
        this.Jg = (int) (gVar.getComposition().jt() / 32.0f);
        this.IX = dVar.kT().kB();
        this.IX.b(this);
        aVar.a(this.IX);
        this.IH = dVar.kJ().kB();
        this.IH.b(this);
        aVar.a(this.IH);
        this.Jd = dVar.kU().kB();
        this.Jd.b(this);
        aVar.a(this.Jd);
        this.Je = dVar.kV().kB();
        this.Je.b(this);
        aVar.a(this.Je);
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.IL.add((m) cVar);
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        Shader shaderJS;
        if (this.IO) {
            return;
        }
        com.tachikoma.lottie.c.beginSection("GradientFillContent#draw");
        this.Iz.reset();
        for (int i2 = 0; i2 < this.IL.size(); i2++) {
            this.Iz.addPath(this.IL.get(i2).getPath(), matrix);
        }
        this.Iz.computeBounds(this.Jb, false);
        if (this.Jc == GradientType.LINEAR) {
            shaderJS = jR();
        } else {
            shaderJS = jS();
        }
        this.Ja.set(matrix);
        shaderJS.setLocalMatrix(this.Ja);
        this.IF.setShader(shaderJS);
        com.tachikoma.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.IK;
        if (aVar != null) {
            this.IF.setColorFilter(aVar.getValue());
        }
        this.IF.setAlpha(com.tachikoma.lottie.d.e.c((int) ((((i / 255.0f) * this.IH.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.Iz, this.IF);
        com.tachikoma.lottie.c.S("GradientFillContent#draw");
    }

    @Override // com.tachikoma.lottie.a.a.e
    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.Iz.reset();
        for (int i = 0; i < this.IL.size(); i++) {
            this.Iz.addPath(this.IL.get(i).getPath(), matrix);
        }
        this.Iz.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    private LinearGradient jR() {
        long jJT = jT();
        LinearGradient linearGradient = this.IY.get(jJT);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.Jd.getValue();
        PointF value2 = this.Je.getValue();
        com.tachikoma.lottie.model.content.c value3 = this.IX.getValue();
        LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, h(value3.getColors()), value3.kR(), Shader.TileMode.CLAMP);
        this.IY.put(jJT, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient jS() {
        long jJT = jT();
        RadialGradient radialGradient = this.IZ.get(jJT);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.Jd.getValue();
        PointF value2 = this.Je.getValue();
        com.tachikoma.lottie.model.content.c value3 = this.IX.getValue();
        int[] iArrH = h(value3.getColors());
        float[] fArrKR = value3.kR();
        float f = value.x;
        float f2 = value.y;
        float fHypot = (float) Math.hypot(value2.x - f, value2.y - f2);
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrH, fArrKR, Shader.TileMode.CLAMP);
        this.IZ.put(jJT, radialGradient2);
        return radialGradient2;
    }

    private int jT() {
        int iRound = Math.round(this.Jd.getProgress() * this.Jg);
        int iRound2 = Math.round(this.Je.getProgress() * this.Jg);
        int iRound3 = Math.round(this.IX.getProgress() * this.Jg);
        int i = iRound != 0 ? iRound * bu.g : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] h(int[] iArr) {
        com.tachikoma.lottie.a.b.p pVar = this.Jf;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.getValue();
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

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        com.tachikoma.lottie.d.e.a(dVar, i, list, dVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        if (t == com.tachikoma.lottie.k.HM) {
            this.IH.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.Ik) {
            if (cVar == null) {
                this.IK = null;
                return;
            }
            this.IK = new com.tachikoma.lottie.a.b.p(cVar);
            this.IK.b(this);
            this.IC.a(this.IK);
            return;
        }
        if (t == com.tachikoma.lottie.k.Il) {
            if (cVar == null) {
                com.tachikoma.lottie.a.b.p pVar = this.Jf;
                if (pVar != null) {
                    this.IC.b(pVar);
                }
                this.Jf = null;
                return;
            }
            this.Jf = new com.tachikoma.lottie.a.b.p(cVar);
            this.Jf.b(this);
            this.IC.a(this.Jf);
        }
    }
}
