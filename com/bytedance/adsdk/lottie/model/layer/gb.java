package com.bytedance.adsdk.lottie.model.layer;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private final long an;
    private final String b;
    private final long c;
    private final float cb;
    private final List<com.bytedance.adsdk.lottie.model.hc.b> d;
    private final boolean de;
    private final float e;
    private final List<com.bytedance.adsdk.lottie.model.hc.gb> gb;
    private final String h;
    private final com.bytedance.adsdk.lottie.an hc;
    private final List<com.bytedance.adsdk.lottie.an.d<Float>> jh;
    private final float k;
    private final int mk;
    private final int mq;
    private final com.bytedance.adsdk.lottie.c.tc np;
    private final com.bytedance.adsdk.lottie.model.d.hc rf;
    private final hc sy;
    private final int tc;
    private final com.bytedance.adsdk.lottie.model.d.mq tt;
    private final d u;
    private final float uo;
    private final com.bytedance.adsdk.lottie.model.hc.d v;
    private final com.bytedance.adsdk.lottie.model.d.tc w;
    private final com.bytedance.adsdk.lottie.model.d.mk yo;

    public enum d {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum hc {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public gb(List<com.bytedance.adsdk.lottie.model.hc.b> list, com.bytedance.adsdk.lottie.an anVar, String str, long j, d dVar, long j2, String str2, List<com.bytedance.adsdk.lottie.model.hc.gb> list2, com.bytedance.adsdk.lottie.model.d.mq mqVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.lottie.model.d.tc tcVar, com.bytedance.adsdk.lottie.model.d.mk mkVar, List<com.bytedance.adsdk.lottie.an.d<Float>> list3, hc hcVar, com.bytedance.adsdk.lottie.model.d.hc hcVar2, boolean z, com.bytedance.adsdk.lottie.model.hc.d dVar2, com.bytedance.adsdk.lottie.c.tc tcVar2) {
        this.d = list;
        this.hc = anVar;
        this.b = str;
        this.c = j;
        this.u = dVar;
        this.an = j2;
        this.h = str2;
        this.gb = list2;
        this.tt = mqVar;
        this.tc = i;
        this.mk = i2;
        this.mq = i3;
        this.uo = f;
        this.k = f2;
        this.e = f3;
        this.cb = f4;
        this.w = tcVar;
        this.yo = mkVar;
        this.jh = list3;
        this.sy = hcVar;
        this.rf = hcVar2;
        this.de = z;
        this.v = dVar2;
        this.np = tcVar2;
    }

    com.bytedance.adsdk.lottie.an d() {
        return this.hc;
    }

    float hc() {
        return this.uo;
    }

    float b() {
        return this.k / this.hc.yo();
    }

    List<com.bytedance.adsdk.lottie.an.d<Float>> c() {
        return this.jh;
    }

    public long u() {
        return this.c;
    }

    public String an() {
        return this.b;
    }

    public String h() {
        return this.h;
    }

    float gb() {
        return this.e;
    }

    float tt() {
        return this.cb;
    }

    List<com.bytedance.adsdk.lottie.model.hc.gb> tc() {
        return this.gb;
    }

    public d mk() {
        return this.u;
    }

    hc mq() {
        return this.sy;
    }

    long uo() {
        return this.an;
    }

    List<com.bytedance.adsdk.lottie.model.hc.b> k() {
        return this.d;
    }

    com.bytedance.adsdk.lottie.model.d.mq e() {
        return this.tt;
    }

    int cb() {
        return this.mq;
    }

    int w() {
        return this.mk;
    }

    int yo() {
        return this.tc;
    }

    com.bytedance.adsdk.lottie.model.d.tc rf() {
        return this.w;
    }

    com.bytedance.adsdk.lottie.model.d.mk jh() {
        return this.yo;
    }

    com.bytedance.adsdk.lottie.model.d.hc sy() {
        return this.rf;
    }

    public String toString() {
        return d("");
    }

    public boolean de() {
        return this.de;
    }

    public com.bytedance.adsdk.lottie.model.hc.d v() {
        return this.v;
    }

    public com.bytedance.adsdk.lottie.c.tc np() {
        return this.np;
    }

    public String d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(an()).append("\n");
        gb gbVarD = this.hc.d(uo());
        if (gbVarD != null) {
            sb.append("\t\tParents: ").append(gbVarD.an());
            gb gbVarD2 = this.hc.d(gbVarD.uo());
            while (gbVarD2 != null) {
                sb.append("->").append(gbVarD2.an());
                gbVarD2 = this.hc.d(gbVarD2.uo());
            }
            sb.append(str).append("\n");
        }
        if (!tc().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(tc().size()).append("\n");
        }
        if (yo() != 0 && w() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(yo()), Integer.valueOf(w()), Integer.valueOf(cb())));
        }
        if (!this.d.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.bytedance.adsdk.lottie.model.hc.b> it = this.d.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
