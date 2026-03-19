package com.tachikoma.lottie.a.b;

import android.graphics.Path;
import com.tachikoma.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g {
    private final List<a<com.tachikoma.lottie.model.content.h, Path>> JO;
    private final List<a<Integer, Integer>> JP;
    private final List<Mask> JQ;

    public g(List<Mask> list) {
        this.JQ = list;
        this.JO = new ArrayList(list.size());
        this.JP = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.JO.add(list.get(i).ld().kB());
            this.JP.add(list.get(i).kJ().kB());
        }
    }

    public final List<Mask> ki() {
        return this.JQ;
    }

    public final List<a<com.tachikoma.lottie.model.content.h, Path>> kj() {
        return this.JO;
    }

    public final List<a<Integer, Integer>> kk() {
        return this.JP;
    }
}
