package com.component.lottie.h;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i extends j<PointF> {
    private final PointF a;

    public i() {
        this.a = new PointF();
    }

    public i(PointF pointF) {
        super(pointF);
        this.a = new PointF();
    }

    @Override // com.component.lottie.h.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final PointF a(b<PointF> bVar) {
        this.a.set(com.component.lottie.g.f.a(bVar.c().x, bVar.d().x, bVar.f()), com.component.lottie.g.f.a(bVar.c().y, bVar.d().y, bVar.f()));
        PointF pointFC = c(bVar);
        this.a.offset(pointFC.x, pointFC.y);
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF c(b<PointF> bVar) {
        if (this.e == 0) {
            throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        }
        return (PointF) this.e;
    }
}
