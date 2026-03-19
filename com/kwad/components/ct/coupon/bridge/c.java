package com.kwad.components.ct.coupon.bridge;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeb;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String afZ;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "pageLifecycleListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
        com.kwad.sdk.core.d.c.d("WebCardPageLifecycleHandler", "WebCardPageLifecycleHandler handleJsCall data = " + str);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeb = null;
    }

    public final void onPagePause() {
        bg("pagePause");
    }

    public final void xM() {
        bg("pageStop");
    }

    public final void onPageDestroy() {
        bg("pageDestroy");
    }

    public final void xN() {
        bg("pageRestart");
    }

    private void bg(final String str) {
        this.aeI.post(new bh() { // from class: com.kwad.components.ct.coupon.bridge.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (c.this.aeb != null) {
                    a aVar = new a();
                    aVar.afZ = str;
                    c.this.aeb.a(aVar);
                }
            }
        });
    }
}
