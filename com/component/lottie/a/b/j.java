package com.component.lottie.a.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j {
    private final List<a<com.component.lottie.d.b.n, Path>> a;
    private final List<a<Integer, Integer>> b;
    private final List<com.component.lottie.d.b.h> c;

    public j(List<com.component.lottie.d.b.h> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).b().a());
            this.b.add(list.get(i).c().a());
        }
    }

    public List<com.component.lottie.d.b.h> a() {
        return this.c;
    }

    public List<a<com.component.lottie.d.b.n, Path>> b() {
        return this.a;
    }

    public List<a<Integer, Integer>> c() {
        return this.b;
    }
}
