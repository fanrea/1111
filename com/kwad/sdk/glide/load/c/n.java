package com.kwad.sdk.glide.load.c;

import com.kwad.sdk.utils.ax;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface n<Model, Data> {
    boolean E(Model model);

    a<Data> b(Model model, int i, int i2, com.kwad.sdk.glide.load.f fVar);

    public static class a<Data> {
        public final com.kwad.sdk.glide.load.c bSq;
        public final List<com.kwad.sdk.glide.load.c> bWB;
        public final com.kwad.sdk.glide.load.a.d<Data> bWC;

        public a(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        private a(com.kwad.sdk.glide.load.c cVar, List<com.kwad.sdk.glide.load.c> list, com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this.bSq = (com.kwad.sdk.glide.load.c) ax.checkNotNull(cVar);
            this.bWB = (List) ax.checkNotNull(list);
            this.bWC = (com.kwad.sdk.glide.load.a.d) ax.checkNotNull(dVar);
        }
    }
}
