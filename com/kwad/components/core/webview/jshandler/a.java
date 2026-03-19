package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b adT;

    /* renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    public static class C0490a extends com.kwad.sdk.core.response.a.a {
        public String PD;
        public String adW;
        public String adX;
    }

    public interface b {
        void c(C0490a c0490a);
    }

    public static class c extends com.kwad.sdk.core.response.a.a {
        public int adY;
        public long adZ;
        public boolean aea;
        public int errorCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public a(b bVar) {
        this.adT = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0490a c0490a = new C0490a();
            c0490a.parseJson(new JSONObject(str));
            b(c0490a);
        } catch (Throwable unused) {
        }
    }

    private void b(final C0490a c0490a) {
        bx.postOnUiThread(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (a.this.adT != null) {
                    a.this.adT.c(c0490a);
                }
            }
        });
    }
}
