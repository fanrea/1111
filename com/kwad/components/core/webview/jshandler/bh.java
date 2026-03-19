package com.kwad.components.core.webview.jshandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bh implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aeb;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
    }

    public final void ai(boolean z) {
        if (this.aeb == null) {
            com.kwad.sdk.core.d.c.d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z ? 1 : 0));
        } else {
            this.aeb.a(new a(z ? 1 : 0));
        }
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int agm;

        public a(int i) {
            this.agm = i;
        }
    }
}
