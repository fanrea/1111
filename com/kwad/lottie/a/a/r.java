package com.kwad.lottie.a.a;

import com.kwad.lottie.a.b.a;
import com.kwad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class r implements b, a.InterfaceC0568a {
    private final List<a.InterfaceC0568a> bmg = new ArrayList();
    private final ShapeTrimPath.Type bmh;
    private final com.kwad.lottie.a.b.a<?, Float> bmi;
    private final com.kwad.lottie.a.b.a<?, Float> bmj;
    private final com.kwad.lottie.a.b.a<?, Float> bmk;
    private final String name;

    @Override // com.kwad.lottie.a.a.b
    public final void b(List<b> list, List<b> list2) {
    }

    public r(com.kwad.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.bmh = shapeTrimPath.QI();
        com.kwad.lottie.a.b.a<Float, Float> aVarRj = shapeTrimPath.RY().Rj();
        this.bmi = aVarRj;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj2 = shapeTrimPath.RX().Rj();
        this.bmj = aVarRj2;
        com.kwad.lottie.a.b.a<Float, Float> aVarRj3 = shapeTrimPath.RR().Rj();
        this.bmk = aVarRj3;
        aVar.a(aVarRj);
        aVar.a(aVarRj2);
        aVar.a(aVarRj3);
        aVarRj.b(this);
        aVarRj2.b(this);
        aVarRj3.b(this);
    }

    @Override // com.kwad.lottie.a.b.a.InterfaceC0568a
    public final void Qz() {
        for (int i = 0; i < this.bmg.size(); i++) {
            this.bmg.get(i).Qz();
        }
    }

    @Override // com.kwad.lottie.a.a.b
    public final String getName() {
        return this.name;
    }

    final void a(a.InterfaceC0568a interfaceC0568a) {
        this.bmg.add(interfaceC0568a);
    }

    final ShapeTrimPath.Type QI() {
        return this.bmh;
    }

    public final com.kwad.lottie.a.b.a<?, Float> QJ() {
        return this.bmi;
    }

    public final com.kwad.lottie.a.b.a<?, Float> QK() {
        return this.bmj;
    }

    public final com.kwad.lottie.a.b.a<?, Float> QL() {
        return this.bmk;
    }
}
