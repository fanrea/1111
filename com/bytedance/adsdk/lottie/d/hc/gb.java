package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private final List<com.bytedance.adsdk.lottie.model.hc.gb> b;
    private final List<d<com.bytedance.adsdk.lottie.model.hc.k, Path>> d;
    private final List<d<Integer, Integer>> hc;

    public gb(List<com.bytedance.adsdk.lottie.model.hc.gb> list) {
        this.b = list;
        this.d = new ArrayList(list.size());
        this.hc = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.d.add(list.get(i).hc().d());
            this.hc.add(list.get(i).b().d());
        }
    }

    public List<com.bytedance.adsdk.lottie.model.hc.gb> d() {
        return this.b;
    }

    public List<d<com.bytedance.adsdk.lottie.model.hc.k, Path>> hc() {
        return this.d;
    }

    public List<d<Integer, Integer>> b() {
        return this.hc;
    }
}
