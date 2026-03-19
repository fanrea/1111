package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aiJ;
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> aiK = new CopyOnWriteArrayList<>();

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.aiJ != null) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.b.w.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (w.this.aiJ != null) {
                        w.this.aiJ.a(bVar);
                    }
                }
            });
        } else {
            this.aiK.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aiJ = cVar;
        if (this.aiK.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.aiK.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.aiK.remove(next);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.aiJ = null;
    }
}
