package com.kwad.components.core.webview.tachikoma.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends w {
    private a aix;

    public interface a {
        void a(h hVar);
    }

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int aiy;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getPlayEndType";
    }

    public final void a(a aVar) {
        this.aix = aVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a aVar = this.aix;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void be(boolean z) {
        int i = z ? 1 : 2;
        b bVar = new b();
        bVar.aiy = i;
        b(bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        this.aix = null;
    }
}
