package com.tachikoma.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h extends com.tachikoma.lottie.e.a<PointF> {
    private Path Iz;
    private final com.tachikoma.lottie.e.a<PointF> JR;

    public h(com.tachikoma.lottie.e eVar, com.tachikoma.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.NG, aVar.NH, aVar.NI, aVar.GT, aVar.NJ);
        this.JR = aVar;
        kl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void kl() {
        boolean z = (this.NH == 0 || this.NG == 0 || !((PointF) this.NG).equals(((PointF) this.NH).x, ((PointF) this.NH).y)) ? false : true;
        if (this.NH == 0 || z) {
            return;
        }
        this.Iz = com.tachikoma.lottie.d.f.a((PointF) this.NG, (PointF) this.NH, this.JR.NQ, this.JR.NR);
    }

    final Path getPath() {
        return this.Iz;
    }
}
