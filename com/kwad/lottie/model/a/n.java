package com.kwad.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.kwad.lottie.e.a<V>> bmm;

    n(V v) {
        this(Collections.singletonList(new com.kwad.lottie.e.a(v)));
    }

    n(List<com.kwad.lottie.e.a<V>> list) {
        this.bmm = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.bmm.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.bmm.toArray()));
        }
        return sb.toString();
    }
}
