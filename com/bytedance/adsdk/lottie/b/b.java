package com.bytedance.adsdk.lottie.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum b {
    JSON(".json"),
    ZIP(".zip");

    public final String b;

    b(String str) {
        this.b = str;
    }

    public String d() {
        return ".temp" + this.b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
