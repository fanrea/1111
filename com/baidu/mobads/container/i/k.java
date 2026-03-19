package com.baidu.mobads.container.i;

import android.webkit.WebView;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.bridge.x;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k extends a {
    static final String k = "BANNER_CLOSE";

    public k(j jVar, WebView webView, x xVar, t tVar) {
        super(jVar, webView, xVar, tVar);
    }

    @Override // com.baidu.mobads.container.i.a, com.baidu.mobads.container.bridge.i
    public JSONObject g() {
        return new com.baidu.mobads.container.j.b(this.e).a();
    }
}
