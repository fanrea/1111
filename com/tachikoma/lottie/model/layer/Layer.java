package com.tachikoma.lottie.model.layer;

import com.tachikoma.lottie.model.a.j;
import com.tachikoma.lottie.model.a.k;
import com.tachikoma.lottie.model.a.l;
import com.tachikoma.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class Layer {
    private final com.tachikoma.lottie.e GD;
    private final float GT;
    private final boolean IO;
    private final List<Mask> JQ;
    private final List<com.tachikoma.lottie.model.content.b> KP;
    private final l LR;
    private final String MB;
    private final long MC;
    private final LayerType MD;
    private final long ME;
    private final String MF;
    private final int MG;
    private final int MH;
    private final int MI;
    private final float MJ;
    private final int MK;
    private final int ML;
    private final j MM;
    private final k MN;
    private final com.tachikoma.lottie.model.a.b MO;
    private final List<com.tachikoma.lottie.e.a<Float>> MP;
    private final MatteType MQ;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<com.tachikoma.lottie.model.content.b> list, com.tachikoma.lottie.e eVar, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, j jVar, k kVar, List<com.tachikoma.lottie.e.a<Float>> list3, MatteType matteType, com.tachikoma.lottie.model.a.b bVar, boolean z) {
        this.KP = list;
        this.GD = eVar;
        this.MB = str;
        this.MC = j;
        this.MD = layerType;
        this.ME = j2;
        this.MF = str2;
        this.JQ = list2;
        this.LR = lVar;
        this.MG = i;
        this.MH = i2;
        this.MI = i3;
        this.MJ = f;
        this.GT = f2;
        this.MK = i4;
        this.ML = i5;
        this.MM = jVar;
        this.MN = kVar;
        this.MP = list3;
        this.MQ = matteType;
        this.MO = bVar;
        this.IO = z;
    }

    final com.tachikoma.lottie.e getComposition() {
        return this.GD;
    }

    final float lB() {
        return this.MJ;
    }

    final float lC() {
        return this.GT / this.GD.jA();
    }

    final List<com.tachikoma.lottie.e.a<Float>> lD() {
        return this.MP;
    }

    public final long getId() {
        return this.MC;
    }

    final String getName() {
        return this.MB;
    }

    final String lE() {
        return this.MF;
    }

    final int lF() {
        return this.MK;
    }

    final int lG() {
        return this.ML;
    }

    final List<Mask> ki() {
        return this.JQ;
    }

    public final LayerType lH() {
        return this.MD;
    }

    final MatteType lI() {
        return this.MQ;
    }

    final long lJ() {
        return this.ME;
    }

    final List<com.tachikoma.lottie.model.content.b> kw() {
        return this.KP;
    }

    final l lp() {
        return this.LR;
    }

    final int getSolidColor() {
        return this.MI;
    }

    final int lK() {
        return this.MH;
    }

    final int lL() {
        return this.MG;
    }

    final j lM() {
        return this.MM;
    }

    final k lN() {
        return this.MN;
    }

    final com.tachikoma.lottie.model.a.b lO() {
        return this.MO;
    }

    public final String toString() {
        return toString("");
    }

    public final boolean isHidden() {
        return this.IO;
    }

    public final String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(getName());
        sb.append("\n");
        Layer layerL = this.GD.l(lJ());
        if (layerL != null) {
            sb.append("\t\tParents: ");
            sb.append(layerL.getName());
            Layer layerL2 = this.GD.l(layerL.lJ());
            while (layerL2 != null) {
                sb.append("->");
                sb.append(layerL2.getName());
                layerL2 = this.GD.l(layerL2.lJ());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!ki().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(ki().size());
            sb.append("\n");
        }
        if (lL() != 0 && lK() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(lL()), Integer.valueOf(lK()), Integer.valueOf(getSolidColor())));
        }
        if (!this.KP.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.tachikoma.lottie.model.content.b bVar : this.KP) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
