package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class an {
    private Map<String, com.kwad.sdk.core.webview.a> cmw;
    private Map<String, com.kwad.sdk.core.webview.c.c> cmx;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.cmw.put(str, aVar);
    }

    public final com.kwad.sdk.core.webview.a it(String str) {
        return this.cmw.get(str);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.cmx.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.c.c iu(String str) {
        return this.cmx.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> it = this.cmw.values().iterator();
        while (it.hasNext()) {
            it.next().pZ();
        }
        this.cmw.clear();
        this.cmx.clear();
    }
}
