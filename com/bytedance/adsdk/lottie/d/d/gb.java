package com.bytedance.adsdk.lottie.d.d;

import android.graphics.BlurMaskFilter;
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
import android.util.LongSparseArray;
import com.baidu.mobads.container.util.bu;
import com.bytedance.adsdk.lottie.d.hc.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb implements mk, u, d.InterfaceC0167d {
    private final boolean b;
    private final com.bytedance.adsdk.lottie.model.layer.b c;
    private com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> cb;
    float d;
    private final com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> e;
    private final Paint gb;
    private final Path h;
    private final String hc;
    private com.bytedance.adsdk.lottie.d.hc.d<Float, Float> jh;
    private final com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> k;
    private final com.bytedance.adsdk.lottie.model.hc.h mk;
    private final com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.c, com.bytedance.adsdk.lottie.model.hc.c> mq;
    private final int rf;
    private com.bytedance.adsdk.lottie.d.hc.b sy;
    private final List<uo> tc;
    private final RectF tt;
    private final com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> uo;
    private com.bytedance.adsdk.lottie.d.hc.w w;
    private final com.bytedance.adsdk.lottie.gb yo;
    private final LongSparseArray<LinearGradient> u = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> an = new LongSparseArray<>();

    public gb(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.u uVar) {
        Path path = new Path();
        this.h = path;
        this.gb = new com.bytedance.adsdk.lottie.d.d(1);
        this.tt = new RectF();
        this.tc = new ArrayList();
        this.d = 0.0f;
        this.c = bVar;
        this.hc = uVar.d();
        this.b = uVar.gb();
        this.yo = gbVar;
        this.mk = uVar.hc();
        path.setFillType(uVar.b());
        this.rf = (int) (anVar.u() / 32.0f);
        com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.c, com.bytedance.adsdk.lottie.model.hc.c> dVarD = uVar.c().d();
        this.mq = dVarD;
        dVarD.d(this);
        bVar.d(dVarD);
        com.bytedance.adsdk.lottie.d.hc.d<Integer, Integer> dVarD2 = uVar.u().d();
        this.uo = dVarD2;
        dVarD2.d(this);
        bVar.d(dVarD2);
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD3 = uVar.an().d();
        this.k = dVarD3;
        dVarD3.d(this);
        bVar.d(dVarD3);
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD4 = uVar.h().d();
        this.e = dVarD4;
        dVarD4.d(this);
        bVar.d(dVarD4);
        if (bVar.mq() != null) {
            com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD5 = bVar.mq().d().d();
            this.jh = dVarD5;
            dVarD5.d(this);
            bVar.d(this.jh);
        }
        if (bVar.uo() != null) {
            this.sy = new com.bytedance.adsdk.lottie.d.hc.b(this, bVar, bVar.uo());
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.yo.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof uo) {
                this.tc.add((uo) bVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(Canvas canvas, Matrix matrix, int i) {
        Shader shaderB;
        if (this.b) {
            return;
        }
        com.bytedance.adsdk.lottie.u.d("GradientFillContent#draw");
        this.h.reset();
        for (int i2 = 0; i2 < this.tc.size(); i2++) {
            this.h.addPath(this.tc.get(i2).c(), matrix);
        }
        this.h.computeBounds(this.tt, false);
        if (this.mk == com.bytedance.adsdk.lottie.model.hc.h.LINEAR) {
            shaderB = hc();
        } else {
            shaderB = b();
        }
        shaderB.setLocalMatrix(matrix);
        this.gb.setShader(shaderB);
        com.bytedance.adsdk.lottie.d.hc.d<ColorFilter, ColorFilter> dVar = this.cb;
        if (dVar != null) {
            this.gb.setColorFilter(dVar.h());
        }
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVar2 = this.jh;
        if (dVar2 != null) {
            float fFloatValue = dVar2.h().floatValue();
            if (fFloatValue == 0.0f) {
                this.gb.setMaskFilter(null);
            } else if (fFloatValue != this.d) {
                this.gb.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.d = fFloatValue;
        }
        com.bytedance.adsdk.lottie.d.hc.b bVar = this.sy;
        if (bVar != null) {
            bVar.d(this.gb);
        }
        this.gb.setAlpha(com.bytedance.adsdk.lottie.u.gb.d((int) ((((i / 255.0f) * this.uo.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.h, this.gb);
        com.bytedance.adsdk.lottie.u.hc("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.d.d.u
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.h.reset();
        for (int i = 0; i < this.tc.size(); i++) {
            this.h.addPath(this.tc.get(i).c(), matrix);
        }
        this.h.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient hc() {
        long jC = c();
        LinearGradient linearGradient = this.u.get(jC);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFH = this.k.h();
        PointF pointFH2 = this.e.h();
        com.bytedance.adsdk.lottie.model.hc.c cVarH = this.mq.h();
        LinearGradient linearGradient2 = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, d(cVarH.hc()), cVarH.d(), Shader.TileMode.CLAMP);
        this.u.put(jC, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient b() {
        long jC = c();
        RadialGradient radialGradient = this.an.get(jC);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFH = this.k.h();
        PointF pointFH2 = this.e.h();
        com.bytedance.adsdk.lottie.model.hc.c cVarH = this.mq.h();
        int[] iArrD = d(cVarH.hc());
        float[] fArrD = cVarH.d();
        float f = pointFH.x;
        float f2 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f, pointFH2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrD, fArrD, Shader.TileMode.CLAMP);
        this.an.put(jC, radialGradient2);
        return radialGradient2;
    }

    private int c() {
        int iRound = Math.round(this.k.gb() * this.rf);
        int iRound2 = Math.round(this.e.gb() * this.rf);
        int iRound3 = Math.round(this.mq.gb() * this.rf);
        int i = iRound != 0 ? iRound * bu.g : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] d(int[] iArr) {
        com.bytedance.adsdk.lottie.d.hc.w wVar = this.w;
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
