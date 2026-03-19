package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g {
    private List<f> bLt = new CopyOnWriteArrayList();

    public final void l(View view, boolean z) {
        Iterator<f> it = this.bLt.iterator();
        while (it.hasNext()) {
            it.next().i(view, z);
        }
    }

    public final void a(f fVar) {
        if (c(fVar)) {
            return;
        }
        this.bLt.add(fVar);
    }

    public final void b(f fVar) {
        this.bLt.remove(fVar);
    }

    private boolean c(f fVar) {
        if (fVar != null) {
            return this.bLt.contains(fVar);
        }
        return false;
    }
}
