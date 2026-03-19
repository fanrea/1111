package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.uo.b;
import com.bytedance.sdk.component.uo.hc;
import com.bytedance.sdk.component.utils.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BizWebView extends MultiWebview implements b {
    @Override // com.bytedance.sdk.component.uo.b
    public View getView() {
        return this;
    }

    public BizWebView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        super.G_();
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setNetworkAvailable(final boolean z) {
        if (this.hc != null) {
            this.hc.setNetworkAvailable(z);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setNetworkAvailable(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void loadUrl(final String str) {
        if (this.hc != null) {
            this.hc.loadUrl(str);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.loadUrl(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public boolean canGoBack() {
        if (this.hc != null) {
            if (this.hc.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && d() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void goBack() {
        if (this.hc != null) {
            this.hc.goBack();
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public String getUrl() {
        return this.hc != null ? this.hc.getUrl() : "";
    }

    @Override // com.bytedance.sdk.component.uo.b
    public int getProgress() {
        if (this.hc != null) {
            return this.hc.getProgress();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.uo.b
    public int getContentHeight() {
        if (this.hc != null) {
            return this.hc.getContentHeight();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.uo.b
    public String getUserAgentString() {
        return this.hc != null ? this.hc.getUserAgentString() : "";
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setUserAgentString(final String str) {
        if (this.hc != null) {
            this.hc.setUserAgentString(str);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void onResume() {
        if (this.hc != null) {
            this.hc.onResume();
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void clearCache(boolean z) {
        if (this.hc != null) {
            this.hc.clearCache(z);
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void clearHistory() {
        if (this.hc != null) {
            this.hc.clearHistory();
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.hc != null) {
            this.hc.setWebViewClient(webViewClient);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.hc != null) {
            this.hc.setDownloadListener(downloadListener);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.38
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.hc != null) {
            this.hc.setWebChromeClient(webChromeClient);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.hc != null) {
            this.hc.addJavascriptInterface(obj, str);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setJavaScriptEnabled(final boolean z) {
        if (this.hc != null) {
            this.hc.setJavaScriptEnabled(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setDisplayZoomControls(final boolean z) {
        if (this.hc != null) {
            this.hc.setDisplayZoomControls(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setCacheMode(final int i) {
        if (this.hc != null) {
            this.hc.setCacheMode(i);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setCacheMode(i);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.hc != null) {
            this.hc.onPause();
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.hc != null) {
            this.hc.evaluateJavascript(str, valueCallback);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public WebView getWebView() throws InterruptedException {
        if (this.hc != null) {
            return this.hc.getWebView();
        }
        if (u()) {
            return null;
        }
        long j = 500;
        while (this.d.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.hc != null) {
            return this.hc.getWebView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.uo.b
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void removeJavascriptInterface(String str) {
        b bVar = this.hc;
        if (bVar != null) {
            bVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setAppCacheEnabled(final boolean z) {
        if (this.hc != null) {
            this.hc.setAppCacheEnabled(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setSupportZoom(final boolean z) {
        if (this.hc != null) {
            this.hc.setSupportZoom(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setUseWideViewPort(final boolean z) {
        if (this.hc != null) {
            this.hc.setUseWideViewPort(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.hc != null) {
            this.hc.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setDomStorageEnabled(final boolean z) {
        if (this.hc != null) {
            this.hc.setDomStorageEnabled(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setBuiltInZoomControls(final boolean z) {
        if (this.hc != null) {
            this.hc.setBuiltInZoomControls(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.hc != null) {
            this.hc.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.hc != null) {
            this.hc.setLoadWithOverviewMode(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setDefaultTextEncodingName(final String str) {
        if (this.hc != null) {
            this.hc.setDefaultTextEncodingName(str);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setDefaultFontSize(final int i) {
        if (this.hc != null) {
            this.hc.setDefaultFontSize(i);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setMixedContentMode(final int i) {
        if (this.hc != null) {
            this.hc.setMixedContentMode(i);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setDatabaseEnabled(final boolean z) {
        if (this.hc != null) {
            this.hc.setDatabaseEnabled(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setAllowFileAccess(final boolean z) {
        if (this.hc != null) {
            this.hc.setAllowFileAccess(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void clearView() {
        if (this.hc != null) {
            this.hc.clearView();
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void pauseTimers() {
        if (this.hc != null) {
            this.hc.pauseTimers();
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void resumeTimers() {
        if (this.hc != null) {
            this.hc.resumeTimers();
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setBlockNetworkImage(final boolean z) {
        if (this.hc != null) {
            this.hc.setBlockNetworkImage(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.hc != null) {
            this.hc.setAllowFileAccessFromFileURLs(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.hc != null) {
            this.hc.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setSavePassword(final boolean z) {
        if (this.hc != null) {
            this.hc.setSavePassword(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.hc != null) {
            this.hc.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.d.get() < 3) {
            hc(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.hc != null) {
            this.hc.setBackgroundColor(i);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setBackgroundColor(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void computeScroll() {
        if (this.hc != null) {
            this.hc.computeScroll();
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.28
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.computeScroll();
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setLayerType(final int i, final Paint paint) {
        if (this.hc != null) {
            this.hc.setLayerType(i, paint);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.29
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setLayerType(i, paint);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.hc != null) {
            this.hc.setOverScrollMode(i);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.30
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setOverScrollMode(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.hc != null) {
            this.hc.setVisibility(i);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.31
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setVisibility(i);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.hc != null) {
            this.hc.setAlpha(f);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.32
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setAlpha(f);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.hc != null) {
            this.hc.setOnScrollChangeListener(onScrollChangeListener);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.33
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setOnScrollChangeListener(onScrollChangeListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.hc
    public void setTouchEventListener(final hc.d dVar) {
        if (this.hc != null) {
            this.hc.setTouchEventListener(dVar);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.34
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setTouchEventListener(dVar);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.uo.b
    public void setBackgroundResource(final int i) {
        if (this.hc != null) {
            this.hc.setBackgroundResource(i);
        } else {
            if (this.d == null || this.d.get() >= 3) {
                return;
            }
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hc != null) {
                        BizWebView.this.hc.setBackgroundResource(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.uo.b
    public void d(String str, String str2, Object obj) {
        if (this.hc != null) {
            this.hc.d(str, str2, obj);
        }
    }

    private void hc(Runnable runnable) {
        gb.hc().post(runnable);
    }
}
