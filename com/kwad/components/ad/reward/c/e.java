package com.kwad.components.ad.reward.c;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private String TAG;
    private com.kwad.sdk.core.webview.c.c sd;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String wd;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.d.c.d(str, "create: ");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d(this.TAG, "handleJsCall: " + cVar);
        this.sd = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.c.d(this.TAG, "onDestroy: ");
        this.sd = null;
    }

    public final void ie() {
        com.kwad.sdk.core.d.c.d(this.TAG, "notifyDialogClose: ");
        N("close");
    }

    private void N(String str) {
        if (TextUtils.isEmpty(str) || this.sd == null) {
            return;
        }
        a aVar = new a();
        aVar.wd = str;
        this.sd.a(aVar);
    }
}
