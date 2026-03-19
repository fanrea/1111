package com.tachikoma.lottie.a.a;

import com.tachikoma.lottie.a.b.a;
import com.tachikoma.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class s implements c, a.InterfaceC0799a {
    private final boolean IO;
    private final ShapeTrimPath.Type JA;
    private final com.tachikoma.lottie.a.b.a<?, Float> JB;
    private final com.tachikoma.lottie.a.b.a<?, Float> JC;
    private final com.tachikoma.lottie.a.b.a<?, Float> JD;
    private final List<a.InterfaceC0799a> Jz = new ArrayList();
    private final String name;

    @Override // com.tachikoma.lottie.a.a.c
    public final void b(List<c> list, List<c> list2) {
    }

    public s(com.tachikoma.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.IO = shapeTrimPath.isHidden();
        this.JA = shapeTrimPath.jX();
        this.JB = shapeTrimPath.lv().kB();
        this.JC = shapeTrimPath.lu().kB();
        this.JD = shapeTrimPath.lo().kB();
        aVar.a(this.JB);
        aVar.a(this.JC);
        aVar.a(this.JD);
        this.JB.b(this);
        this.JC.b(this);
        this.JD.b(this);
    }

    @Override // com.tachikoma.lottie.a.b.a.InterfaceC0799a
    public final void jO() {
        for (int i = 0; i < this.Jz.size(); i++) {
            this.Jz.get(i).jO();
        }
    }

    @Override // com.tachikoma.lottie.a.a.c
    public final String getName() {
        return this.name;
    }

    final void a(a.InterfaceC0799a interfaceC0799a) {
        this.Jz.add(interfaceC0799a);
    }

    final ShapeTrimPath.Type jX() {
        return this.JA;
    }

    public final com.tachikoma.lottie.a.b.a<?, Float> jY() {
        return this.JB;
    }

    public final com.tachikoma.lottie.a.b.a<?, Float> jZ() {
        return this.JC;
    }

    public final com.tachikoma.lottie.a.b.a<?, Float> ka() {
        return this.JD;
    }

    public final boolean isHidden() {
        return this.IO;
    }
}
