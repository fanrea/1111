package com.kwad.sdk.glide.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class a implements h {
    private boolean adz;
    private boolean aev;
    private final Set<i> bYD = Collections.newSetFromMap(new WeakHashMap());

    a() {
    }

    @Override // com.kwad.sdk.glide.a.h
    public final void a(i iVar) {
        this.bYD.add(iVar);
        if (this.adz) {
            iVar.onDestroy();
        } else if (this.aev) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    @Override // com.kwad.sdk.glide.a.h
    public final void b(i iVar) {
        this.bYD.remove(iVar);
    }

    final void onStart() {
        this.aev = true;
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYD).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStart();
        }
    }

    final void onStop() {
        this.aev = false;
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYD).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStop();
        }
    }

    final void onDestroy() {
        this.adz = true;
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYD).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onDestroy();
        }
    }
}
