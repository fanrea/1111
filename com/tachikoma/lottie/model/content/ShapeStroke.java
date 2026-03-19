package com.tachikoma.lottie.model.content;

import android.graphics.Paint;
import com.tachikoma.lottie.a.a.r;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class ShapeStroke implements b {
    private final boolean IO;
    private final LineCapType LA;
    private final LineJoinType LB;
    private final float LC;
    private final List<com.tachikoma.lottie.model.a.b> LD;
    private final com.tachikoma.lottie.model.a.b LQ;
    private final com.tachikoma.lottie.model.a.a Lb;
    private final com.tachikoma.lottie.model.a.d Lj;
    private final com.tachikoma.lottie.model.a.b Lz;
    private final String name;

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public final Paint.Cap toPaintCap() {
            int i = AnonymousClass1.LX[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* renamed from: com.tachikoma.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] LX;
        static final /* synthetic */ int[] LY = new int[LineJoinType.values().length];

        static {
            try {
                LY[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                LY[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                LY[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            LX = new int[LineCapType.values().length];
            try {
                LX[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                LX[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                LX[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public final Paint.Join toPaintJoin() {
            int i = AnonymousClass1.LY[ordinal()];
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

    public ShapeStroke(String str, com.tachikoma.lottie.model.a.b bVar, List<com.tachikoma.lottie.model.a.b> list, com.tachikoma.lottie.model.a.a aVar, com.tachikoma.lottie.model.a.d dVar, com.tachikoma.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.name = str;
        this.LQ = bVar;
        this.LD = list;
        this.Lb = aVar;
        this.Lj = dVar;
        this.Lz = bVar2;
        this.LA = lineCapType;
        this.LB = lineJoinType;
        this.LC = f;
        this.IO = z;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new r(gVar, aVar, this);
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

    public final com.tachikoma.lottie.model.a.b kW() {
        return this.Lz;
    }

    public final List<com.tachikoma.lottie.model.a.b> kZ() {
        return this.LD;
    }

    public final com.tachikoma.lottie.model.a.b la() {
        return this.LQ;
    }

    public final LineCapType kX() {
        return this.LA;
    }

    public final LineJoinType kY() {
        return this.LB;
    }

    public final float lb() {
        return this.LC;
    }

    public final boolean isHidden() {
        return this.IO;
    }
}
