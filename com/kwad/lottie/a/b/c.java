package com.kwad.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends f<Float> {
    public c(List<com.kwad.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float a(com.kwad.lottie.e.a<Float> aVar, float f) {
        Float f2;
        if (aVar.bpN == null || aVar.bpO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.bmn == null || (f2 = (Float) this.bmn.b(aVar.bjS, aVar.bpQ.floatValue(), aVar.bpN, aVar.bpO, f, QO(), getProgress())) == null) ? Float.valueOf(com.kwad.lottie.d.e.lerp(aVar.bpN.floatValue(), aVar.bpO.floatValue(), f)) : f2;
    }
}
