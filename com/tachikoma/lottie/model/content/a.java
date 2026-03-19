package com.tachikoma.lottie.model.content;

import android.graphics.PointF;
import com.tachikoma.lottie.model.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a implements b {
    private final boolean IO;
    private final m<PointF, PointF> Lg;
    private final com.tachikoma.lottie.model.a.f Lo;
    private final boolean Lp;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.tachikoma.lottie.model.a.f fVar, boolean z, boolean z2) {
        this.name = str;
        this.Lg = mVar;
        this.Lo = fVar;
        this.Lp = z;
        this.IO = z2;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new com.tachikoma.lottie.a.a.f(gVar, aVar, this);
    }

    public final String getName() {
        return this.name;
    }

    public final m<PointF, PointF> kG() {
        return this.Lg;
    }

    public final com.tachikoma.lottie.model.a.f kP() {
        return this.Lo;
    }

    public final boolean kQ() {
        return this.Lp;
    }

    public final boolean isHidden() {
        return this.IO;
    }
}
