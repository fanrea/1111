package com.tachikoma.lottie.model.content;

import com.tachikoma.lottie.a.a.q;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class k implements b {
    private final boolean IO;
    private final com.tachikoma.lottie.model.a.h LW;
    private final int index;
    private final String name;

    public k(String str, int i, com.tachikoma.lottie.model.a.h hVar, boolean z) {
        this.name = str;
        this.index = i;
        this.LW = hVar;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final com.tachikoma.lottie.model.a.h lt() {
        return this.LW;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public final boolean isHidden() {
        return this.IO;
    }

    public final String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + '}';
    }
}
