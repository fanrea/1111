package com.kwad.components.core.webview.jshandler.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    public static class C0491a extends com.kwad.sdk.core.response.a.a {
        public String agH;
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "checkAppInstalled";
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String ba(String str) {
        try {
            C0491a c0491a = new C0491a();
            c0491a.parseJson(new JSONObject(str));
            return c0491a.agH;
        } catch (Throwable unused) {
            return null;
        }
    }
}
