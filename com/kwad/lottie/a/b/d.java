package com.kwad.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends f<com.kwad.lottie.model.content.c> {
    private final com.kwad.lottie.model.content.c bmp;

    public d(List<com.kwad.lottie.e.a<com.kwad.lottie.model.content.c>> list) {
        super(list);
        com.kwad.lottie.model.content.c cVar = list.get(0).bpN;
        int size = cVar != null ? cVar.getSize() : 0;
        this.bmp = new com.kwad.lottie.model.content.c(new float[size], new int[size]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.kwad.lottie.model.content.c a(com.kwad.lottie.e.a<com.kwad.lottie.model.content.c> aVar, float f) {
        this.bmp.a(aVar.bpN, aVar.bpO, f);
        return this.bmp;
    }
}
