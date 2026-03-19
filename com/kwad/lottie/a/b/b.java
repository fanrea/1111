package com.kwad.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends f<Integer> {
    public b(List<com.kwad.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(com.kwad.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.bpN == null || aVar.bpO == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = aVar.bpN.intValue();
        int iIntValue2 = aVar.bpO.intValue();
        return (this.bmn == null || (num = (Integer) this.bmn.b(aVar.bjS, aVar.bpQ.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, QO(), getProgress())) == null) ? Integer.valueOf(com.kwad.lottie.d.b.a(f, iIntValue, iIntValue2)) : num;
    }
}
