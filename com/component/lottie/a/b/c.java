package com.component.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends i<Integer> {
    public c(List<com.component.lottie.h.a<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.component.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(com.component.lottie.h.a<Integer> aVar, float f) {
        return Integer.valueOf(c(aVar, f));
    }

    public int c(com.component.lottie.h.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.c != null && (num = (Integer) this.c.a(aVar.f, aVar.g.floatValue(), aVar.a, aVar.b, f, d(), h())) != null) {
            return num.intValue();
        }
        return com.component.lottie.g.b.a(com.component.lottie.g.f.b(f, 0.0f, 1.0f), aVar.a.intValue(), aVar.b.intValue());
    }

    public int i() {
        return c(c(), e());
    }
}
