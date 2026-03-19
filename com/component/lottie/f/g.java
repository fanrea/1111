package com.component.lottie.f;

import android.graphics.Color;
import com.component.lottie.f.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g implements ap<Integer> {
    public static final g a = new g();

    private g() {
    }

    @Override // com.component.lottie.f.ap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer b(com.component.lottie.f.a.c cVar, float f) {
        double dK;
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        double dK2 = cVar.k();
        double dK3 = cVar.k();
        double dK4 = cVar.k();
        if (cVar.f() != c.b.NUMBER) {
            dK = 1.0d;
        } else {
            dK = cVar.k();
        }
        if (z) {
            cVar.b();
        }
        if (dK2 <= 1.0d && dK3 <= 1.0d && dK4 <= 1.0d) {
            dK2 *= 255.0d;
            dK3 *= 255.0d;
            dK4 *= 255.0d;
            if (dK <= 1.0d) {
                dK *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dK, (int) dK2, (int) dK3, (int) dK4));
    }
}
