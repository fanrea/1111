package com.component.lottie.f;

import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ai implements ap<com.component.lottie.h.k> {
    public static final ai a = new ai();

    private ai() {
    }

    @Override // com.component.lottie.f.ap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.component.lottie.h.k b(com.component.lottie.f.a.c cVar, float f) {
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        float fK = (float) cVar.k();
        float fK2 = (float) cVar.k();
        while (cVar.e()) {
            cVar.m();
        }
        if (z) {
            cVar.b();
        }
        return new com.component.lottie.h.k((fK / 100.0f) * f, (fK2 / 100.0f) * f);
    }
}
