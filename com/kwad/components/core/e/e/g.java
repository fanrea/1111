package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private final List<f> RM;

    /* synthetic */ g(byte b) {
        this();
    }

    public static class a {
        private static final g RN = new g(0);
    }

    private g() {
        this.RM = new CopyOnWriteArrayList();
    }

    public static g qh() {
        return a.RN;
    }

    public final void a(f fVar) {
        this.RM.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.RM.remove(fVar);
        }
    }

    public final void qi() {
        Iterator<f> it = this.RM.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void qj() {
        Iterator<f> it = this.RM.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }
}
