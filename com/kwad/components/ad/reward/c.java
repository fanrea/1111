package com.kwad.components.ad.reward;

import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> sZ;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.sZ = new HashSet();
    }

    static class a {
        private static final c tc = new c(0);
    }

    public static c gs() {
        return a.tc;
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.sZ.add(mVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.sZ.remove(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (this.sZ.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.sZ.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public final void c(final r rVar) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.this.b(rVar);
            }
        });
    }
}
