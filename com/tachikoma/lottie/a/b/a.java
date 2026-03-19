package com.tachikoma.lottie.a.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class a<K, A> {
    private final List<? extends com.tachikoma.lottie.e.a<K>> JF;
    protected com.tachikoma.lottie.e.c<A> JG;
    private com.tachikoma.lottie.e.a<K> JH;
    private com.tachikoma.lottie.e.a<K> JI;
    final List<InterfaceC0799a> Jz = new ArrayList(1);
    private boolean JE = false;
    private float GG = 0.0f;
    private float JJ = -1.0f;
    private A JK = null;
    private float JL = -1.0f;
    private float JM = -1.0f;

    /* renamed from: com.tachikoma.lottie.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0799a {
        void jO();
    }

    abstract A a(com.tachikoma.lottie.e.a<K> aVar, float f);

    a(List<? extends com.tachikoma.lottie.e.a<K>> list) {
        this.JF = list;
    }

    public final void kb() {
        this.JE = true;
    }

    public final void b(InterfaceC0799a interfaceC0799a) {
        this.Jz.add(interfaceC0799a);
    }

    public void setProgress(float f) {
        if (this.JF.isEmpty()) {
            return;
        }
        com.tachikoma.lottie.e.a<K> aVarKc = kc();
        if (f < kf()) {
            f = kf();
        } else if (f > kg()) {
            f = kg();
        }
        if (f == this.GG) {
            return;
        }
        this.GG = f;
        com.tachikoma.lottie.e.a<K> aVarKc2 = kc();
        if (aVarKc == aVarKc2 && aVarKc2.kC()) {
            return;
        }
        jN();
    }

    public void jN() {
        for (int i = 0; i < this.Jz.size(); i++) {
            this.Jz.get(i).jO();
        }
    }

    protected final com.tachikoma.lottie.e.a<K> kc() {
        com.tachikoma.lottie.e.a<K> aVar = this.JH;
        if (aVar != null && aVar.n(this.GG)) {
            return this.JH;
        }
        com.tachikoma.lottie.e.a<K> aVar2 = this.JF.get(r0.size() - 1);
        if (this.GG < aVar2.lC()) {
            for (int size = this.JF.size() - 1; size >= 0; size--) {
                aVar2 = this.JF.get(size);
                if (aVar2.n(this.GG)) {
                    break;
                }
            }
        }
        this.JH = aVar2;
        return aVar2;
    }

    final float kd() {
        if (this.JE) {
            return 0.0f;
        }
        com.tachikoma.lottie.e.a<K> aVarKc = kc();
        if (aVarKc.kC()) {
            return 0.0f;
        }
        return (this.GG - aVarKc.lC()) / (aVarKc.kg() - aVarKc.lC());
    }

    protected final float ke() {
        com.tachikoma.lottie.e.a<K> aVarKc = kc();
        if (aVarKc.kC()) {
            return 0.0f;
        }
        return aVarKc.NI.getInterpolation(kd());
    }

    private float kf() {
        if (this.JL == -1.0f) {
            this.JL = this.JF.isEmpty() ? 0.0f : this.JF.get(0).lC();
        }
        return this.JL;
    }

    float kg() {
        float fKg;
        if (this.JM == -1.0f) {
            if (this.JF.isEmpty()) {
                fKg = 1.0f;
            } else {
                fKg = this.JF.get(r0.size() - 1).kg();
            }
            this.JM = fKg;
        }
        return this.JM;
    }

    public A getValue() {
        com.tachikoma.lottie.e.a<K> aVarKc = kc();
        float fKe = ke();
        if (this.JG == null && aVarKc == this.JI && this.JJ == fKe) {
            return this.JK;
        }
        this.JI = aVarKc;
        this.JJ = fKe;
        A a = a(aVarKc, fKe);
        this.JK = a;
        return a;
    }

    public final float getProgress() {
        return this.GG;
    }

    public final void a(com.tachikoma.lottie.e.c<A> cVar) {
        com.tachikoma.lottie.e.c<A> cVar2 = this.JG;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.JG = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
