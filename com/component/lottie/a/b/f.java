package com.component.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends i<Float> {
    public f(List<com.component.lottie.h.a<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(com.component.lottie.h.a<Float> aVar, float f) {
        return Float.valueOf(c(aVar, f));
    }

    float c(com.component.lottie.h.a<Float> aVar, float f) {
        Float f2;
        if (aVar.a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.c != null && (f2 = (Float) this.c.a(aVar.f, aVar.g.floatValue(), aVar.a, aVar.b, f, d(), h())) != null) {
            return f2.floatValue();
        }
        return com.component.lottie.g.f.a(aVar.f(), aVar.g(), f);
    }

    public float i() {
        return c(c(), e());
    }
}
