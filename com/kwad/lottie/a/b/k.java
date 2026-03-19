package com.kwad.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends f<com.kwad.lottie.e.d> {
    public k(List<com.kwad.lottie.e.a<com.kwad.lottie.e.d>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.kwad.lottie.e.d a(com.kwad.lottie.e.a<com.kwad.lottie.e.d> aVar, float f) {
        com.kwad.lottie.e.d dVar;
        if (aVar.bpN == null || aVar.bpO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.kwad.lottie.e.d dVar2 = aVar.bpN;
        com.kwad.lottie.e.d dVar3 = aVar.bpO;
        return (this.bmn == null || (dVar = (com.kwad.lottie.e.d) this.bmn.b(aVar.bjS, aVar.bpQ.floatValue(), dVar2, dVar3, f, QO(), getProgress())) == null) ? new com.kwad.lottie.e.d(com.kwad.lottie.d.e.lerp(dVar2.getScaleX(), dVar3.getScaleX(), f), com.kwad.lottie.d.e.lerp(dVar2.getScaleY(), dVar3.getScaleY(), f)) : dVar;
    }
}
