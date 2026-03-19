package com.kwad.components.core.u;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private Set<b> aaw;

    public interface b {
        void onPageClose();
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
        this.aaw = new HashSet();
    }

    static class a {
        private static c aax = new c(0);
    }

    public static c tr() {
        return a.aax;
    }

    public final void a(b bVar) {
        this.aaw.add(bVar);
    }

    public final void b(b bVar) {
        this.aaw.remove(bVar);
    }

    public final void ts() {
        if (this.aaw.size() == 0) {
            return;
        }
        Iterator<b> it = this.aaw.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }
}
