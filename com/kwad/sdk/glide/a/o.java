package com.kwad.sdk.glide.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o implements i {
    private final Set<com.kwad.sdk.glide.request.a.j<?>> bYY = Collections.newSetFromMap(new WeakHashMap());

    public final void f(com.kwad.sdk.glide.request.a.j<?> jVar) {
        this.bYY.add(jVar);
    }

    public final void g(com.kwad.sdk.glide.request.a.j<?> jVar) {
        this.bYY.remove(jVar);
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onStart() {
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYY).iterator();
        while (it.hasNext()) {
            ((com.kwad.sdk.glide.request.a.j) it.next()).onStart();
        }
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onStop() {
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYY).iterator();
        while (it.hasNext()) {
            ((com.kwad.sdk.glide.request.a.j) it.next()).onStop();
        }
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onDestroy() {
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYY).iterator();
        while (it.hasNext()) {
            ((com.kwad.sdk.glide.request.a.j) it.next()).onDestroy();
        }
    }

    public final List<com.kwad.sdk.glide.request.a.j<?>> aaj() {
        return com.kwad.sdk.glide.e.j.c(this.bYY);
    }

    public final void clear() {
        this.bYY.clear();
    }
}
