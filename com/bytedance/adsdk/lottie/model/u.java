package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static final u d = new u();
    private final k<String, com.bytedance.adsdk.lottie.an> hc = new k<>(20);

    public static u d() {
        return d;
    }

    u() {
    }

    public com.bytedance.adsdk.lottie.an d(String str) {
        if (str == null) {
            return null;
        }
        return this.hc.d((k<String, com.bytedance.adsdk.lottie.an>) str);
    }

    public void d(String str, com.bytedance.adsdk.lottie.an anVar) {
        if (str == null) {
            return;
        }
        this.hc.d(str, anVar);
    }
}
