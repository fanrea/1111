package com.just.agentweb;

import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class AbsAgentWebSettings implements IAgentWebSettings, WebListenerManager {
    private static final String TAG = "AbsAgentWebSettings";
    public static final String USERAGENT_AGENTWEB = " AgentWeb/5.0.8 ";
    public static final String USERAGENT_QQ_BROWSER = " MQQBrowser/8.0 ";
    public static final String USERAGENT_UC = " UCBrowser/11.6.4.950 ";
    protected AgentWeb mAgentWeb;
    private WebSettings mWebSettings;

    public static AbsAgentWebSettings getInstance() {
        return new AgentWebSettingsImpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void settings(android.webkit.WebView r8) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.just.agentweb.AbsAgentWebSettings.settings(android.webkit.WebView):void");
    }

    final void bindAgentWeb(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
        bindAgentWebSupport(agentWeb);
    }

    protected abstract void bindAgentWebSupport(AgentWeb agentWeb);

    @Override // com.just.agentweb.IAgentWebSettings
    public WebSettings getWebSettings() {
        return this.mWebSettings;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        webView.setDownloadListener(downloadListener);
        return this;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setWebChromeClient(WebView webView, android.webkit.WebChromeClient webChromeClient) {
        webView.setWebChromeClient(webChromeClient);
        return this;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setWebViewClient(WebView webView, android.webkit.WebViewClient webViewClient) {
        webView.setWebViewClient(webViewClient);
        return this;
    }

    @Override // com.just.agentweb.IAgentWebSettings
    public IAgentWebSettings toSetting(WebView webView) {
        settings(webView);
        return this;
    }
}
