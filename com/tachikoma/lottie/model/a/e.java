package com.tachikoma.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e implements m<PointF, PointF> {
    private final List<com.tachikoma.lottie.e.a<PointF>> JF;

    public e() {
        this.JF = Collections.singletonList(new com.tachikoma.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.tachikoma.lottie.e.a<PointF>> list) {
        this.JF = list;
    }

    @Override // com.tachikoma.lottie.model.a.m
    public final List<com.tachikoma.lottie.e.a<PointF>> kD() {
        return this.JF;
    }

    @Override // com.tachikoma.lottie.model.a.m
    public final boolean kC() {
        return this.JF.size() == 1 && this.JF.get(0).kC();
    }

    @Override // com.tachikoma.lottie.model.a.m
    public final com.tachikoma.lottie.a.b.a<PointF, PointF> kB() {
        if (this.JF.get(0).kC()) {
            return new com.tachikoma.lottie.a.b.j(this.JF);
        }
        return new com.tachikoma.lottie.a.b.i(this.JF);
    }
}
