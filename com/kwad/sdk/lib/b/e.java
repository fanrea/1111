package com.kwad.sdk.lib.b;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private boolean ccG;
    private final List<f> mObservers = new CopyOnWriteArrayList();

    public final void a(f fVar) {
        if (this.mObservers.contains(fVar)) {
            return;
        }
        this.mObservers.add(fVar);
    }

    public final void b(f fVar) {
        this.mObservers.remove(fVar);
    }

    public final void akM() {
        this.mObservers.clear();
    }

    public final void s(boolean z, boolean z2) {
        Iterator<f> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().m(z, z2);
        }
    }

    public final void t(boolean z, boolean z2) {
        Iterator<f> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().n(z, z2);
        }
    }

    public final void b(boolean z, int i, String str) {
        Iterator<f> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().a(z, i, str);
        }
    }

    public final void de(boolean z) {
        if (this.ccG) {
            return;
        }
        Iterator<f> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().df(z);
        }
    }
}
