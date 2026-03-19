package com.bytedance.adsdk.lottie.d.d;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.d.hc.d;
import com.bytedance.adsdk.lottie.model.hc.rf;
import com.bytedance.adsdk.lottie.model.hc.tc;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k implements mk, uo, d.InterfaceC0167d {
    private final boolean an;
    private final com.bytedance.adsdk.lottie.gb b;
    private final tc.d c;
    private boolean e;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, PointF> gb;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> h;
    private final String hc;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> mk;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> mq;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> tc;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> tt;
    private final boolean u;
    private final com.bytedance.adsdk.lottie.d.hc.d<?, Float> uo;
    private final Path d = new Path();
    private final hc k = new hc();

    public k(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.tc tcVar) {
        this.b = gbVar;
        this.hc = tcVar.d();
        tc.d type = tcVar.getType();
        this.c = type;
        this.u = tcVar.tt();
        this.an = tcVar.tc();
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = tcVar.hc().d();
        this.h = dVarD;
        com.bytedance.adsdk.lottie.d.hc.d<PointF, PointF> dVarD2 = tcVar.b().d();
        this.gb = dVarD2;
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD3 = tcVar.c().d();
        this.tt = dVarD3;
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD4 = tcVar.an().d();
        this.mk = dVarD4;
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD5 = tcVar.gb().d();
        this.uo = dVarD5;
        if (type == tc.d.STAR) {
            this.tc = tcVar.u().d();
            this.mq = tcVar.h().d();
        } else {
            this.tc = null;
            this.mq = null;
        }
        bVar.d(dVarD);
        bVar.d(dVarD2);
        bVar.d(dVarD3);
        bVar.d(dVarD4);
        bVar.d(dVarD5);
        if (type == tc.d.STAR) {
            bVar.d(this.tc);
            bVar.d(this.mq);
        }
        dVarD.d(this);
        dVarD2.d(this);
        dVarD3.d(this);
        dVarD4.d(this);
        dVarD5.d(this);
        if (type == tc.d.STAR) {
            this.tc.d(this);
            this.mq.d(this);
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        hc();
    }

    private void hc() {
        this.e = false;
        this.b.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof sy) {
                sy syVar = (sy) bVar;
                if (syVar.getType() == rf.d.SIMULTANEOUSLY) {
                    this.k.d(syVar);
                    syVar.d(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.d.d.uo
    public Path c() {
        if (this.e) {
            return this.d;
        }
        this.d.reset();
        if (this.u) {
            this.e = true;
            return this.d;
        }
        int i = AnonymousClass1.d[this.c.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            u();
        }
        this.d.close();
        this.k.d(this.d);
        this.e = true;
        return this.d;
    }

    /* renamed from: com.bytedance.adsdk.lottie.d.d.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[tc.d.values().length];
            d = iArr;
            try {
                iArr[tc.d.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[tc.d.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void b() {
        double d;
        int i;
        double d2;
        float fCos;
        float fSin;
        float f;
        float f2;
        float f3;
        float f4;
        double d3;
        float f5;
        float f6;
        float f7;
        float fFloatValue = this.h.h().floatValue();
        double radians = Math.toRadians((this.tt == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f8 = (float) (6.283185307179586d / d4);
        if (this.an) {
            f8 *= -1.0f;
        }
        float f9 = f8 / 2.0f;
        float f10 = fFloatValue - ((int) fFloatValue);
        int i2 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f10) * f9;
        }
        float fFloatValue2 = this.mk.h().floatValue();
        float fFloatValue3 = this.tc.h().floatValue();
        com.bytedance.adsdk.lottie.d.hc.d<?, Float> dVar = this.mq;
        float fFloatValue4 = dVar != null ? dVar.h().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.d.hc.d<?, Float> dVar2 = this.uo;
        float fFloatValue5 = dVar2 != null ? dVar2.h().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((fFloatValue2 - fFloatValue3) * f10) + fFloatValue3;
            i = i2;
            double d5 = f;
            d = d4;
            fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.d.moveTo(fCos, fSin);
            d2 = radians + ((f8 * f10) / 2.0f);
        } else {
            d = d4;
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.d.moveTo(fCos2, fSin2);
            d2 = radians + f9;
            fCos = fCos2;
            fSin = fSin2;
            f = 0.0f;
        }
        double dCeil = Math.ceil(d) * 2.0d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < dCeil) {
                float f11 = z ? fFloatValue2 : fFloatValue3;
                if (f == 0.0f || d7 != dCeil - 2.0d) {
                    f2 = f8;
                    f3 = f9;
                } else {
                    f2 = f8;
                    f3 = (f8 * f10) / 2.0f;
                }
                if (f == 0.0f || d7 != dCeil - 1.0d) {
                    f4 = f9;
                    d3 = d7;
                    f5 = f11;
                } else {
                    f4 = f9;
                    d3 = d7;
                    f5 = f;
                }
                double d8 = f5;
                double d9 = dCeil;
                float fCos3 = (float) (d8 * Math.cos(d2));
                float fSin3 = (float) (d8 * Math.sin(d2));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.d.lineTo(fCos3, fSin3);
                    f6 = fFloatValue4;
                    f7 = f;
                } else {
                    f6 = fFloatValue4;
                    f7 = f;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f12 = z ? f6 : fFloatValue5;
                    float f13 = z ? fFloatValue5 : f6;
                    float f14 = (z ? fFloatValue3 : fFloatValue2) * f12 * 0.47829f;
                    float f15 = fCos4 * f14;
                    float f16 = f14 * fSin4;
                    float f17 = (z ? fFloatValue2 : fFloatValue3) * f13 * 0.47829f;
                    float f18 = fCos5 * f17;
                    float f19 = f17 * fSin5;
                    if (i != 0) {
                        if (i3 == 0) {
                            f15 *= f10;
                            f16 *= f10;
                        } else if (d3 == d9 - 1.0d) {
                            f18 *= f10;
                            f19 *= f10;
                        }
                    }
                    this.d.cubicTo(fCos - f15, fSin - f16, fCos3 + f18, fSin3 + f19, fCos3, fSin3);
                }
                d2 += f3;
                z = !z;
                i3++;
                fCos = fCos3;
                fSin = fSin3;
                fFloatValue4 = f6;
                f = f7;
                f9 = f4;
                f8 = f2;
                dCeil = d9;
            } else {
                PointF pointFH = this.gb.h();
                this.d.offset(pointFH.x, pointFH.y);
                this.d.close();
                return;
            }
        }
    }

    private void u() {
        double d;
        double d2;
        double d3;
        int i;
        int iFloor = (int) Math.floor(this.h.h().floatValue());
        double radians = Math.toRadians((this.tt == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.uo.h().floatValue() / 100.0f;
        float fFloatValue2 = this.mk.h().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.d.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.d.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i = i2;
                this.d.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFH = this.gb.h();
        this.d.offset(pointFH.x, pointFH.y);
        this.d.close();
    }
}
