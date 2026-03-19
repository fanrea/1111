package com.tachikoma.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class k extends f<com.tachikoma.lottie.e.d> {
    private final com.tachikoma.lottie.e.d JW;

    public k(List<com.tachikoma.lottie.e.a<com.tachikoma.lottie.e.d>> list) {
        super(list);
        this.JW = new com.tachikoma.lottie.e.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.tachikoma.lottie.e.d a(com.tachikoma.lottie.e.a<com.tachikoma.lottie.e.d> aVar, float f) {
        com.tachikoma.lottie.e.d dVar;
        if (aVar.NG == null || aVar.NH == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.tachikoma.lottie.e.d dVar2 = aVar.NG;
        com.tachikoma.lottie.e.d dVar3 = aVar.NH;
        if (this.JG != null && (dVar = (com.tachikoma.lottie.e.d) this.JG.b(aVar.GT, aVar.NJ.floatValue(), dVar2, dVar3, f, kd(), getProgress())) != null) {
            return dVar;
        }
        this.JW.set(com.tachikoma.lottie.d.e.c(dVar2.getScaleX(), dVar3.getScaleX(), f), com.tachikoma.lottie.d.e.c(dVar2.getScaleY(), dVar3.getScaleY(), f));
        return this.JW;
    }
}
