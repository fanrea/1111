package com.tachikoma.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.model.content.PolystarShape;
import com.tachikoma.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class n implements k, m, a.InterfaceC0799a {
    private final com.tachikoma.lottie.g Gt;
    private final boolean IO;
    private final com.tachikoma.lottie.a.b.a<?, PointF> IT;
    private boolean IW;
    private final PolystarShape.Type Jl;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jm;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jn;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jo;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jp;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jq;
    private final com.tachikoma.lottie.a.b.a<?, Float> Jr;
    private final String name;
    private final Path Iz = new Path();
    private b IV = new b();

    public n(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.Gt = gVar;
        this.name = polystarShape.getName();
        this.Jl = polystarShape.lg();
        this.IO = polystarShape.isHidden();
        this.Jm = polystarShape.lh().kB();
        this.IT = polystarShape.kG().kB();
        this.Jn = polystarShape.kI().kB();
        this.Jp = polystarShape.lj().kB();
        this.Jr = polystarShape.ll().kB();
        if (this.Jl == PolystarShape.Type.STAR) {
            this.Jo = polystarShape.li().kB();
            this.Jq = polystarShape.lk().kB();
        } else {
            this.Jo = null;
            this.Jq = null;
        }
        aVar.a(this.Jm);
        aVar.a(this.IT);
        aVar.a(this.Jn);
        aVar.a(this.Jp);
        aVar.a(this.Jr);
        if (this.Jl == PolystarShape.Type.STAR) {
            aVar.a(this.Jo);
            aVar.a(this.Jq);
        }
        this.Jm.b(this);
        this.IT.b(this);
        this.Jn.b(this);
        this.Jp.b(this);
        this.Jr.b(this);
        if (this.Jl == PolystarShape.Type.STAR) {
            this.Jo.b(this);
            this.Jq.b(this);
        }
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        invalidate();
    }

    private void invalidate() {
        this.IW = false;
        this.Gt.invalidateSelf();
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.jX() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.IV.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.m
    public final Path getPath() {
        if (this.IW) {
            return this.Iz;
        }
        this.Iz.reset();
        if (this.IO) {
            this.IW = true;
            return this.Iz;
        }
        int i = AnonymousClass1.Js[this.Jl.ordinal()];
        if (i == 1) {
            jV();
        } else if (i == 2) {
            jW();
        }
        this.Iz.close();
        this.IV.a(this.Iz);
        this.IW = true;
        return this.Iz;
    }

    /* renamed from: com.tachikoma.lottie.a.a.n$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Js = new int[PolystarShape.Type.values().length];

        static {
            try {
                Js[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Js[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    private void jV() {
        double d;
        float f;
        float f2;
        float f3;
        float f4;
        double d2;
        float f5;
        float f6;
        float f7;
        boolean z;
        float f8;
        float f9;
        float f10;
        float f11;
        float fFloatValue = this.Jm.getValue().floatValue();
        double radians = Math.toRadians((this.Jn == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d3 = fFloatValue;
        Double.isNaN(d3);
        float f12 = (float) (6.283185307179586d / d3);
        float f13 = f12 / 2.0f;
        float f14 = fFloatValue - ((int) fFloatValue);
        if (f14 != 0.0f) {
            double d4 = (1.0f - f14) * f13;
            Double.isNaN(d4);
            radians += d4;
        }
        float fFloatValue2 = this.Jp.getValue().floatValue();
        float fFloatValue3 = this.Jo.getValue().floatValue();
        com.tachikoma.lottie.a.b.a<?, Float> aVar = this.Jq;
        float fFloatValue4 = aVar != null ? aVar.getValue().floatValue() / 100.0f : 0.0f;
        com.tachikoma.lottie.a.b.a<?, Float> aVar2 = this.Jr;
        float fFloatValue5 = aVar2 != null ? aVar2.getValue().floatValue() / 100.0f : 0.0f;
        if (f14 != 0.0f) {
            float f15 = ((fFloatValue2 - fFloatValue3) * f14) + fFloatValue3;
            double d5 = f15;
            double dCos = Math.cos(radians);
            Double.isNaN(d5);
            d = d3;
            float f16 = (float) (d5 * dCos);
            double dSin = Math.sin(radians);
            Double.isNaN(d5);
            float f17 = (float) (d5 * dSin);
            this.Iz.moveTo(f16, f17);
            double d6 = (f12 * f14) / 2.0f;
            Double.isNaN(d6);
            d2 = radians + d6;
            f3 = f16;
            f5 = f15;
            f = fFloatValue2;
            f4 = f17;
            f2 = f13;
        } else {
            d = d3;
            f = fFloatValue2;
            double d7 = f;
            double dCos2 = Math.cos(radians);
            Double.isNaN(d7);
            f2 = f13;
            f3 = (float) (d7 * dCos2);
            double dSin2 = Math.sin(radians);
            Double.isNaN(d7);
            f4 = (float) (d7 * dSin2);
            this.Iz.moveTo(f3, f4);
            double d8 = f2;
            Double.isNaN(d8);
            d2 = radians + d8;
            f5 = 0.0f;
        }
        double dCeil = Math.ceil(d) * 2.0d;
        int i = 0;
        double d9 = d2;
        float f18 = f4;
        float f19 = f3;
        boolean z2 = false;
        while (true) {
            double d10 = i;
            if (d10 < dCeil) {
                float f20 = z2 ? f : fFloatValue3;
                if (f5 == 0.0f || d10 != dCeil - 2.0d) {
                    f6 = f12;
                    f7 = f2;
                } else {
                    f6 = f12;
                    f7 = (f12 * f14) / 2.0f;
                }
                if (f5 != 0.0f && d10 == dCeil - 1.0d) {
                    f20 = f5;
                }
                float f21 = f;
                float f22 = f2;
                double d11 = f20;
                double dCos3 = Math.cos(d9);
                Double.isNaN(d11);
                float f23 = fFloatValue3;
                float f24 = (float) (d11 * dCos3);
                double dSin3 = Math.sin(d9);
                Double.isNaN(d11);
                float f25 = (float) (d11 * dSin3);
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.Iz.lineTo(f24, f25);
                    f11 = f7;
                    f10 = f25;
                    z = z2;
                    f8 = fFloatValue4;
                    f9 = fFloatValue5;
                } else {
                    z = z2;
                    f8 = fFloatValue4;
                    f9 = fFloatValue5;
                    double dAtan2 = (float) (Math.atan2(f18, f19) - 1.5707963267948966d);
                    float fCos = (float) Math.cos(dAtan2);
                    float fSin = (float) Math.sin(dAtan2);
                    float f26 = f19;
                    float f27 = f7;
                    f10 = f25;
                    double dAtan22 = (float) (Math.atan2(f25, f24) - 1.5707963267948966d);
                    float fCos2 = (float) Math.cos(dAtan22);
                    float fSin2 = (float) Math.sin(dAtan22);
                    float f28 = z ? f8 : f9;
                    float f29 = z ? f9 : f8;
                    float f30 = (z ? f23 : f21) * f28 * 0.47829f;
                    float f31 = fCos * f30;
                    float f32 = f30 * fSin;
                    float f33 = (z ? f21 : f23) * f29 * 0.47829f;
                    float f34 = fCos2 * f33;
                    float f35 = f33 * fSin2;
                    if (f14 != 0.0f) {
                        if (i == 0) {
                            f31 *= f14;
                            f32 *= f14;
                        } else if (d10 == dCeil - 1.0d) {
                            f34 *= f14;
                            f35 *= f14;
                        }
                    }
                    this.Iz.cubicTo(f26 - f31, f18 - f32, f24 + f34, f10 + f35, f24, f10);
                    f11 = f27;
                }
                double d12 = f11;
                Double.isNaN(d12);
                d9 += d12;
                z2 = !z;
                i++;
                f19 = f24;
                f12 = f6;
                f = f21;
                f2 = f22;
                fFloatValue4 = f8;
                fFloatValue5 = f9;
                fFloatValue3 = f23;
                f18 = f10;
            } else {
                PointF value = this.IT.getValue();
                this.Iz.offset(value.x, value.y);
                this.Iz.close();
                return;
            }
        }
    }

    private void jW() {
        double d;
        double d2;
        double d3;
        int i;
        int iFloor = (int) Math.floor(this.Jm.getValue().floatValue());
        double radians = Math.toRadians((this.Jn == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = iFloor;
        Double.isNaN(d4);
        float fFloatValue = this.Jr.getValue().floatValue() / 100.0f;
        float fFloatValue2 = this.Jp.getValue().floatValue();
        double d5 = fFloatValue2;
        double dCos = Math.cos(radians);
        Double.isNaN(d5);
        float f = (float) (dCos * d5);
        double dSin = Math.sin(radians);
        Double.isNaN(d5);
        float f2 = (float) (dSin * d5);
        this.Iz.moveTo(f, f2);
        double d6 = (float) (6.283185307179586d / d4);
        Double.isNaN(d6);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            double dCos2 = Math.cos(d7);
            Double.isNaN(d5);
            float f3 = (float) (dCos2 * d5);
            double dSin2 = Math.sin(d7);
            Double.isNaN(d5);
            double d8 = dCeil;
            float f4 = (float) (d5 * dSin2);
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(f2, f) - 1.5707963267948966d);
                float fCos = (float) Math.cos(dAtan2);
                float fSin = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(f4, f3) - 1.5707963267948966d);
                float f5 = fFloatValue2 * fFloatValue * 0.25f;
                this.Iz.cubicTo(f - (fCos * f5), f2 - (fSin * f5), f3 + (((float) Math.cos(dAtan22)) * f5), f4 + (f5 * ((float) Math.sin(dAtan22))), f3, f4);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i = i2;
                this.Iz.lineTo(f3, f4);
            }
            Double.isNaN(d3);
            d7 = d + d3;
            i2 = i + 1;
            f2 = f4;
            f = f3;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF value = this.IT.getValue();
        this.Iz.offset(value.x, value.y);
        this.Iz.close();
    }

    @Override // com.tachikoma.lottie.model.e
    public final void a(com.tachikoma.lottie.model.d dVar, int i, List<com.tachikoma.lottie.model.d> list, com.tachikoma.lottie.model.d dVar2) {
        com.tachikoma.lottie.d.e.a(dVar, i, list, dVar2, this);
    }

    @Override // com.tachikoma.lottie.model.e
    public final <T> void a(T t, com.tachikoma.lottie.e.c<T> cVar) {
        com.tachikoma.lottie.a.b.a<?, Float> aVar;
        com.tachikoma.lottie.a.b.a<?, Float> aVar2;
        if (t == com.tachikoma.lottie.k.Ib) {
            this.Jm.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.Ic) {
            this.Jn.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.HS) {
            this.IT.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.Id && (aVar2 = this.Jo) != null) {
            aVar2.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.Ie) {
            this.Jp.a(cVar);
            return;
        }
        if (t == com.tachikoma.lottie.k.If && (aVar = this.Jq) != null) {
            aVar.a(cVar);
        } else if (t == com.tachikoma.lottie.k.Ig) {
            this.Jr.a(cVar);
        }
    }
}
