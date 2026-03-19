package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private final Set<g> ajQ;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.ajQ = new CopyOnWriteArraySet();
    }

    static class a {
        private static final c ajW = new c(0);
    }

    public static c wq() {
        return a.ajW;
    }

    public final void a(g gVar) {
        if (gVar != null) {
            this.ajQ.add(gVar);
        }
    }

    public final void b(g gVar) {
        this.ajQ.remove(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2) {
        if (this.ajQ.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.ajQ).iterator();
        while (it.hasNext()) {
            ((g) it.next()).x(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j, long j2, long j3) {
        if (this.ajQ.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.ajQ).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(str, j, j2, j3);
        }
    }

    public final void t(final String str, final String str2) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.e.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.this.s(str, str2);
            }
        });
    }

    public final void c(final String str, final long j, final long j2, final long j3) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.e.c.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.this.b(str, j, j2, j3);
            }
        });
    }

    public final void wr() {
        this.ajQ.clear();
    }
}
