package com.just.agentweb;

import android.webkit.WebView;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface WebCreator extends IWebIndicator {
    WebCreator create();

    FrameLayout getWebParentLayout();

    WebView getWebView();

    int getWebViewType();
}
