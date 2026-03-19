package com.kwad.lottie.model.content;

import android.graphics.PointF;
import com.kwad.lottie.model.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class PolystarShape implements b {
    private final Type blS;
    private final com.kwad.lottie.model.a.b bnT;
    private final com.kwad.lottie.model.a.b bnU;
    private final com.kwad.lottie.model.a.b bnV;
    private final com.kwad.lottie.model.a.b bnW;
    private final com.kwad.lottie.model.a.b bnX;
    private final m<PointF, PointF> bnu;
    private final com.kwad.lottie.model.a.b bnw;
    private final String name;

    public enum Type {
        Star(1),
        Polygon(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.kwad.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.kwad.lottie.model.a.b bVar2, com.kwad.lottie.model.a.b bVar3, com.kwad.lottie.model.a.b bVar4, com.kwad.lottie.model.a.b bVar5, com.kwad.lottie.model.a.b bVar6) {
        this.name = str;
        this.blS = type;
        this.bnT = bVar;
        this.bnu = mVar;
        this.bnw = bVar2;
        this.bnU = bVar3;
        this.bnV = bVar4;
        this.bnW = bVar5;
        this.bnX = bVar6;
    }

    public final String getName() {
        return this.name;
    }

    public final Type RJ() {
        return this.blS;
    }

    public final com.kwad.lottie.model.a.b RK() {
        return this.bnT;
    }

    public final m<PointF, PointF> Rm() {
        return this.bnu;
    }

    public final com.kwad.lottie.model.a.b Ro() {
        return this.bnw;
    }

    public final com.kwad.lottie.model.a.b RL() {
        return this.bnU;
    }

    public final com.kwad.lottie.model.a.b RM() {
        return this.bnV;
    }

    public final com.kwad.lottie.model.a.b RN() {
        return this.bnW;
    }

    public final com.kwad.lottie.model.a.b RO() {
        return this.bnX;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new com.kwad.lottie.a.a.m(fVar, aVar, this);
    }
}
