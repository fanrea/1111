package com.tachikoma.lottie.model.content;

import android.graphics.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements b {
    private final boolean IO;
    private final com.tachikoma.lottie.model.a.d Lj;
    private final GradientType Ls;
    private final Path.FillType Lt;
    private final com.tachikoma.lottie.model.a.c Lu;
    private final com.tachikoma.lottie.model.a.f Lv;
    private final com.tachikoma.lottie.model.a.f Lw;
    private final com.tachikoma.lottie.model.a.b Lx = null;
    private final com.tachikoma.lottie.model.a.b Ly = null;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tachikoma.lottie.model.a.c cVar, com.tachikoma.lottie.model.a.d dVar, com.tachikoma.lottie.model.a.f fVar, com.tachikoma.lottie.model.a.f fVar2, com.tachikoma.lottie.model.a.b bVar, com.tachikoma.lottie.model.a.b bVar2, boolean z) {
        this.Ls = gradientType;
        this.Lt = fillType;
        this.Lu = cVar;
        this.Lj = dVar;
        this.Lv = fVar;
        this.Lw = fVar2;
        this.name = str;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final GradientType kS() {
        return this.Ls;
    }

    public final Path.FillType getFillType() {
        return this.Lt;
    }

    public final com.tachikoma.lottie.model.a.c kT() {
        return this.Lu;
    }

    public final com.tachikoma.lottie.model.a.d kJ() {
        return this.Lj;
    }

    public final com.tachikoma.lottie.model.a.f kU() {
        return this.Lv;
    }

    public final com.tachikoma.lottie.model.a.f kV() {
        return this.Lw;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new com.tachikoma.lottie.a.a.h(gVar, aVar, this);
    }
}
