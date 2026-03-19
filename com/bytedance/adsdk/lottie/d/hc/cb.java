package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.d.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb {
    private d<PointF, PointF> an;
    private final Matrix b;
    private final Matrix c;
    private final Matrix d = new Matrix();
    private d<com.bytedance.adsdk.lottie.an.c, com.bytedance.adsdk.lottie.an.c> gb;
    private d<?, PointF> h;
    private final Matrix hc;
    private d<?, Float> k;
    private c mk;
    private c mq;
    private d<Integer, Integer> tc;
    private d<Float, Float> tt;
    private final float[] u;
    private d<?, Float> uo;

    public cb(com.bytedance.adsdk.lottie.model.d.mq mqVar) {
        this.an = mqVar.d() == null ? null : mqVar.d().d();
        this.h = mqVar.hc() == null ? null : mqVar.hc().d();
        this.gb = mqVar.b() == null ? null : mqVar.b().d();
        this.tt = mqVar.c() == null ? null : mqVar.c().d();
        c cVar = mqVar.gb() == null ? null : (c) mqVar.gb().d();
        this.mk = cVar;
        if (cVar != null) {
            this.hc = new Matrix();
            this.b = new Matrix();
            this.c = new Matrix();
            this.u = new float[9];
        } else {
            this.hc = null;
            this.b = null;
            this.c = null;
            this.u = null;
        }
        this.mq = mqVar.tt() == null ? null : (c) mqVar.tt().d();
        if (mqVar.u() != null) {
            this.tc = mqVar.u().d();
        }
        if (mqVar.an() != null) {
            this.uo = mqVar.an().d();
        } else {
            this.uo = null;
        }
        if (mqVar.h() != null) {
            this.k = mqVar.h().d();
        } else {
            this.k = null;
        }
    }

    public void d(com.bytedance.adsdk.lottie.model.layer.b bVar) {
        bVar.d(this.tc);
        bVar.d(this.uo);
        bVar.d(this.k);
        bVar.d(this.an);
        bVar.d(this.h);
        bVar.d(this.gb);
        bVar.d(this.tt);
        bVar.d(this.mk);
        bVar.d(this.mq);
    }

    public void d(d.InterfaceC0167d interfaceC0167d) {
        d<Integer, Integer> dVar = this.tc;
        if (dVar != null) {
            dVar.d(interfaceC0167d);
        }
        d<?, Float> dVar2 = this.uo;
        if (dVar2 != null) {
            dVar2.d(interfaceC0167d);
        }
        d<?, Float> dVar3 = this.k;
        if (dVar3 != null) {
            dVar3.d(interfaceC0167d);
        }
        d<PointF, PointF> dVar4 = this.an;
        if (dVar4 != null) {
            dVar4.d(interfaceC0167d);
        }
        d<?, PointF> dVar5 = this.h;
        if (dVar5 != null) {
            dVar5.d(interfaceC0167d);
        }
        d<com.bytedance.adsdk.lottie.an.c, com.bytedance.adsdk.lottie.an.c> dVar6 = this.gb;
        if (dVar6 != null) {
            dVar6.d(interfaceC0167d);
        }
        d<Float, Float> dVar7 = this.tt;
        if (dVar7 != null) {
            dVar7.d(interfaceC0167d);
        }
        c cVar = this.mk;
        if (cVar != null) {
            cVar.d(interfaceC0167d);
        }
        c cVar2 = this.mq;
        if (cVar2 != null) {
            cVar2.d(interfaceC0167d);
        }
    }

    public void d(float f) {
        d<Integer, Integer> dVar = this.tc;
        if (dVar != null) {
            dVar.d(f);
        }
        d<?, Float> dVar2 = this.uo;
        if (dVar2 != null) {
            dVar2.d(f);
        }
        d<?, Float> dVar3 = this.k;
        if (dVar3 != null) {
            dVar3.d(f);
        }
        d<PointF, PointF> dVar4 = this.an;
        if (dVar4 != null) {
            dVar4.d(f);
        }
        d<?, PointF> dVar5 = this.h;
        if (dVar5 != null) {
            dVar5.d(f);
        }
        d<com.bytedance.adsdk.lottie.an.c, com.bytedance.adsdk.lottie.an.c> dVar6 = this.gb;
        if (dVar6 != null) {
            dVar6.d(f);
        }
        d<Float, Float> dVar7 = this.tt;
        if (dVar7 != null) {
            dVar7.d(f);
        }
        c cVar = this.mk;
        if (cVar != null) {
            cVar.d(f);
        }
        c cVar2 = this.mq;
        if (cVar2 != null) {
            cVar2.d(f);
        }
    }

    public d<?, Integer> d() {
        return this.tc;
    }

    public d<?, Float> hc() {
        return this.uo;
    }

    public d<?, Float> b() {
        return this.k;
    }

    public Matrix c() {
        PointF pointFH;
        float fTt;
        PointF pointFH2;
        this.d.reset();
        d<?, PointF> dVar = this.h;
        if (dVar != null && (pointFH2 = dVar.h()) != null && (pointFH2.x != 0.0f || pointFH2.y != 0.0f)) {
            this.d.preTranslate(pointFH2.x, pointFH2.y);
        }
        d<Float, Float> dVar2 = this.tt;
        if (dVar2 != null) {
            if (dVar2 instanceof w) {
                fTt = dVar2.h().floatValue();
            } else {
                fTt = ((c) dVar2).tt();
            }
            if (fTt != 0.0f) {
                this.d.preRotate(fTt);
            }
        }
        if (this.mk != null) {
            float fCos = this.mq == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.tt()) + 90.0f));
            float fSin = this.mq == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.tt()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.tt()));
            u();
            float[] fArr = this.u;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.hc.setValues(fArr);
            u();
            float[] fArr2 = this.u;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.b.setValues(fArr2);
            u();
            float[] fArr3 = this.u;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.c.setValues(fArr3);
            this.b.preConcat(this.hc);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
        }
        d<com.bytedance.adsdk.lottie.an.c, com.bytedance.adsdk.lottie.an.c> dVar3 = this.gb;
        if (dVar3 != null) {
            com.bytedance.adsdk.lottie.an.c cVarH = dVar3.h();
            if (cVarH.d() != 1.0f || cVarH.hc() != 1.0f) {
                this.d.preScale(cVarH.d(), cVarH.hc());
            }
        }
        d<PointF, PointF> dVar4 = this.an;
        if (dVar4 != null && (((pointFH = dVar4.h()) != null && pointFH.x != 0.0f) || pointFH.y != 0.0f)) {
            this.d.preTranslate(-pointFH.x, -pointFH.y);
        }
        return this.d;
    }

    private void u() {
        for (int i = 0; i < 9; i++) {
            this.u[i] = 0.0f;
        }
    }

    public Matrix hc(float f) {
        d<?, PointF> dVar = this.h;
        PointF pointFH = dVar == null ? null : dVar.h();
        d<com.bytedance.adsdk.lottie.an.c, com.bytedance.adsdk.lottie.an.c> dVar2 = this.gb;
        com.bytedance.adsdk.lottie.an.c cVarH = dVar2 == null ? null : dVar2.h();
        this.d.reset();
        if (pointFH != null) {
            this.d.preTranslate(pointFH.x * f, pointFH.y * f);
        }
        if (cVarH != null) {
            double d = f;
            this.d.preScale((float) Math.pow(cVarH.d(), d), (float) Math.pow(cVarH.hc(), d));
        }
        d<Float, Float> dVar3 = this.tt;
        if (dVar3 != null) {
            float fFloatValue = dVar3.h().floatValue();
            d<PointF, PointF> dVar4 = this.an;
            PointF pointFH2 = dVar4 != null ? dVar4.h() : null;
            this.d.preRotate(fFloatValue * f, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.d;
    }
}
