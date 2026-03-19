package com.kwad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.lottie.e.a<PointF> {
    private Path blk;

    /* JADX WARN: Multi-variable type inference failed */
    public h(com.kwad.lottie.d dVar, com.kwad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.bpN, aVar.bpO, aVar.bpP, aVar.bjS, aVar.bpQ);
        boolean z = (this.bpO == 0 || this.bpN == 0 || !((PointF) this.bpN).equals(((PointF) this.bpO).x, ((PointF) this.bpO).y)) ? false : true;
        if (this.bpO == 0 || z) {
            return;
        }
        this.blk = com.kwad.lottie.d.f.a((PointF) this.bpN, (PointF) this.bpO, aVar.bpT, aVar.bpU);
    }

    final Path getPath() {
        return this.blk;
    }
}
