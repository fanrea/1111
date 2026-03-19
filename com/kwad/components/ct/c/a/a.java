package com.kwad.components.ct.c.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
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
    private final Map<String, com.kwad.sdk.core.webview.c.a> adx = new ConcurrentHashMap();
    private com.kwad.sdk.core.webview.c.a ady = new d();
    private boolean adz;

    public a(WebView webView) {
        this.UO = webView;
    }

    @JavascriptInterface
    public final void handleLoginAction(String str) {
        com.kwad.sdk.core.webview.c.c cVar;
        com.kwad.sdk.core.d.c.d("KSAdJSBridge", "handleLoginAction ==" + str);
        try {
            final c cVar2 = new c();
            cVar2.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.adx.get(cVar2.anf);
            if (aVar == null) {
                aVar = this.ady;
            }
            if (aVar != null) {
                if (!TextUtils.isEmpty(cVar2.aQX)) {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.ct.c.a.a.1
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar) {
                            a.this.o(cVar2.aQX, new f(bVar).toJson().toString());
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                            a.this.o(cVar2.aQX, new e(i, str2).toJson().toString());
                        }
                    };
                } else {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.ct.c.a.a.2
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar) {
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                        }
                    };
                }
                aVar.a(cVar2.params, cVar);
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
        if (!TextUtils.isEmpty(aVar.getKey())) {
            if (this.adx.containsKey(aVar.getKey())) {
                com.kwad.sdk.core.d.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
            }
            this.adx.put(aVar.getKey(), aVar);
            return;
        }
        com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
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
