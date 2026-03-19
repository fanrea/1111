package com.tachikoma.lottie.model.content;

import android.graphics.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i implements b {
    private final boolean IO;
    private final boolean LU;
    private final com.tachikoma.lottie.model.a.a Lb;
    private final com.tachikoma.lottie.model.a.d Lj;
    private final Path.FillType Lt;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, com.tachikoma.lottie.model.a.a aVar, com.tachikoma.lottie.model.a.d dVar, boolean z2) {
        this.name = str;
        this.LU = z;
        this.Lt = fillType;
        this.Lb = aVar;
        this.Lj = dVar;
        this.IO = z2;
    }

    public final String getName() {
        return this.name;
    }

    public final com.tachikoma.lottie.model.a.a ls() {
        return this.Lb;
    }

    public final com.tachikoma.lottie.model.a.d kJ() {
        return this.Lj;
    }

    public final Path.FillType getFillType() {
        return this.Lt;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new com.tachikoma.lottie.a.a.g(gVar, aVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.LU + '}';
    }
}
