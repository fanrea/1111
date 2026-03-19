package com.kwad.lottie.model.content;

import com.kwad.lottie.a.a.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ShapeTrimPath implements b {
    private final Type bmh;
    private final com.kwad.lottie.model.a.b boa;
    private final com.kwad.lottie.model.a.b boj;
    private final com.kwad.lottie.model.a.b bok;
    private final String name;

    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, com.kwad.lottie.model.a.b bVar, com.kwad.lottie.model.a.b bVar2, com.kwad.lottie.model.a.b bVar3) {
        this.name = str;
        this.bmh = type;
        this.boj = bVar;
        this.bok = bVar2;
        this.boa = bVar3;
    }

    public final String getName() {
        return this.name;
    }

    public final Type QI() {
        return this.bmh;
    }

    public final com.kwad.lottie.model.a.b RX() {
        return this.bok;
    }

    public final com.kwad.lottie.model.a.b RY() {
        return this.boj;
    }

    public final com.kwad.lottie.model.a.b RR() {
        return this.boa;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.boj + ", end: " + this.bok + ", offset: " + this.boa + com.alipay.sdk.m.u.i.d;
    }
}
