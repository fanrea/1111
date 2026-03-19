package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.cd;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private WebView UO;
    private final Map<String, com.kwad.sdk.core.webview.c.a> adx = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.c.a ady = new d();
    private boolean adz;

    public a(WebView webView) {
        this.UO = webView;
        uK();
    }

    private void uK() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new ab());
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.webview.c.c cVar;
        com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.adx.get(bVar.anf);
            if (aVar == null) {
                aVar = this.ady;
            }
            WebView webView = this.UO;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.anf, bVar.data);
            }
            if (aVar != null) {
                if (!TextUtils.isEmpty(bVar.aQX)) {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            a.this.o(bVar.aQX, new f(bVar2).toJson().toString());
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                            a.this.o(bVar.aQX, new e(i, str2).toJson().toString());
                        }
                    };
                } else {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                        }
                    };
                }
                aVar.a(bVar.data, cVar);
                return;
            }
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "bridgeHandler is null");
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2) {
        if (this.adz) {
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback is empty");
            return;
        }
        com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
        WebView webView = this.UO;
        if (webView == null) {
            return;
        }
        cd.a(webView, str, str2);
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.getKey())) {
            if (this.adx.containsKey(aVar.getKey())) {
                com.kwad.sdk.core.d.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
            }
            this.adx.put(aVar.getKey(), aVar);
            return;
        }
        com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (!TextUtils.isEmpty(aVar.getKey())) {
            this.adx.put(aVar.getKey(), aVar);
        } else {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.d.c.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.c.a>> it = this.adx.entrySet().iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.webview.c.a value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.adz = true;
    }
}
