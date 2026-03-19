package com.kwad.components.ct.tube.panel.a;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final List<b> mListeners;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.mListeners = new ArrayList();
    }

    static class a {
        private static final c aXP = new c(0);
    }

    public static c KJ() {
        return a.aXP;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.mListeners.add(bVar);
        }
    }

    public final void b(b bVar) {
        this.mListeners.remove(bVar);
    }

    public final void g(final KsFragment ksFragment) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.tube.panel.a.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                Iterator it = c.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).f(ksFragment);
                }
            }
        });
    }
}
