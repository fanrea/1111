package com.kwad.lottie.model;

import androidx.collection.LruCache;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private static final g bnl = new g();
    private final LruCache<String, com.kwad.lottie.d> bnm = new LruCache<>(10485760);

    public static g Ri() {
        return bnl;
    }

    g() {
    }

    public final com.kwad.lottie.d dr(String str) {
        if (str == null) {
            return null;
        }
        return this.bnm.get(str);
    }

    public final void a(String str, com.kwad.lottie.d dVar) {
        if (str == null) {
            return;
        }
        this.bnm.put(str, dVar);
    }
}
