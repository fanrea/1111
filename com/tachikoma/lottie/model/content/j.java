package com.tachikoma.lottie.model.content;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class j implements b {
    private final boolean IO;
    private final List<b> LV;
    private final String name;

    public j(String str, List<b> list, boolean z) {
        this.name = str;
        this.LV = list;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final List<b> getItems() {
        return this.LV;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new com.tachikoma.lottie.a.a.d(gVar, aVar, this);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.LV.toArray()) + '}';
    }
}
