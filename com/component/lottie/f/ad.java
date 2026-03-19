package com.component.lottie.f;

import android.graphics.PointF;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ad implements ap<PointF> {
    public static final ad a = new ad();

    private ad() {
    }

    @Override // com.component.lottie.f.ap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF b(com.component.lottie.f.a.c cVar, float f) {
        c.b bVarF = cVar.f();
        if (bVarF == c.b.BEGIN_ARRAY) {
            return s.b(cVar, f);
        }
        if (bVarF == c.b.BEGIN_OBJECT) {
            return s.b(cVar, f);
        }
        if (bVarF == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.k()) * f, ((float) cVar.k()) * f);
            while (cVar.e()) {
                cVar.m();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarF);
    }
}
