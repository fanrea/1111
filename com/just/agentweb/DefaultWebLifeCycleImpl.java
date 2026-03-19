package com.just.agentweb;

import android.os.Build;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultWebLifeCycleImpl implements WebLifeCycle {
    private WebView mWebView;

    DefaultWebLifeCycleImpl(WebView webView) {
        this.mWebView = webView;
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onDestroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.resumeTimers();
        }
        AgentWebUtils.clearWebView(this.mWebView);
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onPause() {
        WebView webView = this.mWebView;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.onPause();
            }
            this.mWebView.pauseTimers();
        }
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onResume() {
        WebView webView = this.mWebView;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.onResume();
            }
            this.mWebView.resumeTimers();
        }
    }
}
