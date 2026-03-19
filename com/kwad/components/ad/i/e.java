package com.kwad.components.ad.i;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private final AtomicBoolean sO;
    private final List<com.kwad.components.ad.b.a.b> sP;

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.sO = new AtomicBoolean();
        this.sP = new CopyOnWriteArrayList();
    }

    public final boolean X() {
        return this.sO.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.sP.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.sP.remove(bVar);
        }
    }

    public final void gf() {
        this.sO.set(true);
        Iterator<com.kwad.components.ad.b.a.b> it = this.sP.iterator();
        while (it.hasNext()) {
            it.next().Y();
        }
    }

    public final void gh() {
        this.sO.set(false);
        Iterator<com.kwad.components.ad.b.a.b> it = this.sP.iterator();
        while (it.hasNext()) {
            it.next().Z();
        }
    }

    static class a {
        private static final e sQ = new e(0);
    }

    public static e gj() {
        return a.sQ;
    }
}
