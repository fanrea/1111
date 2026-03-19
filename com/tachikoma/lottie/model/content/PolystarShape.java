package com.tachikoma.lottie.model.content;

import android.graphics.PointF;
import com.tachikoma.lottie.a.a.n;
import com.tachikoma.lottie.model.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class PolystarShape implements b {
    private final boolean IO;
    private final Type Jl;
    private final com.tachikoma.lottie.model.a.b LJ;
    private final com.tachikoma.lottie.model.a.b LK;
    private final com.tachikoma.lottie.model.a.b LL;
    private final com.tachikoma.lottie.model.a.b LM;
    private final com.tachikoma.lottie.model.a.b LN;
    private final m<PointF, PointF> Lg;
    private final com.tachikoma.lottie.model.a.b Li;
    private final String name;

    public enum Type {
        STAR(1),
        POLYGON(2);

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

    public PolystarShape(String str, Type type, com.tachikoma.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.tachikoma.lottie.model.a.b bVar2, com.tachikoma.lottie.model.a.b bVar3, com.tachikoma.lottie.model.a.b bVar4, com.tachikoma.lottie.model.a.b bVar5, com.tachikoma.lottie.model.a.b bVar6, boolean z) {
        this.name = str;
        this.Jl = type;
        this.LJ = bVar;
        this.Lg = mVar;
        this.Li = bVar2;
        this.LK = bVar3;
        this.LL = bVar4;
        this.LM = bVar5;
        this.LN = bVar6;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final Type lg() {
        return this.Jl;
    }

    public final com.tachikoma.lottie.model.a.b lh() {
        return this.LJ;
    }

    public final m<PointF, PointF> kG() {
        return this.Lg;
    }

    public final com.tachikoma.lottie.model.a.b kI() {
        return this.Li;
    }

    public final com.tachikoma.lottie.model.a.b li() {
        return this.LK;
    }

    public final com.tachikoma.lottie.model.a.b lj() {
        return this.LL;
    }

    public final com.tachikoma.lottie.model.a.b lk() {
        return this.LM;
    }

    public final com.tachikoma.lottie.model.a.b ll() {
        return this.LN;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }
}
