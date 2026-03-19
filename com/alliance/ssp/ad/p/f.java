package com.alliance.ssp.ad.p;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: SAWebViewUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public static void a(WebView webView, int i, int i2) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (i == 0) {
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
        }
        settings.setDomStorageEnabled(true);
        if (i2 == 0) {
            settings.setCacheMode(2);
        }
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i3 >= 19) {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
    }
}
