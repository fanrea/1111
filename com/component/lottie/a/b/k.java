package com.component.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k extends com.component.lottie.h.a<PointF> {
    private Path j;
    private final com.component.lottie.h.a<PointF> k;

    public k(com.component.lottie.t tVar, com.component.lottie.h.a<PointF> aVar) {
        super(tVar, aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g);
        this.k = aVar;
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        boolean z = (this.b == 0 || this.a == 0 || !((PointF) this.a).equals(((PointF) this.b).x, ((PointF) this.b).y)) ? false : true;
        if (this.a != 0 && this.b != 0 && !z) {
            this.j = com.component.lottie.g.g.a((PointF) this.a, (PointF) this.b, this.k.h, this.k.i);
        }
    }

    Path b() {
        return this.j;
    }
}
