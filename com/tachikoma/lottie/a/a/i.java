package com.tachikoma.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.baidu.mobads.container.util.bu;
import com.tachikoma.lottie.model.content.GradientType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i extends a {
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<com.tachikoma.lottie.model.content.c, com.tachikoma.lottie.model.content.c> IX;
    private final android.support.v4.d.e<LinearGradient> IY;
    private final android.support.v4.d.e<RadialGradient> IZ;
    private final RectF Jb;
    private final GradientType Jc;
    private final com.tachikoma.lottie.a.b.a<PointF, PointF> Jd;
    private final com.tachikoma.lottie.a.b.a<PointF, PointF> Je;
    private com.tachikoma.lottie.a.b.p Jf;
    private final int Jg;
    private final String name;

    public i(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, com.tachikoma.lottie.model.content.e eVar) {
        super(gVar, aVar, eVar.kX().toPaintCap(), eVar.kY().toPaintJoin(), eVar.lb(), eVar.kJ(), eVar.kW(), eVar.kZ(), eVar.la());
        this.IY = new android.support.v4.d.e<>();
        this.IZ = new android.support.v4.d.e<>();
        this.Jb = new RectF();
        this.name = eVar.getName();
        this.Jc = eVar.kS();
        this.IO = eVar.isHidden();
        this.Jg = (int) (gVar.getComposition().jt() / 32.0f);
        this.IX = eVar.kT().kB();
        this.IX.b(this);
        aVar.a(this.IX);
        this.Jd = eVar.kU().kB();
        this.Jd.b(this);
        aVar.a(this.Jd);
        this.Je = eVar.kV().kB();
        this.Je.b(this);
        aVar.a(this.Je);
    }

    @Override // com.tachikoma.lottie.a.a.a, com.tachikoma.lottie.a.a.e
    public final void a(Canvas canvas, Matrix matrix, int i) {
        Shader shaderJS;
        if (this.IO) {
            return;
        }
        a(this.Jb, matrix, false);
        if (this.Jc == GradientType.LINEAR) {
            shaderJS = jR();
        } else {
            shaderJS = jS();
        }
        this.IF.setShader(shaderJS);
        super.a(canvas, matrix, i);
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
        LinearGradient linearGradient2 = new LinearGradient((int) (this.Jb.left + (this.Jb.width() / 2.0f) + value.x), (int) (this.Jb.top + (this.Jb.height() / 2.0f) + value.y), (int) (this.Jb.left + (this.Jb.width() / 2.0f) + value2.x), (int) (this.Jb.top + (this.Jb.height() / 2.0f) + value2.y), h(value3.getColors()), value3.kR(), Shader.TileMode.CLAMP);
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
        RadialGradient radialGradient2 = new RadialGradient((int) (this.Jb.left + (this.Jb.width() / 2.0f) + value.x), (int) (this.Jb.top + (this.Jb.height() / 2.0f) + value.y), (float) Math.hypot(((int) ((this.Jb.left + (this.Jb.width() / 2.0f)) + value2.x)) - r4, ((int) ((this.Jb.top + (this.Jb.height() / 2.0f)) + value2.y)) - r0), iArrH, fArrKR, Shader.TileMode.CLAMP);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tachikoma.lottie.a.a.a, com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        super.a(t, cVar);
        if (t == com.tachikoma.lottie.k.Il) {
            if (cVar == null) {
                if (this.Jf != null) {
                    this.IC.b(this.Jf);
                }
                this.Jf = null;
            } else {
                this.Jf = new com.tachikoma.lottie.a.b.p(cVar);
                this.Jf.b(this);
                this.IC.a(this.Jf);
            }
        }
    }
}
