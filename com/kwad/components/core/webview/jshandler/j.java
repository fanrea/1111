package com.kwad.components.core.webview.jshandler;

import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aeb;
    private p aef;

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int SS;
        public int aeh;
        public int aei;
        public String aej;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getNativeData";
    }

    public j(p pVar) {
        this.aef = pVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            p pVar = this.aef;
            if (pVar != null) {
                pVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeb = null;
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.aeh = playableSource.getCode();
        a(bVar);
    }

    public final void bl(int i) {
        b bVar = new b();
        bVar.SS = i;
        a(bVar);
    }

    public final void ba(boolean z) {
        b bVar = new b();
        bVar.aei = z ? 1 : 0;
        a(bVar);
    }

    public final void P(long j) {
        b bVar = new b();
        bVar.aej = Long.toString(j);
        a(bVar);
    }

    public final void a(com.kwad.sdk.core.response.a.a aVar) {
        com.kwad.sdk.core.webview.c.c cVar = this.aeb;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aeg;

        public final String getTarget() {
            return this.aeg;
        }
    }
}
