package com.kwad.lottie.model.content;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j implements b {
    private final List<b> bof;
    private final String name;

    public j(String str, List<b> list) {
        this.name = str;
        this.bof = list;
    }

    public final String getName() {
        return this.name;
    }

    public final List<b> getItems() {
        return this.bof;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new com.kwad.lottie.a.a.c(fVar, aVar, this);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.bof.toArray()) + '}';
    }
}
