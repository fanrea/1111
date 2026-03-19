package com.just.agentweb;

import android.webkit.DownloadListener;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface WebListenerManager {
    WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener);

    WebListenerManager setWebChromeClient(WebView webView, android.webkit.WebChromeClient webChromeClient);

    WebListenerManager setWebViewClient(WebView webView, android.webkit.WebViewClient webViewClient);
}
