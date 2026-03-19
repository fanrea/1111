package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.tachikoma.b.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o extends w implements at.b {
    private com.kwad.components.core.playable.a tv;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    public o(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar = gVar.tv;
        this.tv = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.tv;
        if (aVar != null) {
            aVar.b(this);
            this.tv = null;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.at.b
    public final void a(at.a aVar) {
        b(aVar);
    }
}
