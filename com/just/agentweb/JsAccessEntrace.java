package com.just.agentweb;

import android.webkit.ValueCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface JsAccessEntrace extends QuickCallJs {
    void callJs(String str);

    void callJs(String str, ValueCallback<String> valueCallback);
}
