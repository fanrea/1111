package com.kwad.lottie.model.layer;

import com.kwad.lottie.model.a.j;
import com.kwad.lottie.model.a.k;
import com.kwad.lottie.model.a.l;
import com.kwad.lottie.model.content.Mask;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class Layer {
    private final com.kwad.lottie.d bjG;
    private final float bjS;
    private final List<Mask> bms;
    private final List<com.kwad.lottie.model.content.b> bnf;
    private final String boL;
    private final long boM;
    private final LayerType boN;
    private final long boO;
    private final String boP;
    private final int boQ;
    private final int boR;
    private final int boS;
    private final float boT;
    private final int boU;
    private final int boV;
    private final j boW;
    private final k boX;
    private final com.kwad.lottie.model.a.b boY;
    private final List<com.kwad.lottie.e.a<Float>> boZ;
    private final l bob;
    private final MatteType bpa;

    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.kwad.lottie.model.content.b> list, com.kwad.lottie.d dVar, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, j jVar, k kVar, List<com.kwad.lottie.e.a<Float>> list3, MatteType matteType, com.kwad.lottie.model.a.b bVar) {
        this.bnf = list;
        this.bjG = dVar;
        this.boL = str;
        this.boM = j;
        this.boN = layerType;
        this.boO = j2;
        this.boP = str2;
        this.bms = list2;
        this.bob = lVar;
        this.boQ = i;
        this.boR = i2;
        this.boS = i3;
        this.boT = f;
        this.bjS = f2;
        this.boU = i4;
        this.boV = i5;
        this.boW = jVar;
        this.boX = kVar;
        this.boZ = list3;
        this.bpa = matteType;
        this.boY = bVar;
    }

    final com.kwad.lottie.d getComposition() {
        return this.bjG;
    }

    final float Se() {
        return this.boT;
    }

    final float Sf() {
        return this.bjS / this.bjG.Qk();
    }

    final List<com.kwad.lottie.e.a<Float>> Sg() {
        return this.boZ;
    }

    public final long getId() {
        return this.boM;
    }

    final String getName() {
        return this.boL;
    }

    final String Sh() {
        return this.boP;
    }

    final int Si() {
        return this.boU;
    }

    final int Sj() {
        return this.boV;
    }

    final List<Mask> QS() {
        return this.bms;
    }

    public final LayerType Sk() {
        return this.boN;
    }

    final MatteType Sl() {
        return this.bpa;
    }

    final long Sm() {
        return this.boO;
    }

    final List<com.kwad.lottie.model.content.b> Re() {
        return this.bnf;
    }

    final l RS() {
        return this.bob;
    }

    final int getSolidColor() {
        return this.boS;
    }

    final int Sn() {
        return this.boR;
    }

    final int So() {
        return this.boQ;
    }

    final j Sp() {
        return this.boW;
    }

    final k Sq() {
        return this.boX;
    }

    final com.kwad.lottie.model.a.b Sr() {
        return this.boY;
    }

    public final String toString() {
        return toString("");
    }

    public final String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer layerAB = this.bjG.aB(Sm());
        if (layerAB != null) {
            sb.append("\t\tParents: ").append(layerAB.getName());
            Layer layerAB2 = this.bjG.aB(layerAB.Sm());
            while (layerAB2 != null) {
                sb.append("->").append(layerAB2.getName());
                layerAB2 = this.bjG.aB(layerAB2.Sm());
            }
            sb.append(str).append("\n");
        }
        if (!QS().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(QS().size()).append("\n");
        }
        if (So() != 0 && Sn() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(So()), Integer.valueOf(Sn()), Integer.valueOf(getSolidColor())));
        }
        if (!this.bnf.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.kwad.lottie.model.content.b> it = this.bnf.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
