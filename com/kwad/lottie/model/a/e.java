package com.kwad.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements m<PointF, PointF> {
    private final List<com.kwad.lottie.e.a<PointF>> bmm;

    public e() {
        this.bmm = Collections.singletonList(new com.kwad.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.kwad.lottie.e.a<PointF>> list) {
        this.bmm = list;
    }

    @Override // com.kwad.lottie.model.a.m
    public final com.kwad.lottie.a.b.a<PointF, PointF> Rj() {
        if (this.bmm.get(0).SJ()) {
            return new com.kwad.lottie.a.b.j(this.bmm);
        }
        return new com.kwad.lottie.a.b.i(this.bmm);
    }
}
