package com.component.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class n extends i<com.component.lottie.h.k> {
    private final com.component.lottie.h.k d;

    public n(List<com.component.lottie.h.a<com.component.lottie.h.k>> list) {
        super(list);
        this.d = new com.component.lottie.h.k();
    }

    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.component.lottie.h.k a(com.component.lottie.h.a<com.component.lottie.h.k> aVar, float f) {
        com.component.lottie.h.k kVar;
        if (aVar.a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.component.lottie.h.k kVar2 = aVar.a;
        com.component.lottie.h.k kVar3 = aVar.b;
        if (this.c != null && (kVar = (com.component.lottie.h.k) this.c.a(aVar.f, aVar.g.floatValue(), kVar2, kVar3, f, d(), h())) != null) {
            return kVar;
        }
        this.d.a(com.component.lottie.g.f.a(kVar2.a(), kVar3.a(), f), com.component.lottie.g.f.a(kVar2.b(), kVar3.b(), f));
        return this.d;
    }
}
