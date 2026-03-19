package com.kwad.components.ad.reward.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a Cr;

    public interface a {
        void kk();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickGift";
    }

    public final void a(a aVar) {
        this.Cr = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.Cr;
        if (aVar != null) {
            aVar.kk();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Cr = null;
    }
}
