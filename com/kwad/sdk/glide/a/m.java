package com.kwad.sdk.glide.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m {
    private boolean bBT;
    private final Set<com.kwad.sdk.glide.request.e> bYQ = Collections.newSetFromMap(new WeakHashMap());
    private final List<com.kwad.sdk.glide.request.e> bYR = new ArrayList();

    public final void a(com.kwad.sdk.glide.request.e eVar) {
        this.bYQ.add(eVar);
        if (!this.bBT) {
            eVar.begin();
            return;
        }
        eVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.bYR.add(eVar);
    }

    public final boolean b(com.kwad.sdk.glide.request.e eVar) {
        return a(eVar, true);
    }

    private boolean a(com.kwad.sdk.glide.request.e eVar, boolean z) {
        boolean z2 = true;
        if (eVar == null) {
            return true;
        }
        boolean zRemove = this.bYQ.remove(eVar);
        if (!this.bYR.remove(eVar) && !zRemove) {
            z2 = false;
        }
        if (z2) {
            eVar.clear();
            if (z) {
                eVar.recycle();
            }
        }
        return z2;
    }

    public final void afo() {
        this.bBT = true;
        for (com.kwad.sdk.glide.request.e eVar : com.kwad.sdk.glide.e.j.c(this.bYQ)) {
            if (eVar.isRunning()) {
                eVar.clear();
                this.bYR.add(eVar);
            }
        }
    }

    public final void afp() {
        this.bBT = false;
        for (com.kwad.sdk.glide.request.e eVar : com.kwad.sdk.glide.e.j.c(this.bYQ)) {
            if (!eVar.isComplete() && !eVar.isRunning()) {
                eVar.begin();
            }
        }
        this.bYR.clear();
    }

    public final void aip() {
        Iterator it = com.kwad.sdk.glide.e.j.c(this.bYQ).iterator();
        while (it.hasNext()) {
            a((com.kwad.sdk.glide.request.e) it.next(), false);
        }
        this.bYR.clear();
    }

    public final void aiq() {
        for (com.kwad.sdk.glide.request.e eVar : com.kwad.sdk.glide.e.j.c(this.bYQ)) {
            if (!eVar.isComplete() && !eVar.ajb()) {
                eVar.clear();
                if (!this.bBT) {
                    eVar.begin();
                } else {
                    this.bYR.add(eVar);
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.bYQ.size() + ", isPaused=" + this.bBT + com.alipay.sdk.m.u.i.d;
    }
}
