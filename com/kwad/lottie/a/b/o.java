package com.kwad.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.kwad.lottie.a.b.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o {
    private final Matrix bka = new Matrix();
    private final a<PointF, PointF> bmB;
    private final a<?, PointF> bmC;
    private final a<com.kwad.lottie.e.d, com.kwad.lottie.e.d> bmD;
    private final a<Float, Float> bmE;
    private final a<Integer, Integer> bmF;
    private final a<?, Float> bmG;
    private final a<?, Float> bmH;

    public o(com.kwad.lottie.model.a.l lVar) {
        this.bmB = lVar.Rl().Rj();
        this.bmC = lVar.Rm().Rj();
        this.bmD = lVar.Rn().Rj();
        this.bmE = lVar.Ro().Rj();
        this.bmF = lVar.Rp().Rj();
        if (lVar.Rq() != null) {
            this.bmG = lVar.Rq().Rj();
        } else {
            this.bmG = null;
        }
        if (lVar.Rr() != null) {
            this.bmH = lVar.Rr().Rj();
        } else {
            this.bmH = null;
        }
    }

    public final void a(com.kwad.lottie.model.layer.a aVar) {
        aVar.a(this.bmB);
        aVar.a(this.bmC);
        aVar.a(this.bmD);
        aVar.a(this.bmE);
        aVar.a(this.bmF);
        a<?, Float> aVar2 = this.bmG;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        a<?, Float> aVar3 = this.bmH;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
    }

    public final void a(a.InterfaceC0568a interfaceC0568a) {
        this.bmB.b(interfaceC0568a);
        this.bmC.b(interfaceC0568a);
        this.bmD.b(interfaceC0568a);
        this.bmE.b(interfaceC0568a);
        this.bmF.b(interfaceC0568a);
        a<?, Float> aVar = this.bmG;
        if (aVar != null) {
            aVar.b(interfaceC0568a);
        }
        a<?, Float> aVar2 = this.bmH;
        if (aVar2 != null) {
            aVar2.b(interfaceC0568a);
        }
    }

    public final void setProgress(float f) {
        this.bmB.setProgress(f);
        this.bmC.setProgress(f);
        this.bmD.setProgress(f);
        this.bmE.setProgress(f);
        this.bmF.setProgress(f);
        a<?, Float> aVar = this.bmG;
        if (aVar != null) {
            aVar.setProgress(f);
        }
        a<?, Float> aVar2 = this.bmH;
        if (aVar2 != null) {
            aVar2.setProgress(f);
        }
    }

    public final a<?, Integer> QX() {
        return this.bmF;
    }

    public final a<?, Float> QY() {
        return this.bmG;
    }

    public final a<?, Float> QZ() {
        return this.bmH;
    }

    public final Matrix getMatrix() {
        this.bka.reset();
        PointF value = this.bmC.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.bka.preTranslate(value.x, value.y);
        }
        float fFloatValue = this.bmE.getValue().floatValue();
        if (fFloatValue != 0.0f) {
            this.bka.preRotate(fFloatValue);
        }
        com.kwad.lottie.e.d value2 = this.bmD.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.bka.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.bmB.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.bka.preTranslate(-value3.x, -value3.y);
        }
        return this.bka;
    }

    public final Matrix D(float f) {
        PointF value = this.bmC.getValue();
        PointF value2 = this.bmB.getValue();
        com.kwad.lottie.e.d value3 = this.bmD.getValue();
        float fFloatValue = this.bmE.getValue().floatValue();
        this.bka.reset();
        this.bka.preTranslate(value.x * f, value.y * f);
        double d = f;
        this.bka.preScale((float) Math.pow(value3.getScaleX(), d), (float) Math.pow(value3.getScaleY(), d));
        this.bka.preRotate(fFloatValue * f, value2.x, value2.y);
        return this.bka;
    }

    public final <T> boolean b(T t, com.kwad.lottie.e.c<T> cVar) {
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == com.kwad.lottie.i.bkB) {
            this.bmB.a(cVar);
            return true;
        }
        if (t == com.kwad.lottie.i.bkC) {
            this.bmC.a(cVar);
            return true;
        }
        if (t == com.kwad.lottie.i.bkF) {
            this.bmD.a(cVar);
            return true;
        }
        if (t == com.kwad.lottie.i.bkG) {
            this.bmE.a(cVar);
            return true;
        }
        if (t == com.kwad.lottie.i.bkz) {
            this.bmF.a(cVar);
            return true;
        }
        if (t == com.kwad.lottie.i.bkR && (aVar2 = this.bmG) != null) {
            aVar2.a(cVar);
            return true;
        }
        if (t != com.kwad.lottie.i.bkS || (aVar = this.bmH) == null) {
            return false;
        }
        aVar.a(cVar);
        return true;
    }
}
