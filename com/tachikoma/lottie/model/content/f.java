package com.tachikoma.lottie.model.content;

import android.graphics.PointF;
import com.tachikoma.lottie.a.a.o;
import com.tachikoma.lottie.model.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f implements b {
    private final boolean IO;
    private final com.tachikoma.lottie.model.a.b LO;
    private final m<PointF, PointF> Lg;
    private final com.tachikoma.lottie.model.a.f Lo;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tachikoma.lottie.model.a.f fVar, com.tachikoma.lottie.model.a.b bVar, boolean z) {
        this.name = str;
        this.Lg = mVar;
        this.Lo = fVar;
        this.LO = bVar;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final com.tachikoma.lottie.model.a.b lm() {
        return this.LO;
    }

    public final com.tachikoma.lottie.model.a.f kP() {
        return this.Lo;
    }

    public final m<PointF, PointF> kG() {
        return this.Lg;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }

    public final String toString() {
        return "RectangleShape{position=" + this.Lg + ", size=" + this.Lo + '}';
    }
}
