package com.component.lottie.d.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.component.lottie.h.a<V>> a;

    n(V v) {
        this(Collections.singletonList(new com.component.lottie.h.a(v)));
    }

    n(List<com.component.lottie.h.a<V>> list) {
        this.a = list;
    }

    @Override // com.component.lottie.d.a.m
    public List<com.component.lottie.h.a<V>> c() {
        return this.a;
    }

    @Override // com.component.lottie.d.a.m
    public boolean b() {
        if (this.a.isEmpty()) {
            return true;
        }
        return this.a.size() == 1 && this.a.get(0).e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
