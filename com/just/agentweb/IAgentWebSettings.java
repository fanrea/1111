package com.just.agentweb;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IAgentWebSettings<T extends WebSettings> {
    T getWebSettings();

    IAgentWebSettings toSetting(WebView webView);
}
