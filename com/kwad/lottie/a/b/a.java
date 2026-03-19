package com.kwad.lottie.a.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a<K, A> {
    private final List<? extends com.kwad.lottie.e.a<K>> bmm;
    protected com.kwad.lottie.e.c<A> bmn;
    private com.kwad.lottie.e.a<K> bmo;
    final List<InterfaceC0568a> bmg = new ArrayList();
    private boolean bml = false;
    private float agh = 0.0f;

    /* renamed from: com.kwad.lottie.a.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0568a {
        void Qz();
    }

    abstract A a(com.kwad.lottie.e.a<K> aVar, float f);

    a(List<? extends com.kwad.lottie.e.a<K>> list) {
        this.bmm = list;
    }

    public final void QM() {
        this.bml = true;
    }

    public final void b(InterfaceC0568a interfaceC0568a) {
        this.bmg.add(interfaceC0568a);
    }

    public void setProgress(float f) {
        if (f < QQ()) {
            f = QQ();
        } else if (f > QR()) {
            f = QR();
        }
        if (f == this.agh) {
            return;
        }
        this.agh = f;
        kL();
    }

    public void kL() {
        for (int i = 0; i < this.bmg.size(); i++) {
            this.bmg.get(i).Qz();
        }
    }

    private com.kwad.lottie.e.a<K> QN() {
        com.kwad.lottie.e.a<K> aVar = this.bmo;
        if (aVar != null && aVar.I(this.agh)) {
            return this.bmo;
        }
        com.kwad.lottie.e.a<K> aVar2 = this.bmm.get(r0.size() - 1);
        if (this.agh < aVar2.Sf()) {
            for (int size = this.bmm.size() - 1; size >= 0; size--) {
                aVar2 = this.bmm.get(size);
                if (aVar2.I(this.agh)) {
                    break;
                }
            }
        }
        this.bmo = aVar2;
        return aVar2;
    }

    final float QO() {
        if (this.bml) {
            return 0.0f;
        }
        com.kwad.lottie.e.a<K> aVarQN = QN();
        if (aVarQN.SJ()) {
            return 0.0f;
        }
        return (this.agh - aVarQN.Sf()) / (aVarQN.QR() - aVarQN.Sf());
    }

    private float QP() {
        com.kwad.lottie.e.a<K> aVarQN = QN();
        if (aVarQN.SJ()) {
            return 0.0f;
        }
        return aVarQN.bpP.getInterpolation(QO());
    }

    private float QQ() {
        if (this.bmm.isEmpty()) {
            return 0.0f;
        }
        return this.bmm.get(0).Sf();
    }

    float QR() {
        if (this.bmm.isEmpty()) {
            return 1.0f;
        }
        return this.bmm.get(r0.size() - 1).QR();
    }

    public A getValue() {
        return a(QN(), QP());
    }

    public final float getProgress() {
        return this.agh;
    }

    public final void a(com.kwad.lottie.e.c<A> cVar) {
        com.kwad.lottie.e.c<A> cVar2 = this.bmn;
        if (cVar2 != null) {
            cVar2.b(null);
        }
        this.bmn = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
