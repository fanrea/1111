package com.kwad.lottie.model.content;

import android.graphics.Paint;
import com.kwad.lottie.a.a.q;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ShapeStroke implements b {
    private final com.kwad.lottie.model.a.b bnK;
    private final LineCapType bnL;
    private final LineJoinType bnM;
    private final float bnN;
    private final List<com.kwad.lottie.model.a.b> bnO;
    private final com.kwad.lottie.model.a.a bnp;
    private final com.kwad.lottie.model.a.d bnx;
    private final com.kwad.lottie.model.a.b boa;
    private final String name;

    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public final Paint.Cap toPaintCap() {
            int i = AnonymousClass1.boh[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* renamed from: com.kwad.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] boh;
        static final /* synthetic */ int[] boi;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            boi = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                boi[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                boi[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            boh = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                boh[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                boh[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public final Paint.Join toPaintJoin() {
            int i = AnonymousClass1.boi[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke(String str, com.kwad.lottie.model.a.b bVar, List<com.kwad.lottie.model.a.b> list, com.kwad.lottie.model.a.a aVar, com.kwad.lottie.model.a.d dVar, com.kwad.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.boa = bVar;
        this.bnO = list;
        this.bnp = aVar;
        this.bnx = dVar;
        this.bnK = bVar2;
        this.bnL = lineCapType;
        this.bnM = lineJoinType;
        this.bnN = f;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public final String getName() {
        return this.name;
    }

    public final com.kwad.lottie.model.a.a RV() {
        return this.bnp;
    }

    public final com.kwad.lottie.model.a.d Rp() {
        return this.bnx;
    }

    public final com.kwad.lottie.model.a.b RA() {
        return this.bnK;
    }

    public final List<com.kwad.lottie.model.a.b> RD() {
        return this.bnO;
    }

    public final com.kwad.lottie.model.a.b RE() {
        return this.boa;
    }

    public final LineCapType RB() {
        return this.bnL;
    }

    public final LineJoinType RC() {
        return this.bnM;
    }

    public final float RF() {
        return this.bnN;
    }
}
