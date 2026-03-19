package com.baidu.mobads.container.i;

import android.webkit.WebView;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.bridge.w;
import com.baidu.mobads.container.bridge.x;
import com.baidu.mobads.container.hybrid.XHybridAdRenderer;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l extends a {
    static final String k = "BANNER_CLOSE";

    public l(XHybridAdRenderer xHybridAdRenderer, WebView webView, x xVar, t tVar) {
        super(xHybridAdRenderer, webView, xVar, tVar);
        this.j = true;
        f();
    }

    @Override // com.baidu.mobads.container.i.a, com.baidu.mobads.container.bridge.i
    public JSONObject g() {
        return new com.baidu.mobads.container.j.c(this.e).a();
    }

    @Override // com.baidu.mobads.container.bridge.i
    public void a(StringBuilder sb) {
        if (this.g != null && (this.g instanceof XHybridAdRenderer)) {
            sb.append(w.f);
        }
    }
}
