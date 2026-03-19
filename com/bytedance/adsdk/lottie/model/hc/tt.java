package com.bytedance.adsdk.lottie.model.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt implements b {
    private final boolean b;
    private final String d;
    private final d hc;

    public enum d {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static d d(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public tt(String str, d dVar, boolean z) {
        this.d = str;
        this.hc = dVar;
        this.b = z;
    }

    public String d() {
        return this.d;
    }

    public d hc() {
        return this.hc;
    }

    public boolean b() {
        return this.b;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.mq(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.hc + '}';
    }
}
