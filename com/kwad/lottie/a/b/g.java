package com.kwad.lottie.a.b;

import android.graphics.Path;
import com.kwad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private final List<a<com.kwad.lottie.model.content.h, Path>> bmq;
    private final List<a<Integer, Integer>> bmr;
    private final List<Mask> bms;

    public g(List<Mask> list) {
        this.bms = list;
        this.bmq = new ArrayList(list.size());
        this.bmr = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.bmq.add(list.get(i).RH().Rj());
            this.bmr.add(list.get(i).Rp().Rj());
        }
    }

    public final List<Mask> QS() {
        return this.bms;
    }

    public final List<a<com.kwad.lottie.model.content.h, Path>> QT() {
        return this.bmq;
    }

    public final List<a<Integer, Integer>> QU() {
        return this.bmr;
    }
}
