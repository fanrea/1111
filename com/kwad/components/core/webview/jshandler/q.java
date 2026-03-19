package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q implements com.kwad.sdk.core.webview.c.a {
    private BroadcastReceiver aeo;
    private com.kwad.sdk.core.webview.c.c sd;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.sd = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        try {
            if (this.aeo != null) {
                com.kwad.sdk.utils.ad.dq(ServiceProvider.getContext()).unregisterReceiver(this.aeo);
                this.aeo = null;
            }
            this.aeo = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.q.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    String stringExtra = intent.getStringExtra("data");
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    a aVar = new a();
                    aVar.message = stringExtra;
                    q.this.sd.a(aVar);
                }
            };
            com.kwad.sdk.utils.ad.dq(ServiceProvider.getContext()).a(this.aeo, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.s(th);
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        try {
            if (this.aeo != null) {
                com.kwad.sdk.utils.ad.dq(ServiceProvider.getContext()).unregisterReceiver(this.aeo);
                this.aeo = null;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.s(th);
        }
    }
}
