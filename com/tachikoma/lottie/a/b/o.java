package com.tachikoma.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tachikoma.lottie.a.b.a;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class o {
    private final Matrix Hh = new Matrix();
    private final Matrix Kb;
    private final Matrix Kc;
    private final Matrix Kd;
    private final float[] Ke;
    private a<PointF, PointF> Kf;
    private a<?, PointF> Kg;
    private a<com.tachikoma.lottie.e.d, com.tachikoma.lottie.e.d> Kh;
    private a<Float, Float> Ki;
    private a<Integer, Integer> Kj;
    private c Kk;
    private c Kl;
    private a<?, Float> Km;
    private a<?, Float> Kn;

    public o(com.tachikoma.lottie.model.a.l lVar) {
        this.Kf = lVar.kF() == null ? null : lVar.kF().kB();
        this.Kg = lVar.kG() == null ? null : lVar.kG().kB();
        this.Kh = lVar.kH() == null ? null : lVar.kH().kB();
        this.Ki = lVar.kI() == null ? null : lVar.kI().kB();
        this.Kk = lVar.kM() == null ? null : (c) lVar.kM().kB();
        if (this.Kk != null) {
            this.Kb = new Matrix();
            this.Kc = new Matrix();
            this.Kd = new Matrix();
            this.Ke = new float[9];
        } else {
            this.Kb = null;
            this.Kc = null;
            this.Kd = null;
            this.Ke = null;
        }
        this.Kl = lVar.kN() == null ? null : (c) lVar.kN().kB();
        if (lVar.kJ() != null) {
            this.Kj = lVar.kJ().kB();
        }
        if (lVar.kK() != null) {
            this.Km = lVar.kK().kB();
        } else {
            this.Km = null;
        }
        if (lVar.kL() != null) {
            this.Kn = lVar.kL().kB();
        } else {
            this.Kn = null;
        }
    }

    public final void a(com.tachikoma.lottie.model.layer.a aVar) {
        aVar.a(this.Kj);
        aVar.a(this.Km);
        aVar.a(this.Kn);
        aVar.a(this.Kf);
        aVar.a(this.Kg);
        aVar.a(this.Kh);
        aVar.a(this.Ki);
        aVar.a(this.Kk);
        aVar.a(this.Kl);
    }

    public final void a(a.InterfaceC0799a interfaceC0799a) {
        a<Integer, Integer> aVar = this.Kj;
        if (aVar != null) {
            aVar.b(interfaceC0799a);
        }
        a<?, Float> aVar2 = this.Km;
        if (aVar2 != null) {
            aVar2.b(interfaceC0799a);
        }
        a<?, Float> aVar3 = this.Kn;
        if (aVar3 != null) {
            aVar3.b(interfaceC0799a);
        }
        a<PointF, PointF> aVar4 = this.Kf;
        if (aVar4 != null) {
            aVar4.b(interfaceC0799a);
        }
        a<?, PointF> aVar5 = this.Kg;
        if (aVar5 != null) {
            aVar5.b(interfaceC0799a);
        }
        a<com.tachikoma.lottie.e.d, com.tachikoma.lottie.e.d> aVar6 = this.Kh;
        if (aVar6 != null) {
            aVar6.b(interfaceC0799a);
        }
        a<Float, Float> aVar7 = this.Ki;
        if (aVar7 != null) {
            aVar7.b(interfaceC0799a);
        }
        c cVar = this.Kk;
        if (cVar != null) {
            cVar.b(interfaceC0799a);
        }
        c cVar2 = this.Kl;
        if (cVar2 != null) {
            cVar2.b(interfaceC0799a);
        }
    }

    public final void setProgress(float f) {
        a<Integer, Integer> aVar = this.Kj;
        if (aVar != null) {
            aVar.setProgress(f);
        }
        a<?, Float> aVar2 = this.Km;
        if (aVar2 != null) {
            aVar2.setProgress(f);
        }
        a<?, Float> aVar3 = this.Kn;
        if (aVar3 != null) {
            aVar3.setProgress(f);
        }
        a<PointF, PointF> aVar4 = this.Kf;
        if (aVar4 != null) {
            aVar4.setProgress(f);
        }
        a<?, PointF> aVar5 = this.Kg;
        if (aVar5 != null) {
            aVar5.setProgress(f);
        }
        a<com.tachikoma.lottie.e.d, com.tachikoma.lottie.e.d> aVar6 = this.Kh;
        if (aVar6 != null) {
            aVar6.setProgress(f);
        }
        a<Float, Float> aVar7 = this.Ki;
        if (aVar7 != null) {
            aVar7.setProgress(f);
        }
        c cVar = this.Kk;
        if (cVar != null) {
            cVar.setProgress(f);
        }
        c cVar2 = this.Kl;
        if (cVar2 != null) {
            cVar2.setProgress(f);
        }
    }

    public final a<?, Integer> ko() {
        return this.Kj;
    }

    public final a<?, Float> kp() {
        return this.Km;
    }

    public final a<?, Float> kq() {
        return this.Kn;
    }

    public final Matrix getMatrix() {
        float fKh;
        this.Hh.reset();
        a<?, PointF> aVar = this.Kg;
        if (aVar != null) {
            PointF value = aVar.getValue();
            if (value.x != 0.0f || value.y != 0.0f) {
                this.Hh.preTranslate(value.x, value.y);
            }
        }
        a<Float, Float> aVar2 = this.Ki;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                fKh = aVar2.getValue().floatValue();
            } else {
                fKh = ((c) aVar2).kh();
            }
            if (fKh != 0.0f) {
                this.Hh.preRotate(fKh);
            }
        }
        if (this.Kk != null) {
            float fCos = this.Kl == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.kh()) + 90.0f));
            float fSin = this.Kl == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.kh()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.Kk.kh()));
            kr();
            float[] fArr = this.Ke;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.Kb.setValues(fArr);
            kr();
            float[] fArr2 = this.Ke;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.Kc.setValues(fArr2);
            kr();
            float[] fArr3 = this.Ke;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.Kd.setValues(fArr3);
            this.Kc.preConcat(this.Kb);
            this.Kd.preConcat(this.Kc);
            this.Hh.preConcat(this.Kd);
        }
        a<com.tachikoma.lottie.e.d, com.tachikoma.lottie.e.d> aVar3 = this.Kh;
        if (aVar3 != null) {
            com.tachikoma.lottie.e.d value2 = aVar3.getValue();
            if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
                this.Hh.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        a<PointF, PointF> aVar4 = this.Kf;
        if (aVar4 != null) {
            PointF value3 = aVar4.getValue();
            if (value3.x != 0.0f || value3.y != 0.0f) {
                this.Hh.preTranslate(-value3.x, -value3.y);
            }
        }
        return this.Hh;
    }

    private void kr() {
        for (int i = 0; i < 9; i++) {
            this.Ke[i] = 0.0f;
        }
    }

    public final Matrix h(float f) {
        a<?, PointF> aVar = this.Kg;
        PointF value = aVar == null ? null : aVar.getValue();
        a<com.tachikoma.lottie.e.d, com.tachikoma.lottie.e.d> aVar2 = this.Kh;
        com.tachikoma.lottie.e.d value2 = aVar2 == null ? null : aVar2.getValue();
        this.Hh.reset();
        if (value != null) {
            this.Hh.preTranslate(value.x * f, value.y * f);
        }
        if (value2 != null) {
            double d = f;
            this.Hh.preScale((float) Math.pow(value2.getScaleX(), d), (float) Math.pow(value2.getScaleY(), d));
        }
        a<Float, Float> aVar3 = this.Ki;
        if (aVar3 != null) {
            float fFloatValue = aVar3.getValue().floatValue();
            a<PointF, PointF> aVar4 = this.Kf;
            PointF value3 = aVar4 != null ? aVar4.getValue() : null;
            this.Hh.preRotate(fFloatValue * f, value3 == null ? 0.0f : value3.x, value3 != null ? value3.y : 0.0f);
        }
        return this.Hh;
    }

    public final <T> boolean b(T t, com.tachikoma.lottie.e.c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == com.tachikoma.lottie.k.HN) {
            a<PointF, PointF> aVar3 = this.Kf;
            if (aVar3 == null) {
                this.Kf = new p(cVar, new PointF());
                return true;
            }
            aVar3.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.HO) {
            a<?, PointF> aVar4 = this.Kg;
            if (aVar4 == null) {
                this.Kg = new p(cVar, new PointF());
                return true;
            }
            aVar4.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.HT) {
            a<com.tachikoma.lottie.e.d, com.tachikoma.lottie.e.d> aVar5 = this.Kh;
            if (aVar5 == null) {
                this.Kh = new p(cVar, new com.tachikoma.lottie.e.d());
                return true;
            }
            aVar5.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.HU) {
            a<Float, Float> aVar6 = this.Ki;
            if (aVar6 == null) {
                this.Ki = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.HL) {
            a<Integer, Integer> aVar7 = this.Kj;
            if (aVar7 == null) {
                this.Kj = new p(cVar, 100);
                return true;
            }
            aVar7.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.Ih && (aVar2 = this.Km) != null) {
            if (aVar2 == null) {
                this.Km = new p(cVar, 100);
                return true;
            }
            aVar2.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.Ii && (aVar = this.Kn) != null) {
            if (aVar == null) {
                this.Kn = new p(cVar, 100);
                return true;
            }
            aVar.a(cVar);
            return true;
        }
        if (t == com.tachikoma.lottie.k.HV && (cVar3 = this.Kk) != null) {
            if (cVar3 == null) {
                this.Kk = new c(Collections.singletonList(new com.tachikoma.lottie.e.a(Float.valueOf(0.0f))));
            }
            this.Kk.a(cVar);
            return true;
        }
        if (t != com.tachikoma.lottie.k.HW || (cVar2 = this.Kl) == null) {
            return false;
        }
        if (cVar2 == null) {
            this.Kl = new c(Collections.singletonList(new com.tachikoma.lottie.e.a(Float.valueOf(0.0f))));
        }
        this.Kl.a(cVar);
        return true;
    }
}
