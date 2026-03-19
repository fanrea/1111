package com.component.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q extends i<com.component.lottie.d.b> {
    public q(List<com.component.lottie.h.a<com.component.lottie.d.b>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.component.lottie.d.b a(com.component.lottie.h.a<com.component.lottie.d.b> aVar, float f) {
        if (this.c != null) {
            return (com.component.lottie.d.b) this.c.a(aVar.f, aVar.g == null ? Float.MAX_VALUE : aVar.g.floatValue(), aVar.a, aVar.b == null ? aVar.a : aVar.b, f, e(), h());
        }
        if (f != 1.0f || aVar.b == null) {
            return aVar.a;
        }
        return aVar.b;
    }

    public void b(com.component.lottie.h.j<String> jVar) {
        super.a(new r(this, new com.component.lottie.h.b(), jVar, new com.component.lottie.d.b()));
    }
}
