package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.d.d.jh;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo implements b {
    private final com.bytedance.adsdk.lottie.model.d.hc an;
    private final List<com.bytedance.adsdk.lottie.model.d.hc> b;
    private final com.bytedance.adsdk.lottie.model.d.d c;
    private final String d;
    private final hc gb;
    private final d h;
    private final com.bytedance.adsdk.lottie.model.d.hc hc;
    private final boolean tc;
    private final float tt;
    private final com.bytedance.adsdk.lottie.model.d.c u;

    public enum d {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap d() {
            int i = AnonymousClass1.d[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.hc.yo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] hc;

        static {
            int[] iArr = new int[hc.values().length];
            hc = iArr;
            try {
                iArr[hc.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                hc[hc.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                hc[hc.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.values().length];
            d = iArr2;
            try {
                iArr2[d.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[d.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[d.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum hc {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join d() {
            int i = AnonymousClass1.hc[ordinal()];
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

    public yo(String str, com.bytedance.adsdk.lottie.model.d.hc hcVar, List<com.bytedance.adsdk.lottie.model.d.hc> list, com.bytedance.adsdk.lottie.model.d.d dVar, com.bytedance.adsdk.lottie.model.d.c cVar, com.bytedance.adsdk.lottie.model.d.hc hcVar2, d dVar2, hc hcVar3, float f, boolean z) {
        this.d = str;
        this.hc = hcVar;
        this.b = list;
        this.c = dVar;
        this.u = cVar;
        this.an = hcVar2;
        this.h = dVar2;
        this.gb = hcVar3;
        this.tt = f;
        this.tc = z;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new jh(gbVar, bVar, this);
    }

    public String d() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.d.d hc() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.d.c b() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.d.hc c() {
        return this.an;
    }

    public List<com.bytedance.adsdk.lottie.model.d.hc> u() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.d.hc an() {
        return this.hc;
    }

    public d h() {
        return this.h;
    }

    public hc gb() {
        return this.gb;
    }

    public float tt() {
        return this.tt;
    }

    public boolean tc() {
        return this.tc;
    }
}
