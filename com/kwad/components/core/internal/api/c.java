package com.kwad.components.core.internal.api;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private List<b> SW = new CopyOnWriteArrayList();
    private boolean SX = false;
    private boolean SY = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.SW.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.SW.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.SY);
        if (this.SY) {
            return;
        }
        Iterator<b> it = this.SW.iterator();
        while (it.hasNext()) {
            it.next().c(aVar);
        }
        this.SY = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.SX);
        if (this.SX) {
            return;
        }
        Iterator<b> it = this.SW.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        this.SX = true;
    }
}
