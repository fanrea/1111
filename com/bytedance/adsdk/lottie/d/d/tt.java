package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.baidu.mobads.container.util.bu;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends d {
    private final LongSparseArray<LinearGradient> an;
    private final String c;
    private final RectF gb;
    private final LongSparseArray<RadialGradient> h;
    private com.bytedance.adsdk.lottie.d.hc.w k;
    private final com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.c, com.bytedance.adsdk.lottie.model.hc.c> mk;
    private final com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> mq;
    private final int tc;
    private final com.bytedance.adsdk.lottie.model.hc.h tt;
    private final boolean u;
    private final com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> uo;

    public tt(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.an anVar) {
        super(gbVar, bVar, anVar.gb().d(), anVar.tt().d(), anVar.mq(), anVar.c(), anVar.h(), anVar.tc(), anVar.mk());
        this.an = new LongSparseArray<>();
        this.h = new LongSparseArray<>();
        this.gb = new RectF();
        this.c = anVar.d();
        this.tt = anVar.hc();
        this.u = anVar.uo();
        this.tc = (int) (gbVar.vv().u() / 32.0f);
        com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.c, com.bytedance.adsdk.lottie.model.hc.c> dVarD = anVar.b().d();
        this.mk = dVarD;
        dVarD.d(this);
        bVar.d(dVarD);
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD2 = anVar.u().d();
        this.mq = dVarD2;
        dVarD2.d(this);
        bVar.d(dVarD2);
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD3 = anVar.an().d();
        this.uo = dVarD3;
        dVarD3.d(this);
        bVar.d(dVarD3);
    }

    @Override // com.bytedance.adsdk.lottie.d.d.d, com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        Shader shaderB;
        if (this.u) {
            return;
        }
        d(this.gb, matrix, false);
        if (this.tt == com.bytedance.adsdk.lottie.model.hc.h.LINEAR) {
            shaderB = hc();
        } else {
            shaderB = b();
        }
        shaderB.setLocalMatrix(matrix);
        this.hc.setShader(shaderB);
        super.d(canvas, matrix, i);
    }

    private LinearGradient hc() {
        long jC = c();
        LinearGradient linearGradient = this.an.get(jC);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.mq.h();
        PointF pointFH2 = this.uo.h();
        com.bytedance.adsdk.lottie.model.hc.c cVarH = this.mk.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, d(cVarH.hc()), cVarH.d(), Shader.TileMode.CLAMP);
        this.an.put(jC, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient b() {
        long jC = c();
        RadialGradient radialGradient = this.h.get(jC);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.mq.h();
        PointF pointFH2 = this.uo.h();
        com.bytedance.adsdk.lottie.model.hc.c cVarH = this.mk.h();
        int[] iArrD = d(cVarH.hc());
        float[] fArrD = cVarH.d();
        RadialGradient radialGradient2 = new RadialGradient(pointFH.x, pointFH.y, (float) Math.hypot(pointFH2.x - r7, pointFH2.y - r8), iArrD, fArrD, Shader.TileMode.CLAMP);
        this.h.put(jC, radialGradient2);
        return radialGradient2;
    }

    private int c() {
        int iRound = Math.round(this.mq.gb() * this.tc);
        int iRound2 = Math.round(this.uo.gb() * this.tc);
        int iRound3 = Math.round(this.mk.gb() * this.tc);
        int i = iRound != 0 ? iRound * bu.g : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] d(int[] iArr) {
        com.bytedance.adsdk.lottie.d.hc.w wVar = this.k;
        if (wVar != null) {
            Integer[] numArr = (Integer[]) wVar.h();
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
}
