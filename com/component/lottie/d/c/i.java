package com.component.lottie.d.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.component.lottie.af;
import com.component.lottie.d.b.p;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i extends a {
    private final com.component.lottie.a.a.e g;
    private final d h;

    i(af afVar, g gVar, d dVar) {
        super(afVar, gVar);
        this.h = dVar;
        this.g = new com.component.lottie.a.a.e(afVar, this, new p("__container", gVar.n(), false));
        this.g.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.component.lottie.d.c.a
    void b(Canvas canvas, Matrix matrix, int i) {
        this.g.a(canvas, matrix, i);
    }

    @Override // com.component.lottie.d.c.a, com.component.lottie.a.a.f
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.g.a(rectF, this.a, z);
    }

    @Override // com.component.lottie.d.c.a
    public com.component.lottie.d.b.a f() {
        com.component.lottie.d.b.a aVarF = super.f();
        if (aVarF != null) {
            return aVarF;
        }
        return this.h.f();
    }

    @Override // com.component.lottie.d.c.a
    public com.component.lottie.f.j g() {
        com.component.lottie.f.j jVarG = super.g();
        if (jVarG != null) {
            return jVarG;
        }
        return this.h.g();
    }

    @Override // com.component.lottie.d.c.a
    protected void b(com.component.lottie.d.e eVar, int i, List<com.component.lottie.d.e> list, com.component.lottie.d.e eVar2) {
        this.g.a(eVar, i, list, eVar2);
    }
}
