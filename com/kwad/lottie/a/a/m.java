package com.kwad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.kwad.lottie.a.b.a;
import com.kwad.lottie.model.content.PolystarShape;
import com.kwad.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m implements j, l, a.InterfaceC0568a {
    private final com.kwad.lottie.f bjz;
    private final com.kwad.lottie.a.b.a<?, PointF> blC;
    private boolean blE;
    private final PolystarShape.Type blS;
    private final com.kwad.lottie.a.b.a<?, Float> blT;
    private final com.kwad.lottie.a.b.a<?, Float> blU;
    private final com.kwad.lottie.a.b.a<?, Float> blV;
    private final com.kwad.lottie.a.b.a<?, Float> blW;
    private final com.kwad.lottie.a.b.a<?, Float> blX;
    private final com.kwad.lottie.a.b.a<?, Float> blY;
    private final Path blk = new Path();
    private r blx;
    private final String name;

    public m(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.bjz = fVar;
        this.name = polystarShape.getName();
        PolystarShape.Type typeRJ = polystarShape.RJ();
        this.blS = typeRJ;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj = polystarShape.RK().Rj();
        this.blT = aVarRj;
        com.kwad.lottie.a.b.a<PointF, PointF> aVarRj2 = polystarShape.Rm().Rj();
        this.blC = aVarRj2;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj3 = polystarShape.Ro().Rj();
        this.blU = aVarRj3;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj4 = polystarShape.RM().Rj();
        this.blW = aVarRj4;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj5 = polystarShape.RO().Rj();
        this.blY = aVarRj5;
        if (typeRJ == PolystarShape.Type.Star) {
            this.blV = polystarShape.RL().Rj();
            this.blX = polystarShape.RN().Rj();
        } else {
            this.blV = null;
            this.blX = null;
        }
        aVar.a(aVarRj);
        aVar.a(aVarRj2);
        aVar.a(aVarRj3);
        aVar.a(aVarRj4);
        aVar.a(aVarRj5);
        if (typeRJ == PolystarShape.Type.Star) {
            aVar.a(this.blV);
            aVar.a(this.blX);
        }
        aVarRj.b(this);
        aVarRj2.b(this);
        aVarRj3.b(this);
        aVarRj4.b(this);
        aVarRj5.b(this);
        if (typeRJ == PolystarShape.Type.Star) {
            this.blV.b(this);
            this.blX.b(this);
        }
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        invalidate();
    }

    private void invalidate() {
        this.blE = false;
        this.bjz.invalidateSelf();
    }

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.QI() == ShapeTrimPath.Type.Simultaneously) {
                    this.blx = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.kwad.lottie.a.a.l
    public final Path getPath() {
        if (this.blE) {
            return this.blk;
        }
        this.blk.reset();
        int i = AnonymousClass1.blZ[this.blS.ordinal()];
        if (i == 1) {
            QG();
        } else if (i == 2) {
            QH();
        }
        this.blk.close();
        com.kwad.lottie.d.f.a(this.blk, this.blx);
        this.blE = true;
        return this.blk;
    }

    /* renamed from: com.kwad.lottie.a.a.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] blZ;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            blZ = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                blZ[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    private void QG() {
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
        float fFloatValue = this.blT.getValue().floatValue();
        double radians = Math.toRadians((this.blU == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f8 = (float) (6.283185307179586d / d4);
        float f9 = f8 / 2.0f;
        float f10 = fFloatValue - ((int) fFloatValue);
        int i2 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f10) * f9;
        }
        float fFloatValue2 = this.blW.getValue().floatValue();
        com.kwad.lottie.a.b.a<?, Float> aVar = this.blV;
        float fFloatValue3 = aVar != null ? aVar.getValue().floatValue() : 0.0f;
        com.kwad.lottie.a.b.a<?, Float> aVar2 = this.blX;
        float fFloatValue4 = aVar2 != null ? aVar2.getValue().floatValue() / 100.0f : 0.0f;
        com.kwad.lottie.a.b.a<?, Float> aVar3 = this.blY;
        float fFloatValue5 = aVar3 != null ? aVar3.getValue().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((fFloatValue2 - fFloatValue3) * f10) + fFloatValue3;
            i = i2;
            double d5 = f;
            d = d4;
            fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.blk.moveTo(fCos, fSin);
            d2 = radians + ((f8 * f10) / 2.0f);
        } else {
            d = d4;
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.blk.moveTo(fCos2, fSin2);
            d2 = radians + f9;
            fCos = fCos2;
            fSin = fSin2;
            f = 0.0f;
        }
        double dCeil = Math.ceil(d) * 2.0d;
        float f11 = fFloatValue3;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < dCeil) {
                float f12 = z ? fFloatValue2 : f11;
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
                    f5 = f12;
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
                    this.blk.lineTo(fCos3, fSin3);
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
                    float f13 = z ? f6 : fFloatValue5;
                    float f14 = z ? fFloatValue5 : f6;
                    float f15 = (z ? f11 : fFloatValue2) * f13 * 0.47829f;
                    float f16 = fCos4 * f15;
                    float f17 = f15 * fSin4;
                    float f18 = (z ? fFloatValue2 : f11) * f14 * 0.47829f;
                    float f19 = fCos5 * f18;
                    float f20 = f18 * fSin5;
                    if (i != 0) {
                        if (i3 == 0) {
                            f16 *= f10;
                            f17 *= f10;
                        } else if (d3 == d9 - 1.0d) {
                            f19 *= f10;
                            f20 *= f10;
                        }
                    }
                    this.blk.cubicTo(fCos - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
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
                PointF value = this.blC.getValue();
                this.blk.offset(value.x, value.y);
                this.blk.close();
                return;
            }
        }
    }

    private void QH() {
        double d;
        double d2;
        double d3;
        int i;
        int iFloor = (int) Math.floor(this.blT.getValue().floatValue());
        double radians = Math.toRadians((this.blU == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.blY.getValue().floatValue() / 100.0f;
        float fFloatValue2 = this.blW.getValue().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.blk.moveTo(fCos, fSin);
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
                this.blk.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i = i2;
                this.blk.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF value = this.blC.getValue();
        this.blk.offset(value.x, value.y);
        this.blk.close();
    }

    @Override // com.kwad.lottie.model.f
    public final void a(com.kwad.lottie.model.e eVar, int i, List<com.kwad.lottie.model.e> list, com.kwad.lottie.model.e eVar2) {
        com.kwad.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.kwad.lottie.model.f
    public final <T> void a(T t, com.kwad.lottie.e.c<T> cVar) {
        com.kwad.lottie.a.b.a<?, Float> aVar;
        com.kwad.lottie.a.b.a<?, Float> aVar2;
        if (t == com.kwad.lottie.i.bkL) {
            this.blT.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkM) {
            this.blU.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkE) {
            this.blC.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkN && (aVar2 = this.blV) != null) {
            aVar2.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkO) {
            this.blW.a(cVar);
            return;
        }
        if (t == com.kwad.lottie.i.bkP && (aVar = this.blX) != null) {
            aVar.a(cVar);
        } else if (t == com.kwad.lottie.i.bkQ) {
            this.blY.a(cVar);
        }
    }
}
