package com.tachikoma.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends f<com.tachikoma.lottie.model.content.c> {
    private final com.tachikoma.lottie.model.content.c JN;

    public d(List<com.tachikoma.lottie.e.a<com.tachikoma.lottie.model.content.c>> list) {
        super(list);
        com.tachikoma.lottie.model.content.c cVar = list.get(0).NG;
        int size = cVar != null ? cVar.getSize() : 0;
        this.JN = new com.tachikoma.lottie.model.content.c(new float[size], new int[size]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tachikoma.lottie.model.content.c a(com.tachikoma.lottie.e.a<com.tachikoma.lottie.model.content.c> aVar, float f) {
        this.JN.a(aVar.NG, aVar.NH, f);
        return this.JN;
    }
}
