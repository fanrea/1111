package com.just.agentweb;

import android.webkit.ValueCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface QuickCallJs {
    void quickCallJs(String str);

    void quickCallJs(String str, ValueCallback<String> valueCallback, String... strArr);

    void quickCallJs(String str, String... strArr);
}
