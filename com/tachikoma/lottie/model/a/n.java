package com.tachikoma.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.tachikoma.lottie.e.a<V>> JF;

    n(V v) {
        this(Collections.singletonList(new com.tachikoma.lottie.e.a(v)));
    }

    n(List<com.tachikoma.lottie.e.a<V>> list) {
        this.JF = list;
    }

    @Override // com.tachikoma.lottie.model.a.m
    public List<com.tachikoma.lottie.e.a<V>> kD() {
        return this.JF;
    }

    @Override // com.tachikoma.lottie.model.a.m
    public boolean kC() {
        return this.JF.isEmpty() || (this.JF.size() == 1 && this.JF.get(0).kC());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.JF.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.JF.toArray()));
        }
        return sb.toString();
    }
}
