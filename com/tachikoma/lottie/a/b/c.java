package com.tachikoma.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends f<Float> {
    public c(List<com.tachikoma.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float a(com.tachikoma.lottie.e.a<Float> aVar, float f) {
        return Float.valueOf(e(aVar, f));
    }

    private float e(com.tachikoma.lottie.e.a<Float> aVar, float f) {
        Float f2;
        if (aVar.NG == null || aVar.NH == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.JG != null && (f2 = (Float) this.JG.b(aVar.GT, aVar.NJ.floatValue(), aVar.NG, aVar.NH, f, kd(), getProgress())) != null) {
            return f2.floatValue();
        }
        return com.tachikoma.lottie.d.e.c(aVar.mg(), aVar.mh(), f);
    }

    public final float kh() {
        return e(kc(), ke());
    }
}
