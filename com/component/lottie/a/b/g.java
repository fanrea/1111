package com.component.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g extends i<com.component.lottie.d.b.d> {
    private final com.component.lottie.d.b.d d;

    public g(List<com.component.lottie.h.a<com.component.lottie.d.b.d>> list) {
        super(list);
        com.component.lottie.d.b.d dVar = list.get(0).a;
        int iC = dVar != null ? dVar.c() : 0;
        this.d = new com.component.lottie.d.b.d(new float[iC], new int[iC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.component.lottie.d.b.d a(com.component.lottie.h.a<com.component.lottie.d.b.d> aVar, float f) {
        this.d.a(aVar.a, aVar.b, f);
        return this.d;
    }
}
