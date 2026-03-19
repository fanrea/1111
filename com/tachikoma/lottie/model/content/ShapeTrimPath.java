package com.tachikoma.lottie.model.content;

import com.tachikoma.lottie.a.a.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class ShapeTrimPath implements b {
    private final boolean IO;
    private final Type JA;
    private final com.tachikoma.lottie.model.a.b LQ;
    private final com.tachikoma.lottie.model.a.b LZ;
    private final com.tachikoma.lottie.model.a.b Ma;
    private final String name;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, com.tachikoma.lottie.model.a.b bVar, com.tachikoma.lottie.model.a.b bVar2, com.tachikoma.lottie.model.a.b bVar3, boolean z) {
        this.name = str;
        this.JA = type;
        this.LZ = bVar;
        this.Ma = bVar2;
        this.LQ = bVar3;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final Type jX() {
        return this.JA;
    }

    public final com.tachikoma.lottie.model.a.b lu() {
        return this.Ma;
    }

    public final com.tachikoma.lottie.model.a.b lv() {
        return this.LZ;
    }

    public final com.tachikoma.lottie.model.a.b lo() {
        return this.LQ;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new s(aVar, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.LZ + ", end: " + this.Ma + ", offset: " + this.LQ + com.alipay.sdk.m.u.i.d;
    }
}
