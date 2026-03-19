package com.bytedance.adsdk.lottie.model.d;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class k<V, O> implements uo<V, O> {
    final List<com.bytedance.adsdk.lottie.an.d<V>> d;

    k(List<com.bytedance.adsdk.lottie.an.d<V>> list) {
        this.d = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public List<com.bytedance.adsdk.lottie.an.d<V>> b() {
        return this.d;
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public boolean hc() {
        return this.d.isEmpty() || (this.d.size() == 1 && this.d.get(0).u());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.d.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.d.toArray()));
        }
        return sb.toString();
    }
}
