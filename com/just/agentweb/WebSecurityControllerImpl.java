package com.just.agentweb;

import android.os.Build;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.just.agentweb.AgentWeb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WebSecurityControllerImpl implements WebSecurityController<WebSecurityCheckLogic> {
    private ArrayMap<String, Object> mMap;
    private AgentWeb.SecurityType mSecurityType;
    private WebView mWebView;

    public WebSecurityControllerImpl(WebView webView, ArrayMap<String, Object> arrayMap, AgentWeb.SecurityType securityType) {
        this.mWebView = webView;
        this.mMap = arrayMap;
        this.mSecurityType = securityType;
    }

    @Override // com.just.agentweb.WebSecurityController
    public void check(WebSecurityCheckLogic webSecurityCheckLogic) {
        if (Build.VERSION.SDK_INT > 11) {
            webSecurityCheckLogic.dealHoneyComb(this.mWebView);
        }
        ArrayMap<String, Object> arrayMap = this.mMap;
        if (arrayMap == null || this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || arrayMap.isEmpty()) {
            return;
        }
        webSecurityCheckLogic.dealJsInterface(this.mMap, this.mSecurityType);
    }
}
